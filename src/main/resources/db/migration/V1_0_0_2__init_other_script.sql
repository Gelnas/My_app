CREATE SEQUENCE IF NOT EXISTS hibernate_sequence start 1000 increment 1;

CREATE TABLE IF NOT EXISTS Rate
(
    id            serial PRIMARY KEY,
    rateWH float ,
    rateWC float ,
    rateE float
);

CREATE TABLE IF NOT EXISTS WaterSupply
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
    dateN date         NOT NULL,
    FOREIGN KEY (water_id) REFERENCES WaterSupply (id),
    FOREIGN KEY (elect_id) REFERENCES Electricity (id)
);

