package com.uco.myproject.aplicacion.servicio.caracteristica;

import com.uco.myproject.aplicacion.dto.DtoCaracteristica;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Caracteristica;
import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.dominio.servicio.caracteristica.ServicioGuardarCaracteristica;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarCaracteristica {

    private final ServicioGuardarCaracteristica servicioGuardarCaracteristica;

    public ServicioAplicacionGuardarCaracteristica(ServicioGuardarCaracteristica servicioGuardarCaracteristica) {
        this.servicioGuardarCaracteristica = servicioGuardarCaracteristica;
    }

    public DtoRespuesta<Long> ejecutar(DtoCaracteristica dto) {
        Tamano tamano = Tamano.of(dto.getDtoTamano().getNombre(), dto.getDtoTamano().getEspecificacion());

        Caracteristica caracteristica = Caracteristica.of(dto.getMarca(), dto.getDescripcion(),
                tamano, dto.getProveedor());

        return new DtoRespuesta<>(this.servicioGuardarCaracteristica.ejecutar(caracteristica));
    }
}
