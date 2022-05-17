package com.uco.myproject.dominio.modelo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class UsuarioTest {

    @Test
    void validarCreacionExitosa() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = "Santiago";
        String apellido = "Cárdenas";
        String correo = "santicarfranco8@gmmail.com";
        String password = "w3Unpo<code>t0d0";
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"),RolUsuario.of("EGRESADO"));

        //act (ejecuta el metodo a probar)
        Usuario usuario = Usuario.of(nombre, apellido, correo, password, roles);

        //assert se valida el resultado

        Assertions.assertEquals("Santiago", usuario.getNombre());
        Assertions.assertEquals("Cárdenas", usuario.getApellido());
    }

    @Test
    void validarCamposFaltantes() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = null;
        String apellido = "Cárdenas";
        String correo = "santicarfranco8@gmmail.com";
        String password = "w3Unpo<code>t0d0";
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"),RolUsuario.of("EGRESADO"));

        //act - assert (ejecuta el metodo a probar)

        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
            Usuario.of(nombre, apellido, correo, password, roles)
        ).getMessage());
    }

    @Test
    void validarCamposVacios() {
        //patron 3a

        //arrange (prepara todos los datos para la prueba)
        String nombre = "";
        String apellido = "Cárdenas";
        String correo = "santicarfranco8@gmmail.com";
        String password = "w3Unpo<code>t0d0";
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"),RolUsuario.of("EGRESADO"));
        //act - assert (ejecuta el metodo a probar)

        Assertions.assertEquals("El nombre no puede ser vacio",Assertions.assertThrows(IllegalArgumentException.class, () ->
                Usuario.of(nombre, apellido, correo, password, roles)
        ).getMessage());
    }
}
