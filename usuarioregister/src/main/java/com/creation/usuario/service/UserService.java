package com.creation.usuario.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.creation.usuario.entities.Telefono;
import com.creation.usuario.entities.Usuario;
import com.creation.usuario.repository.UsarioRepository;

@Service
public class UserService {
	
	
	   
	    @Autowired
		private UsarioRepository usarioRepository;



	    public Usuario findUsuarioById(Long userId) {
	        return usarioRepository.findById(userId);
	    }

	    public Usuario findUsuarioByName(String username) {
	        return usarioRepository.findUsuarioByName(username);
	    }

	    public Usuario createUser(Usuario user) {
	    	// Genera un UUID aleatorio
            UUID uuid = UUID.randomUUID();
            long uuidValue = uuid.getMostSignificantBits();
            

            // Crear un nuevo objeto de usuario
            Usuario nuevoUsuario = new Usuario();
            // Asigna el UUID generado al usuario
            nuevoUsuario.setId(uuidValue);
            nuevoUsuario.setName(user.getName());
            
            //Verificamos si el correo ingresado en el JSON ya está registrado en la base de datos
            if (usarioRepository.existsByEmail(user.getEmail()))
            
            nuevoUsuario.setEmail(user.getEmail());
            nuevoUsuario.setPassword(user.getPassword());
            nuevoUsuario.setCreated(user.getCreated());
            nuevoUsuario.setModified(user.getModified());
            nuevoUsuario.setLastlogin(user.getLastlogin());
            nuevoUsuario.setIsactive(user.getIsactive());
                
            // Crear la lista de teléfonos
            List<Telefono> telefonos = new ArrayList<>();
            for (Telefono telefonoRequest : user.getPhones()) {
                Telefono telefono = new Telefono();
                telefono.setNumber(telefonoRequest.getNumber());
                telefono.setCitycode(telefonoRequest.getCitycode());
                telefono.setContrycode(telefonoRequest.getContrycode());
                telefonos.add(telefono);
            }
            nuevoUsuario.setPhones(telefonos);

            // Guardar el usuario en base de datos
            
	        return usarioRepository.save(nuevoUsuario);
	    }

		public Usuario findUsuarioById(long userId) {
			return usarioRepository.findById(userId);
		}

}
