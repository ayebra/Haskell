-- MySQL Script generated by MySQL Workbench
-- Fri Oct 13 00:34:56 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema BaseReserva
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BaseReserva
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BaseReserva` DEFAULT CHARACTER SET utf8 ;
USE `BaseReserva` ;

-- -----------------------------------------------------
-- Table `BaseReserva`.`Habitación`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BaseReserva`.`Habitación` (
  `idHabitación` INT NOT NULL AUTO_INCREMENT,
  `Numero` VARCHAR(4) NOT NULL,
  `Piso` VARCHAR(2) NOT NULL,
  `Descripcion` VARCHAR(255) NULL,
  `Caracteristicas` VARCHAR(512) NULL,
  `Precio_Diario` DECIMAL(7,2) NOT NULL,
  `Estado` VARCHAR(15) NOT NULL,
  `Tipo_Habitacion` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idHabitación`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseReserva`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BaseReserva`.`Persona` (
  `idPersona` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(20) NOT NULL,
  `ApellidoPaterno` VARCHAR(20) NOT NULL,
  `ApellidoMaterno` VARCHAR(20) NOT NULL,
  `Tipo_Documento` VARCHAR(15) NOT NULL,
  `Numero_Documento` VARCHAR(8) NOT NULL,
  `Direccion` VARCHAR(100) NULL,
  `Telefono` VARCHAR(8) NULL,
  `Email` VARCHAR(25) NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE INDEX `Telefono_UNIQUE` (`Telefono` ASC),
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseReserva`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BaseReserva`.`Cliente` (
  `idPersona` INT NOT NULL,
  `Codigo_Cliente` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE INDEX `Codigo_Cliente_UNIQUE` (`Codigo_Cliente` ASC),
  CONSTRAINT `fk_Persona_Cliente`
    FOREIGN KEY (`idPersona`)
    REFERENCES `BaseReserva`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseReserva`.`Trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BaseReserva`.`Trabajador` (
  `idPersona` INT NOT NULL,
  `Sueldo` DECIMAL(7,2) NOT NULL,
  `Acceso` VARCHAR(15) NOT NULL,
  `Login` VARCHAR(15) NOT NULL,
  `Password` VARCHAR(20) NOT NULL,
  `Estado` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`idPersona`),
  CONSTRAINT `fK_Persona_Trabajador`
    FOREIGN KEY (`idPersona`)
    REFERENCES `BaseReserva`.`Persona` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseReserva`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BaseReserva`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Descripcion` VARCHAR(255) NULL,
  `Unidad_Medida` VARCHAR(20) NOT NULL,
  `Precio_Venta` DECIMAL(7,2) NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseReserva`.`Reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BaseReserva`.`Reserva` (
  `idReserva` INT NOT NULL AUTO_INCREMENT,
  `idHabitacion` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `idTrabajador` INT NOT NULL,
  `Tipo_Reserva` VARCHAR(20) NOT NULL,
  `Fecha_Reserva` DATE NOT NULL,
  `Fecha_Ingresa` DATE NOT NULL,
  `Fecha_Salida` DATE NOT NULL,
  `Costo_Alojamiento` DECIMAL(7,2) NOT NULL,
  `Estado` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idReserva`),
  INDEX `fk_Reserva_Habitacion_idx` (`idHabitacion` ASC),
  INDEX `fk_Reserva_Cliente_idx` (`idCliente` ASC),
  INDEX `fk_Reserva_Trabajador_idx` (`idTrabajador` ASC),
  CONSTRAINT `fk_Reserva_Habitacion`
    FOREIGN KEY (`idHabitacion`)
    REFERENCES `BaseReserva`.`Habitación` (`idHabitación`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `BaseReserva`.`Cliente` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Trabajador`
    FOREIGN KEY (`idTrabajador`)
    REFERENCES `BaseReserva`.`Trabajador` (`idPersona`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseReserva`.`Consumo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BaseReserva`.`Consumo` (
  `idConsumo` INT NOT NULL AUTO_INCREMENT,
  `idReserva` INT NOT NULL,
  `idProducto` INT NOT NULL,
  `Cantidad` DECIMAL(7,2) NULL,
  `Precio_Venta` DECIMAL(7,2) NULL,
  `Estado` VARCHAR(15) NULL,
  PRIMARY KEY (`idConsumo`),
  INDEX `fk_Consumo_Producto_idx` (`idProducto` ASC),
  INDEX `fk_Consumo_Reserva_idx` (`idReserva` ASC),
  CONSTRAINT `fk_Consumo_Producto`
    FOREIGN KEY (`idProducto`)
    REFERENCES `BaseReserva`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Consumo_Reserva`
    FOREIGN KEY (`idReserva`)
    REFERENCES `BaseReserva`.`Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BaseReserva`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `BaseReserva`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `idReserva` INT NOT NULL,
  `Tipo_Comprobante` VARCHAR(20) NOT NULL,
  `Numero_Comprobante` VARCHAR(20) NOT NULL,
  `igv` DECIMAL(4,2) NOT NULL,
  `Total_Pago` DECIMAL(7,2) NOT NULL,
  `Fecha_Emision` DATE NOT NULL,
  `Fecha_Pago` DATE NOT NULL,
  PRIMARY KEY (`idPago`),
  INDEX `fk_Pago_Reserva_idx` (`idReserva` ASC),
  CONSTRAINT `fk_Pago_Reserva`
    FOREIGN KEY (`idReserva`)
    REFERENCES `BaseReserva`.`Reserva` (`idReserva`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
