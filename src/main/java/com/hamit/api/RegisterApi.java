package com.hamit.api;

import org.springframework.http.ResponseEntity;

public interface RegisterApi<T> {
	
	// CRUD
	
	// GET ==> single select * from register where register_id=1;
	public ResponseEntity<T> getById(int id);
	
	// GET ==> multiple select * from ;
	public ResponseEntity<T> getAllList();
	
	// POST ==> insert register (register_name) values ("Deneme")
	public ResponseEntity<T> getPost(T dto);
	
	// DELETE ==> delete from register where register_id=4
	public ResponseEntity<T> getDelete(int id);
	
	// DELETE ==> delete from register
	public ResponseEntity<T> getDeleteAll();
	
	// UPDATE ==> update `angular_springboot`.`register` set `register_name` =
	// 'Deneme44' WHERE (`register_id` = '5');
	public ResponseEntity<T> getUpdate(int id, T dto);
	
}
