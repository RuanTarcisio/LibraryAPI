package io.github.ruantarcisio.arquiteturaspring.todos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class TodoController {

private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoEntity salvar(@RequestBody TodoEntity newTodo){

        return todoService.salvar(newTodo);
    }

    @PutMapping("{id}")
    public TodoEntity getTodo(@PathVariable Long id){

        return todoService.findTodo(id);
    }

    @GetMapping("{id}")
    public void atualizar(@PathVariable Long id, @RequestBody TodoEntity todo){
        todo.setId(id);
        todoService.atualizar(todo);
    }
}
