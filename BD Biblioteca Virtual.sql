create database biblioteca_virtual;

use biblioteca_virtual;

CREATE TABLE autor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    biografia TEXT
);

CREATE TABLE leitor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    status VARCHAR(20)
);

CREATE TABLE livro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    ano_publicacao INT,
    categoria VARCHAR(100),
    disponivel BOOLEAN,
    autor_id BIGINT,

    CONSTRAINT fk_livro_autor
        FOREIGN KEY (autor_id)
        REFERENCES autor(id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

CREATE TABLE transacao (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    livro_id BIGINT NOT NULL,
    leitor_id BIGINT NOT NULL,
    data_reserva DATE,
    status VARCHAR(20),

    CONSTRAINT fk_transacao_livro
        FOREIGN KEY (livro_id)
        REFERENCES livro(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,

    CONSTRAINT fk_transacao_leitor
        FOREIGN KEY (leitor_id)
        REFERENCES leitor(id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);