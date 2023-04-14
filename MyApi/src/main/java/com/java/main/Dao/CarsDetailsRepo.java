package com.java.main.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.main.entity.CarsDetails;

@Repository
public interface CarsDetailsRepo extends JpaRepository<CarsDetails, Integer> {

	public List<CarsDetails> findBycarname(String carName);

	public List<CarsDetails> findByPrice(String carType);

}
