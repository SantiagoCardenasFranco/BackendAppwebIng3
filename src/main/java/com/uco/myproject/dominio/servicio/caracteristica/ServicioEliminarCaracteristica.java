package com.uco.myproject.dominio.servicio.caracteristica;

import com.uco.myproject.dominio.puerto.RepositorioCaracteristica;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarCaracteristica {

    private static final String MENSAJE_NO_EXISTE = "La caracteristica que intenta eliminar no está en el repositorio";

    private final RepositorioCaracteristica repositorioCaracteristica;

    public ServicioEliminarCaracteristica(RepositorioCaracteristica repositorioCaracteristica){
        this.repositorioCaracteristica = repositorioCaracteristica;
    }

    public Boolean ejecutar(Long id) {
        if(repositorioCaracteristica.consultarPorId(id) != null){
            return this.repositorioCaracteristica.eliminar(id);
        }else{
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
    }
}
