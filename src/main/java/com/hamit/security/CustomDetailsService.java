package com.hamit.security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hamit.repository.LoginRepository;

import lombok.extern.java.Log;

@Log

@Service
public class CustomDetailsService implements UserDetailsService {
	
	@Autowired
	LoginRepository loginRepository;
	
	private Map<String, String> mapUser = new HashMap<String, String>();
	// private String userName,userPassword;
	
	@PostConstruct
	public void init() {
		mapUser.put("root", "root");
		// userName="root"; userPassword="root";
	}
	
	// 1.YOL
	// Eğer database kontrol etmek istiyorsak;
	// @Override
	// public UserDetails loadUserByUsername(String username) throws
	// UsernameNotFoundException {
	// return loginRepository.findByLoginUserName(username);
	// }
	
	// 2.YOL
	// Eğer database kontrol etmek istemiyorsakkkkkkkk;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if (mapUser.containsKey(username)) {
			return new User(username, mapUser.get("username"), new ArrayList<>());
		}
		
		log.warning(username + " ");
		throw new UsernameNotFoundException(username);
		
	}
	
}
