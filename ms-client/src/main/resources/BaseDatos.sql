CREATE TABLE client (
    client_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    gender VARCHAR(50),
    age INT,
    identification VARCHAR(100) UNIQUE NOT NULL,
    address VARCHAR(255),
    phone VARCHAR(20),
    password VARCHAR(255),
    status BOOLEAN NOT NULL
);