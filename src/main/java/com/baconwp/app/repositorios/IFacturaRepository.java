package com.baconwp.app.repositorios;

import com.baconwp.app.models.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {
}
