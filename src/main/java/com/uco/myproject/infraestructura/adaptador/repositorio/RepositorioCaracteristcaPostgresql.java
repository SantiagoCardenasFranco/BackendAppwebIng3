package com.uco.myproject.infraestructura.adaptador.repositorio;

import com.uco.myproject.dominio.modelo.Caracteristica;
import com.uco.myproject.dominio.modelo.Tamano;
import com.uco.myproject.dominio.puerto.RepositorioCaracteristica;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadCaracteristica;
import com.uco.myproject.infraestructura.adaptador.entidad.EntidadTamano;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioCaracteristicaJpa;
import com.uco.myproject.infraestructura.adaptador.repositorio.jpa.RepositorioTamanoJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class RepositorioCaracteristcaPostgresql implements RepositorioCaracteristica {

    private final RepositorioCaracteristicaJpa repositorioCaracteristicaJpa;
    private final RepositorioTamanoJpa repositorioTamanoJpa;

    public RepositorioCaracteristcaPostgresql(RepositorioCaracteristicaJpa repositorioCaracteristicaJpa, RepositorioTamanoJpa repositorioTamanoJpa) {
        this.repositorioCaracteristicaJpa = repositorioCaracteristicaJpa;
        this.repositorioTamanoJpa = repositorioTamanoJpa;
    }


    @Override
    public List<Caracteristica> listar() {

        List<EntidadCaracteristica> entidades = this.repositorioCaracteristicaJpa.findAll();
        return entidades.stream().map(entidad -> Caracteristica.of(entidad.getMarca(), entidad.getDescripcion(),
                Tamano.of(entidad.getEntidadTamano().getNombre(), entidad.getEntidadTamano().getEspecificacion()),
                entidad.getProveedor())).collect(Collectors.toList());
    }

    @Override
    public Caracteristica consultarPorId(Long id) {

        Optional<EntidadCaracteristica> entidadEncontrada = this.repositorioCaracteristicaJpa.findById(id);

        return entidadEncontrada
                .map(entidad -> Caracteristica.of(entidad.getMarca(), entidad.getDescripcion(),
                        Tamano.of(entidad.getEntidadTamano().getNombre(),
                                entidad.getEntidadTamano().getEspecificacion()),
                        entidad.getProveedor())).orElse(null);
    }

    @Override
    public Long guardar(Caracteristica caracteristica) {



        EntidadTamano entidadTamano = this.repositorioTamanoJpa.findByNombreAndEspecificacion(caracteristica.getTamano().getNombre(),
                caracteristica.getTamano().getEspecificacion());

        EntidadCaracteristica entidadCaracteristica = new EntidadCaracteristica(caracteristica.getMarca(),
                caracteristica.getDescripcion(),
                entidadTamano,
                caracteristica.getProveedor());

        return this.repositorioCaracteristicaJpa.save(entidadCaracteristica).getId();
    }

    @Override
    public boolean existe(Caracteristica caracteristica) {
        return this.repositorioCaracteristicaJpa.findByMarca(caracteristica.getMarca()) != null;
    }

    @Override
    public Boolean eliminar(Long id) {
        repositorioCaracteristicaJpa.deleteById(id);
        return true;
    }

    @Override
    public Boolean actualizar(Long id, Caracteristica caracteristica) {
        EntidadTamano entidadTamano = this.repositorioTamanoJpa.findByNombreAndEspecificacion(caracteristica.getTamano().getNombre(),
                caracteristica.getTamano().getEspecificacion());
        repositorioCaracteristicaJpa.findById(id);
        EntidadCaracteristica entidadCaracteristica = new EntidadCaracteristica();
        entidadCaracteristica.setId(id);
        entidadCaracteristica.setDescripcion(caracteristica.getDescripcion());
        entidadCaracteristica.setMarca(caracteristica.getMarca());
        entidadCaracteristica.setEntidadTamano(entidadTamano);
        entidadCaracteristica.setProveedor(caracteristica.getProveedor());
        repositorioCaracteristicaJpa.save(entidadCaracteristica);
        return true;
    }
}
