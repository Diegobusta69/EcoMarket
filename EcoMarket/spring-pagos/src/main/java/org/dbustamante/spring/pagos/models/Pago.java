package org.dbustamante.spring.pagos.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table (name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String metodoPago;

    @NotNull
    @Min(1)
    private Double monto;

    private String estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(@NotBlank String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public @NotNull @Min(1) Double getMonto() {
        return monto;
    }

    public void setMonto(@NotNull @Min(1) Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
