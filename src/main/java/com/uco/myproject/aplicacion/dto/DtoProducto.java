package com.uco.myproject.aplicacion.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoProducto {

    private String nombre;
    private DtoUsuario dtoUsuario;
    private DtoCaracteristica dtoCaracteristica;

    public DtoProducto() {
    }

    public DtoProducto(String nombre, DtoUsuario dtoUsuario, DtoCaracteristica dtoCaracteristica) {
        this.nombre = nombre;
        this.dtoUsuario = dtoUsuario;
        this.dtoCaracteristica = dtoCaracteristica;
    }
}
