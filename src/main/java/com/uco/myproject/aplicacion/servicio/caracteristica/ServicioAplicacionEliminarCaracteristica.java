package com.uco.myproject.aplicacion.servicio.caracteristica;

import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.servicio.caracteristica.ServicioEliminarCaracteristica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarCaracteristica {

    private final ServicioEliminarCaracteristica servicioEliminarCaracteristica;

    public ServicioAplicacionEliminarCaracteristica(ServicioEliminarCaracteristica servicioEliminarCaracteristica) {
        this.servicioEliminarCaracteristica = servicioEliminarCaracteristica;
    }

    public DtoRespuesta<Boolean> ejecutar(Long id) {
        return new DtoRespuesta<>(this.servicioEliminarCaracteristica.ejecutar(id));
    }
}
