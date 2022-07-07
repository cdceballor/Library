package com.ceiba.biblioteca.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "")
public class PrestamoUsuarioInvitadoExcepcion extends RuntimeException {

   public PrestamoUsuarioInvitadoExcepcion(String userId){
        super("El usuario con identificación " +userId +
        " tiene 1 libro prestado por lo cual no se le puede realizar otro préstamo");
    }
}
