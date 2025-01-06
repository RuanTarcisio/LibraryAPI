package io.github.ruantarcisio.libraryapi.services;

import io.github.ruantarcisio.libraryapi.domain.Livro;
import io.github.ruantarcisio.libraryapi.enums.GeneroLivro;
import io.github.ruantarcisio.libraryapi.repositories.LivroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository repository;

    public Livro salvar(Livro livro) {
        return repository.save(livro);
    }

    public Optional<Livro> obterPorId(UUID id){
        return repository.findById(id);
    }

    public void deletar(Livro livro){
        repository.delete(livro);
    }
}