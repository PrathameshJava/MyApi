package com.java.main.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.main.entity.Users;
@Repository
public interface UserDao extends JpaRepository<Users, Integer>{

	public Users findByUsernameAndPassword(String username,String password);
}
