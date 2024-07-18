package com.baconwp.app.service;

import com.baconwp.app.models.entities.ItemFactura;
import com.baconwp.app.repositorios.IItemFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemFacturaServiceImpl implements IItemFacturaService{

    @Autowired
    private IItemFacturaRepository repository;

    @Override
    public void deletefactura(Long id) {

        repository.deleteById(id);

    }

    @Override
    public List<ItemFactura> listarItemFactura() {
        return repository.findAll();
    }

    @Override
    public ItemFactura obtenerItemFacturaporId(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public ItemFactura create(ItemFactura itemFactura) {
        return repository.save(itemFactura);
    }
}
