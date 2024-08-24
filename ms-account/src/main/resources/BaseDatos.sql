CREATE TABLE account (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_number VARCHAR(50) NOT NULL,
    account_type VARCHAR(20) NOT NULL,
    initial_balance DECIMAL(15, 2) NOT NULL,
    status BOOLEAN NOT NULL,
    client_id BIGINT NOT NULL,
    UNIQUE (accountNumber, accountType, client_id)
);

CREATE TABLE movements (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    date_movement TIMESTAMP NOT NULL,
    transaction_type VARCHAR(20) NOT NULL,
    value_movement DECIMAL(15, 2) NOT NULL,
    balance DECIMAL(15, 2) NOT NULL,
    account_id VARCHAR(50),
    CONSTRAINT fk_account_transaction FOREIGN KEY (account_id) REFERENCES Account(id)
);