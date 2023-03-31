-- drop table AUTO_USER cascade;
-- drop table AUTO_POST;

CREATE TABLE auto_user (
    id       SERIAL PRIMARY KEY,
    login    TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL
);

COMMENT ON TABLE auto_user IS 'autos user table';
COMMENT ON COLUMN auto_user.id IS 'user id';
COMMENT ON COLUMN auto_user.login IS 'login';
COMMENT ON COLUMN auto_user.password IS 'password';

CREATE TABLE auto_post (
    id           SERIAL PRIMARY KEY,
    description  TEXT      NOT NULL,
    created      TIMESTAMP NOT NULL,
    auto_user_id INT       NOT NULL REFERENCES auto_user (id)
);

COMMENT ON TABLE auto_post IS 'posts table';
COMMENT ON COLUMN auto_post.id IS 'post id';
COMMENT ON COLUMN auto_post.description IS 'AD description';
COMMENT ON COLUMN auto_post.created IS 'date of creation';
COMMENT ON COLUMN auto_post.auto_user_id IS 'user id';