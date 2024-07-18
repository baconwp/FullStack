package com.baconwp.app.repositorios;

import com.baconwp.app.models.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteRepository extends JpaRepository<Cliente, Long> {
}
