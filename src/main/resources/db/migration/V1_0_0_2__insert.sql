INSERT INTO roles (role_)
VALUES ('ROLE_USER'), ('ROLE_ADMIN'), ('ROLE_SUPERADMIN');

INSERT INTO users (username, password)
VALUES ('admin', '$2y$04$63U.dyRiUW.sPTXBpmcIwOklxmTg33H6W/C8AHwNmEEk4PuaXn9OC'), --password: 12345
       ('user', '$2y$04$63U.dyRiUW.sPTXBpmcIwOklxmTg33H6W/C8AHwNmEEk4PuaXn9OC'),
       ('superadmin', '$2y$04$63U.dyRiUW.sPTXBpmcIwOklxmTg33H6W/C8AHwNmEEk4PuaXn9OC');

INSERT INTO users_roles (user_id, role_id)
VALUES (1,2), (2,1), (3,3);

INSERT INTO permission (permission)
VALUES ('READ'), ('WRITE'), ('DELETE');

-- INSERT INTO user_roles_permissions (user_id, role_id, perm_id)
-- VALUES (1, 2, 1), (1, 2, 2), (1, 2, 3);

INSERT INTO roles_permission (role_id, perm_id)
VALUES (1, 1), (2, 1), (2, 2), (3, 1), (3, 2), (3, 3);

INSERT INTO rate (rate_WH, rate_WC, rate_E)
VALUES (5.2, 2.6, 6), (9.5, 7.4, 6);