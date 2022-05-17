package com.uco.myproject.dominio.servicio.usuario;

import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarUsuarioTest {

    @Test
    void noExisteUnUsuario()
    {
        var repositorio = Mockito.mock(RepositorioUsuario.class);
        var servicio= new ServicioEliminarUsuario(repositorio);

        Mockito.when(!repositorio.existe(Mockito.any())).thenReturn(true);

        Assertions.assertEquals("El usuario que intenta eliminar no está en el repositorio", Assertions.assertThrows(IllegalStateException.class,
                () -> servicio.ejecutar(1L)).getMessage());
    }

}
