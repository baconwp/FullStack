package com.baconwp.app.controllers;

import com.baconwp.app.models.entities.Cliente;
import com.baconwp.app.models.entities.Factura;
import com.baconwp.app.service.IClienteService;
import com.baconwp.app.service.IFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    private IFacturaService facturaService;

    @PostMapping("/crear")
    public ResponseEntity<?> saveFactura(@RequestBody Factura factura) {

        if(factura == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(facturaService.create(factura), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(facturaService.obtenerFacturaporId(id), HttpStatus.OK);

    }

    @GetMapping("/listar")
    public ResponseEntity<List<?>> listarClientes(){
        return new ResponseEntity<>(facturaService.listarFactura(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteFactura(@PathVariable Long id){
        facturaService.deletefactura(id);
    }
}
