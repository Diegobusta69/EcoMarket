package org.dbustamante.spring.pedidos.services;

import org.dbustamante.spring.pedidos.models.Pedido;
import org.dbustamante.spring.pedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl  implements PedidoService{

    @Autowired
    private PedidoRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Pedido> listar() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pedido> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Pedido guardar(Pedido pedido) {
        return repository.save(pedido);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

}
