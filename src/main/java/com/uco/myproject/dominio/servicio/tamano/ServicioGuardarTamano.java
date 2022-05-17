package com.uco.myproject.dominio.servicio.tamano;

import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.dominio.puerto.RepositorioTamano;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarTamano {

    private static final String MENSAJE_YA_EXISTE = "Ya existe el tamaño con los datos ingresados";

    private final RepositorioTamano repositorioTamano;

    public ServicioGuardarTamano(RepositorioTamano repositorioTamano) {
        this.repositorioTamano = repositorioTamano;
    }

    public Long ejecutar(Tamano tamano) {

        if(this.repositorioTamano.existe(tamano)) {
            throw new IllegalStateException(MENSAJE_YA_EXISTE);
        }
        return this.repositorioTamano.guardar(tamano);
    }
}
