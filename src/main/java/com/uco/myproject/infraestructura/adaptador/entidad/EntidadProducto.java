package com.uco.myproject.infraestructura.adaptador.entidad;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class EntidadProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProducto;

    private String nombre;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private EntidadUsuario entidadUsuario;

    @ManyToOne
    @JoinColumn(name = "caracteritica_id")
    private EntidadCaracteristica entidadCaracteristica;

    public EntidadProducto() {
    }

    public EntidadProducto(String nombre, EntidadUsuario entidadUsuario,
                           EntidadCaracteristica entidadCaracteristica) {
        this.nombre = nombre;
        this.entidadUsuario = entidadUsuario;
        this.entidadCaracteristica = entidadCaracteristica;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public EntidadUsuario getEntidadUsuario() {
        return entidadUsuario;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public EntidadCaracteristica getEntidadCaracteristica() {
        return entidadCaracteristica;
    }

}
