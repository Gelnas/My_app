CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS Electricity
(
    id            serial PRIMARY KEY,
    dateN date         NOT NULL,
    counter  integer,
    score float
);

CREATE TABLE IF NOT EXISTS Rate
(
    id            serial PRIMARY KEY,
    rate_WH float ,
    rate_WC float ,
    rate_E float
);

CREATE TABLE IF NOT EXISTS Water_Supply
(
    id            serial PRIMARY KEY,
    counterHot integer,
    counterCold integer,
    scoreHot float,
    scoreCold float
);


CREATE TABLE IF NOT EXISTS Expense
(
    id            serial PRIMARY KEY,
    water_Id int8,
    elect_Id int8,
    dateN date         NOT NULL,
    FOREIGN KEY (water_Id) REFERENCES Water_Supply (id),
    FOREIGN KEY (elect_Id) REFERENCES Electricity (id)
);
CREATE TABLE IF NOT EXISTS users
(
   id serial PRIMARY  KEY,
   username varchar(30) not null,
   password varchar(80) not null
);

CREATE TABLE IF NOT EXISTS roles
(
   id serial PRIMARY  KEY,
   role_ varchar(30) not null
);

CREATE TABLE IF NOT EXISTS users_roles(
   user_id   integer not null,
   role_id   integer not null,
   PRIMARY  KEY (user_id, role_id),
   FOREIGN KEY (user_id) REFERENCES users (id),
   FOREIGN KEY (role_id) REFERENCES roles (id)
);

CREATE TABLE IF NOT EXISTS permission
(
   id serial PRIMARY  KEY,
   permission varchar (50) not null
);


CREATE TABLE IF NOT EXISTS roles_permission(
   role_id   integer not null,
   perm_id   integer not null,
   PRIMARY  KEY (role_id, perm_id),
   FOREIGN KEY (perm_id) REFERENCES permission (id),
   FOREIGN KEY (role_id) REFERENCES roles (id)
);


CREATE TABLE IF NOT EXISTS user_roles_permissions(
   user_id   integer not null,
   role_id   integer not null,
   perm_id   integer not null,
   PRIMARY  KEY (user_id, role_id, perm_id),
   FOREIGN KEY (user_id) REFERENCES users (id),
   FOREIGN KEY (perm_id) REFERENCES permission (id),
   FOREIGN KEY (role_id) REFERENCES roles (id)
);
