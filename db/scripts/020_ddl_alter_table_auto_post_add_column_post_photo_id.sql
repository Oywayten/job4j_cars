ALTER TABLE auto_post
    ADD COLUMN post_photo_id INTEGER REFERENCES file (id);