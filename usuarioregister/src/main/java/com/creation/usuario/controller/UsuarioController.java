package com.creation.usuario.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.creation.usuario.entities.Telefono;
import com.creation.usuario.entities.Usuario;
import com.creation.usuario.repository.UsarioRepository;
import com.creation.usuario.util.ConstantUtils;



@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsarioRepository usarioRepository;
	
	
	/***
	 * Rest api para probar el controller
	 * @return
	 */
	@GetMapping("/hellousuario")
	public ResponseEntity<?> getHello() {

		return ResponseEntity.ok("Hello word users!!!!");
	}
	
	@GetMapping("/listaUsuarios")
	public ResponseEntity<List<Usuario>> getAllUsuers() {
        List<Usuario> usuarios = usarioRepository.findAll();  
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	
	@GetMapping("/detailUser/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long id){
        Usuario usuario = usarioRepository.findById(id);
        if (usuario != null) {
	        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
    }

	@GetMapping("/detailUser")
	public ResponseEntity<Usuario> getUserById(@RequestParam("id") Long id) {
	    Usuario usuario = usarioRepository.findById(id);
	    if (usuario != null) {
	        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	
	
	   
    /***
     * Rest api para creacion de usuarios en base de datos
     * @param usuario
     * @return
     */
    @PostMapping("/registro")
    public ResponseEntity<String> registrarUsuario(@Valid @RequestBody Usuario usuario) {
        try {
        	
        	// Genera un UUID aleatorio
            UUID uuid = UUID.randomUUID();
            long uuidValue = uuid.getMostSignificantBits();
            
            // Validar los datos de entrada
            validarDatosEntrada(usuario);

            // Crear un nuevo objeto de usuario
            Usuario nuevoUsuario = new Usuario();
            // Asigna el UUID generado al usuario
            nuevoUsuario.setId(uuidValue);
            nuevoUsuario.setName(usuario.getName());
            
            //Verificamos si el correo ingresado en el JSON ya está registrado en la base de datos
            if (usarioRepository.existsByEmail(usuario.getEmail())) {
                return ResponseEntity.badRequest().body("El correo ya está registrado");
            }
            
            nuevoUsuario.setEmail(usuario.getEmail());
            nuevoUsuario.setPassword(usuario.getPassword());
            nuevoUsuario.setCreated(usuario.getCreated());
            nuevoUsuario.setModified(usuario.getModified());
            nuevoUsuario.setLastlogin(usuario.getLastlogin());
            nuevoUsuario.setIsactive(usuario.getIsactive());
                
            // Crear la lista de teléfonos
            List<Telefono> telefonos = new ArrayList<>();
            for (Telefono telefonoRequest : usuario.getPhones()) {
                Telefono telefono = new Telefono();
                telefono.setNumber(telefonoRequest.getNumber());
                telefono.setCitycode(telefonoRequest.getCitycode());
                telefono.setContrycode(telefonoRequest.getContrycode());
                telefonos.add(telefono);
            }
            nuevoUsuario.setPhones(telefonos);

            // Guardar el usuario en base de datos
            usarioRepository.save(nuevoUsuario);

            // Devuelve un mensaje de éxito
            return ResponseEntity.status(HttpStatus.OK).body("{\"mensaje\": \"Usuario registrado exitosamente\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"mensaje\": \"" + e.getMessage() + "\"}");
        }
    }

    /***
     * Método para validar los datos de entrada
     * @param usuario
     * @throws Exception
     */
    private void validarDatosEntrada(Usuario usuario) throws Exception {
    	
        if (usuario.getName() == null || usuario.getName().isEmpty()) {
            throw new Exception("El campo 'name' es obligatorio.");
        }
        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new Exception("El campo 'email' es obligatorio.");
        }
        if (validarFormatoCorreo(usuario.getEmail())) {
        	throw new Exception("Formato de email incorrecto");
        }
        if (usuario.getPassword() == null || usuario.getPassword().isEmpty()) {
            throw new Exception("El campo 'password' es obligatorio.");
        }
        if (usuario.getPhones() == null || usuario.getPhones().isEmpty() || usuario.getPhones().size() < 0) {
            throw new Exception("El campo 'phones' es obligatorio.");
        }   
        
    }
    
    
    // Expresión regular para validar el formato de correo
    //private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
    //private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String EMAIL_REGEX = "^(?=.{1,256}$)[a-zA-Z0-9_-]+(\\\\.[a-zA-Z0-9_-]+)*(\\\\.[a-zA-Z0-9]+)*(\\\\.[a-zA-Z]{2,})$\r\n" + "";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);

    public boolean validarFormatoCorreo(String correo) {
       Matcher matcher = pattern.matcher(correo);
       return matcher.matches();
    }
    
    
    
}
