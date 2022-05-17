package com.uco.myproject.dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.*;

import java.util.List;

public class ProductoTestDataBuilder {

    private String nombre;
    private Usuario usuario;
    private Caracteristica caracteristica;

    public ProductoTestDataBuilder() {
        this.nombre = "ProductoUno";
        this.usuario = Usuario.of("Santiago", "Cárdenas", "santicarfranco8@gmmail.com",
                "w3Unpo<code>t0d0",  List.of(RolUsuario.of("Empleado")));
        this.caracteristica = Caracteristica.of("LG", "Fundación",
                Tamano.of("Grande", "Va desde 32 a 50 cm") , "Gerente de LG");
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public ProductoTestDataBuilder conCaracteristica(Caracteristica caracteristica) {
        this.caracteristica = caracteristica;
        return this;
    }

        public Producto build() {
        return Producto.of(nombre, usuario, caracteristica);
    }
}
