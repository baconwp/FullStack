package com.baconwp.app.service;

import com.baconwp.app.models.entities.Factura;
import com.baconwp.app.repositorios.IFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements IFacturaService{

    @Autowired
    private IFacturaRepository repository;

    @Override
    public void deletefactura(Long id) {

        repository.deleteById(id);

    }

    @Override
    public List<Factura> listarFactura() {
        return repository.findAll();
    }

    @Override
    public Factura obtenerFacturaporId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Factura create(Factura factura) {
        return repository.save(factura);
    }
}
