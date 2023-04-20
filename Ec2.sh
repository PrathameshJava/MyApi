#!/bin/bash

# Set the cluster name
CLUSTER_NAME="MyApi"

# Set the number of instances to launch
NUM_INSTANCES=3

# Set the instance type
INSTANCE_TYPE="t2.micro"

# Set the AMI ID
AMI_ID="ami-0c94855ba95c71c99"

# Set the security group ID
SECURITY_GROUP_ID="sg-0123456789abcdef"

# Set the key pair name
KEY_PAIR_NAME="my-key-pair"

# Set the subnet ID
SUBNET_ID="subnet-0123456789abcdef"

# Set the IAM instance profile name
IAM_INSTANCE_PROFILE_NAME="my-instance-profile"

# Set the EC2 role name
EC2_ROLE_NAME="my-ec2-role"

# Set the Elastic IP allocation ID
ELASTIC_IP_ALLOCATION_ID="eipalloc-0123456789abcdef"

# Set the user data
USER_DATA="#!/bin/bash
echo 'Hello, world!'
"

# Create the launch configuration
aws autoscaling create-launch-configuration \
    --launch-configuration-name ${CLUSTER_NAME}-launch-configuration \
    --image-id ${AMI_ID} \
    --instance-type ${INSTANCE_TYPE} \
    --security-groups ${SECURITY_GROUP_ID} \
    --key-name ${KEY_PAIR_NAME} \
    --iam-instance-profile ${IAM_INSTANCE_PROFILE_NAME} \
    --user-data "${USER_DATA}"

# Create the auto scaling group
aws autoscaling create-auto-scaling-group \
    --auto-scaling-group-name ${CLUSTER_NAME}-auto-scaling-group \
    --launch-configuration-name ${CLUSTER_NAME}-launch-configuration \
    --min-size ${NUM_INSTANCES} \
    --max-size ${NUM_INSTANCES} \
    --vpc-zone-identifier ${SUBNET_ID} \
    --health-check-type EC2 \
    --health-check-grace-period 300 \
    --tags ResourceId=${CLUSTER_NAME},ResourceType=auto-scaling-group,Key=Name,Value=${CLUSTER_NAME},PropagateAtLaunch=true \
    --availability-zones us-east-1a us-east-1b us-east-1c \
    --termination-policies "OldestInstance" \
    --default-cooldown 300 \
    --target-group-arns arn:aws:elasticloadbalancing:us-east-1:123456789012:targetgroup/my-target-group/1234567890123456 \
    --service-linked-role-arn arn:aws:iam::123456789012:role/aws-service-role/autoscaling.amazonaws.com/AWSServiceRoleForAutoScaling

# Attach an Elastic IP to the instances
aws ec2 associate-address \
    --instance-id $(aws ec2 describe-instances --query "Reservations[].Instances[].InstanceId" --filters "Name=tag:aws:autoscaling:groupName,Values=${CLUSTER_NAME}-auto-scaling-group" --output text) \
    --allocation-id ${ELASTIC_IP_ALLOCATION_ID}
