CREATE TABLE participant (
    user_id INT NOT NULL REFERENCES auto_user(id),
    post_id INT NOT NULL REFERENCES auto_post(id)
);