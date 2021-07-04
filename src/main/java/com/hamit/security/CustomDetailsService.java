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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Log
@Service
public class CustomDetailsService implements UserDetailsService {
	
	//// 1.YOL
	//// Eğer database kontrol etmek istemiyorsakkkkkkkk;
	private Map<String, String> mapUser = new HashMap<String, String>();
	// private String userName,userPassword;
	
	// Şifreleyerek gönderelim.
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostConstruct
	public void init() {
		// mapUser.put("root", bCryptPasswordEncoder.encode("root"));
		mapUser.put("hamit", bCryptPasswordEncoder.encode("mizrak"));
		// userName="root"; userPassword="root";
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (mapUser.containsKey(username)) {
			// import org.springframework.security.core.userdetails.User;
			return new User(username, mapUser.get(username), new ArrayList<>());
		}
		log.warning(username + " ");
		throw new UsernameNotFoundException(username);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @Autowired
	// LoginRepository loginRepository;
	//
	// //// 2.YOL
	// //// Eğer database kontrol etmek istiyorsak;
	// @Override
	// public UserDetails loadUserByUsername(String username) throws
	// UsernameNotFoundException {
	// LoginAuth auth = loginRepository.findByLoginUserName(username);
	// LoginAuth deneme = auth;
	// if (auth == null) {
	// throw new UsernameNotFoundException("Kullanıcı email veya şifre yanlış");
	// }
	// return new User(auth.getUsername(), auth.getPassword(), getAuthority());
	// }
	//
	// private List<SimpleGrantedAuthority> getAuthority() {
	// return Arrays.asList(new SimpleGrantedAuthority("ADMIN")); // USER
	// }
	
}
