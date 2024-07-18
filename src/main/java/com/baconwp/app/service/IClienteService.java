package com.baconwp.app.service;

import com.baconwp.app.models.entities.Cliente;

import java.util.List;

public interface IClienteService {

    public Cliente create(Cliente cliente);
    public Cliente obtenerClienteporId(Long id);
    public List<Cliente> listarClientes();
    public void delete(Long id);
}
