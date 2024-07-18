package com.baconwp.app.repositorios;

import com.baconwp.app.models.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
