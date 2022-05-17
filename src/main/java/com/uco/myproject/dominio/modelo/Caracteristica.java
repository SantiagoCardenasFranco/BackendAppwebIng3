package com.uco.myproject.dominio.modelo;

import com.uco.myproject.dominio.validador.ValidadorAtributos;
import com.uco.myproject.dominio.validador.ValidadorObjeto;
import lombok.Getter;

@Getter
public class Caracteristica {

    private final String marca;
    private final String descripcion;
    private final Tamano tamano;
    private final String proveedor;

    public static Caracteristica of(String marca, String descripcion, Tamano tamano, String proveedor) {

        ValidadorAtributos.validarObligatorio(marca, "La marca no puede ser vacia");
        ValidadorAtributos.validarObligatorio(descripcion, "La descripcion no puede ser vacia");
        ValidadorObjeto.validarObjeto(tamano, "El tamaño no puede ser vacio");
        ValidadorAtributos.validarObligatorio(proveedor, "La contraseña no puede estar vacia");

        return new Caracteristica(marca, descripcion, tamano, proveedor);
    }

    private Caracteristica(String marca, String descripcion, Tamano tamano, String proveedor) {
        this.marca = marca;
        this.descripcion = descripcion;
        this.tamano = tamano;
        this.proveedor = proveedor;
    }
}
