package org.dbustamante.spring.productos.spring_productos.controller;


import jakarta.validation.Valid;
import org.dbustamante.spring.productos.spring_productos.models.Producto;
import org.dbustamante.spring.productos.spring_productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @GetMapping
    public List<Producto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> ver(@PathVariable Long id) {
        return service.porId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto crear(@Valid @RequestBody Producto producto) {
        return service.guardar(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> editar(@PathVariable Long id, @Valid @RequestBody Producto producto) {
        return service.porId(id).map(p -> {
            p.setNombre(producto.getNombre());
            p.setPrecio(producto.getPrecio());
            p.setStock(producto.getStock());
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




