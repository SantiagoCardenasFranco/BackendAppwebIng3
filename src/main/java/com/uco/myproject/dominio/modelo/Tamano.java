package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.validador.ValidadorAtributos;
import lombok.Getter;

@Getter
public class Tamano {

    private final String nombre;
    private final String especificacion;

    public static Tamano of(String nombre, String especificacion) {

        ValidadorAtributos.validarObligatorio(nombre, "El nombre no puede ser vacio");
        ValidadorAtributos.validarObligatorio(especificacion, "La especificación no puede estar vacia");

        return new Tamano(nombre, especificacion);
    }

    private Tamano(String nombre, String especificacion) {
        this.nombre = nombre;
        this.especificacion = especificacion;
    }

}
