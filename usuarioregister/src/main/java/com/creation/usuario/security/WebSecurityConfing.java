package com.creation.usuario.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;



@Configuration
public class WebSecurityConfing {
	
	
	private final UserDetailsService userDetailsService;
	private final JwtAuthorizationFilter authorizationFilter;

  
	
	  @Bean
	  SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
		  
		  JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
		  jwtAuthenticationFilter.setAuthenticationManager(authManager);
		  jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		  
		  
		  return http
                  .csrf(csrf -> csrf.disable())
                  .authorizeHttpRequests()
                  .anyRequest()
                  .authenticated()
                  .and()
                  .httpBasic(withDefaults())
                  .sessionManagement(management -> management
                          .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                  .addFilter(jwtAuthenticationFilter)
		          .addFilterBefore(authorizationFilter, UsernamePasswordAuthenticationFilter.class)
                  .build();
	  }
	  
	    /*
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
	    }*/
	    
	    @Bean
	    AuthenticationManager authenticationManagerBean(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder) throws Exception {
	    	
	        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
	        	   .userDetailsService(userDetailsService)
	        	   .passwordEncoder(passwordEncoder())
	        	   .and()
	        	   .build();
	    }
	    
	    
	    @Bean
	    PasswordEncoder passwordEncoder() throws Exception {
	    	
	        return new BCryptPasswordEncoder();
	    }
	    
	    public WebSecurityConfing(UserDetailsService userDetailsService) {
	        this.authorizationFilter = new JwtAuthorizationFilter();
			this.userDetailsService = userDetailsService;
	    }
	    
		public static void main(String[] args) {
			
			System.out.print("password" + new BCryptPasswordEncoder().encode("hunter2"));
		}
	    
}
	 
