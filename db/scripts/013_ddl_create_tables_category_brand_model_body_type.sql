create table category (
    id   serial primary key,
    name TEXT not null
);

create table brand (
    id   serial primary key,
    name TEXT not null
);

create table model (
    id       serial primary key,
    name     TEXT not null,
    brand_id INT  NOT NULL REFERENCES brand (id)
);

create table body_type (
    id   serial primary key,
    name TEXT not null
);