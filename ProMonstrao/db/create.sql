CREATE DATABASE IF NOT EXISTS ProMonstrao;

USE ProMonstrao;

CREATE TABLE usuario (
    id BIGINT NOT NULL, -- AUTO_INCREMENT (tirei o auto_increment temporariamente para ter controle sob o ID dos usuários
    email VARCHAR(256) NOT NULL UNIQUE,
    senha VARCHAR(64) NOT NULL,
    papel VARCHAR(6) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE site (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    nome VARCHAR(256) NOT NULL,
    telefone VARCHAR(30),
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id) ON DELETE CASCADE
);

CREATE TABLE teatro (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE, -- Exemplo de CNPJ: 11.536.612/0001-10 (18 caracteres)
    nome VARCHAR(256) NOT NULL,
    cidade VARCHAR(90),
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id) ON DELETE CASCADE
);

CREATE TABLE promocao (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_site BIGINT NOT NULL,
    id_teatro BIGINT NOT NULL,
    nome_peca VARCHAR(256) NOT NULL,
    preco FLOAT NOT NULL,
    data_peca DATETIME NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_site) REFERENCES tb_site(id) ON DELETE CASCADE,
    FOREIGN KEY (id_teatro) REFERENCES tb_teatro(id) ON DELETE CASCADE
);

INSERT INTO usuario (id, email, senha, papel) VALUES (0, 'admin@admin', 'admin', 'ADMIN');
INSERT INTO usuario (id, email, senha, papel) VALUES (1, 'site@site', 'site', 'SITE');
INSERT INTO usuario (id, email, senha, papel) VALUES (2, 'teatro@teatro', 'teatro', 'TEATRO');

INSERT INTO site (id_usuario, nome, telefone) VALUES (1, 'Site Monstrão', '+55 19 95812-5148');
INSERT INTO teatro (id_usuario, cnpj, nome, cidade) VALUES (2, '01.234.567/8901-23', 'Teatro Monstrão', 'São Carlos City');

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