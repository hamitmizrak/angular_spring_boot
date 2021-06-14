package com.hamit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamit.entity.RegisterEntity;

@Repository
public interface RegisterRepository extends JpaRepository<RegisterEntity, Integer> {
	
	// Yeni eklenecek sorgular
	// List<RegisterEntity> getByRegisterName(String registerName);
	
}
