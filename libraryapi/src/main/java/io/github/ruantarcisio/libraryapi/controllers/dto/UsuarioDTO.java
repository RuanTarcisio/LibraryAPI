package io.github.ruantarcisio.libraryapi.controllers.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Set;

public record UsuarioDTO(
                    @NotBlank(message = "campo obrigatório")
                    String login,
                    @Email(message = "inválido")
                    @NotBlank(message = "campo obrigatório")
                    String email,
                    @NotBlank(message = "campo obrigatório")
                    String senha,
                    Set<String> roles) {
}
