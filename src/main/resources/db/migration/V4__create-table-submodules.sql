CREATE TABLE submodules(
   id uuid PRIMARY KEY,
   name VARCHAR(50) NOT NULL UNIQUE,
   average_duration BIGINT NOT NULL,
   description TEXT,
   module_id uuid NOT NULL,

   CONSTRAINT fk_submodules_module
       FOREIGN KEY(module_id) REFERENCES modules(id)
);