-- MySQL Script generated by MySQL Workbench
-- 03/23/15 16:40:17
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CFMedDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CFMedDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CFMedDB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `CFMedDB` ;

-- -----------------------------------------------------
-- Table `CFMedDB`.`Drugs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Drugs` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Drugs` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NULL,
  `Indication` MEDIUMTEXT NULL,
  `Side_Effects` MEDIUMTEXT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`Adult_Administration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Adult_Administration` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Adult_Administration` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Oral` MEDIUMTEXT NULL,
  `IV` MEDIUMTEXT NULL,
  `Inhaled` MEDIUMTEXT NULL,
  `IM` MEDIUMTEXT NULL,
  `PR` MEDIUMTEXT NULL,
  `SC` MEDIUMTEXT NULL,
  `Drugs_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Adult_Administration_Drugs1_idx` (`Drugs_ID` ASC),
  CONSTRAINT `fk_Adult_Administration_Drugs1`
    FOREIGN KEY (`Drugs_ID`)
    REFERENCES `CFMedDB`.`Drugs` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`Adult_Dose`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Adult_Dose` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Adult_Dose` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Oral` MEDIUMTEXT NULL,
  `IV` MEDIUMTEXT NULL,
  `Inhaled` MEDIUMTEXT NULL,
  `IM` MEDIUMTEXT NULL,
  `PR` MEDIUMTEXT NULL,
  `SC` MEDIUMTEXT NULL,
  `Drugs_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Adult_Dose_Drugs1_idx` (`Drugs_ID` ASC),
  CONSTRAINT `fk_Adult_Dose_Drugs1`
    FOREIGN KEY (`Drugs_ID`)
    REFERENCES `CFMedDB`.`Drugs` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`Paediatric_Administration`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Paediatric_Administration` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Paediatric_Administration` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Oral` MEDIUMTEXT NULL,
  `IV` MEDIUMTEXT NULL,
  `Inhaled` MEDIUMTEXT NULL,
  `IM` MEDIUMTEXT NULL,
  `PR` MEDIUMTEXT NULL,
  `SC` MEDIUMTEXT NULL,
  `Drugs_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Paediatric_Administration_Drugs1_idx` (`Drugs_ID` ASC),
  CONSTRAINT `fk_Paediatric_Administration_Drugs1`
    FOREIGN KEY (`Drugs_ID`)
    REFERENCES `CFMedDB`.`Drugs` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`Paediatric_Dose`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Paediatric_Dose` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Paediatric_Dose` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Oral` MEDIUMTEXT NULL,
  `IV` MEDIUMTEXT NULL,
  `Inhaled` MEDIUMTEXT NULL,
  `IM` MEDIUMTEXT NULL,
  `PR` MEDIUMTEXT NULL,
  `SC` MEDIUMTEXT NULL,
  `Drugs_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Paediatric_Dose_Drugs1_idx` (`Drugs_ID` ASC),
  CONSTRAINT `fk_Paediatric_Dose_Drugs1`
    FOREIGN KEY (`Drugs_ID`)
    REFERENCES `CFMedDB`.`Drugs` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`Brand_Names`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Brand_Names` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Brand_Names` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Brand_Name` VARCHAR(100) NULL,
  `Drugs_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Brand_Names_Drugs1_idx` (`Drugs_ID` ASC),
  CONSTRAINT `fk_Brand_Names_Drugs1`
    FOREIGN KEY (`Drugs_ID`)
    REFERENCES `CFMedDB`.`Drugs` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`Interations`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Interations` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Interations` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Interacting_Drug` VARCHAR(100) NULL,
  `Effect` MEDIUMTEXT NULL,
  `Drugs_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Interations_Drugs1_idx` (`Drugs_ID` ASC),
  CONSTRAINT `fk_Interations_Drugs1`
    FOREIGN KEY (`Drugs_ID`)
    REFERENCES `CFMedDB`.`Drugs` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`First_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`First_Line` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`First_Line` (
  `ID` INT NOT NULL,
  `Drug_Name` VARCHAR(100) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`Second_Line`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Second_Line` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Second_Line` (
  `ID` INT NOT NULL,
  `Drug_Name` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CFMedDB`.`Pathogens`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CFMedDB`.`Pathogens` ;

CREATE TABLE IF NOT EXISTS `CFMedDB`.`Pathogens` (
  `Pathogen_ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(100) NULL,
  `Description` MEDIUMTEXT NULL,
  `First_Line_ID` INT NOT NULL,
  `Second_Line_ID` INT NOT NULL,
  PRIMARY KEY (`Pathogen_ID`),
  INDEX `fk_Pathogens_First_Line1_idx` (`First_Line_ID` ASC),
  INDEX `fk_Pathogens_Second_Line1_idx` (`Second_Line_ID` ASC),
  CONSTRAINT `fk_Pathogens_First_Line1`
    FOREIGN KEY (`First_Line_ID`)
    REFERENCES `CFMedDB`.`First_Line` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Pathogens_Second_Line1`
    FOREIGN KEY (`Second_Line_ID`)
    REFERENCES `CFMedDB`.`Second_Line` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
