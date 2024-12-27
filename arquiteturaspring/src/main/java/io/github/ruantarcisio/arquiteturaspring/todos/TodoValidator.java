package io.github.ruantarcisio.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    private TodoRepository repository;

    public TodoValidator(TodoRepository repository) {
        this.repository = repository;
    }

    public void validar (TodoEntity todo) throws IllegalArgumentException{
        if(existeTodoComDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe todo com essa descricao.");
        }
    }

    private boolean existeTodoComDescricao(String descricao) {
        return repository.existsByDescricao(descricao);
    }
}
