package com.java.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.Dao.CustomersDetailRepository;
import com.java.main.entity.CustomersDetail;
import com.java.main.service.CustomerDetailsService;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomersDetailRepository customerDetailRepository;

	@Override
	public List<CustomersDetail> getCarsdetailByCustomer_Name(String customername) {

		return null;
	}

	@Override
	public List<CustomersDetail> getCustomerByCustomer_Contact(String Customer_Contact) {

		return null;
	}

	@Override
	public List<CustomersDetail> getCustomerByCustomer_Address(String Customer_Address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomersDetail> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDetailRepository.findAll();
	}

	@Override
	public CustomersDetail regCustomer(CustomersDetail customersDetail) {
		// TODO Auto-generated method stub
		return customerDetailRepository.save(customersDetail);
	}

	@Override
	public CustomersDetail upateCustomer(String customername, Integer id) {
		CustomersDetail customersDetail = getCustomerById(id);
		customersDetail.setCustomername(customername);

		return customerDetailRepository.save(customersDetail);
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerDetailRepository.deleteById(id);

	}

	@Override
	public CustomersDetail getCustomerById(int id) {

		return customerDetailRepository.findById(id).orElse(new CustomersDetail());
	}

}
