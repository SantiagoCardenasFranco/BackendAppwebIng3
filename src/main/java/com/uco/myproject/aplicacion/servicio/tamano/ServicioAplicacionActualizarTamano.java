package com.uco.myproject.aplicacion.servicio.tamano;

import com.uco.myproject.aplicacion.dto.DtoTamano;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.dominio.servicio.tamano.ServicioActualizarTamano;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionActualizarTamano {

    private final ServicioActualizarTamano servicioActualizarTamano;

    public ServicioAplicacionActualizarTamano(ServicioActualizarTamano servicioActualizarTamano) {
        this.servicioActualizarTamano = servicioActualizarTamano;
    }

    public DtoRespuesta<Boolean> ejecutar(Long id, DtoTamano dto) {
        Tamano tamano = Tamano.of(dto.getNombre(), dto.getEspecificacion());
        return new DtoRespuesta<>(this.servicioActualizarTamano.ejecutar(id,tamano));
    }
}
