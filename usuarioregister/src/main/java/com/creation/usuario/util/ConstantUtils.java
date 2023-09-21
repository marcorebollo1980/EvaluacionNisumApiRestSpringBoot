package com.creation.usuario.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ConstantUtils {
	
	// Expresión regular para validar el formato de correo
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
    
    public boolean validarFormatoCorreo(String correo) {
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

}
