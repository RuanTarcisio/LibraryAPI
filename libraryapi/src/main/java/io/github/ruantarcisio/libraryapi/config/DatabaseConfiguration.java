package io.github.ruantarcisio.libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

//    @Bean
//    public DataSource dataSource(){
//        DriverManagerDataSource ds = new DriverManagerDataSource();
//        ds.setUrl(url);
//        ds.setUsername(username);
//        ds.setPassword(password);
//        ds.setDriverClassName(driver);
//        return ds;
//    }

    @Bean
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(10); // Número máximo de conexões que podem ser criadas no pool.
        config.setMinimumIdle(1); //  Número mínimo de conexões que o pool deve manter ociosas.
        config.setPoolName("library-pool-db");
        config.setMaxLifetime(600000); // Tempo máximo que uma conexão pode permanecer ativa antes de ser descartada.
        config.setConnectionTimeout(100000); // Tempo máximo que o pool deve esperar para obter uma conexão antes de lançar uma exceção.

        return new HikariDataSource(config);
    }

}
