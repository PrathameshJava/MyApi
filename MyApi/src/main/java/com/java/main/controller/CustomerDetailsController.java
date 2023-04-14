package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entity.CustomersDetail;
import com.java.main.exception.ResourceNotFoundException;
import com.java.main.service.CustomerDetailsService;

@RestController
@RequestMapping("/api/v1")
public class CustomerDetailsController {
	@Autowired
	private CustomerDetailsService customerDetailsServiceImpl;

	@GetMapping(value = "/customers")
	public ResponseEntity<List<CustomersDetail>> getAllCustomers() {
		List<CustomersDetail> customersDetails = customerDetailsServiceImpl.getAllCustomers();
		customerDetailsServiceImpl.getAllCustomers();
		try {
			if (customersDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(customersDetails, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping(value = "/customer")
	public ResponseEntity<CustomersDetail> regCustomer(@RequestBody CustomersDetail customersDetail) {

		CustomersDetail customersDetail2 = customerDetailsServiceImpl.regCustomer(customersDetail);
		try {
			return new ResponseEntity<>(customersDetail2, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping(value = "/{customername}/{id}")
	public CustomersDetail upateCustomer(@PathVariable("customername") String customername,
			@PathVariable("id") Integer id) throws ResourceNotFoundException {
		return customerDetailsServiceImpl.upateCustomer(customername, id);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<HttpStatus> deleteCustomerdetails(@PathVariable("id") Integer id) {

		try {
			customerDetailsServiceImpl.deleteCustomer(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping(value = "/{Id}")
	public ResponseEntity<CustomersDetail> getCustomerById(int id) throws ResourceNotFoundException {

		CustomersDetail customersDetail = customerDetailsServiceImpl.getCustomerById(id);
		if (customersDetail == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(customersDetail, HttpStatus.OK);

	}

	@GetMapping(value = "/{customername}")
	public ResponseEntity<List<CustomersDetail>> getCarspackageByCustomer_Name(
			@PathVariable("customername") String customername) {
		List<CustomersDetail> customersDetails = customerDetailsServiceImpl.getCarsdetailByCustomer_Name(customername);
		try {
			if (customersDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(customersDetails, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping(value = "/{customercontact}")
	public ResponseEntity<List<CustomersDetail>> getCustomerByCustomer_Contact(@PathVariable String customercontact) {
		List<CustomersDetail> customersDetails = customerDetailsServiceImpl
				.getCustomerByCustomer_Contact(customercontact);
		try {
			if (customersDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(customersDetails, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
