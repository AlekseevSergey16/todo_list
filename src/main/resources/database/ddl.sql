CREATE TABLE to_do (
    todo_id BIGSERIAL PRIMARY KEY,
    description VARCHAR (255) NOT NULL,
    status BOOLEAN,
    user_id BIGSERIAL NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_profile (user_id)
)

CREATE TABLE user_profile (
    user_id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
)