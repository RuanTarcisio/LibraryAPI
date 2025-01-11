BEGIN;

INSERT INTO roles (nome) VALUES ('ADMIN');
INSERT INTO roles (nome) VALUES ('USER');
INSERT INTO roles (nome) VALUES ('OPERADOR');
INSERT INTO roles (nome) VALUES ('GERENTE');

-- Insere usuários na tabela 'usuarios'
INSERT INTO usuarios (id, login, senha)
VALUES
    ('123e4567-e89b-12d3-a456-426614174001', 'usuario1', '$2a$12$7mku8Idh7UGbn1Py8yGHbeMcOkDXt226xCq5GG8.ji6JmUixVHGKi'),
    ('123e4567-e89b-12d3-a456-426614174002', 'usuario2', '$2a$12$7mku8Idh7UGbn1Py8yGHbeMcOkDXt226xCq5GG8.ji6JmUixVHGKi'),
    ('123e4567-e89b-12d3-a456-426614174003', 'usuario3', '$2a$12$7mku8Idh7UGbn1Py8yGHbeMcOkDXt226xCq5GG8.ji6JmUixVHGKi'),
    ('123e4567-e89b-12d3-a456-426614174004', 'usuario4', '$2a$12$7mku8Idh7UGbn1Py8yGHbeMcOkDXt226xCq5GG8.ji6JmUixVHGKi');

-- Associa papéis aos usuários na tabela 'user_roles'
INSERT INTO usuarios_roles (user_id, role_id)
VALUES
    -- Usuário 1: ADMIN
    ('123e4567-e89b-12d3-a456-426614174001', 1), -- role_id 1 = ADMIN

    -- Usuário 2: USER e OPERADOR
    ('123e4567-e89b-12d3-a456-426614174002', 2), -- role_id 2 = USER
    ('123e4567-e89b-12d3-a456-426614174002', 3), -- role_id 3 = OPERADOR

    -- Usuário 3: GERENTE
    ('123e4567-e89b-12d3-a456-426614174003', 4), -- role_id 4 = GERENTE

    -- Usuário 4: ADMIN e GERENTE
    ('123e4567-e89b-12d3-a456-426614174004', 1), -- role_id 1 = ADMIN
    ('123e4567-e89b-12d3-a456-426614174004', 4); -- role_id 4 = GERENTE


COMMIT;
