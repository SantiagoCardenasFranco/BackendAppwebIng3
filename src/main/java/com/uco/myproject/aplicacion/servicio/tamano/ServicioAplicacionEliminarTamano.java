package com.uco.myproject.aplicacion.servicio.tamano;

import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.servicio.tamano.ServicioEliminarTamano;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarTamano {

    private final ServicioEliminarTamano servicioEliminarTamano;

    public ServicioAplicacionEliminarTamano(ServicioEliminarTamano servicioEliminarTamano) {
        this.servicioEliminarTamano = servicioEliminarTamano;
    }

    public DtoRespuesta<Boolean> ejecutar(Long id) {
        return new DtoRespuesta<>(this.servicioEliminarTamano.ejecutar(id));
    }
}
