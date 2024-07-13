CREATE TABLE autores(

                        id bigint not null auto_increment,
                        nome varchar(100) not null,

                        primary key(id)
);

CREATE TABLE topicos (
                         id BIGINT NOT NULL AUTO_INCREMENT,
                         titulo VARCHAR(255) NOT NULL,
                         mensagem TEXT NOT NULL,
                         data DATETIME NOT NULL,
                         resposta_topico BOOLEAN DEFAULT FALSE,
                         autor_id BIGINT NOT NULL,
                         curso VARCHAR(25) NOT NULL,
                         PRIMARY KEY (id),
                         FOREIGN KEY (autor_id) REFERENCES autores(id)
);

CREATE TABLE respostas (
                           id BIGINT NOT NULL AUTO_INCREMENT,
                           mensagem TEXT NOT NULL,
                           data DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           autor_id BIGINT NOT NULL,
                           topicos_id BIGINT NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (autor_id) REFERENCES autores(id),
                           FOREIGN KEY (topicos_id) REFERENCES topicos(id)
);

CREATE TABLE usuarios(

                         id bigint not null auto_increment,
                         login varchar(100) not null,
                         senha varchar(255) not null,
                         email varchar(100) not null unique,

                         primary key(id)

);
