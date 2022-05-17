package com.uco.myproject.dominio.validador;

import java.util.List;

public class ValidadorAtributos {

    private static final String PATRON_CONTRASENA = "^(?=.*\\d)(?=.*[\\u0021-\\u002b\\u003c-\\u0040])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$";
    private static final String PATRON_CORREO = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private ValidadorAtributos() {
    }

    public static void validarObligatorio(String valor, String mensaje) {
        if(valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void longitudContrasena(String valor, String mensaje)
    {
        if(valor.length()>=8 && valor.length()<=15)
        {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static void noVacio(List<? extends Object> lista, String mensaje){
        if(lista == null || lista.isEmpty()){
            throw  new IllegalArgumentException(mensaje);
        }
    }

    public static boolean patronDeAceptacionClave(String dato, String patron)
    {
        return dato.matches(patron);
    }

    public static boolean patronDeAceptacionCorreo(String dato, String patron)
    {
        return dato.matches(patron);
    }

    public static void implemetacionCaracteresEspecialesPassword(String clave, String mensaje)
    {
        if(!patronDeAceptacionClave(clave, PATRON_CONTRASENA))
        {
            throw new IllegalArgumentException(mensaje);
        }
        else{
            ValidadorAtributos.longitudContrasena(clave, mensaje);
        }
    }

    public static void implemetacionCaracteresEspecialesCorreo(String correo, String mensaje)
    {
        if(!patronDeAceptacionCorreo(correo, PATRON_CORREO))
        {
            throw new IllegalArgumentException(mensaje);
        }
    }

}
