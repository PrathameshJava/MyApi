package com.java.main.service;

import java.util.List;

import com.java.main.entity.Cars;

public interface CarsService {

	public List<Cars> getCarByCar_Name(String car_name);

	public List<Cars> getCarByCar_type(String car_type);

	public List<Cars> getAllCars();

	public Cars regCars(Cars cars);

	public Cars upateCars(String carname, Integer id);

	public void deleteCars(Integer id);

	public Cars getCarById(int id);

}
