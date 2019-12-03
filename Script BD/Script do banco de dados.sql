--Script do banco de dados
--##Drops##
DROP DATABASE congresso;
DROP TABLE IF EXISTS `endereco`;
DROP TABLE IF EXISTS `participante`;
DROP TABLE IF EXISTS `cartao`;
DROP TABLE IF EXISTS `artigo`;
DROP TABLE IF EXISTS `artigo_autor`;
DROP TABLE IF EXISTS `revisao`;
DROP TABLE IF EXISTS `artigo_revisao`;

--##Creates##
CREATE DATABASE congresso;

CREATE TABLE `endereco` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `rua` varchar(255) default NULL,
  `bairro` varchar(10) default NULL,
  `cidade` varchar(255),
  `estado` varchar(50) default NULL,
  `complemento` varchar(30) default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

CREATE TABLE `participante` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `nome` varchar(255) default NULL,
  `telefone` varchar(100) default NULL,
  `email` varchar(255) default NULL,
  `localEmprego` varchar(255),
  `revisor` varchar(255) default NULL,
  `enderecoId` mediumint,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

CREATE TABLE `cartao` (
  `numero` varchar(255),
  `dataVencimento` varchar(255),
  `marca` varchar(255),
  `participanteId` mediumint
);

CREATE TABLE `artigo` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `titulo` TEXT default NULL,
  `resumo` TEXT default NULL,
  `pdf` mediumint default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

CREATE TABLE `artigo_autor` (
  `artigoId` mediumint,
  `participanteId` mediumint,
) AUTO_INCREMENT=1;

CREATE TABLE `revisao` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `artigoId` mediumint,
  `participanteId` mediumint,
  `nota` mediumint default NULL,
  `comentario` TEXT default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

CREATE TABLE `artigo_revisao` (
  `artigoId` mediumint,
  `revisaoId` mediumint
);


--##Inserts##
/*
INSERT INTO endereco (rua, bairro, cidade, estado, complemento) VALUES ('Prof Jaimede Sá Menezes','Cajazeiras','Salvador','BA','Prox ao LFMC');
INSERT INTO participante(nome, telefone, email, localEmprego, revisor, enderecoId) VALUES ('Jamille','71991121926','mille.bittencourt@gmail.com','Solutis Tec',1,1);
INSERT INTO cartao(numeroCartao, dataVencimento, marcaCartao, participanteId) VALUES ('4400890087009900','20200413','MasterCard',2);
INSERT INTO artigo(titulo, resumo, pdf) VALUES ('Utilização de QR Code na Acessibilidaade','Um resumo bem curto',9);
INSERT INTO artigo_autor(artigoId, participanteId) VALUES (1,2);
INSERT INTO revisao(artigoId, participanteId, nota, comentario) VALUES (1,2,8.5,'Bom artigo');
INSERT INTO artigo_revisao (artigoId, revisaoId) VALUES (1,1);
*/
