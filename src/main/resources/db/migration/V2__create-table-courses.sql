CREATE TABLE courses(
    id uuid PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    average_duration BIGINT NOT NULL
);