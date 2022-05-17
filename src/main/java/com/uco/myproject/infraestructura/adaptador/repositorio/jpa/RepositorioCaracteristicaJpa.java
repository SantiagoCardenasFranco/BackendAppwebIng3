package com.uco.myproject.infraestructura.adaptador.repositorio.jpa;

import com.uco.myproject.infraestructura.adaptador.entidad.EntidadCaracteristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCaracteristicaJpa extends JpaRepository<EntidadCaracteristica, Long> {

    EntidadCaracteristica findByMarca(String marca);

}
