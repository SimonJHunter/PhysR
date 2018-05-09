-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema physr
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema physr
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `physr` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `physr` ;

-- -----------------------------------------------------
-- Table `physr`.`clients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `physr`.`clients` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Firstname` VARCHAR(45) NOT NULL,
  `Lastname` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `physr`.`exercises`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `physr`.`exercises` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Description` VARCHAR(45) NOT NULL,
  `Repetitions` INT(11) NOT NULL DEFAULT '3',
  `Sets` INT(11) NOT NULL DEFAULT '10',
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `physr`.`workouts`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `physr`.`workouts` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL DEFAULT NULL,
  `Client_ID` INT(11) NULL DEFAULT NULL,
  `Excercise_ID` INT(11) NULL DEFAULT NULL,
  `AdditionalText` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`),
  INDEX `workout_client_FK_idx` (`Client_ID` ASC),
  INDEX `workout_exercise_FK_idx` (`Excercise_ID` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
