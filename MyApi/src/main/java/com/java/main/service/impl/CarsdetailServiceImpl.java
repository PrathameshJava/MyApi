package com.java.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.main.Dao.CarsDetailsRepo;
import com.java.main.entity.CarsDetails;
import com.java.main.service.CarsdetailService;

@Service
public class CarsdetailServiceImpl implements CarsdetailService {

	@Autowired
	private CarsDetailsRepo carsDetailsRepo;

	@Override
	public List<CarsDetails> getCarsdetailByCar_Name(String car_name) {

		return null;
	}

	@Override
	public List<CarsDetails> getCarsdetailByCar_type(String car_type) {

		return null;
	}

	@Override
	public List<CarsDetails> getAllCarsdetail() {

		return null;
	}

	@Override
	public CarsDetails regCarsdetail(CarsDetails carsDetails) {

		return carsDetailsRepo.save(carsDetails);
	}

	@Override
	public CarsDetails upateCarsdetail(String carname, Integer id) {
		CarsDetails carsDetails = getCarsdetailById(id);
		carsDetails.setCarname(carname);
		return carsDetailsRepo.save(carsDetails);
	}

	@Override
	public void deleteCarsdetail(Integer id) {
		carsDetailsRepo.deleteById(id);

	}

	@Override
	public CarsDetails getCarsdetailById(int id) {

		return carsDetailsRepo.findById(id).orElse(new CarsDetails());
	}

}
