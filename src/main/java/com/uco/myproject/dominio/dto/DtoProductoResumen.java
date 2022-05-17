package com.uco.myproject.dominio.dto;

import com.uco.myproject.dominio.modelo.Caracteristica;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DtoProductoResumen {

    private String nombre;
    private Caracteristica caracteristica;

    public DtoProductoResumen(String nombre, Caracteristica caracteristica) {
        this.nombre = nombre;
        this.caracteristica = caracteristica;
    }
}
