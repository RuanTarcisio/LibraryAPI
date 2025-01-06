package io.github.ruantarcisio.libraryapi.controllers.mappers;

import io.github.ruantarcisio.libraryapi.controllers.dto.AutorDTO;
import io.github.ruantarcisio.libraryapi.domain.Autor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    @Mapping(source = "nacionalidade", target = "nacionalidade")
    Autor toEntity(AutorDTO dto);

    AutorDTO toDTO(Autor autor);
}
