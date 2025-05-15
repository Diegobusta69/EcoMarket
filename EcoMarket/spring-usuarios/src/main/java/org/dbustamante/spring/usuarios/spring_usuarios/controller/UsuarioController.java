package org.dbustamante.spring.usuarios.spring_usuarios.controller;

import org.dbustamante.spring.usuarios.spring_usuarios.models.entity.Usuario;
import org.dbustamante.spring.usuarios.spring_usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @GetMapping
    public List<Usuario> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id){
        Optional<Usuario> usuarioOptional = service.porId(id);
        if(usuarioOptional.isPresent()){
            return ResponseEntity.ok().body(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result){
        if(service.buscarPorEmail(usuario.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body(Collections.singletonMap("mensaje", "Ya existe un usuario con ese email"));
        }
        if (result.hasErrors()) {
            return validar(result);
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));
    }

    private ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String, String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "el campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario,BindingResult result, @PathVariable Long id){
        if (result.hasErrors()) {
            return validar(result);
        }
        Optional<Usuario> o = service.porId(id);
        if(o.isPresent()){
            Usuario usuarioDb = o.get();
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setEmail(usuario.getEmail());
            // Solo actualizamos la contraseña si se proporciona una nueva
            if (usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
                usuarioDb.setPassword(passwordEncoder.encode(usuario.getPassword()));
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioDb));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        Optional<Usuario> o = service.porId(id);
        if(o.isPresent()){
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
