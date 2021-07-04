package com.hamit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hamit.entity.LoginEntity;
import com.hamit.security.LoginAuth;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {
	
	LoginAuth findByLoginUserName(String username);
}
