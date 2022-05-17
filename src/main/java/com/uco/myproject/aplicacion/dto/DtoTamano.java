package com.uco.myproject.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoTamano {

    private String nombre;
    private String especificacion;

    public DtoTamano() {
    }

    public DtoTamano(String nombre, String especificacion) {
        this.nombre = nombre;
        this.especificacion = especificacion;
    }
}
