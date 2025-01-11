package io.github.ruantarcisio.libraryapi.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String login;

    @Column
    private String senha;

    @Column
    private String email;

    @ManyToMany
    @JoinTable(
            name = "usuarios_roles", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "user_id"), // Coluna que referencia User
            inverseJoinColumns = @JoinColumn(name = "role_id") // Coluna que referencia Role
    )
    private Set<Role> roles = new HashSet<>();
}
