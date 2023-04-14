package com.java.main.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.main.entity.CustomersDetail;



@Repository
public interface CustomersDetailRepository extends JpaRepository<CustomersDetail,Integer > {

	public List<CustomersDetail> findByCustomername(String customername);

	public List<CustomersDetail> findByCustomercontact(String customercontact);

	public List<CustomersDetail> findByCustomeraddress(String customeraddress);

}
