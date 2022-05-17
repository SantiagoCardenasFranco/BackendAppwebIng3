package com.uco.myproject.infraestructura.testdatabuilder;

import com.uco.myproject.aplicacion.dto.DtoCaracteristica;
import com.uco.myproject.aplicacion.dto.DtoTamano;

public class DtoCaracteristicaTestDataBuilder {

    private String marca;
    private String descripcion;
    private DtoTamano dtoTamano;
    private String proveedor;

    public DtoCaracteristicaTestDataBuilder() {
        this.marca = "LG";
        this.descripcion = "Fundación";
        this.dtoTamano = new DtoTamano("Grande", "Va desde 32 a 50 cm");
        this.proveedor = "Gerente de LG";
    }

    public DtoCaracteristicaTestDataBuilder conMarca(String marca) {
        this.marca = marca;
        return this;
    }

    public DtoCaracteristicaTestDataBuilder conDescrpcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public DtoCaracteristicaTestDataBuilder conDtoTamano(DtoTamano dtoTamano) {
        this.dtoTamano = dtoTamano;
        return this;
    }
    public DtoCaracteristicaTestDataBuilder conProveedor(String proveedor) {
        this.proveedor = proveedor;
        return this;
    }

        public DtoCaracteristica build() {
        return new DtoCaracteristica(marca, descripcion, dtoTamano, proveedor);
    }
}
