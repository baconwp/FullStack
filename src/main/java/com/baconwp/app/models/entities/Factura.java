package com.baconwp.app.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String observacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_registro")
    private Date fecharegistro;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private List<ItemFactura> items;

    public Factura() {
        this.items = new ArrayList<ItemFactura>();
    }

    @PrePersist
    public void prePersist() {
        fecharegistro = new Date();
    }


    public Factura(Long id, String description, String observacion, Date fecharegistro, Cliente cliente) {
        this.id = id;
        this.description = description;
        this.observacion = observacion;
        this.fecharegistro = fecharegistro;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

    public void addItem(ItemFactura item) {
        this.items.add(item);
    }

    public Double gettotal(){
        Double total = 0.0;

        int size = items.size();

        for(int i = 0; i < size; i++){
            total += items.get(i).calculateTotal();
        }

        return total;
    }

    private static final long serialVersionUID = 1L;



}
