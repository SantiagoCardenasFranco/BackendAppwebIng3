package com.uco.myproject.infraestructura.controlador;

import com.uco.myproject.aplicacion.dto.DtoLogin;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.aplicacion.servicio.ServicioAplicacionLogin;
import com.uco.myproject.infraestructura.aspecto.LogExecutionTime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/login")
@Tag(name = "Controlador Login")
public class ControladorLogin {

    private final ServicioAplicacionLogin servicioAplicacionLogin;

    public ControladorLogin(ServicioAplicacionLogin servicioAplicacionLogin) {
        this.servicioAplicacionLogin = servicioAplicacionLogin;
    }


    @PostMapping
    @LogExecutionTime
    @Operation(summary = "Login", description = "Elemento usado para hacer login a la aplicación")
    public DtoRespuesta<String> login(@RequestBody DtoLogin dto) {
        return this.servicioAplicacionLogin.ejecutar(dto);
    }

}
