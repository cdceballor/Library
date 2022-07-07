package com.ceiba.biblioteca.errors;

public class PrestamoUsuarioNoPermitidoExcepcion extends RuntimeException {
    public PrestamoUsuarioNoPermitidoExcepcion (){
        super("Tipo de usuario no permitido en la biblioteca");
    }
}
