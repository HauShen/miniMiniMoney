CREATE TABLE wallet
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    amount          DECIMAL,
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR,
)

CREATE TABLE user_profile
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    birthday        DATE,
    name            VARCHAR,
    wallet_id       VARCHAR UNIQUE REFERENCES wallet (oid),
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR,
)

CREATE TABLE asset
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    name            VARCHAR,
    description     VARCHAR,
    amount          double,
    type            VARCHAR,
    wallet_id       VARCHAR UNIQUE REFERENCES wallet (oid),
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR,
)

CREATE TABLE asset
(
    oid             BIGINT NOT NULL PRIMARY KEY,
    name            VARCHAR,
    description     VARCHAR,
    amount          double,
    type            VARCHAR,
    wallet_id       VARCHAR UNIQUE REFERENCES wallet (oid),
    created_at      TIMESTAMP,
    created_by      VARCHAR,
    updated_at      TIMESTAMP,
    updated_by      VARCHAR,
)