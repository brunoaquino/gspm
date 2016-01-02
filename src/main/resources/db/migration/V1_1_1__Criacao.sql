SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `db_gspm`.`usuario` (
  `usuario_id` INT(11) NOT NULL,
  `text_email` VARCHAR(200) NOT NULL,
  `text_senha` VARCHAR(12) NOT NULL,
  `bool_ativo` TINYINT(4) NOT NULL DEFAULT 1,
  `text_login` VARCHAR(200) NOT NULL,
  `bool_admin` TINYINT(4) NOT NULL DEFAULT 0,
  `dataDeCadastro` DATETIME NOT NULL,
  `dataDeAlteracao` DATETIME NOT NULL,
  PRIMARY KEY (`usuario_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `db_gspm`.`usuario` (`usuario_id`, `text_email`, `text_senha`, `bool_ativo`, `text_login`, `bool_admin`, `dataDeCadastro`, `dataDeAlteracao`) VALUES ('1', 'bruno-smv2@hotmail.com', '1', '1', 'admin', '1', '2015-09-11 16:17:25', '2015-09-11 16:17:25');


--SET FOREIGN_KEY_CHECKS = 0;
--SET FOREIGN_KEY_CHECKS = 1;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

