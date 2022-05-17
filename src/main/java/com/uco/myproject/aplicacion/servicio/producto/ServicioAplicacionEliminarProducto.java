package com.uco.myproject.aplicacion.servicio.producto;

import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.servicio.producto.ServicioEliminarProducto;
import org.springframework.stereotype.Component;

@Component
public class ServicioAplicacionEliminarProducto {

    private final ServicioEliminarProducto servicioEliminarProducto;

    public ServicioAplicacionEliminarProducto(ServicioEliminarProducto servicioEliminarProducto) {
        this.servicioEliminarProducto = servicioEliminarProducto;
    }

    public DtoRespuesta<Boolean> ejecutar(Long id) {
        return new DtoRespuesta<>(this.servicioEliminarProducto.ejecutar(id));
    }
}
