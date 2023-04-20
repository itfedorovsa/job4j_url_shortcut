CREATE TABLE IF NOT EXISTS refers(
    id SERIAL PRIMARY KEY,
    original_url VARCHAR NOT NULL,
    shortened_url VARCHAR NOT NULL
);