package com.baconwp.app.controllers;


import com.baconwp.app.models.entities.ItemFactura;
import com.baconwp.app.service.IItemFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemfactura")
public class ItemFacturaController {

    @Autowired
    private IItemFacturaService itemfacturaService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ItemFactura factura) {
        if(factura == null){
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(itemfacturaService.create(factura), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@RequestParam Long id) {
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }

        return new ResponseEntity<>(itemfacturaService.obtenerItemFacturaporId(id), HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<?>> listar(){
        return new ResponseEntity<>(itemfacturaService.listarItemFactura(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@RequestParam Long id) {
        if(id <= 0){
            return ResponseEntity.badRequest().build();
        }
        itemfacturaService.deletefactura(id);
        return ResponseEntity.noContent().build();
    }
}
