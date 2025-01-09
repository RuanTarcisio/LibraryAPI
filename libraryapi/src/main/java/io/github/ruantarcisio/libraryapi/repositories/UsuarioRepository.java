package io.github.ruantarcisio.libraryapi.repositories;

import io.github.ruantarcisio.libraryapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Usuario findByLogin(String login);
}
