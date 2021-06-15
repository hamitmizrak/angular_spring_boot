package com.hamit.api.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamit.api.RegisterApi;
import com.hamit.dto.RegisterDto;
import com.hamit.service.impl.RegisterServiceImpl;

import lombok.extern.java.Log;

@RestController
@RequestMapping(value = "/api/register")
@Log
public class RegisterApiImpl implements RegisterApi<RegisterDto> {
	
	// rest
	// @GetMapping ==> listeleme
	// @PostMapping ==> Ekleme
	// @DeleteMapping ==> Silmek
	// @PutMapping ==> Güncellemek
	
	// inject
	@Autowired
	RegisterServiceImpl registerServiceImp;
	
	// private final RegisterServiceImpl registerServiceImp;
	// public RegisterApiImpl(RegisterServiceImpl registerServiceImp) {
	// this.registerServiceImp = registerServiceImp;
	// }
	
	// localhost:9293/api/register/get/1
	@GetMapping("/get/{id44}")
	@Override
	public ResponseEntity<RegisterDto> getById(@PathVariable("id44") int id) {
		RegisterDto dto = registerServiceImp.getById(id);
		log.info(RegisterDto.class + " Api Tek Liste dönüldü");
		return ResponseEntity.ok(dto);
	}
	
	// localhost:9293/api/register/get/list
	@GetMapping("/get/list")
	@Override
	public ResponseEntity<List<RegisterDto>> getAllList() {
		return ResponseEntity.ok(registerServiceImp.getAllList());
	}
	
	// localhost:9293/api/register/post
	@PostMapping("/post")
	@Override
	public ResponseEntity<RegisterDto> getPost(@ModelAttribute RegisterDto dto) {
		log.info(RegisterDto.class + " Api Eklendi dönüldü");
		return ResponseEntity.ok(registerServiceImp.getPost(dto));
	}
	
	// localhost:9293/api/register/delete/1
	@DeleteMapping("/delete/{id44}")
	@Override
	public ResponseEntity<RegisterDto> getDelete(@PathVariable("id44") int id) {
		registerServiceImp.getDelete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// localhost:9293/api/register/delete
	@Override
	public ResponseEntity<RegisterDto> getDeleteAll() {
		registerServiceImp.getDeleteAll();
		log.info(RegisterDto.class + " Api Silindi");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// localhost:9293/api/register/update/1
	@PutMapping("/update/{id44}")
	@Override
	public ResponseEntity<RegisterDto> getUpdate(@PathVariable("id44") int id, @ModelAttribute RegisterDto dto) {
		registerServiceImp.getUpdate(id, dto);
		log.info(RegisterDto.class + " Api Güncellendi");
		return ResponseEntity.ok(dto);
	}
	
}
