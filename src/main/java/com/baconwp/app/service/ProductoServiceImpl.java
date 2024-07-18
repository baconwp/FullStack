package com.baconwp.app.service;

import com.baconwp.app.models.entities.Producto;
import com.baconwp.app.repositorios.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImpl implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);

    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductporId(Long id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public Producto create(Producto producto) {
        return productoRepository.save(producto);
    }
}
