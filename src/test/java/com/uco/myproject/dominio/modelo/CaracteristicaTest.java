package com.uco.myproject.dominio.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaracteristicaTest {

    @Test
    void validarCreacionExitosa() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String marca = "LG";
        String descripcion = "Fundada en un año";
        Tamano tamano = Tamano.of("Grande", "Va desde 32 a 50 cm");
        String proveedor = "Gerente de LG";

        //act (ejecuta el metodo a probar)
        Caracteristica caracteristica = Caracteristica.of(marca, descripcion, tamano, proveedor);

        //assert se valida el resultado

        Assertions.assertEquals("LG", caracteristica.getMarca());
        Assertions.assertEquals("Fundada en un año", caracteristica.getDescripcion());
        Assertions.assertEquals("Grande", caracteristica.getTamano().getNombre());
        Assertions.assertEquals("Gerente de LG", caracteristica.getProveedor());
    }

    @Test
    void validarCamposFaltantes() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String marca = null;
        String descripcion = "Fundada en un año";
        Tamano tamano = Tamano.of("Grande", "Va desde 32 a 50 cm");
        String proveedor = "Gerente de LG";

        //act - assert (ejecuta el metodo a probar)

        Assertions.assertEquals("La marca no puede ser vacia",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Caracteristica.of(marca, descripcion, tamano, proveedor)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String marca = "";
        String descripcion = "Fundada en un año";
        Tamano tamano = Tamano.of("Grande", "Va desde 32 a 50 cm");
        String proveedor = "Gerente de LG";

        //act - assert (ejecuta el metodo a probar)

        Assertions.assertEquals("La marca no puede ser vacia",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Caracteristica.of(marca, descripcion, tamano, proveedor)
        ).getMessage());
    }
}
