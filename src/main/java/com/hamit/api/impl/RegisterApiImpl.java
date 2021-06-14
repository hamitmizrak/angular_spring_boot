package com.hamit.api.impl;

import org.springframework.http.ResponseEntity;

import com.hamit.api.RegisterApi;
import com.hamit.dto.RegisterDto;

public class RegisterApiImpl implements RegisterApi<RegisterDto> {
	
	// api
	@Override
	public ResponseEntity<RegisterDto> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseEntity<RegisterDto> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseEntity<RegisterDto> getPost(RegisterDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseEntity<RegisterDto> getDelete(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseEntity<RegisterDto> getDeleteAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseEntity<RegisterDto> getUpdate(int id, RegisterDto dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
