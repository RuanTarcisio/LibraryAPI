package io.github.ruantarcisio.libraryapi.controllers.mappers;

import io.github.ruantarcisio.libraryapi.controllers.dto.CadastroLivroDTO;
import io.github.ruantarcisio.libraryapi.controllers.dto.ResultadoPesquisaLivroDTO;
import io.github.ruantarcisio.libraryapi.domain.Livro;
import io.github.ruantarcisio.libraryapi.repositories.AutorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = AutorMapper.class)
public abstract class LivroMapper {

    @Autowired
    AutorRepository autorRepository;

    @Mapping(target = "autor", expression = "java( autorRepository.findById(dto.idAutor()).orElse(null) )")
    public abstract Livro toEntity(CadastroLivroDTO dto);

    public abstract ResultadoPesquisaLivroDTO toDTO(Livro livro);
}