package com.hamit.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;

// lombok
@Data
@Service
public class CommonSecurityValue {
	
	// header
	public static final String HEADER = "Authorization";
	
	// bearer
	public static final String BEARER = "Bearer";
	
	// token ne kadar yasayacak
	private final long expiredAt = 24 * 60 * 60 * 1000; // gün sakalanacak
	
	// SecretKey
	private final String secretKey = "HamitMizrak";
	
	// key
	private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	// şimdiki zamanı almak istiyorsak
	public Date getNowDateCurrentTimeMillis() {
		return new Date(System.currentTimeMillis());
	}
	
	// şimdiki zamanı expiredAt yani 1 gün eklendi ekleyelim
	public Date getExpiredAt() {
		return new Date(System.currentTimeMillis() + expiredAt);
	}
}
