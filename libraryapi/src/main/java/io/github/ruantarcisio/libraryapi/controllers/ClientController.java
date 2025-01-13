package io.github.ruantarcisio.libraryapi.controllers;

import io.github.ruantarcisio.libraryapi.domain.Client;
import io.github.ruantarcisio.libraryapi.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE')")
    public void salvar(@RequestBody Client client) {
        service.salvar(client);

    }
}
