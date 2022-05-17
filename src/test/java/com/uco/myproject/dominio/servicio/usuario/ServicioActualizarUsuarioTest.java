package com.uco.myproject.dominio.servicio.usuario;

import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.dominio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarUsuarioTest {

    @Test
    void noExisteUusuarioParaActualizar()
    {
        var usuario = new UsuarioTestDataBuilder().build();

        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio = new ServicioActualizarUsuario(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("NO SE ENCONTRÓ AL USUARIO O NO EXISTE",
                Assertions.assertThrows(IllegalStateException.class,
                        () -> servicio.ejecutar(1L, usuario)).getMessage());
    }
}
