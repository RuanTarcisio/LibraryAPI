package io.github.ruantarcisio.libraryapi.controllers.mappers;

import io.github.ruantarcisio.libraryapi.controllers.dto.UsuarioDTO;
import io.github.ruantarcisio.libraryapi.domain.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);
}
