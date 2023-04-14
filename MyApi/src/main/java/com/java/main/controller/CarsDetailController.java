package com.java.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.main.entity.CarsDetails;
import com.java.main.service.CarsdetailService;


@RestController
@RequestMapping("/api/v1")
public class CarsDetailController {
	@Autowired
	private CarsdetailService carsdetailServiceImpl;

	@GetMapping(value = "/carsDetails")
	public List<CarsDetails> getAllCarsPackage(int id) {
		return carsdetailServiceImpl.getAllCarsdetail();
	}

	@PostMapping(value = "/carsDetails")
	public CarsDetails regCarsPackage(@RequestBody CarsDetails cd) {
		return carsdetailServiceImpl.regCarsdetail(cd);
	}

//	@PutMapping(value = "/{carname}/{id}")
//	public CarsDetails upateCarsPackage(@PathVariable("carname") String carname, @PathVariable("id") Integer id) {
//		return carsdetailServiceImpl.upateCarsdetail(carname, id);
//	}

//	@DeleteMapping(value = "/{id}")
//	public void deletecardetails(@PathVariable("id") Integer id) {
//		carsdetailServiceImpl.deleteCarsdetail(id);
//	}

	@GetMapping(value = "/{id}")
	public CarsDetails getCarsdetailById(int id) {

		return carsdetailServiceImpl.getCarsdetailById(id);
	}

	@GetMapping(value = "/{carName}")
	public List<CarsDetails> getCarspackageByCar_Name(String car_name) {

		return carsdetailServiceImpl.getCarsdetailByCar_Name(car_name);
	}

	@GetMapping(value = "/cars-Detail/{car-Detail-Type}")
	public List<CarsDetails> getCarsPackageByCar_type(String car_type) {
		return carsdetailServiceImpl.getCarsdetailByCar_type(car_type);
	}

}
