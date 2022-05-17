package com.uco.myproject.dominio.servicio.producto;

import com.uco.myproject.dominio.puerto.RepositorioProducto;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarProducto {

    private static final String MENSAJE_NO_EXISTE = "El producto que intenta eliminar no está en el repositorio";

    private final RepositorioProducto repositorioProducto;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto){
        this.repositorioProducto = repositorioProducto;
    }

    public Boolean ejecutar(Long id) {
        if (repositorioProducto.consultarPorId(id) != null)
        {
            return this.repositorioProducto.eliminar(id);
        }
        else {
            throw new IllegalStateException(MENSAJE_NO_EXISTE);
        }
    }
}
