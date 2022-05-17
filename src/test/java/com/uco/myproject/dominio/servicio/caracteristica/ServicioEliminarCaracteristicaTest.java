package com.uco.myproject.dominio.servicio.caracteristica;

import com.uco.myproject.dominio.puerto.RepositorioCaracteristica;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarCaracteristicaTest {

    @Test
    void noExisteUnaCaracteristica()
    {
        var repositorio = Mockito.mock(RepositorioCaracteristica.class);
        var servicio = new ServicioEliminarCaracteristica(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("La caracteristica que intenta eliminar no está en el repositorio", Assertions.assertThrows(IllegalStateException.class,
                () -> servicio.ejecutar(1L)).getMessage());
    }

}
