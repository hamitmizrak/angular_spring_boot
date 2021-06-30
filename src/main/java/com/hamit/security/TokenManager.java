package com.hamit.security;

import io.jsonwebtoken.Claims;

public interface TokenManager {
	
	// token olusturmak
	public String generateToken(String username);
	
	// token kontrolunu saglamak yani gerecekten bu token mı
	public boolean tokenValidate(String token);
	
	// getObject almak icin
	public String getUserFromToken(String token);
	
	// token yasıyor mu?
	public boolean isExpired(String token);
	
	// claimleri almak
	public Claims getClaims(String token);
}
