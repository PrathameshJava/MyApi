package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entity.CarsDetails;
import com.java.main.exception.ResourceNotFoundException;
import com.java.main.service.CarsdetailService;

@RestController
@RequestMapping("/api/v1")
public class CarsDetailController {
	@Autowired
	private CarsdetailService carsdetailServiceImpl;

	@GetMapping(value = "/carsDetails")
	public ResponseEntity<List<CarsDetails>> getAllCarsPackage() {
		List<CarsDetails> carsDetails = carsdetailServiceImpl.getAllCarsdetail();
		try {
			if (carsDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(carsDetails, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@PostMapping(value = "/carsDetails")
	public ResponseEntity<CarsDetails> regCarsPackage(@RequestBody CarsDetails cd) {
		try {
			CarsDetails carsDetails = carsdetailServiceImpl.regCarsdetail(cd);
			return new ResponseEntity<>(carsDetails, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CarsDetails> getCarsdetailById(int id) throws ResourceNotFoundException {

		CarsDetails carsDetails = carsdetailServiceImpl.getCarsdetailById(id);
		if (carsDetails == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(carsDetails, HttpStatus.OK);

	}

	@GetMapping(value = "/{carName}")
	public ResponseEntity<List<CarsDetails>> getCarspackageByCar_Name(String car_name) {

		List<CarsDetails> carsDetails = carsdetailServiceImpl.getCarsdetailByCar_Name(car_name);
		try {
			if (carsDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(carsDetails, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@GetMapping(value = "/cars-Detail/{car-Detail-Type}")
	public ResponseEntity<List<CarsDetails>> getCarsPackageByprice(String carprice) {
		List<CarsDetails> carsDetails = carsdetailServiceImpl.getCarsdetailByCarprice(carprice);
		try {
			if (carsDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(carsDetails, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

}
