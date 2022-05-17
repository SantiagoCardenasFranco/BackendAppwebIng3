package com.uco.myproject.dominio.servicio.producto;

import com.uco.myproject.dominio.puerto.RepositorioProducto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarProductoTest {

    @Test
    void noExisteUnProducto()
    {
        var repositorio = Mockito.mock(RepositorioProducto.class);
        var servicio = new ServicioEliminarProducto(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("El producto que intenta eliminar no está en el repositorio", Assertions.assertThrows(IllegalStateException.class,
                () -> servicio.ejecutar(1L)).getMessage());
    }

}
