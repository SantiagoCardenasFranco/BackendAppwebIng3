package com.uco.myproject.dominio.puerto;

import com.uco.myproject.dominio.dto.DtoProductoResumen;
import com.uco.myproject.dominio.modelo.Producto;

import java.util.List;

public interface RepositorioProducto {

    List<Producto> listar();
    DtoProductoResumen consultarPorId(Long id);
    Long guardar(Producto producto);
    Boolean eliminar(Long id);
    Boolean actualizar(Long id, Producto producto);
    boolean existe(Producto producto);
}
