package org.dbustamante.spring.productos.spring_productos.services;

import org.dbustamante.spring.productos.spring_productos.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    List<Producto> listar();
    Optional<Producto> porId(Long  id);
    Producto guardar(Producto producto);
    void eliminar (Long id);


}
