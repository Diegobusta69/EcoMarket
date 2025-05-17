package org.dbustamante.spring.pagos.repositories;


import org.dbustamante.spring.pagos.models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepository extends JpaRepository <Pago, Long> {
}
