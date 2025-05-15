package org.dbustamante.spring.usuarios.spring_usuarios.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
@Schema(description = "Entidad que representa a un usuario del sistema")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Identificador único del usuario", example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Nombre completo del usuario", example = "Fernando Sierra")
    @NotBlank
    private String nombre;

    @Column(unique = true)
    @Email
    @NotBlank
    @Schema(description = "Correo electrónico único del usuario", example = "fernando@example.com")

    private String email;

    @Schema(description = "Contraseña del usuario", example = "123456", writeOnly = true)
    @NotBlank
    private String password;

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
