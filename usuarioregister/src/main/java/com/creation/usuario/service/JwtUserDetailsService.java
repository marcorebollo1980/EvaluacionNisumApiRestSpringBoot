package com.creation.usuario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creation.usuario.repository.UsarioRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsarioRepository userRepository;

    //@Override
    //public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Implementa la carga de detalles del usuario desde tu repositorio
        // Normalmente, esto implica buscar un usuario en la base de datos por su nombre de usuario.
        // Luego, devuelve un objeto UserDetails con los detalles del usuario.
    //}
}

