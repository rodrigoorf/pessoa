CREATE TABLE pessoas (
  id BIGINT NOT NULL,
   nome VARCHAR(255),
   idade INT NOT NULL,
   CONSTRAINT pk_pessoas PRIMARY KEY (id)
);

INSERT INTO pessoas (id, nome, idade) VALUES (1, 'Fulano', 30);
INSERT INTO pessoas (id, nome, idade) VALUES (2, 'Beltrano', 20);
INSERT INTO pessoas (id, nome, idade) VALUES (3, 'Ciclano', 25);