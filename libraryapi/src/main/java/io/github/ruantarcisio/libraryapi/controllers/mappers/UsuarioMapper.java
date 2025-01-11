package io.github.ruantarcisio.libraryapi.controllers.mappers;

import io.github.ruantarcisio.libraryapi.controllers.dto.UsuarioDTO;
import io.github.ruantarcisio.libraryapi.domain.Role;
import io.github.ruantarcisio.libraryapi.domain.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "roles", source = "roles")
    Usuario toEntity(UsuarioDTO dto);

    @Mapping(target = "roles", source = "roles")
    UsuarioDTO toDTO(Usuario usuario);

    // Mapeamento de Set<Role> para Set<String> (mapeando os nomes das roles)
    default Set<String> mapRolesToNames(Set<Role> roles) {
        if (roles == null) {
            return Collections.emptySet();
        }
        return roles.stream()
                .map(Role::getNome) // Aqui você pega o nome de cada role
                .collect(Collectors.toSet());
    }

    // Mapeamento de Set<String> para Set<Role> (gerando novas instâncias de Role)
    default Set<Role> mapNamesToRoles(Set<String> roleNames) {
        if (roleNames == null) {
            return Collections.emptySet();
        }
        return roleNames.stream()
                .map(Role::new)  // Supondo que você tenha um construtor adequado em Role
                .collect(Collectors.toSet());
    }
}
