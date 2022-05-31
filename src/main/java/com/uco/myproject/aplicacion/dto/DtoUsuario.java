package com.uco.myproject.aplicacion.dto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DtoUsuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String password;

    public DtoUsuario() {
    }

    public DtoUsuario(String nombre, String apellido, String correo, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.password = password;
    }

}
