package com.uco.myproject.aplicacion.servicio.caracteristica;

import com.uco.myproject.dominio.modelo.Caracteristica;
import com.uco.myproject.dominio.puerto.RepositorioCaracteristica;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarCaracteristica {

    private final RepositorioCaracteristica repositorioCaracteristica;

    public ServicioAplicacionListarCaracteristica(RepositorioCaracteristica repositorioCaracteristica) {
        this.repositorioCaracteristica = repositorioCaracteristica;
    }

    public List<Caracteristica> ejecutar() {
        return this.repositorioCaracteristica.listar();
    }
}
