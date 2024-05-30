package com.creation.usuario.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Keys;

import org.hibernate.mapping.Collection;
import org.springframework.data.repository.query.QueryLookupStrategy.Key;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class TokenUtils {
	
	private final static String ACCESS_TOKEN_SECRET = "hahahshhjjagffadfgahahshgagfdada";
	
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
	
	
	public static String createToken(String name, String email) {
		
		long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000;
		Date expirationDate = new Date(System.currentTimeMillis() * expirationTime);
		
		
		Map<String, Object> extra = new HashMap<>();
		extra.put("name", name);
		
		return Jwts.builder()
				.setSubject(email)
		        .setExpiration(expirationDate)
		        .addClaims(extra)
		        .signWith(null, Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
		        .compact();
	}
	
	
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
    	try {
    		
    		Claims claims = Jwts.parser()
                    .setSigningKey(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();
        	
        	String email = claims.getSubject();
        	
        	
        	
        	return new UsernamePasswordAuthenticationToken(email, null, java.util.Collections.emptyList());
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	
	
	

}
