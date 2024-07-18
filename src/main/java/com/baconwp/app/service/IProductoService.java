package com.baconwp.app.service;



import com.baconwp.app.models.entities.Producto;

import java.util.List;

public interface IProductoService {

    public Producto create(Producto producto);
    public Producto obtenerProductporId(Long id);
    public List<Producto> listarProductos();
    public void deleteProducto(Long id);
}
