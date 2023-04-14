package com.java.main.service;

import java.util.List;

import com.java.main.entity.CarsDetails;

public interface CarsdetailService {
	public List<CarsDetails> getCarsdetailByCar_Name(String car_name);

	public List<CarsDetails> getCarsdetailByCar_type(String car_type);

	public List<CarsDetails> getAllCarsdetail();

	public CarsDetails regCarsdetail(CarsDetails cp);

	public CarsDetails upateCarsdetail(String carname, Integer id);

	public void deleteCarsdetail(Integer id);

	public CarsDetails getCarsdetailById(int id);

}
