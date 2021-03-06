package com.uco.myproject.aplicacion.servicio;

import com.uco.myproject.aplicacion.dto.DtoLogin;
import com.uco.myproject.aplicacion.dto.respuesta.DtoRespuesta;
import com.uco.myproject.dominio.modelo.RolUsuario;
import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import com.uco.myproject.dominio.servicio.ServicioCifrarTexto;
import com.uco.myproject.dominio.servicio.ServicioGenerarToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicioAplicacionLogin {

    private final ServicioGenerarToken servicioGenerarToken;
    private final ServicioCifrarTexto servicioCifrarTexto;
    private final RepositorioUsuario repositorioUsuario;

    public ServicioAplicacionLogin(ServicioGenerarToken servicioGenerarToken,ServicioCifrarTexto servicioCifrarTexto,
                                   RepositorioUsuario repositorioUsuario) {
        this.servicioGenerarToken = servicioGenerarToken;
        this.servicioCifrarTexto = servicioCifrarTexto;
        this.repositorioUsuario = repositorioUsuario;
    }

    public DtoRespuesta<String> ejecutar(DtoLogin dto) {

        String claveCifrada = this.servicioCifrarTexto.ejecutar(dto.getPassword());
        Usuario usuario = this.repositorioUsuario.consultar(dto.getNombre(), claveCifrada);

        if(usuario == null) {
            throw new IllegalStateException("Usuario o clave incorrecta");
        }

        List<String> roles = usuario.getRoles().stream().map(RolUsuario::getRol).collect(Collectors.toList());

        return new DtoRespuesta<>(this.servicioGenerarToken.ejecutar(dto.getNombre(), roles));
    }
}
