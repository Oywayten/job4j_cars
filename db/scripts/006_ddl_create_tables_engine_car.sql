CREATE TABLE engine (
    id   SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE car (
    id        SERIAL PRIMARY KEY,
    name      TEXT NOT NULL,
    engine_id INT  NOT NULL REFERENCES engine (id)
);