package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoTamano;

public class DtoTamanoTestDataBuilder {

    private String nombre;
    private String especificacion;

    public DtoTamanoTestDataBuilder() {
        this.nombre = "juan";
        this.especificacion = "Va desde 30 a 50 cm";
    }

    public DtoTamanoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DtoTamanoTestDataBuilder conEspecificacion(String especificacion) {
        this.especificacion = especificacion;
        return this;
    }

    public DtoTamano build() {
        return new DtoTamano(nombre, especificacion);
    }
}
