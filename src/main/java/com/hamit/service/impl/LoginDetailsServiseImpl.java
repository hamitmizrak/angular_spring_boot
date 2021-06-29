package com.hamit.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hamit.entity.LoginEntity;
import com.hamit.repository.LoginRepository;

public class LoginDetailsServiseImpl implements UserDetailsService {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginEntity loginEntity = loginRepository.findByLoginUserName(username);
		
		if (loginEntity == null)
			throw new UsernameNotFoundException("Kullanıcı adı veya şifre yanlış");
		
		return new org.springframework.security.core.userdetails.User(loginEntity.getLoginUserName(),
				loginEntity.getLoginPassword(), getAuthorities("ROLE_ADMIN"));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return java.util.Arrays.asList(new SimpleGrantedAuthority(role));
	}
	
}
