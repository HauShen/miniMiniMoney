CREATE TABLE wallet
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    amount          DECIMAL,
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR
);

CREATE TABLE user_profile
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    birthday        DATE,
    name            VARCHAR,
    wallet_id       BIGINT UNIQUE REFERENCES wallet (oid),
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR
);

CREATE TABLE asset
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    name            VARCHAR,
    description     VARCHAR,
    amount          DECIMAL,
    type            VARCHAR,
    wallet_id       BIGINT REFERENCES wallet (oid),
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR
);

CREATE TABLE transaction_record
(
    oid                    BIGINT NOT NULL PRIMARY KEY,
    name                   VARCHAR,
    description            VARCHAR,
    amount                 DECIMAL,
    type                   VARCHAR,
    wallet_id              BIGINT REFERENCES wallet (oid),
    date_of_transaction    DATE,
    created_at             TIMESTAMP,
    created_by             VARCHAR,
    updated_at             TIMESTAMP,
    updated_by             VARCHAR
);

CREATE TABLE debt
(
    oid                    BIGINT NOT NULL PRIMARY KEY,
    name                   VARCHAR,
    description            VARCHAR,
    total_amount           DECIMAL,
    status                 VARCHAR,
    wallet_id              BIGINT REFERENCES wallet (oid),
    monthly_due_date       DATE,
    amountLeft             DECIMAL,
    date_started           DATE,
    debtor                 VARCHAR,
    created_at             TIMESTAMP,
    created_by             VARCHAR,
    updated_at             TIMESTAMP,
    updated_by             VARCHAR
);

CREATE TABLE loan
(
    oid                    BIGINT NOT NULL PRIMARY KEY,
    name                   VARCHAR,
    description            VARCHAR,
    total_amount           DECIMAL,
    status                 VARCHAR,
    wallet_id              BIGINT REFERENCES wallet (oid),
    monthly_due_date       DATE,
    date_started           DATE,
    monthlyAmount          DECIMAL,
    amountLeft             DECIMAL,
    lender                 VARCHAR,
    created_at             TIMESTAMP,
    created_by             VARCHAR,
    updated_at             TIMESTAMP,
    updated_by             VARCHAR
);