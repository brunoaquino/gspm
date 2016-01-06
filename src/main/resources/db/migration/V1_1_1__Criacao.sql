-- MySQL Workbench Synchronization
-- Generated: 2016-01-05 20:55
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: bruno

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `db_gspm`.`usuario` (
  `idusuario` VARCHAR(32) NOT NULL,
  `login` VARCHAR(12) NOT NULL,
  `senha` VARCHAR(12) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `ativo` TINYINT(4) NOT NULL DEFAULT 1,
  `datadecadastro` DATETIME NOT NULL,
  `datadealteracao` DATETIME NOT NULL,
  `tipo` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_gspm`.`demolay` (
  `iddemolay` VARCHAR(32) NOT NULL,
  `idUsuario` VARCHAR(32) NOT NULL,
  `idpessoa` VARCHAR(32) NOT NULL,
  `iddm` INT(11) NOT NULL,
  PRIMARY KEY (`iddemolay`, `idUsuario`, `idpessoa`),
  INDEX `fk_demolay_usuario1_idx` (`idUsuario` ASC),
  INDEX `fk_demolay_pessoa1_idx` (`idpessoa` ASC),
  CONSTRAINT `fk_demolay_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `db_gspm`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_demolay_pessoa1`
    FOREIGN KEY (`idpessoa`)
    REFERENCES `db_gspm`.`pessoa` (`idpessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_gspm`.`macom` (
  `idmacom` VARCHAR(32) NOT NULL,
  `idUsuario` VARCHAR(32) NOT NULL,
  `idpessoa` VARCHAR(32) NOT NULL,
  `registro` INT(11) NOT NULL,
  PRIMARY KEY (`idmacom`, `idUsuario`, `idpessoa`),
  INDEX `fk_macom_usuario1_idx` (`idUsuario` ASC),
  INDEX `fk_macom_pessoa1_idx` (`idpessoa` ASC),
  CONSTRAINT `fk_macom_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `db_gspm`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_macom_pessoa1`
    FOREIGN KEY (`idpessoa`)
    REFERENCES `db_gspm`.`pessoa` (`idpessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_gspm`.`filhadejo` (
  `idfilhadejo` VARCHAR(32) NOT NULL,
  `idUsuario` VARCHAR(32) NOT NULL,
  `idpessoa` VARCHAR(32) NOT NULL,
  `registro` INT(11) NOT NULL,
  PRIMARY KEY (`idfilhadejo`, `idUsuario`, `idpessoa`),
  INDEX `fk_filhadejo_usuario_idx` (`idUsuario` ASC),
  INDEX `fk_filhadejo_pessoa1_idx` (`idpessoa` ASC),
  CONSTRAINT `fk_filhadejo_usuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `db_gspm`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_filhadejo_pessoa1`
    FOREIGN KEY (`idpessoa`)
    REFERENCES `db_gspm`.`pessoa` (`idpessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_gspm`.`pessoa` (
  `idpessoa` VARCHAR(32) NOT NULL,
  `nome` VARCHAR(45) NULL DEFAULT NULL,
  `idade` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idpessoa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_gspm`.`administrador` (
  `idadministrador` VARCHAR(32) NOT NULL,
  `idusuario` VARCHAR(32) NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`idadministrador`, `idusuario`),
  INDEX `fk_administrador_usuario1_idx` (`idusuario` ASC),
  CONSTRAINT `fk_administrador_usuario1`
    FOREIGN KEY (`idusuario`)
    REFERENCES `db_gspm`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `db_gspm`.`usuario` (`idusuario`, `login`, `senha`, `email`, `ativo`, `datadecadastro`, `datadealteracao`, `tipo`) VALUES ('475ec6070e3d4f599cac06070f45aef1', 'admin', '1', 'brunosmv2@gmail.com', '1', '2015-09-11 16:17:25', '2015-09-11 16:17:25', '4');
INSERT INTO `db_gspm`.`administrador` (`idadministrador`, `idusuario`, `nome`) VALUES ('63a1cdc89e9a42d7a90a3aafe33e426d', '475ec6070e3d4f599cac06070f45aef1', 'Bruno Carvalho de Aquino');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
