package org.dbustamante.spring.usuarios.spring_usuarios.repositories;

import org.dbustamante.spring.usuarios.spring_usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
