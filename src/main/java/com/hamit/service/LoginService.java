package com.hamit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hamit.dto.LoginDto;

@Service
public interface LoginService {
	
	// CRUD
	
	public LoginDto getById(int id);
	
	public List<LoginDto> getAllList();
	
	public LoginDto getUpdate(int id, LoginDto loginDto);
	
	public void getDelete(int id);
	
	public void getAllDelete();
	
	public LoginDto getPost(LoginDto loginDto);
}
