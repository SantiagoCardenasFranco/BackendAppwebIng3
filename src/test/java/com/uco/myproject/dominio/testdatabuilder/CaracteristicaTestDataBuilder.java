package com.uco.myproject.dominio.testdatabuilder;

import com.uco.myproject.dominio.modelo.Caracteristica;
import com.uco.myproject.dominio.modelo.Tamano;

public class CaracteristicaTestDataBuilder {

    private String marca;
    private String descripcion;
    private Tamano tamano;
    private String proveedor;

    public CaracteristicaTestDataBuilder() {
        this.marca = "LG";
        this.descripcion = "Fundación";
        this.tamano = Tamano.of("Grande", "Va desde 32 a 50 cm");
        this.proveedor = "Gerente de LG";
    }

    public CaracteristicaTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public CaracteristicaTestDataBuilder conDescrpcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public CaracteristicaTestDataBuilder conTamano(Tamano tamano) {
        this.tamano = tamano;
        return this;
    }
    public CaracteristicaTestDataBuilder conProveedor(String proveedor) {
        this.proveedor = proveedor;
        return this;
    }

        public Caracteristica build() {
        return Caracteristica.of(marca, descripcion, tamano, proveedor);
    }
}
