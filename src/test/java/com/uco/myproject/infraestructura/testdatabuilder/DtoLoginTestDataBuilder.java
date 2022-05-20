package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoLogin;

public class DtoLoginTestDataBuilder {

    private String nombre;
    private String password;

    public DtoLoginTestDataBuilder() {
        this.nombre = "Santiago";
        this.password = "w3Unpo<code>t0d0";
    }

    public DtoLogin build() {
        return new DtoLogin(nombre, password);
    }
}
