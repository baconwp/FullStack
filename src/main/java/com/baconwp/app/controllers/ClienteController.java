package com.baconwp.app.controllers;


import com.baconwp.app.models.entities.Cliente;
import com.baconwp.app.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @PostMapping("/crear")
    public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente) {

        if(cliente == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(clienteService.create(cliente), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        if (id <= 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(clienteService.obtenerClienteporId(id), HttpStatus.OK);

    }

    @GetMapping("/listar")
    public ResponseEntity<List<?>> listarClientes(){
        return new ResponseEntity<>(clienteService.listarClientes(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delteCliente(@PathVariable Long id){
        clienteService.delete(id);
    }

}
