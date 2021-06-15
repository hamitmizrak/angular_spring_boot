package com.hamit.api;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface RegisterApi<RegisterDto> {
	
	// CRUD
	
	// GET ==> single select * from register where register_id=1;
	public ResponseEntity<RegisterDto> getById(int id);
	
	// GET ==> multiple select * from ;
	public ResponseEntity<List<RegisterDto>> getAllList();
	
	// POST ==> insert register (register_name) values ("Deneme")
	public ResponseEntity<RegisterDto> getPost(RegisterDto dto);
	
	// DELETE ==> delete from register where register_id=4
	public ResponseEntity<RegisterDto> getDelete(int id);
	
	// DELETE ==> delete from register
	public ResponseEntity<RegisterDto> getDeleteAll();
	
	// UPDATE ==> update `angular_springboot`.`register` set `register_name` =
	// 'Deneme44' WHERE (`register_id` = '5');
	public ResponseEntity<RegisterDto> getUpdate(int id, RegisterDto dto);
	
}
