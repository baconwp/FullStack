package com.baconwp.app.repositorios;

import com.baconwp.app.models.entities.ItemFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemFacturaRepository extends JpaRepository<ItemFactura, Long> {
}
