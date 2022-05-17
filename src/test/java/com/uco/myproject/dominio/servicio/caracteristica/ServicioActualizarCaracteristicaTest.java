package com.uco.myproject.dominio.servicio.caracteristica;

import com.uco.myproject.dominio.puerto.RepositorioCaracteristica;
import com.uco.myproject.dominio.testdatabuilder.CaracteristicaTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarCaracteristicaTest {

    @Test
    void noExisteUnaCaracteristicaParaActualizar()
    {
        var caracteristica = new CaracteristicaTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioCaracteristica.class);
        var servicio = new ServicioActualizarCaracteristica(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("NO SE ENCONTRÓ LA CARACTERISTICA O NO EXISTE",
                Assertions.assertThrows(IllegalStateException.class,
                        () -> servicio.ejecutar(1L, caracteristica)).getMessage());
    }
}
