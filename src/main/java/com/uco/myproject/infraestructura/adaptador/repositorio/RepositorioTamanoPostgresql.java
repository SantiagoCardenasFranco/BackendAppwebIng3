package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.dominio.puerto.RepositorioTamano;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadTamano;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioTamanoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositorioTamanoPostgresql implements RepositorioTamano {

    private final RepositorioTamanoJpa repositorioTamanoJpa;

    public RepositorioTamanoPostgresql(RepositorioTamanoJpa repositorioTamanoJpa) {
        this.repositorioTamanoJpa = repositorioTamanoJpa;
    }

    @Override
    public List<Tamano> listar() {
        List<EntidadTamano> entidades = this.repositorioTamanoJpa.findAll();
        return entidades.stream().map(entidad -> Tamano.of(entidad.getNombre(), entidad.getEspecificacion()
                )).collect(Collectors.toList());
    }

    @Override
    public Long guardar(Tamano tamano) {
        EntidadTamano entidadTamano = new EntidadTamano(tamano.getNombre(), tamano.getEspecificacion());
        return this.repositorioTamanoJpa.save(entidadTamano).getId();
    }

    @Override
    public boolean existe(Tamano tamano) {
        return this.repositorioTamanoJpa.findByNombreAndEspecificacion(tamano.getNombre(),
                tamano.getEspecificacion()) != null;
    }

    @Override
    public Tamano consultarPorId(Long id) {
        return this.repositorioTamanoJpa
                .findById(id)
                .map(entidad -> Tamano.of(entidad.getNombre(), entidad.getEspecificacion()))
                .orElse(null);
    }

    @Override
    public Boolean eliminar(Long id) {
        repositorioTamanoJpa.findById(id);
        repositorioTamanoJpa.deleteById(id);
        return true;
    }

    @Override
    public Boolean actualizar(Long id, Tamano tamano) {
        repositorioTamanoJpa.findById(id);
        EntidadTamano entidadTamano = new EntidadTamano();
        entidadTamano.setId(id);
        entidadTamano.setNombre(tamano.getNombre());
        entidadTamano.setEspecificacion(tamano.getEspecificacion());
        repositorioTamanoJpa.save(entidadTamano);
        return true;
    }
}
