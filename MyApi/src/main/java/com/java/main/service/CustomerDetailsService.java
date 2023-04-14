package com.java.main.service;

import java.util.List;

import com.java.main.entity.CustomersDetail;
import com.java.main.exception.ResourceNotFoundException;

public interface CustomerDetailsService {

	public List<CustomersDetail> getCarsdetailByCustomer_Name(String customername);

	public List<CustomersDetail> getCustomerByCustomer_Contact(String CustomerContact);

	public List<CustomersDetail> getCustomerByCustomer_Address(String Customer_Address);

	public List<CustomersDetail> getAllCustomers();

	public void deleteCustomer(Integer cd);

	public CustomersDetail regCustomer(CustomersDetail customersDetail);

	public CustomersDetail upateCustomer(String carname, Integer id) throws ResourceNotFoundException;

	public CustomersDetail getCustomerById(int id) throws ResourceNotFoundException;

}
