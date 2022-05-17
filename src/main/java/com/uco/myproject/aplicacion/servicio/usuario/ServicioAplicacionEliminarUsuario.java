package com.uco.myproject.aplicacion.servicio.usuario;

import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.servicio.usuario.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarUsuario {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ServicioAplicacionEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public DtoRespuesta<Boolean> ejecutar(Long id) {
        return new DtoRespuesta<>(this.servicioEliminarUsuario.ejecutar(id));
    }
}
