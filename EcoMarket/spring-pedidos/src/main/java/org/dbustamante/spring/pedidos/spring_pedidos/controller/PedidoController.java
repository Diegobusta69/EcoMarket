package org.dbustamante.spring.pedidos.spring_pedidos.controller;


import jakarta.validation.Valid;
import org.dbustamante.spring.pedidos.spring_pedidos.models.Pedido;
import org.dbustamante.spring.pedidos.spring_pedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @GetMapping
    public List<Pedido> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> ver(@PathVariable Long id) {
        return service.porId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido crear(@Valid @RequestBody Pedido pedido) {
        return service.guardar(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> editar(@PathVariable Long id, @Valid @RequestBody Pedido pedido) {
        return service.porId(id).map(p -> {
            p.setUsuarioId(pedido.getUsuarioId());
            p.setFecha(pedido.getFecha());
            p.setTotal(pedido.getTotal());
            return ResponseEntity.ok(service.guardar(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return service.porId(id).map(p -> {
            service.eliminar(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }


}
