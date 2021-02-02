CREATE TABLE topic (
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    description TEXT,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now()
);

CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    text TEXT,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now(),
    topic_id INT,
    FOREIGN KEY (topic_id) REFERENCES topic (id)
);

CREATE TABLE topic_post (
    topic_id INT NOT NULL,
    post_id INT NOT NULL,
    FOREIGN KEY (topic_id) REFERENCES topic (id),
    FOREIGN KEY (post_id) REFERENCES post (id)
);