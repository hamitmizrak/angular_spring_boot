package com.hamit.api.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hamit.api.LoginApi;
import com.hamit.dto.LoginDto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.java.Log;

// log
@Log

// Cross Origin Http
@CrossOrigin

// swagger-2
@Api(value = "/api/login")

// rest api
@RestController
@RequestMapping("/api/login")
public class LoginApiImpl implements LoginApi {
	
	// @RestController
	// @RequestMapping
	// @CrossOrigin
	// @GetMapping
	// @PostMapping
	// PutMapping ==> @PathVariable @ModelAttribute
	// DeleteMapping
	
	@Override
	@GetMapping("/get/{login_id}")
	@ApiOperation(value = "get", notes = "id ile tek bir tane veri dönder ", response = LoginDto.class)
	public ResponseEntity<LoginDto> getById(@PathVariable("login_id") int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@GetMapping("/get/list")
	@ApiOperation(value = "", notes = "listeleme yapıalcak", response = LoginDto.class)
	public ResponseEntity<List<LoginDto>> getAllList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@PutMapping("/update/{login_id}")
	@ApiOperation(value = "Put", notes = "güncelleme id ve nesne", response = LoginDto.class)
	public ResponseEntity<LoginDto> getUpdate(@PathVariable("login_id") int id, @ModelAttribute LoginDto loginDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@DeleteMapping("/delete/{login_id")
	@ApiOperation(value = "delete By Id", notes = "id ile silme yapılacak ", response = LoginDto.class)
	public ResponseEntity<LoginDto> getDelete(@PathVariable("login_id") int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@DeleteMapping("/delete/list")
	@ApiOperation(value = "delete allList", notes = "dikkat bütün tablo silinir", response = LoginDto.class)
	public ResponseEntity<LoginDto> getAllDelete() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@PostMapping("/post")
	@ApiOperation(value = "post", notes = "ekleme yapılacak", response = LoginDto.class)
	public ResponseEntity<LoginDto> getPost(@ModelAttribute LoginDto loginDto) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
