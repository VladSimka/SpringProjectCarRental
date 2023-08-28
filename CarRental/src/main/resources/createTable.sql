CREATE TABLE Car
(
    id          INT PRIMARY KEY,
    brand       VARCHAR(255),
    description VARCHAR(255),
    pathToImage VARCHAR(255)
);

CREATE TABLE Client
(
    id             INT PRIMARY KEY,
    name           VARCHAR(255),
    surname        VARCHAR(255),
    passportSeries VARCHAR(255),
    passportId     VARCHAR(255),
    gmail          VARCHAR(255)
);

CREATE TABLE Order
(
    id        INT PRIMARY KEY,
    client_id INT,
    hours     INT,
    car_id    INT,
    startDate DATETIME,
    price     DOUBLE,
    accepted  BOOLEAN,
    FOREIGN KEY (client_id) REFERENCES Client (id),
    FOREIGN KEY (car_id) REFERENCES Car (id)
);