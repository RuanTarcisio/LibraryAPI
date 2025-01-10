BEGIN;

-- Tabela de papéis (roles)
CREATE TABLE roles (
                       id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY, -- IDENTITY para auto-incremento
                       nome VARCHAR(255) NOT NULL UNIQUE
);

-- Tabela de usuários
CREATE TABLE usuarios (
                          id UUID PRIMARY KEY,
                          login VARCHAR(255) NOT NULL UNIQUE,
                          senha VARCHAR(255) NOT NULL
);

-- Tabela intermediária para associar usuários e papéis
CREATE TABLE usuarios_roles (
                                user_id UUID NOT NULL,
                                role_id BIGINT NOT NULL,
                                PRIMARY KEY (user_id, role_id),
                                CONSTRAINT fk_user_roles_user FOREIGN KEY (user_id) REFERENCES usuarios (id) ON DELETE CASCADE,
                                CONSTRAINT fk_user_roles_role FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE
);

-- Tabela de autores
CREATE TABLE autores (
                         id UUID PRIMARY KEY,
                         nome VARCHAR(100) NOT NULL,
                         data_nascimento DATE NOT NULL,
                         nacionalidade VARCHAR(50) NOT NULL,
                         id_usuario UUID, -- Chave estrangeira para a tabela usuarios
                         data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         CONSTRAINT fk_autor_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id) ON DELETE SET NULL
);

-- Tabela de livros
CREATE TABLE livros (
                        id UUID PRIMARY KEY,
                        isbn VARCHAR(20) NOT NULL UNIQUE,
                        titulo VARCHAR(150) NOT NULL,
                        data_publicacao DATE,
                        genero VARCHAR(30) NOT NULL, -- Enum representado como String
                        preco NUMERIC(18, 2), -- Precision e scale para valores monetários
                        id_autor UUID, -- Chave estrangeira para a tabela autores
                        id_usuario UUID, -- Chave estrangeira para a tabela usuarios
                        data_cadastro TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        data_atualizacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT fk_livro_autor FOREIGN KEY (id_autor) REFERENCES autores (id) ON DELETE CASCADE,
                        CONSTRAINT fk_livro_usuario FOREIGN KEY (id_usuario) REFERENCES usuarios (id) ON DELETE SET NULL
);


COMMIT;
