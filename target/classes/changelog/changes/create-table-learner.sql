DROP TABLE IF EXISTS learner CASCADE;

CREATE TABLE learner(
    id BIGSERIAL PRIMARY KEY,
    firstname TEXT,
    lastname TEXT NOT NULL,
    groupe_id BIGINT REFERENCES groupe(id)
)