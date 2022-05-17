package com.uco.myproject.dominio.validador;

public class ValidadorObjeto {

    private ValidadorObjeto() {
    }

    public static void validarObjeto(Object objeto, String mensaje){
        if(objeto == null){
            throw new IllegalArgumentException(mensaje);
        }
    }
}
