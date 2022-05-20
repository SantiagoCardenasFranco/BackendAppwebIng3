package com.uco.myproject.aplicacion.servicio.producto;

import com.uco.myproject.aplicacion.dto.DtoProducto;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.modelo.*;
import com.uco.myproject.dominio.servicio.producto.ServicioGuardarProducto;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ServicioAplicacionGuardarProducto {

    private final ServicioGuardarProducto servicioGuardarProducto;

    public ServicioAplicacionGuardarProducto(ServicioGuardarProducto servicioGuardarProducto) {
        this.servicioGuardarProducto = servicioGuardarProducto;
    }

    public DtoRespuesta<Long> ejecutar(DtoProducto dto) {
        List<RolUsuario> roles = Arrays.asList(RolUsuario.of("EMPLEADO"),RolUsuario.of("EGRESADO"));

        Usuario usuario = Usuario.of(dto.getDtoUsuario().getNombre(), dto.getDtoUsuario().getApellido(), dto.getDtoUsuario().getCorreo(), dto.getDtoUsuario().getPassword(), roles);
        Tamano tamano = Tamano.of(dto.getDtoCaracteristica().getDtoTamano().getNombre(), dto.getDtoCaracteristica().getDtoTamano().getEspecificacion());
        Caracteristica caracteristica = Caracteristica.of(dto.getDtoCaracteristica().getMarca(), dto.getDtoCaracteristica().getDescripcion(), tamano, dto.getDtoCaracteristica().getProveedor());
        Producto producto = Producto.of(dto.getNombre(),usuario, caracteristica);
        return new DtoRespuesta<>(this.servicioGuardarProducto.ejecutar(producto));
    }
}
