package org.dbustamante.spring.productos.spring_productos.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table (name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombre;

    @NotNull
    @Min(0)
    private Double precio;

    @Min(0)
    private Integer stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @NotNull @Min(0) Double getPrecio() {
        return precio;
    }

    public void setPrecio(@NotNull @Min(0) Double precio) {
        this.precio = precio;
    }

    public @Min(0) Integer getStock() {
        return stock;
    }

    public void setStock(@Min(0) Integer stock) {
        this.stock = stock;
    }
}
