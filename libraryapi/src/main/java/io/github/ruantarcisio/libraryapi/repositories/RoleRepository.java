package io.github.ruantarcisio.libraryapi.repositories;

import io.github.ruantarcisio.libraryapi.domain.Role;
import io.github.ruantarcisio.libraryapi.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
