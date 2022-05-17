package com.uco.myproject.dominio.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TamanoTest {

    @Test
    void validarCreacionExitosa() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = "Grande";
        String especificacion = "Va desde 30 a 50 cm";

        //act (ejecuta el metodo a probar)
        Tamano tamano = Tamano.of(nombre, especificacion);

        //assert se valida el resultado

        Assertions.assertEquals("Grande", tamano.getNombre());
        Assertions.assertEquals("Va desde 30 a 50 cm", tamano.getEspecificacion());
    }

    @Test
    void validarCamposFaltantes() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = null;
        String especificacion = "Va desde 30 a 50 cm";
        //act - assert (ejecuta el metodo a probar)

        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
            Tamano.of(nombre, especificacion)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = "";
        String especificacion = "Va desde 30 a 50 cm";

        //act - assert (ejecuta el metodo a probar)

        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Tamano.of(nombre, especificacion)
        ).getMessage());
    }
}
