package com.hamit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutApiController {
	
	// JWT
	@Autowired
	private TokenManagerImpl tokenManagerImpl;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	//// localhost:9293/api/login/jwt
	//// 1.YOL DEVAMI
	@PostMapping
	public ResponseEntity<String> login(@ModelAttribute LoginAuth loginAuth) {
		// @RequestBody veya @ModelAttribute
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginAuth.getUsername(), loginAuth.getPassword()));
			return ResponseEntity.ok(tokenManagerImpl.generateToken(loginAuth.getUsername()));
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	//// 2.YOL DEVAMI
	// @PostMapping
	// public ResponseEntity<String> login(@ModelAttribute LoginEntity loginEntity)
	// {
	// // @RequestBody veya @ModelAttribute
	//
	// try {
	// authenticationManager.authenticate(new
	// UsernamePasswordAuthenticationToken(loginEntity.getLoginUserName(),
	// loginEntity.getLoginPassword()));
	// return
	// ResponseEntity.ok(tokenManagerImpl.generateToken(loginEntity.getLoginUserName()));
	// } catch (Exception e) {
	// throw e;
	// }
	// }
}
