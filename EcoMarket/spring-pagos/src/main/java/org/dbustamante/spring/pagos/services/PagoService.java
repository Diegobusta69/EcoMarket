package org.dbustamante.spring.pagos.services;

import org.dbustamante.spring.pagos.models.Pago;

import java.util.List;
import java.util.Optional;

public interface PagoService {
    List<Pago> listar();
    Optional<Pago> porId(Long id);
    Pago guardar(Pago pago);
    void eliminar(Long id);

}
