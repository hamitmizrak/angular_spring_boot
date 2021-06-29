package com.hamit.service;

import java.util.List;

import com.hamit.dto.LoginDto;

public interface LoginService {
	
	// CRUD
	
	public LoginDto getById(int id);
	
	public List<LoginDto> getAllList();
	
	public LoginDto getUpdate(int id, LoginDto loginDto);
	
	public LoginDto getDelete(int id);
	
	public LoginDto getAllDelete();
	
	public LoginDto getPost(LoginDto loginDto);
}
