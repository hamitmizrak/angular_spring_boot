package com.hamit.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.hamit.dto.LoginDto;

public interface LoginApi {
	// CRUD
	
	// select ==> ById AllList
	// SELECT * FROM angular_springboot.login where login_id=3
	public ResponseEntity<LoginDto> getById(int id);
	
	// SELECT * FROM angular_springboot.login;
	public ResponseEntity<List<LoginDto>> getAllList();
	
	// Update ==> UPDATE
	// update login set
	// login_email_address='hamitmizrak@gmail.com',login_user_password='44444',login_user_name='Hamit'
	// where login_id=2
	public ResponseEntity<LoginDto> getUpdate(int id, LoginDto loginDto);
	
	// Delete == DELETE
	// delete from login where login_id=4
	public ResponseEntity<LoginDto> getDelete(int id);
	
	public ResponseEntity<LoginDto> getAllDelete();
	
	// Insert ==> POST
	// insert login (login_email_address,login_user_password,login_user_name) values
	// ("hamitmizrak@gmail.com","123456","Hamit")
	public ResponseEntity<LoginDto> getPost(LoginDto loginDto);
	
}
