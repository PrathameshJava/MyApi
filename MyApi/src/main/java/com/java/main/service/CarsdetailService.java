package com.java.main.service;

import java.util.List;

import com.java.main.entity.CarsDetails;
import com.java.main.exception.ResourceNotFoundException;

public interface CarsdetailService {
	public List<CarsDetails> getCarsdetailByCar_Name(String car_name);

	public List<CarsDetails> getCarsdetailByCarprice(String car_price);

	public List<CarsDetails> getAllCarsdetail();

	public CarsDetails regCarsdetail(CarsDetails cp);

	public CarsDetails upateCarsdetail(String carname, Integer id) throws ResourceNotFoundException;

	public void deleteCarsdetail(Integer id);

	public CarsDetails getCarsdetailById(int id) throws ResourceNotFoundException;

}
