package com.uco.myproject.infraestructura.adaptador.repositorio.jpa;

import com.uco.myproject.infraestructura.adaptador.entidad.EntidadTamano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioTamanoJpa extends JpaRepository<EntidadTamano, Long> {

    EntidadTamano findByNombreAndEspecificacion(String nombre, String especificacion);
}
