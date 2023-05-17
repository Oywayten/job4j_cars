ALTER TABLE car DROP COLUMN name;

ALTER TABLE car ADD category_id INT DEFAULT 1 NOT NULL REFERENCES category(id);

UPDATE car SET category_id = 1 WHERE id = 1;
UPDATE car SET category_id = 1 WHERE id = 2;
UPDATE car SET category_id = 1 WHERE id = 3;
UPDATE car SET category_id = 1 WHERE id = 4;
UPDATE car SET category_id = 1 WHERE id = 5;
UPDATE car SET category_id = 1 WHERE id = 6;
UPDATE car SET category_id = 1 WHERE id = 7;
UPDATE car SET category_id = 1 WHERE id = 8;

ALTER TABLE car ADD model_id INT DEFAULT 1 NOT NULL REFERENCES model(id);

UPDATE car SET model_id = 1 WHERE id = 1;
UPDATE car SET model_id = 2 WHERE id = 2;
UPDATE car SET model_id = 3 WHERE id = 3;
UPDATE car SET model_id = 4 WHERE id = 4;
UPDATE car SET model_id = 5 WHERE id = 5;
UPDATE car SET model_id = 6 WHERE id = 6;
UPDATE car SET model_id = 7 WHERE id = 7;
UPDATE car SET model_id = 8 WHERE id = 8;

ALTER TABLE car ADD body_type_id INT DEFAULT 1 NOT NULL REFERENCES body_type(id);

UPDATE car SET body_type_id = 3 WHERE id = 1;
UPDATE car SET body_type_id = 2 WHERE id = 2;
UPDATE car SET body_type_id = 1 WHERE id = 3;
UPDATE car SET body_type_id = 1 WHERE id = 4;
UPDATE car SET body_type_id = 1 WHERE id = 5;
UPDATE car SET body_type_id = 4 WHERE id = 6;
UPDATE car SET body_type_id = 4 WHERE id = 7;
UPDATE car SET body_type_id = 4 WHERE id = 8;