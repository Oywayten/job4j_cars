-- drop table AUTO_USER cascade;
-- drop table AUTO_POST;

CREATE TABLE AUTO_USER(
ID SERIAL PRIMARY KEY,
LOGIN TEXT NOT NULL UNIQUE,
PASSWORD TEXT NOT NULL
);

COMMENT ON table AUTO_USER IS 'autos user table';
COMMENT ON column AUTO_USER.ID IS 'user id';
COMMENT ON column AUTO_USER.LOGIN IS 'login';
COMMENT ON column AUTO_USER.PASSWORD IS 'password';

CREATE TABLE AUTO_POST(
ID SERIAL PRIMARY KEY,
DESCRIPTION TEXT NOT NULL ,
CREATED TIMESTAMP NOT NULL ,
AUTO_USER_ID INT NOT NULL REFERENCES AUTO_USER(ID)
);

COMMENT ON table AUTO_POST IS 'posts table';
COMMENT ON column AUTO_POST.ID IS 'post id';
COMMENT ON column AUTO_POST.DESCRIPTION IS 'AD description';
COMMENT ON column AUTO_POST.CREATED IS 'date of creation';
COMMENT ON column AUTO_POST.AUTO_USER_ID IS 'user id';