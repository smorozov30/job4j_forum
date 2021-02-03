INSERT INTO topic (name, description) VALUES ('О чем этот форум?', 'Как считатет он нужен?');

INSERT INTO post (text, topic_id) VALUES ('Да, думаю нужен', 1);
INSERT INTO post (text, topic_id) VALUES ('Нет, думаю не нужен', 1);

INSERT INTO topic_post (topic_id, post_id) VALUES (1, 1);
INSERT INTO topic_post (topic_id, post_id) VALUES (1, 2);

INSERT INTO authorities (authority) VALUES ('ROLE_USER');
INSERT INTO authorities (authority) VALUES ('ROLE_ADMIN');

INSERT INTO users (username, password, enabled, authority_id)
VALUES ('root', '$2a$10$TlH97IYCuJxGwUPWDbQyROZWsv.gZunpeJbm9xr37ZPRYbj/lbmVC', true, 2);