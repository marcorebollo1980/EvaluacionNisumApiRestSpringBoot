package com.creation.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creation.usuario.entities.Usuario;

@Repository
public interface UsarioRepository extends JpaRepository<Usuario, String>{
	
	public Boolean existsByEmail(String correo);
	
	public Usuario findById(Long userId);
	
	//public Usuario findByUsername(String name);

	public Usuario findUsuarioByName(String username);
	
	public Usuario findOneByEmail(String email);
}
