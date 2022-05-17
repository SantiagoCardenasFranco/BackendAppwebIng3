package com.uco.myproject.dominio.servicio.usuario;

import com.uco.myproject.dominio.modelo.Usuario;
import com.uco.myproject.dominio.puerto.RepositorioUsuario;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarUsuario {

    private static final String PERSONA_ACTUALIZADA = "NO SE ENCONTRÓ AL USUARIO O NO EXISTE";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario)
    {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Boolean ejecutar(Long id, Usuario usuario){
        if(repositorioUsuario.consultarPorId(id) != null){
            return this.repositorioUsuario.actualizar(id, usuario);
        }else
        {
            throw new IllegalStateException(PERSONA_ACTUALIZADA);
        }
    }
}
