package io.github.ruantarcisio.arquiteturaspring;

import io.github.ruantarcisio.arquiteturaspring.todos.*;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ExemploInjecaoDependencia {
    public static void main(String[] args) throws SQLException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("url");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");

        Connection connection = dataSource.getConnection();

        EntityManager entityManager = null;

        TodoRepository repository =  null; // new SimpleJpaRepository<TodoEntity, Long>()
        TodoValidator validator = new TodoValidator(repository);
        MailSender mailSender = new MailSender();

        TodoService todoService = new TodoService(repository, validator, mailSender);

        BeanGerenciavel beanGerenciado = new BeanGerenciavel(null);
        beanGerenciado.setValidator(validator);
//        if(condicao == true){
//            beanGerenciado.setValidator();
//        }
    }
}
