package io.github.ruantarcisio.arquiteturaspring;

import io.github.ruantarcisio.arquiteturaspring.todos.TodoEntity;
import io.github.ruantarcisio.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciavel {

    @Autowired
    private TodoValidator validator;

    public BeanGerenciavel(TodoValidator validator) {
        this.validator = validator;
    }

    public void utilizar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    @Autowired
    public void setValidator(TodoValidator validator){
        this.validator = validator;
    }

}
