package com.uco.myproject.dominio.servicio.caracteristica;

import com.uco.myproject.dominio.modelo.Caracteristica;
import com.uco.myproject.dominio.puerto.RepositorioCaracteristica;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarCaracteristica {

    private static final String MENSAJE_YA_EXISTE = "Ya existe una caracteristca con los datos ingresados";

    private final RepositorioCaracteristica repositorioCaracteristica;

    public ServicioGuardarCaracteristica(RepositorioCaracteristica repositorioCaracteristica) {
        this.repositorioCaracteristica = repositorioCaracteristica;
    }

    public Long ejecutar(Caracteristica caracteristica) {

        if(this.repositorioCaracteristica.existe(caracteristica)) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return this.repositorioCaracteristica.guardar(caracteristica);
    }
}
