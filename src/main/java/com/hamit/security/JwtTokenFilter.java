package com.hamit.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.extern.java.Log;

@Component
@Log
public class JwtTokenFilter extends OncePerRequestFilter {
	
	@Autowired
	private TokenManagerImpl tokenManagerImpl;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String autHeader = request.getHeader("Authorization");
		String username = null;
		String token = null;
		
		// 1-)
		// autHeader kontrolunu saglamak ve tokenve username almak
		if (autHeader != null && autHeader.contains("Bearer")) {
			token = autHeader.substring(7); // token'i Headerdan almak icin
			
			try {
				username = tokenManagerImpl.getUserFromToken(token); // username icini doldurmak icin
			} catch (Exception e) {
				e.printStackTrace();
				log.warning(e.getMessage());
			}
			
		}
		
		// 2-)
		if (username != null && token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			if (tokenManagerImpl.tokenValidate(token)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						username, null, new ArrayList<>());
				
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		
		// 3-) filterChain
		filterChain.doFilter(request, response);
		
	}
	
}
