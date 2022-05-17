package com.uco.myproject.dominio.servicio.producto;

import com.uco.myproject.dominio.modelo.Producto;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import org.springframework.stereotype.Service;

@Service
public class ServicioActualizarProducto {

    private static final String PERSONA_ACTUALIZADA = "NO SE ENCONTRÓ EL PRODUCTO O NO EXISTE";

    private final RepositorioProducto repositorioProducto;

    public ServicioActualizarProducto(RepositorioProducto repositorioProducto)
    {
        this.repositorioProducto = repositorioProducto;
    }

    public Boolean ejecutar(Long id, Producto producto){
        if(repositorioProducto.consultarPorId(id) != null){
            return this.repositorioProducto.actualizar(id, producto);
        }else {
            throw new IllegalStateException(PERSONA_ACTUALIZADA);
        }
    }
}
