package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.validador.ValidadorAtributos;
import com.uco.myproject.dominio.validador.ValidadorObjeto;
import lombok.Getter;

@Getter
public class Producto {

    private final String nombre;
    private final Usuario usuario;
    private final Caracteristica caracteristica;

    public static Producto of(String nombre, Usuario usuario, Caracteristica caracteristica) {

        ValidadorAtributos.validarObligatorio(nombre, "El nombre no puede ser vacio");
        ValidadorObjeto.validarObjeto(usuario, "Un producto debe ser registrado por un usuario");
        ValidadorObjeto.validarObjeto(caracteristica, "La caracteristca de un producto no debe estar vacio");

        return new Producto(nombre, usuario, caracteristica);
    }

    private Producto(String nombre, Usuario usuario, Caracteristica caracteristica) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.caracteristica = caracteristica;
    }
}
