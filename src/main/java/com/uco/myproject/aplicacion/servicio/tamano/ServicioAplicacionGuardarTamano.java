package com.uco.myproject.aplicacion.servicio.tamano;

import com.uco.myproject.aplicacion.dto.DtoTamano;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.dominio.servicio.tamano.ServicioGuardarTamano;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionGuardarTamano {

    private final ServicioGuardarTamano servicioGuardarTamano;

    public ServicioAplicacionGuardarTamano(ServicioGuardarTamano servicioGuardarTamano) {
        this.servicioGuardarTamano = servicioGuardarTamano;
    }

    public DtoRespuesta<Long> ejecutar(DtoTamano dto) {

        Tamano tamano = Tamano.of(dto.getNombre(), dto.getEspecificacion());

        return new DtoRespuesta<>(this.servicioGuardarTamano.ejecutar(tamano));
    }
}
