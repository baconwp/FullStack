package com.baconwp.app.service;


import com.baconwp.app.models.entities.ItemFactura;

import java.util.List;

public interface IItemFacturaService {

    public ItemFactura create(ItemFactura itemFactura);
    public ItemFactura obtenerItemFacturaporId(Long id);
    public List<ItemFactura> listarItemFactura();
    public void deletefactura(Long id);
}
