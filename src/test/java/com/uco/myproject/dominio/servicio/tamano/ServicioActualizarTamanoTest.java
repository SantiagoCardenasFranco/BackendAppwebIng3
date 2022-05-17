package com.uco.myproject.dominio.servicio.tamano;

import com.uco.myproject.dominio.puerto.RepositorioTamano;
import com.uco.myproject.dominio.testdatabuilder.TamanoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarTamanoTest {

    @Test
    void noExisteUnTamanoParaActualizar()
    {
        var tamano = new TamanoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioTamano.class);
        var servicio = new ServicioActualizarTamano(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("NO SE ENCONTRÓ EL TAMAÑO O NO EXISTE",
                Assertions.assertThrows(IllegalStateException.class,
                        () -> servicio.ejecutar(1L, tamano)).getMessage());
    }
}
