CREATE DATABASE IF NOT EXISTS ProMonstrao;

USE ProMonstrao;

CREATE TABLE tb_usuario (
    id BIGINT NOT NULL, -- AUTO_INCREMENT (tirei o auto_increment temporariamente para ter controle sob o ID dos usuários
    email VARCHAR(256) NOT NULL UNIQUE,
    senha VARCHAR(64) NOT NULL,
    papel VARCHAR(6) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE tb_site (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    nome VARCHAR(256) NOT NULL,
    telefone VARCHAR(16),
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id) ON DELETE CASCADE
);

CREATE TABLE tb_teatro (
    id BIGINT NOT NULL AUTO_INCREMENT,
    id_usuario BIGINT NOT NULL,
    cnpj VARCHAR(18) NOT NULL UNIQUE, -- Exemplo de CNPJ: 11.536.612/0001-10 (18 caracteres)
    nome VARCHAR(256) NOT NULL,
    cidade VARCHAR(90),
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuario(id) ON DELETE CASCADE
);

CREATE TABLE tb_promocao (
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

-- Admins
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (1, 'admin1@admin', 'admin1', 'ADMIN');
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (2, 'admin2@admin', 'admin2', 'ADMIN');

-- Sites
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (3, 'site1@site', 'site1', 'SITE');
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (4, 'site2@site', 'site2', 'SITE');
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (5, 'site3@site', 'site3', 'SITE');

INSERT INTO tb_site (id_usuario, nome, telefone) VALUES (3, "Site Monstrao1", "169134134");
INSERT INTO tb_site (id_usuario, nome, telefone) VALUES (4, "Site Monstrao2", "169132341");
INSERT INTO tb_site (id_usuario, nome, telefone) VALUES (5, "Site Monstrao3", "234694124");

-- Teatros
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (6, 'teatro1@teatro', 'teatro1', 'TEATRO');
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (7, 'teatro2@teatro', 'teatro2', 'TEATRO');
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (8, 'teatro3@teatro', 'teatro3', 'TEATRO');
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (9, 'teatro4@teatro', 'teatro4', 'TEATRO');
INSERT INTO tb_usuario (id, email, senha, papel) VALUES (10, 'teatro5@teatro', 'teatro5', 'TEATRO');

INSERT INTO tb_teatro (id_usuario, cnpj, nome, cidade) VALUES (6, '01.234.537/1211-23', 'Teatro Monstrao1', 'Sao Carlos City');
INSERT INTO tb_teatro (id_usuario, cnpj, nome, cidade) VALUES (7, '01.234.563/1301-23', 'Teatro Monstrao2', 'Sao Carlos City');
INSERT INTO tb_teatro (id_usuario, cnpj, nome, cidade) VALUES (8, '01.214.591/3531-23', 'Teatro Monstrao3', 'Sao Carlos City');
INSERT INTO tb_teatro (id_usuario, cnpj, nome, cidade) VALUES (9, '01.264.767/8411-23', 'Teatro Monstrao4', 'Sao Carlos City');
INSERT INTO tb_teatro (id_usuario, cnpj, nome, cidade) VALUES (10, '01.934.557/8901-23', 'Teatro Monstrao5', 'Sao Carlos City');

INSERT INTO tb_promocao (id_site, id_teatro, nome_peca, preco, data_peca) VALUES (1, 1, 'Peca Monstrao de Natal', 34.50, '2020-12-24 23:59:00');
INSERT INTO tb_promocao (id_site, id_teatro, nome_peca, preco, data_peca) VALUES (2, 2, 'Peca Monstrao de Ano Novo', 34.50, '2020-12-31 23:59:00');

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