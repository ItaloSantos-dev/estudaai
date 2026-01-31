CREATE TABLE questions(
  id uuid PRIMARY KEY,
  title VARCHAR(50) NOT NULL UNIQUE,
  type VARCHAR(50) NOT NULL,
  link TEXT NOT NULL,
  submodule_id uuid NOT NULL,

  CONSTRAINT fk_questions_submodule
      FOREIGN KEY(submodule_id) REFERENCES submodules(id)
);