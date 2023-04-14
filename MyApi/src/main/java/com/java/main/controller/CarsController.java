package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entity.Cars;
import com.java.main.exception.ResourceNotFoundException;
import com.java.main.service.CarsService;

@RestController
@RequestMapping("/api/v1")
public class CarsController {
	@Autowired
	private CarsService carsServiceImpl;

	@GetMapping(value = "/cars")
	public ResponseEntity<List<Cars>> getAllCars() {
		List<Cars> cars = carsServiceImpl.getAllCars();
		try {
			if (cars.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(cars, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping(value = "/cars/{id}")
	public ResponseEntity<Cars> getCarById(@PathVariable("id") int id) throws ResourceNotFoundException {

		Cars cars = carsServiceImpl.getCarById(id);
		if (cars == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		return new ResponseEntity<>(cars, HttpStatus.OK);

	}

	@GetMapping(value = "/{carname}")
	public ResponseEntity<List<Cars>> getCarByCar_Name(@PathVariable("carname") String car_name) {

		List<Cars> cars = carsServiceImpl.getCarByCar_Name(car_name);
		try {
			if (cars.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}
			return new ResponseEntity<>(cars, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@PutMapping(value = "/{carname}/{id}")
	public ResponseEntity<Cars> upateCars(@PathVariable("carname") String carname, @PathVariable("id") Integer id)
			throws ResourceNotFoundException {
		Cars cars = carsServiceImpl.upateCars(carname, id);
		if (cars == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<>(HttpStatus.OK);

	}

	@PostMapping(value = "/cars")
	public ResponseEntity<Cars> regCars(@RequestBody Cars cars) {

		try {
			Cars cars2 = carsServiceImpl.regCars(cars);
			return new ResponseEntity<>(cars2, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@DeleteMapping(value = "/{car-Id}")
	public ResponseEntity<HttpStatus> deletecars(@PathVariable("id") Integer id) {
		try {
			carsServiceImpl.deleteCars(id);
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
}
