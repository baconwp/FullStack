package com.baconwp.app.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")

public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;


    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Factura> listafacturas;

    public Cliente() {
        this.listafacturas = new ArrayList<>();
    }

    public Cliente(Long id, String nmbre, List<Factura> listafacturas) {
        this.id = id;
        this.nombre = nmbre;
        this.listafacturas = listafacturas;
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

    public void setNombre(String nmbre) {
        this.nombre = nmbre;
    }

    public List<Factura> getListafacturas() {
        return listafacturas;
    }

    public void setListafacturas(List<Factura> listafacturas) {
        this.listafacturas = listafacturas;
    }

    public void addFactura(Factura factura) {
        this.listafacturas.add(factura);
    }

    private static final long serialVersionUID = 1L;
}
