-- MySQL Workbench Synchronization
-- Generated: 2016-01-05 01:49
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: bruno

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `db_gspm`.`usuario` (
  `idusuario` VARCHAR(32) NOT NULL,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `senha` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_gspm`.`demolay` (
  `iddemolay` VARCHAR(32) NOT NULL,
  `usuario_idUsuario` VARCHAR(32) NOT NULL,
  `pessoa_idpessoa` VARCHAR(32) NOT NULL,
  `registro` INT(11) NOT NULL,
  PRIMARY KEY (`iddemolay`, `usuario_idUsuario`, `pessoa_idpessoa`),
  INDEX `fk_demolay_usuario1_idx` (`usuario_idUsuario` ASC),
  INDEX `fk_demolay_pessoa1_idx` (`pessoa_idpessoa` ASC),
  CONSTRAINT `fk_demolay_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `db_gspm`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_demolay_pessoa1`
    FOREIGN KEY (`pessoa_idpessoa`)
    REFERENCES `db_gspm`.`pessoa` (`idpessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_gspm`.`macom` (
  `idmacom` VARCHAR(32) NOT NULL,
  `usuario_idUsuario` VARCHAR(32) NOT NULL,
  `pessoa_idpessoa` VARCHAR(32) NOT NULL,
  `registro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idmacom`, `usuario_idUsuario`, `pessoa_idpessoa`),
  INDEX `fk_macom_usuario1_idx` (`usuario_idUsuario` ASC),
  INDEX `fk_macom_pessoa1_idx` (`pessoa_idpessoa` ASC),
  CONSTRAINT `fk_macom_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `db_gspm`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_macom_pessoa1`
    FOREIGN KEY (`pessoa_idpessoa`)
    REFERENCES `db_gspm`.`pessoa` (`idpessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `db_gspm`.`filhadejo` (
  `idfilhadejo` VARCHAR(32) NOT NULL,
  `usuario_idUsuario` VARCHAR(32) NOT NULL,
  `pessoa_idpessoa` VARCHAR(32) NOT NULL,
  `registro` INT(11) NOT NULL,
  PRIMARY KEY (`idfilhadejo`, `usuario_idUsuario`, `pessoa_idpessoa`),
  INDEX `fk_filhadejo_usuario_idx` (`usuario_idUsuario` ASC),
  INDEX `fk_filhadejo_pessoa1_idx` (`pessoa_idpessoa` ASC),
  CONSTRAINT `fk_filhadejo_usuario`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `db_gspm`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_filhadejo_pessoa1`
    FOREIGN KEY (`pessoa_idpessoa`)
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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
