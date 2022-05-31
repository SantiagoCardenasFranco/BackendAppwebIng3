package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoUsuario;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.usuario.ServicioAplicacionActualizarUsuario;
import com.uco.myproject.aplicacion.servicio.usuario.ServicioAplicacionEliminarUsuario;
import com.uco.myproject.aplicacion.servicio.usuario.ServicioAplicacionGuardarUsuario;
import com.uco.myproject.aplicacion.servicio.usuario.ServicioAplicacionListarUsuario;
import com.uco.myproject.dominio.dto.DtoUsuarioResumen;
import com.uco.myproject.infraestructura.aspecto.Secured;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuario {

    private final ServicioAplicacionListarUsuario servicioAplicacionListarUsuario;
    private final ServicioAplicacionGuardarUsuario servicioAplicacionGuardarUsuario;
    private final ServicioAplicacionEliminarUsuario servicioAplicacionEliminarUsuario;
    private final ServicioAplicacionActualizarUsuario servicioAplicacionActualizarUsuario;

    public ControladorUsuario(ServicioAplicacionListarUsuario servicioAplicacionListarUsuario,
                              ServicioAplicacionGuardarUsuario servicioAplicacionGuardarUsuario,
                              ServicioAplicacionEliminarUsuario servicioAplicacionEliminarUsuario,
                              ServicioAplicacionActualizarUsuario servicioAplicacionActualizarUsuario) {
        this.servicioAplicacionListarUsuario = servicioAplicacionListarUsuario;
        this.servicioAplicacionGuardarUsuario = servicioAplicacionGuardarUsuario;
        this.servicioAplicacionEliminarUsuario = servicioAplicacionEliminarUsuario;
        this.servicioAplicacionActualizarUsuario = servicioAplicacionActualizarUsuario;
    }

    @GetMapping
    @Secured(roles = {"EMPLEADO"})
    public List<DtoUsuarioResumen> listar() {
        return servicioAplicacionListarUsuario.ejecutar();
    }

    @PostMapping
    public DtoRespuesta<Long> crear(@RequestBody DtoUsuario dto) {
        //return ResponseEntity.status(HttpStatus.CREATED).body(this.servicioAplicacionGuardarUsuario.ejecutar(dto));
        return this.servicioAplicacionGuardarUsuario.ejecutar(dto);
    }

    @DeleteMapping(value = "/{id}")
    @Secured(roles = {"EMPLEADO"})
    public DtoRespuesta<Boolean> eliminar(@PathVariable Long id) {
        return this.servicioAplicacionEliminarUsuario.ejecutar(id);
    }

    @PutMapping(value = "/{id}")
    @Secured(roles = {"EMPLEADO"})
    public DtoRespuesta<Boolean> actualizar(@PathVariable Long id, @RequestBody DtoUsuario dto){
        return this.servicioAplicacionActualizarUsuario.ejecutar(id,dto);
    }
}
