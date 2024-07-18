package com.baconwp.app.service;


import com.baconwp.app.models.entities.Factura;

import java.util.List;

public interface IFacturaService {

    public Factura create(Factura factura);
    public Factura obtenerFacturaporId(Long id);
    public List<Factura> listarFactura();
    public void deletefactura(Long id);
}
