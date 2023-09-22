package com.creation.usuario.security;

public class TokenUtils {
	
	private final static String ACCESS_TOKEN_SECRET = "hahahshhjjagffadfgahahshgagfdada";
	
	private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;
	
	
	public static String createToken(String name, String email) {
		return email;
		
	}

}
