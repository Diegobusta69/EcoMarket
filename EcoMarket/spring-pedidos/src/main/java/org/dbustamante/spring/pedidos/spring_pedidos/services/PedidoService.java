package org.dbustamante.spring.pedidos.spring_pedidos.services;

import org.dbustamante.spring.pedidos.spring_pedidos.models.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    List<Pedido> listar();
    Optional<Pedido> porId(Long id);
    Pedido guardar(Pedido pedido);
    void eliminar(Long id);
}
