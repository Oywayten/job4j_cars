create table engine (
    id   serial primary key,
    name TEXT not null
);

create table car (
    id        serial primary key,
    name      TEXT not null,
    engine_id int  not null references engine (id)
);