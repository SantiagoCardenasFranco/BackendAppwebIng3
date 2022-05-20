package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoCaracteristica;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.caracteristica.ServicioAplicacionActualizarCaracteristica;
import com.uco.myproject.aplicacion.servicio.caracteristica.ServicioAplicacionEliminarCaracteristica;
import com.uco.myproject.aplicacion.servicio.caracteristica.ServicioAplicacionGuardarCaracteristica;
import com.uco.myproject.aplicacion.servicio.caracteristica.ServicioAplicacionListarCaracteristica;
import com.uco.myproject.dominio.modelo.Caracteristica;
import com.uco.myproject.infraestructura.aspecto.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/caracteristicas")
public class ControladorCaracteristica {

    private final ServicioAplicacionListarCaracteristica servicioAplicacionListarCaracteristica;
    private final ServicioAplicacionGuardarCaracteristica servicioAplicacionGuardarCaracteristica;
    private final ServicioAplicacionEliminarCaracteristica servicioAplicacionEliminarCaracteristica;
    private final ServicioAplicacionActualizarCaracteristica servicioAplicacionActualizarCaracteristica;

    public ControladorCaracteristica(ServicioAplicacionListarCaracteristica servicioAplicacionListarCaracteristica, ServicioAplicacionGuardarCaracteristica servicioAplicacionGuardarCaracteristica, ServicioAplicacionEliminarCaracteristica servicioAplicacionEliminarCaracteristica, ServicioAplicacionActualizarCaracteristica servicioAplicacionActualizarCaracteristica) {
        this.servicioAplicacionListarCaracteristica = servicioAplicacionListarCaracteristica;
        this.servicioAplicacionGuardarCaracteristica = servicioAplicacionGuardarCaracteristica;
        this.servicioAplicacionEliminarCaracteristica = servicioAplicacionEliminarCaracteristica;
        this.servicioAplicacionActualizarCaracteristica = servicioAplicacionActualizarCaracteristica;
    }

    @GetMapping
    @Secured(roles = "EMPLEADO")
    public List<Caracteristica> listar() {
        return servicioAplicacionListarCaracteristica.ejecutar();
    }

   @PostMapping
   @Secured(roles = "EMPLEADO")
    public DtoRespuesta<Long> crear(@RequestBody DtoCaracteristica dto) {
        return this.servicioAplicacionGuardarCaracteristica.ejecutar(dto);
    }

    @DeleteMapping(value = "/{id}")
    @Secured(roles = "EMPLEADO")
    public DtoRespuesta<Boolean> eliminar(@PathVariable Long id) {
        return this.servicioAplicacionEliminarCaracteristica.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @Secured(roles = "EMPLEADO")
    public DtoRespuesta<Boolean> actualizar(@PathVariable Long id, @RequestBody DtoCaracteristica dto){
        return this.servicioAplicacionActualizarCaracteristica.ejecutar(id,dto);
    }
}
