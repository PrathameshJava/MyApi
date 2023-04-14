package com.java.main.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.main.entity.Cars;


@Repository
public interface CarsRepository extends JpaRepository<Cars, Integer> {

	public List<Cars> findByCartype(String car_type);

	public List<Cars> findByCarname(String car_name);

}
