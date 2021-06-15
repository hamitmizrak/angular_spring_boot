package com.hamit.service;

import java.util.List;

import com.hamit.dto.RegisterDto;

public interface RegisterService {
	
	// CRUD
	
	// GET ==> single select * from register where register_id=1;
	public RegisterDto getById(int id);
	
	// GET ==> multiple select * from ;
	public List<RegisterDto> getAllList();
	
	// POST ==> insert register (register_name) values ("Deneme")
	public RegisterDto getPost(RegisterDto dto);
	
	// UPDATE ==> update `angular_springboot`.`register` set `register_name` =
	// 'Deneme44' WHERE (`register_id` = '5');
	public RegisterDto getUpdate(int id, RegisterDto dto);
	
	// DELETE ==> delete from register where register_id=4
	public RegisterDto getDelete(int id);
	
	// DELETE ==> delete from register
	public RegisterDto getDeleteAll();
	
}
