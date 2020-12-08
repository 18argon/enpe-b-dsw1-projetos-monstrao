DROP
DATABASE IF EXISTS ProMonstrao;

CREATE
DATABASE ProMonstrao;

USE
ProMonstrao;

CREATE TABLE usuario
(
    id    BIGINT       NOT NULL AUTO_INCREMENT,
    email VARCHAR(256) NOT NULL UNIQUE,
    senha VARCHAR(64)  NOT NULL,
    papel VARCHAR(6)   NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE site
(
    id       BIGINT       NOT NULL,
    email    VARCHAR(256) NOT NULL UNIQUE,
    nome     VARCHAR(256) NOT NULL,
    endereco VARCHAR(256) NOT NULL,
    telefone VARCHAR(30),
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES usuario (id) ON DELETE CASCADE
);

CREATE TABLE teatro
(
    id     BIGINT       NOT NULL,
    email  VARCHAR(256) NOT NULL,
    cnpj   VARCHAR(18)  NOT NULL UNIQUE, -- Exemplo de CNPJ: 11.536.612/0001-10 (18 caracteres)
    nome   VARCHAR(256) NOT NULL,
    cidade VARCHAR(90),
    PRIMARY KEY (id),
    FOREIGN KEY (id) REFERENCES usuario (id) ON DELETE CASCADE
);

CREATE TABLE promocao
(
    id        BIGINT       NOT NULL AUTO_INCREMENT,
    id_site   BIGINT       NOT NULL,
    id_teatro BIGINT       NOT NULL,
    nome_peca VARCHAR(256) NOT NULL,
    preco     FLOAT        NOT NULL,
    data_peca DATETIME     NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_site) REFERENCES site (id) ON DELETE CASCADE,
    FOREIGN KEY (id_teatro) REFERENCES teatro (id) ON DELETE CASCADE
);

INSERT INTO usuario (id, email, senha, papel)
VALUES (1, 'admin@admin', 'admin', 'ADMIN');

INSERT INTO usuario (id, email, senha, papel)
VALUES (2, 'site1@site', 'site', 'SITE');

INSERT INTO usuario (id, email, senha, papel)
VALUES (3, 'teatro1@teatro', 'teatro', 'TEATRO');

INSERT INTO site (id, email, nome, endereco, telefone)
VALUES (2, 'site1@site.com', 'Site Monstrão', 'https://site1.com', '+55 19 95812-5148');

INSERT INTO teatro (id, email, cnpj, nome, cidade)
VALUES (3, 'teatro1@teatro', '01.234.567/8901-23', 'Teatro Monstrão', 'São Carlos City');

-- Querys

-- #R1 Insert já tem
-- SELECT * FROM site WHERE id =
-- UPDATE site SET qualquercoluna = WHERE id =
-- DELETE FROM site WHERE id = 

-- #R3
-- SELECT id, cnpj, nome, cidade FROM teatro
-- UPDATE teatro SET qualquercoluna = WHERE id =
-- DELETE FROM teatro WHERE id = 

-- #R4
-- SELECT id, cnpj, nome, cidade FROM teatro WHERE cidade = ''

-- #R5
-- INSERT INTO promocao(id_site, id_teatro, nome_peca, preco, data_peca) VALUES ()

-- #R7
-- SELECT id_site, id_teatro, nome_peca, preco, data_peca FROM promocao

-- #R8 
-- SELECT id_site, id_teatro, nome_peca, preco, data_peca FROM promocao WHERE id_site = 