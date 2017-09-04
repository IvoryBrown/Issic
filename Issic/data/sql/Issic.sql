-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Issic
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Issic
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Issic` DEFAULT CHARACTER SET utf8 ;
USE `Issic` ;

-- -----------------------------------------------------
-- Table `Issic`.`Lakcím`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Issic`.`Lakcím` (
  `Irányítószám_ID` INT(30) NOT NULL,
  `Ország` VARCHAR(27) NOT NULL,
  `Megye` VARCHAR(30) NOT NULL,
  `Település` VARCHAR(30) NOT NULL,
  `Cím` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Irányítószám_ID`));


-- -----------------------------------------------------
-- Table `Issic`.`Szervezet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Issic`.`Szervezet` (
  `Dolgozo_ID` INT NOT NULL,
  `Belépés_dátuma` DATE NOT NULL,
  `Kilépés_dátuma` DATE NULL,
  `Beosztás` VARCHAR(255) NOT NULL,
  `Osztály` VARCHAR(255) NOT NULL,
  `Tevékenység` VARCHAR(255) NULL,
  `Üzlei_telefon` VARCHAR(255) NULL,
  `Üzleti_mobil` VARCHAR(255) NULL,
  `Üzleti_email` VARCHAR(255) NULL,
  PRIMARY KEY (`Dolgozo_ID`));


-- -----------------------------------------------------
-- Table `Issic`.`Okmányok`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Issic`.`Okmányok` (
  `Taj_szám` INT NOT NULL,
  `Sz_ig_szám` VARCHAR(255) NOT NULL,
  `Adoazonosító` INT NOT NULL,
  `Vezetői_engedély` VARCHAR(255) NULL,
  `Útlevél` VARCHAR(255) NULL,
  PRIMARY KEY (`Taj_szám`));


-- -----------------------------------------------------
-- Table `Issic`.`Levcím`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Issic`.`Levcím` (
  `Irányítószám_ID` INT(30) NOT NULL,
  `Ország` VARCHAR(27) NOT NULL,
  `Megye` VARCHAR(30) NOT NULL,
  `Település` VARCHAR(30) NOT NULL,
  `Cím` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Irányítószám_ID`));


-- -----------------------------------------------------
-- Table `Issic`.`Dolgozok`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Issic`.`Dolgozok` (
  `Dolgozo_ID` INT NOT NULL AUTO_INCREMENT,
  `Név` VARCHAR(255) CHARACTER SET 'utf8' COLLATE 'utf8_hungarian_ci' NOT NULL,
  `Irányítószám_ID` INT(4) NOT NULL,
  `Leánykori_név` VARCHAR(255) NULL,
  `Neme` VARCHAR(10) NOT NULL,
  `Születési_dátum` DATE NOT NULL,
  `Anyja_neve` VARCHAR(255) NOT NULL,
  `Magántelefon` TEXT NULL,
  `Magán_mobil` TEXT NULL,
  `Magán_e-mail` VARCHAR(255) NULL,
  PRIMARY KEY (`Dolgozo_ID`, `Irányítószám_ID`),
  INDEX `fk_Dolgozok_Lakcím_idx` (`Irányítószám_ID` ASC),
  CONSTRAINT `fk_Dolgozok_Lakcím`
    FOREIGN KEY (`Irányítószám_ID`)
    REFERENCES `Issic`.`Lakcím` (`Irányítószám_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dolgozok_Szervezet1`
    FOREIGN KEY (`Dolgozo_ID`)
    REFERENCES `Issic`.`Szervezet` (`Dolgozo_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dolgozok_Okmányok1`
    FOREIGN KEY (`Dolgozo_ID`)
    REFERENCES `Issic`.`Okmányok` (`Taj_szám`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Dolgozok_Levcím1`
    FOREIGN KEY (`Irányítószám_ID`)
    REFERENCES `Issic`.`Levcím` (`Irányítószám_ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
