INSERT INTO roles (role_)
VALUES ('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_SUPERADMIN');

INSERT INTO users (username, password)
VALUES ('admin', '$2y$12$03ENtx8miCd4kBhJjfDmROsUQHoA5YH1/XP8k7oEfiSc8q0Yo8wxO'),
       ('user', '$2y$12$N7rDSgV7iOrLRUrGvhre5Ou9GvRzrosfpyP1ivk/FQAyCwW5cDv7e '),
       ('superadmin', '$2y$12$N7rDSgV7iOrLRUrGvhre5Ou9GvRzrosfpyP1ivk/FQAyCwW5cDv7e ');

INSERT INTO users_roles (user_id, role_id)
VALUES (1,2), (2,1), (3,3);

INSERT INTO permission (permission)
VALUES ('READ'), ('WRITE'), ('DELETE');


INSERT INTO roles_permission (role_id, perm_id)
VALUES (2, 1), (2, 2), (2, 3);