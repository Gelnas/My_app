INSERT INTO Electricity (dateN, counter, score)
VALUES ('12.11.2020', 14536, 500.25), ('12.12.2020', 14736, 550.25);

INSERT INTO Water_Supply (counterHot, counterCold, scoreHot, scoreCold)
VALUES (147, 155, 50.25, 36.0), (149, 170, 51.26, 40.1);

INSERT INTO Expense (water_Id, elect_Id, dateN)
VALUES (1, 1, '12.11.2020'), (2, 2, '12.12.2020');
