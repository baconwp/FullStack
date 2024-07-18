package com.baconwp.app.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double precio;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_creacion")
    private Date feachaCreacion;

    @PrePersist
    protected void prePersist() {
        feachaCreacion = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getFeachaCreacion() {
        return feachaCreacion;
    }

    public void setFeachaCreacion(Date feachaCreacion) {
        this.feachaCreacion = feachaCreacion;
    }

    private static final long serialVersionUID = 1L;
}
