package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoProducto;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.producto.ServicioAplicacionActualizarProducto;
import com.uco.myproject.aplicacion.servicio.producto.ServicioAplicacionEliminarProducto;
import com.uco.myproject.aplicacion.servicio.producto.ServicioAplicacionGuardarProducto;
import com.uco.myproject.aplicacion.servicio.producto.ServicioAplicacionListarProducto;
import com.uco.myproject.dominio.dto.DtoProductoResumen;
import com.uco.myproject.dominio.modelo.Producto;
import com.uco.myproject.infraestructura.aspecto.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/productos")
public class ControladorProducto {

    private final ServicioAplicacionGuardarProducto servicioAplicacionGuardarProducto;
    private final ServicioAplicacionListarProducto servicioAplicacionListarProducto;
    private final ServicioAplicacionEliminarProducto servicioAplicacionEliminarProducto;
    private final ServicioAplicacionActualizarProducto servicioAplicacionActualizarProducto;

    public ControladorProducto(ServicioAplicacionGuardarProducto servicioAplicacionGuardarProducto,
                               ServicioAplicacionListarProducto servicioAplicacionListarProducto, ServicioAplicacionEliminarProducto servicioAplicacionEliminarProducto, ServicioAplicacionActualizarProducto servicioAplicacionActualizarProducto) {
        this.servicioAplicacionGuardarProducto = servicioAplicacionGuardarProducto;
        this.servicioAplicacionListarProducto = servicioAplicacionListarProducto;
        this.servicioAplicacionEliminarProducto = servicioAplicacionEliminarProducto;
        this.servicioAplicacionActualizarProducto = servicioAplicacionActualizarProducto;
    }

    @GetMapping
    public List<Producto> listar() {
        return servicioAplicacionListarProducto.ejecutar();
    }

   @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoProducto dto) {
        return this.servicioAplicacionGuardarProducto.ejecutar(dto);
    }

    @DeleteMapping(value = "/{id}")
    @Secured(roles = "EMPLEADO")
    public DtoRespuesta<Boolean> eliminar(@PathVariable Long id) {
        return this.servicioAplicacionEliminarProducto.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    public DtoRespuesta<Boolean> actualizar(@PathVariable Long id, @RequestBody DtoProducto dto){
        return this.servicioAplicacionActualizarProducto.ejecutar(id,dto);
    }
}
