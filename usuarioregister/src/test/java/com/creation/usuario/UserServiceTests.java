package com.creation.usuario;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.creation.usuario.entities.Usuario;
import com.creation.usuario.repository.UsarioRepository;
import com.creation.usuario.service.UserService;

@SpringBootTest
public class UserServiceTests {
	
	@InjectMocks
    private UserService userService;

    @Mock
    private UsarioRepository usarioRepository;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testFindUserById() {
        // Datos de prueba
        long userId = 1L;
        Usuario user = new Usuario();
        user.setId(userId);
        user.setName("john_doe");

        // Configuración de comportamiento de UserRepository mock
        Mockito.when(usarioRepository.findById(userId)).thenReturn(user);

        // Ejecutar el método que se va a probar
        Usuario foundUser = userService.findUsuarioById(userId);

        // Realizar aserciones para verificar si el método se ejecutó correctamente
        assertEquals(userId, foundUser.getId());
        assertEquals("john_doe", foundUser.getName());
    }

    @Test
    public void testFindUserByUsername() {
        // Datos de prueba
        String username = "jane_smith";
        Usuario user = new Usuario();
        user.setId(2L);
        user.setName(username);

        // Configuración de comportamiento de UserRepository mock
        Mockito.when(usarioRepository.findUsuarioByName(username)).thenReturn(user);

        // Ejecutar el método que se va a probar
        Usuario foundUser = userService.findUsuarioByName(username);

        // Realizar aserciones para verificar si el método se ejecutó correctamente
        assertEquals(username, foundUser.getName());
    }
    
    

}
