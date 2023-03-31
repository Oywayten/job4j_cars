create table owner (
    id      serial primary key,
    name    TEXT not null,
    user_id INT  NOT NULL REFERENCES auto_user (id)
);

create table history_owner (
    id       serial primary key,
    owner_id int       not null references owner (id),
    car_id   int       not null references car (id),
    start_at TIMESTAMP not null,
    end_at   TIMESTAMP not null
);