package com.uco.myproject.infraestructura.adaptador.entidad;

import javax.persistence.*;

@Entity
@Table(name = "tamano")
public class EntidadTamano {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;
    private String especificacion;

    public EntidadTamano() {}

    public EntidadTamano(String nombre, String especificacion) {
        this.nombre = nombre;
        this.especificacion = especificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getId() {
        return id;
    }

    public String getEspecificacion() {
        return especificacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecificacion(String especificacion) {
        this.especificacion = especificacion;
    }
}
