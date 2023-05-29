USE users;

CREATE TABLE users
(
    id        INT AUTO_INCREMENT,
    firstname VARCHAR(80),
    lastname  VARCHAR(80),
    password  VARCHAR(80) NOT NULL,
    AGE varchar(80),
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE roles
(
    id   INT AUTO_INCREMENT,
    name VARCHAR(80) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;


CREATE TABLE users_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (user_id, role_id),
    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id)
);

INSERT INTO roles (name)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');
