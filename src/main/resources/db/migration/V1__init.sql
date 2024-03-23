CREATE TABLE wallet
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    wallet_key      VARCHAR NOT NULL,
    amount          DECIMAL,
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR
);

CREATE TABLE user_profile
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    user_id         VARCHAR NOT NULL,
    birthday        DATE,
    name            VARCHAR,
    wallet_oid      BIGINT UNIQUE REFERENCES wallet (oid),
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR
);

CREATE SEQUENCE s_user_profile START WITH 1 INCREMENT BY 1 CACHE 50 NO CYCLE;
CREATE INDEX i_up_user_id ON user_profile (user_id);
CREATE SEQUENCE s_wallet START WITH 1 INCREMENT BY 1 CACHE 50 NO CYCLE;

CREATE TABLE asset
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    name            VARCHAR,
    description     VARCHAR,
    amount          DECIMAL,
    type            VARCHAR,
    wallet_oid       BIGINT REFERENCES wallet (oid),
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
    transaction_type       VARCHAR,
    wallet_oid             BIGINT REFERENCES wallet (oid),
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
    monthly_amount         DECIMAL,
    wallet_oid             BIGINT REFERENCES wallet (oid),
    monthly_due_date       DATE,
    amount_left            DECIMAL,
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
    wallet_oid             BIGINT REFERENCES wallet (oid),
    monthly_due_date       DATE,
    date_started           DATE,
    monthly_amount         DECIMAL,
    amount_left            DECIMAL,
    lender                 VARCHAR,
    created_at             TIMESTAMP,
    created_by             VARCHAR,
    updated_at             TIMESTAMP,
    updated_by             VARCHAR
);