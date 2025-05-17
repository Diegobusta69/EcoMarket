package org.dbustamante.spring.pagos.controller;


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
    public ResponseEntity<Pago> crear(@RequestBody Pago pago) {
        return ResponseEntity.ok(service.guardar(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pago> editar(@PathVariable Long id, @RequestBody Pago pago) {
        return service.porId(id).map(p -> {
            p.setMetodoPago(pago.getMetodoPago());
            p.setMonto(pago.getMonto());
            p.setEstado(pago.getEstado());
            return ResponseEntity.ok(service.guardar(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        return service.porId(id).map(pago -> {
            service.eliminar(id);
            // Aquí retornamos explícitamente ResponseEntity<Void>
            return ResponseEntity.<Void>noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}