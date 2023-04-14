package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entity.CustomersDetail;
import com.java.main.service.CustomerDetailsService;

@RestController
@RequestMapping("/api/v1")
public class CustomerDetailsController {
	@Autowired
	private CustomerDetailsService customerDetailsServiceImpl;

	@GetMapping(value = "/customers")
	public List<CustomersDetail> getAllCustomers() {
		return customerDetailsServiceImpl.getAllCustomers();
	}

	@PostMapping(value = "/customer")
	public CustomersDetail regCustomer(@RequestBody CustomersDetail customersDetail) {

		return customerDetailsServiceImpl.regCustomer(customersDetail);
	}

	@PostMapping(value = "/{customername}/{id}")
	public CustomersDetail upateCustomer(@PathVariable("customername") String customername,
			@PathVariable("id") Integer id) {
		return customerDetailsServiceImpl.upateCustomer(customername, id);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteCustomerdetails(@PathVariable("id") Integer id) {
		customerDetailsServiceImpl.deleteCustomer(id);
	}

	@GetMapping(value = "/{Id}")
	public CustomersDetail getCustomerById(int id) {

		return customerDetailsServiceImpl.getCustomerById(id);
	}

	@GetMapping(value = "/{customername}")
	public List<CustomersDetail> getCarspackageByCustomer_Name(@PathVariable("customername") String customername) {
		return customerDetailsServiceImpl.getCarsdetailByCustomer_Name(customername);
	}

	@GetMapping(value = "/{customercontact}")
	public List<CustomersDetail> getCustomerByCustomer_Contact(@PathVariable String customercontact) {
		return customerDetailsServiceImpl.getCustomerByCustomer_Contact(customercontact);
	}

	@GetMapping(value = "/{customeraddress}")
	public List<CustomersDetail> getCustomerByCustomer_Address(
			@PathVariable("customeraddress") String customeraddress) {
		return customerDetailsServiceImpl.getCustomerByCustomer_Address(customeraddress);
	}

}
