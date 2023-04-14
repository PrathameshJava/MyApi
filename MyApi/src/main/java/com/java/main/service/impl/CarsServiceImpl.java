package com.java.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.Dao.CarsRepository;
import com.java.main.entity.Cars;
import com.java.main.service.CarsService;

@Service
public class CarsServiceImpl implements CarsService {

	@Autowired
	private CarsRepository carsRepository;

	@Override
	public List<Cars> getCarByCar_Name(String car_name) {
		return null;
	}

	@Override
	public List<Cars> getCarByCar_type(String car_type) {

		return null;
	}

	@Override
	public List<Cars> getAllCars() {

		return carsRepository.findAll();
	}

	@Override
	public Cars regCars(Cars cars) {

		return carsRepository.save(cars);
	}

	@Override
	public Cars upateCars(String carname, Integer id) {
		Cars cars2 = getCarById(id);
		cars2.setCarname(carname);
		return carsRepository.save(cars2);
	}

	@Override
	public void deleteCars(Integer id) {
		carsRepository.deleteById(id);

	}

	@Override
	public Cars getCarById(int id) {

		return carsRepository.findById(id).orElse(new Cars());
	}

}
