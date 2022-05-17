package com.uco.myproject.dominio.servicio.producto;

import com.uco.myproject.dominio.puerto.RepositorioProducto;
import com.uco.myproject.dominio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarProductoTest {

    @Test
    void noExisteUnProductoParaActualizar()
    {
        var producto = new ProductoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioProducto.class);
        var servicio = new ServicioActualizarProducto(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("NO SE ENCONTRÓ EL PRODUCTO O NO EXISTE",
                Assertions.assertThrows(IllegalStateException.class,
                        () -> servicio.ejecutar(1L, producto)).getMessage());
    }
}
