package com.creation.usuario.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



/*
@Configuration
public class WebSecurityConfing {
     
	
	  @Bean
	  SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
		  
		  return http
                  .csrf(csrf -> csrf.disable())
                  .authorizeHttpRequests()
                  .anyRequest()
                  .authenticated()
                  .and()
                  .httpBasic(withDefaults())
                  .sessionManagement(management -> management
                          .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                  .build();
	  }
	  
	    @Bean
	    UserDetailsService userDetailsService() throws Exception {
	        // Creamos un InMemoryUserDetailsManager
	        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

	        // Creamos un UserDetails para el usuario "admin" con contraseña encriptada
	        UserDetails adminUser = User.builder()
	                .username("admin")
	                .password(passwordEncoder().encode("admin"))
	                .roles("ADMIN")
	                .build();

	        // Agregamos el usuario al InMemoryUserDetailsManager
	        userDetailsManager.createUser(adminUser);

	        return (UserDetailsService) userDetailsManager;
	    }
	    
	    @Bean
	    AuthenticationManager authenticationManagerBean(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
	    	
	        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
	        	   .userDetailsService(userDetailsService())
	        	   .passwordEncoder(passwordEncoder())
	        	   .and()
	        	   .build();
	    }
	    
	    
	    @Bean
	    PasswordEncoder passwordEncoder() throws Exception {
	    	
	        return new BCryptPasswordEncoder();
	    }
	    
}
*/ 
