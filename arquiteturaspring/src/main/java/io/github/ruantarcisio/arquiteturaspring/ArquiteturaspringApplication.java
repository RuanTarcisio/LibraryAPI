package io.github.ruantarcisio.arquiteturaspring;

import io.github.ruantarcisio.arquiteturaspring.todos.MailSender;
import io.github.ruantarcisio.arquiteturaspring.todos.TodoRepository;
import io.github.ruantarcisio.arquiteturaspring.todos.TodoService;
import io.github.ruantarcisio.arquiteturaspring.todos.TodoValidator;
import jakarta.persistence.EntityManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;

@SpringBootApplication
public class ArquiteturaspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquiteturaspringApplication.class, args);
	}

    public static class ExemploInjecaoDependencia {
        public static void main(String[] args) throws Exception{
            DriverManagerDataSource dataSource = new DriverManagerDataSource();

            dataSource.setUrl("url");
            dataSource.setUrl("postgres");
            dataSource.setPassword("senh@BD");

            Connection connection = dataSource.getConnection();

            EntityManager entityManager = null;

            TodoRepository repository = null;//new SimpleJpaRepository<TodoEntity, Long>();
            TodoValidator validator = new TodoValidator(repository);
            MailSender mailSender = new MailSender();

            TodoService todoService = new TodoService(repository, validator, mailSender);
        }
    }
}
