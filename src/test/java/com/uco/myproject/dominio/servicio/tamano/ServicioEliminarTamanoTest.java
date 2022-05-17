package com.uco.myproject.dominio.servicio.tamano;

import com.uco.myproject.dominio.puerto.RepositorioTamano;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarTamanoTest {

    @Test
    void noExisteUnTamano()
    {
        var repositorio = Mockito.mock(RepositorioTamano.class);
        var servicio = new ServicioEliminarTamano(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("El tamaño que intenta eliminar no está en el repositorio", Assertions.assertThrows(IllegalStateException.class,
                () -> servicio.ejecutar(1L)).getMessage());
    }

}
