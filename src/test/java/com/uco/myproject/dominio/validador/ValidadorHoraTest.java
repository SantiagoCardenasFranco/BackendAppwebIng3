package com.uco.myproject.dominio.validador;

import com.uco.myproject.dominio.servicio.ServicioObtenerHoraActual;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalTime;

class ValidadorHoraTest {

    @Test
    void validarHoraExitosa() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)

        ServicioObtenerHoraActual servicioObtenerHoraActual = Mockito.mock(ServicioObtenerHoraActual.class);
        Mockito.when(servicioObtenerHoraActual.ejecutar()).thenReturn(LocalTime.of(12,00));
        ValidadorHora validadorHora = new ValidadorHora(servicioObtenerHoraActual);

        //act - assert (ejecuta el metodo a probar) - se valida el resultado

        Assertions.assertDoesNotThrow(() -> validadorHora.validarHora());
    }

    @Test
    void validarCamposFaltantes() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)

        ServicioObtenerHoraActual servicioObtenerHoraActual = Mockito.mock(ServicioObtenerHoraActual.class);
        Mockito.when(servicioObtenerHoraActual.ejecutar()).thenReturn(LocalTime.of(22,00));
        ValidadorHora validadorHora = new ValidadorHora(servicioObtenerHoraActual);

        //act (ejecuta el metodo a probar)

        Assertions.assertEquals("No se puede ingresar despues de la hora establecida",Assertions.assertThrows(IllegalStateException.class, () ->
                validadorHora.validarHora()
        ).getMessage());
    }
}
