CREATE TABLE links(
  id uuid PRIMARY KEY,
  title VARCHAR(50) NOT NULL UNIQUE,
  link TEXT NOT NULL,
  submodule_id uuid NOT NULL,

  CONSTRAINT fk_links_submodule
      FOREIGN KEY(submodule_id) REFERENCES submodules(id)
);