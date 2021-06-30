package com.hamit.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;
// import java.security.Key;
import io.jsonwebtoken.Jwts;

// her yerde kullanmak icin servise yapalım
// final yapmazsak milisaniye cinsinden kaynaklanan sorunu yasayabiliriz.
@Service
public class TokenManagerImpl implements TokenManager {
	
	@Autowired
	CommonSecurityValue common = new CommonSecurityValue();
	
	private final Date iat = common.getNowDateCurrentTimeMillis(); // simdiki zamanı alsın
	private final Date exp = common.getExpiredAt(); // simdiki zamana + ekleme(1gun)
	
	// Token create
	@Override
	public String generateToken(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(iat).setExpiration(exp).signWith(common.getKey())
				.compact();
	}
	
	@Override
	public boolean tokenValidate(String token) {
		if (getUserFromToken(token) != null && isExpired(token))
			return true;
		return false;
	}
	
	@Override
	public String getUserFromToken(String token) {
		Claims claims = getClaims(token);
		return claims.getSubject();
	}
	
	// token yaşıyor mu
	@Override
	public boolean isExpired(String token) {
		Claims claims = getClaims(token);
		return claims.getExpiration().after(iat);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Claims getClaims(String token) {
		return Jwts.parser().setSigningKey(common.getKey()).parseClaimsJws(token).getBody();
	}
	
}
