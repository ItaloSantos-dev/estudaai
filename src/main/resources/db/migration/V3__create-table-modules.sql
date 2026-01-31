CREATE TABLE modules(
    id uuid PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    average_duration BIGINT NOT NULL,
    course_id uuid NOT NULL,

    CONSTRAINT fk_modules_course
        FOREIGN KEY(course_id) REFERENCES courses(id)
);