package org.dbustamante.spring.productos.spring_productos.repositories;

import org.dbustamante.spring.productos.spring_productos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository  extends JpaRepository <Producto, Long> {
}
