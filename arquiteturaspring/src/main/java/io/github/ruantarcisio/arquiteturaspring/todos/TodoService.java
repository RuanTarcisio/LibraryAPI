package io.github.ruantarcisio.arquiteturaspring.todos;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TodoService {

private final TodoRepository  todoRepository;
private final TodoValidator validator;
private final MailSender mailSender;

    public TodoService(TodoRepository todoRepository, TodoValidator validator, MailSender mailSender) {
        this.todoRepository = todoRepository;
        this.validator = validator;
        this.mailSender = mailSender;
    }

    public TodoEntity salvar(TodoEntity newTodo) throws IllegalArgumentException{
        try{
            validator.validar(newTodo);
        }catch(Exception e){
            var mensagemErro = e.getMessage();
            throw new ResponseStatusException(HttpStatus.CONFLICT, mensagemErro);
        }
        return todoRepository.save(newTodo);
    }

    public void atualizar(TodoEntity todo) {

        todoRepository.save(todo);
        String status = todo.getConcluido() == Boolean.TRUE ? "Concluido." : "Não concluido.";
        mailSender.enviar("Todo "+ todo.getDescricao() + "foi atualizado para" + status);

    }

    public TodoEntity findTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo não encontrado."));
    }
}
