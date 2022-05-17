package com.uco.myproject.aplicacion.servicio.tamano;

import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.dominio.puerto.RepositorioTamano;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarTamano {

    private final RepositorioTamano repositorioTamano;

    public ServicioAplicacionListarTamano(RepositorioTamano repositorioTamano) {
        this.repositorioTamano = repositorioTamano;
    }

    public List<Tamano> ejecutar() {
        return this.repositorioTamano.listar();
    }
}
