package com.uco.myproject.aplicacion.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoCaracteristica {

    private String marca;
    private String descripcion;
    private DtoTamano dtoTamano;
    private String proveedor;

    public DtoCaracteristica() {
    }

    public DtoCaracteristica(String marca, String descripcion, DtoTamano tamano, String proveedor) {
        this.marca = marca;
        this.descripcion = descripcion;
        this.dtoTamano = tamano;
        this.proveedor = proveedor;
    }
}
