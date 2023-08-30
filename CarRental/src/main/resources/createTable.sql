CREATE TABLE Car
(
    id int NOT NULL AUTO_INCREMENT,
    brand         VARCHAR(255),
    model         VARCHAR(255),
    description   VARCHAR(1000),
    path_to_image VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Client
(
    id int NOT NULL AUTO_INCREMENT,
    name            VARCHAR(255),
    surname         VARCHAR(255),
    passport_series VARCHAR(255),
    passport_id     VARCHAR(255),
    gmail           VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE Booking
(
    id int NOT NULL AUTO_INCREMENT,
    client_id  INT,
    hours      INT,
    car_id     INT,
    start_date DATETIME,
    price      DOUBLE,
    start_accepted   BOOLEAN,
    end_accepted   BOOLEAN,
    PRIMARY KEY (id),
    FOREIGN KEY (client_id) REFERENCES Client (id),
    FOREIGN KEY (car_id) REFERENCES Car (id)
);