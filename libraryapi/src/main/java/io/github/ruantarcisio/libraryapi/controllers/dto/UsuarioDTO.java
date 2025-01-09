package io.github.ruantarcisio.libraryapi.controllers.dto;

import java.util.List;

public record UsuarioDTO(String login, String senha, List<String> roles) {
}
