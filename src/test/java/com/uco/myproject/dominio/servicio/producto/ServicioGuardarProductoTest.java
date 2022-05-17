package com.uco.myproject.dominio.servicio.producto;

import com.uco.myproject.dominio.modelo.Producto;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import com.uco.myproject.dominio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioGuardarProductoTest {

    @Test
    void guardarExitoso() {

        // arrange
        var producto = new ProductoTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioProducto.class);
        var servicio = new ServicioGuardarProducto(repositorio);


        Mockito.when(repositorio.guardar(Mockito.any(Producto.class))).thenReturn(1L);

        // act
        var id = servicio.ejecutar(producto);

        // assert
        Mockito.verify(repositorio, Mockito.times(1)).guardar(producto);
        Assertions.assertEquals(1L, id);

    }
}
