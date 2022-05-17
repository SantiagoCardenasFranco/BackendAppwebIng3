package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoTamano;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.tamano.ServicioAplicacionActualizarTamano;
import com.uco.myproject.aplicacion.servicio.tamano.ServicioAplicacionEliminarTamano;
import com.uco.myproject.aplicacion.servicio.tamano.ServicioAplicacionGuardarTamano;
import com.uco.myproject.aplicacion.servicio.tamano.ServicioAplicacionListarTamano;
import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.infraestructura.aspecto.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/tamanos")
public class ControladorTamano {

    private final ServicioAplicacionGuardarTamano servicioAplicacionGuardarTamano;
    private final ServicioAplicacionListarTamano servicioAplicacionListarTamano;
    private final ServicioAplicacionEliminarTamano servicioAplicacionEliminarTamano;
    private final ServicioAplicacionActualizarTamano servicioAplicacionActualizarTamano;

    public ControladorTamano(ServicioAplicacionGuardarTamano servicioAplicacionGuardarTamano, ServicioAplicacionListarTamano servicioAplicacionListarTamano, ServicioAplicacionEliminarTamano servicioAplicacionEliminarTamano, ServicioAplicacionActualizarTamano servicioAplicacionActualizarTamano) {
        this.servicioAplicacionGuardarTamano = servicioAplicacionGuardarTamano;
        this.servicioAplicacionListarTamano = servicioAplicacionListarTamano;
        this.servicioAplicacionEliminarTamano = servicioAplicacionEliminarTamano;
        this.servicioAplicacionActualizarTamano = servicioAplicacionActualizarTamano;
    }

    @GetMapping
    public List<Tamano> listar() {
        return servicioAplicacionListarTamano.ejecutar();
    }

    @PostMapping
    @Secured(roles = "EMPLEADO")
    public DtoRespuesta<Long> crear(@RequestBody DtoTamano dto) {
        return this.servicioAplicacionGuardarTamano.ejecutar(dto);
    }

    @DeleteMapping(value = "/{id}")
    public DtoRespuesta<Boolean> eliminar(@PathVariable Long id) {
        return this.servicioAplicacionEliminarTamano.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    public DtoRespuesta<Boolean> actualizar(@PathVariable Long id, @RequestBody DtoTamano dto){
        return this.servicioAplicacionActualizarTamano.ejecutar(id,dto);
    }
}
