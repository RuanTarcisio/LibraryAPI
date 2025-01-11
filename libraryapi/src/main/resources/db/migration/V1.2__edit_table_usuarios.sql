BEGIN;

ALTER TABLE usuarios
ADD COLUMN email VARCHAR(150);

UPDATE usuarios
SET email = 'no-email@example.com'
WHERE email IS NULL;

ALTER TABLE usuarios
ALTER COLUMN email SET NOT NULL;


COMMIT;
