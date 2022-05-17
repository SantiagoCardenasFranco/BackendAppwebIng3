package com.uco.myproject.dominio.puerto;


import com.uco.myproject.dominio.modelo.Caracteristica;

import java.util.List;

public interface RepositorioCaracteristica {

    List<Caracteristica> listar();
    Caracteristica consultarPorId(Long id);
    Long guardar(Caracteristica caracteristica);
    boolean existe(Caracteristica caracteristica);
    Boolean eliminar(Long id);
    Boolean actualizar(Long id, Caracteristica caracteristica);
}
