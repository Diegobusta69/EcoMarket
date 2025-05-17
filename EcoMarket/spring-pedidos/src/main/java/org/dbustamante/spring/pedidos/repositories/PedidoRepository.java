package org.dbustamante.spring.pedidos.repositories;

import org.dbustamante.spring.pedidos.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository  extends JpaRepository <Pedido, Long> {
}
