package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.dto.DtoProductoResumen;
import com.uco.myproject.dominio.dto.DtoUsuarioResumen;
import com.uco.myproject.dominio.modelo.*;
import com.uco.myproject.dominio.puerto.RepositorioProducto;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadCaracteristica;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadProducto;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadUsuario;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioCaracteristicaJpa;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioProductoJpa;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioUsuarioJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class RepositorioProductoPostgresql implements RepositorioProducto {

    private final RepositorioProductoJpa repositorioProductoJpa;
    private final RepositorioUsuarioJpa repositorioUsuarioJpa;
    private final RepositorioCaracteristicaJpa repositorioCaracteristicaJpa;

    public RepositorioProductoPostgresql(RepositorioProductoJpa repositorioProductoJpa, RepositorioUsuarioJpa repositorioUsuarioJpa, RepositorioCaracteristicaJpa repositorioCaracteristicaJpa) {
        this.repositorioProductoJpa = repositorioProductoJpa;
        this.repositorioUsuarioJpa = repositorioUsuarioJpa;
        this.repositorioCaracteristicaJpa = repositorioCaracteristicaJpa;
    }


    @Override
    public List<Producto> listar() {
        List<EntidadProducto> entidades = this.repositorioProductoJpa.findAll();
        List<EntidadUsuario> entidadUsuario = this.repositorioUsuarioJpa.findAll();
        List<RolUsuario> roles = entidadUsuario.stream().map(rol ->
                RolUsuario.of(rol.getRoles().toString())).toList();


        return entidades.stream().map(entidad -> Producto.of(entidad.getNombre(), Usuario.of(entidad.getEntidadUsuario().getNombre(),
                entidad.getEntidadUsuario().getApellido(), entidad.getEntidadUsuario().getCorreo(), entidad.getEntidadUsuario().getPassword(),
                roles), Caracteristica.of(entidad.getEntidadCaracteristica().getMarca(), entidad.getEntidadCaracteristica().getDescripcion(),
                Tamano.of(entidad.getEntidadCaracteristica().getEntidadTamano().getNombre(), entidad.getEntidadCaracteristica().getEntidadTamano().getEspecificacion())
                 ,entidad.getEntidadCaracteristica().getProveedor()))).toList();
    }

    @Override
    public DtoProductoResumen consultarPorId(Long id) {


        return this.repositorioProductoJpa
                .findById(id)
                .map(entidad -> new DtoProductoResumen(entidad.getNombre(),
                        Caracteristica.of(entidad.getEntidadCaracteristica().getMarca(),
                                entidad.getEntidadCaracteristica().getDescripcion(),
                                Tamano.of(entidad.getEntidadCaracteristica().getEntidadTamano().getNombre(),
                                        entidad.getEntidadCaracteristica().getEntidadTamano().getEspecificacion()),
                                entidad.getEntidadCaracteristica().getProveedor())))
               .orElse(null);
    }

    @Override
    public Long guardar(Producto producto) {
        EntidadUsuario entidadUsuario = this.repositorioUsuarioJpa.findByNombreAndApellido(producto.getUsuario().getNombre(), producto.getUsuario().getApellido());
        EntidadCaracteristica entidadCaracteristica =this.repositorioCaracteristicaJpa.findByMarca(producto.getCaracteristica().getMarca());

        EntidadProducto entidadProducto = new EntidadProducto(producto.getNombre(),
                entidadUsuario, entidadCaracteristica);

        return this.repositorioProductoJpa.save(entidadProducto).getIdProducto();
    }


    @Override
    public Boolean eliminar(Long id) {
        repositorioProductoJpa.deleteById(id);
        return true;
    }

    @Override
    public Boolean actualizar(Long id, Producto producto) {
        repositorioProductoJpa.findById(id);
        EntidadProducto entidadProducto = new EntidadProducto();
        entidadProducto.setIdProducto(id);
        entidadProducto.setNombre(producto.getNombre());
        repositorioProductoJpa.save(entidadProducto);
        return true;
    }

    @Override
    public boolean existe(Producto producto) {
        return this.repositorioProductoJpa.findByNombre(producto.getNombre()) != null;
    }
}
