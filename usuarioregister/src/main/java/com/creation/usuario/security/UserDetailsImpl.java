package com.creation.usuario.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.creation.usuario.entities.Usuario;
import com.creation.usuario.repository.UsarioRepository;

@Service
public class UserDetailsImpl implements UserDetailsService{
	
	@Autowired
	private UsarioRepository usarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario =  usarioRepository.findOneByEmail(email)
		                .orElseThrow(("El usuario con el email" +email+ "no existe"));
		return new UsersDetailsImpl(usuario);
	}

}
