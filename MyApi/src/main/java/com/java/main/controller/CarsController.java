package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entity.Cars;
import com.java.main.service.CarsService;

@RestController
@RequestMapping("/api/v1")
public class CarsController {
	@Autowired
	private CarsService carsServiceImpl;

	@GetMapping(value = "/cars")
	public List<Cars> getAllCars() {
		return carsServiceImpl.getAllCars();
	}

	@GetMapping(value = "/{carid}")
	public Cars getCarById(@PathVariable("carid") int id) {

		return carsServiceImpl.getCarById(id);
	}

	@GetMapping(value = "/{carname}")
	public List<Cars> getCarByCar_Name(@PathVariable("carname") String car_name) {

		return carsServiceImpl.getCarByCar_Name(car_name);
	}

	@PutMapping(value = "/{carname}/{id}")
	public Cars upateCars(@PathVariable("carname") String carname, @PathVariable("id") Integer id) {
		return carsServiceImpl.upateCars(carname, id);

	}

	@PostMapping(value = "/cars")
	public Cars regCars(@RequestBody Cars cars) {

		return carsServiceImpl.regCars(cars);

	}

	@DeleteMapping(value = "/{car-Id}")
	public void deletecars(@PathVariable("id") Integer id) {
		carsServiceImpl.deleteCars(id);
	}
}
