CREATE TABLE Car
(
    id            INT PRIMARY KEY,
    brand         VARCHAR(255),
    model         VARCHAR(255),
    description   VARCHAR(255),
    path_to_image VARCHAR(255)
);

CREATE TABLE Client
(
    id              INT PRIMARY KEY,
    name            VARCHAR(255),
    surname         VARCHAR(255),
    passport_series VARCHAR(255),
    passport_id     VARCHAR(255),
    gmail           VARCHAR(255)
);

CREATE TABLE Booking
(
    id         INT PRIMARY KEY,
    client_id  INT,
    hours      INT,
    car_id     INT,
    start_date DATETIME,
    price      DOUBLE,
    start_accepted   BOOLEAN,
    end_accepted   BOOLEAN,
    FOREIGN KEY (client_id) REFERENCES Client (id),
    FOREIGN KEY (car_id) REFERENCES Car (id)
);