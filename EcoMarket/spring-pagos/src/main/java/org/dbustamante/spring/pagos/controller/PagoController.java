package org.dbustamante.spring.pagos.controller;


import jakarta.validation.Valid;
import org.dbustamante.spring.pagos.models.Pago;
import org.dbustamante.spring.pagos.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService service;

    @GetMapping
    public List<Pago> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> detalle(@PathVariable Long id) {
        return service.porId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pago> crear(@Valid @RequestBody Pago pago) {
        return ResponseEntity.ok(service.guardar(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> editar(@PathVariable Long id, @Valid @RequestBody Pago pago) {
        return service.porId(id).map(p -> {
            p.setMetodoPago(pago.getMetodoPago());
            p.setMonto(pago.getMonto());
            p.setEstado(pago.getEstado());
            return ResponseEntity.ok(service.guardar(p));
        }).orElse(ResponseEntity.notFound().build());
    }

}
