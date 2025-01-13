package io.github.ruantarcisio.libraryapi.repositories;

import io.github.ruantarcisio.libraryapi.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
    Client findByClientId(String clientId);
}
