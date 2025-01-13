BEGIN;

CREATE TABLE client(
                id UUID PRIMARY KEY,
                client_id VARCHAR(150) NOT NULL,
                client_secret VARCHAR(400) NOT NULL,
                redirect_uri VARCHAR(200) NOT NULL,
                scope VARCHAR(50)
);

COMMIT;
