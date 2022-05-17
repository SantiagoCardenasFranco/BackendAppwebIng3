package com.uco.myproject.dominio.dto;

import lombok.Getter;

@Getter
public class DtoUsuarioResumen {

    private String nombre;
    private String apellido;
    private String correo;


    public DtoUsuarioResumen() {
    }

    public DtoUsuarioResumen(String nombre, String apellido, String correo
                             ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
}
