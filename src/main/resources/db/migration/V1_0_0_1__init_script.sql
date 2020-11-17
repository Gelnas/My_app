CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS Electricity
(
    id            serial PRIMARY KEY,
    dateN date         NOT NULL,
    counter  integer,
    score float
);


