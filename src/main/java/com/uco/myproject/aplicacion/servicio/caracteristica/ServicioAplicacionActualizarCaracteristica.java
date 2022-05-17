package com.uco.myproject.aplicacion.servicio.caracteristica;

import com.uco.myproject.aplicacion.dto.DtoCaracteristica;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Caracteristica;
import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.dominio.servicio.caracteristica.ServicioActualizarCaracteristica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionActualizarCaracteristica {

    private final ServicioActualizarCaracteristica servicioActualizarCaracteristica;

    public ServicioAplicacionActualizarCaracteristica(ServicioActualizarCaracteristica servicioActualizarCaracteristica) {
        this.servicioActualizarCaracteristica = servicioActualizarCaracteristica;
    }

    public DtoRespuesta<Boolean> ejecutar(Long id, DtoCaracteristica dto) {
        Tamano tamano = Tamano.of(dto.getDtoTamano().getNombre(), dto.getDtoTamano().getEspecificacion());
        Caracteristica caracteristica = Caracteristica.of(dto.getMarca(), dto.getDescripcion(),
                tamano, dto.getProveedor());
        return new DtoRespuesta<>(this.servicioActualizarCaracteristica.ejecutar(id,caracteristica));
    }
}
