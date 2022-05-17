package com.uco.myproject.infraestructura.adaptador.servicio;

import com.uco.myproject.dominio.servicio.ServicioCifrarTexto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
@Tag(name = "Encriptador")
public class ServicioCifrarTextoSha implements ServicioCifrarTexto {

    @Operation(summary = "Encriptador", description = "Encargado de encriptar las contraseñas de los usuarios")
    @Override
    public String ejecutar(String texto) {
        return DigestUtils.sha256Hex(texto);
    }
}
