package com.uco.myproject.dominio.servicio.producto;

import com.uco.myproject.dominio.modelo.Producto;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import org.springframework.stereotype.Service;

@Service
public class ServicioGuardarProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioGuardarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar(Producto producto) {
        return this.repositorioProducto.guardar(producto);
    }
}
