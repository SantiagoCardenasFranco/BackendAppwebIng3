package com.uco.myproject.aplicacion.servicio.usuario;

import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.modelo.RolUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.servicio.ServicioCifrarTexto;
import com.uco.myproject.dominio.servicio.usuario.ServicioGuardarUsuario;
import com.uco.myproject.dominio.validador.ValidadorAtributos;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionGuardarUsuario {

    private final ServicioGuardarUsuario servicioGuardarUsuario;
    private final ServicioCifrarTexto servicioCifrarTexto;

    public ServicioAplicacionGuardarUsuario(ServicioGuardarUsuario servicioGuardarUsuario, ServicioCifrarTexto servicioCifrarTexto) {
        this.servicioGuardarUsuario = servicioGuardarUsuario;
        this.servicioCifrarTexto = servicioCifrarTexto;
    }

    public DtoRespuesta<Long> ejecutar(DtoUsuario dto) {

        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"),RolUsuario.of("EGRESADO"));
       /* ValidadorAtributos.implemetacionCaracteresEspecialesPassword(dto.getPassword(),
                "La escritura de la clave tiene unas reglas ya definidas");*/

        Usuario usuario = Usuario.of(dto.getNombre(), dto.getApellido(), dto.getCorreo(),
                dto.getPassword(), roles);

        ValidadorAtributos.implemetacionCaracteresEspecialesPassword(dto.getPassword(), "La contaseña tiene unas reglas de escritura");

        String claveCifrada = this.servicioCifrarTexto.ejecutar(usuario.getPassword());
        usuario.asignarClaveCifrada(claveCifrada);

        return new DtoRespuesta<>(this.servicioGuardarUsuario.ejecutar(usuario));
    }
}
