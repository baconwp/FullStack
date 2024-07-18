package com.baconwp.app.controllers;


import com.baconwp.app.models.entities.Producto;
import com.baconwp.app.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;

    @PostMapping("/crear")
    public ResponseEntity<?> saveProdcuto(@RequestBody Producto producto) {

        if(producto == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(productoService.create(producto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productoService.obtenerProductporId(id), HttpStatus.OK);

    }

    @GetMapping("/listar")
    public ResponseEntity<List<?>> listarProductos(){
        return new ResponseEntity<>(productoService.listarProductos(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delteCliente(@PathVariable Long id){
        productoService.deleteProducto(id);
    }
}
