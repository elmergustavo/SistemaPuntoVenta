-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.5.5-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para punto_de_ventas
DROP DATABASE IF EXISTS `punto_de_ventas`;
CREATE DATABASE IF NOT EXISTS `punto_de_ventas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `punto_de_ventas`;

-- Volcando estructura para tabla punto_de_ventas.tclientes
DROP TABLE IF EXISTS `tclientes`;
CREATE TABLE IF NOT EXISTS `tclientes` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nid` varchar(50) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  `Apellido` varchar(50) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Direccion` varchar(50) DEFAULT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  `Credito` tinyint(4) DEFAULT NULL,
  `Fecha` varchar(50) NOT NULL,
  `Imagen` longblob DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

-- Volcando estructura para tabla punto_de_ventas.treportes_clientes
DROP TABLE IF EXISTS `treportes_clientes`;
CREATE TABLE IF NOT EXISTS `treportes_clientes` (
  `IdReporte` int(11) NOT NULL AUTO_INCREMENT,
  `DeudaActual` decimal(10,0) NOT NULL DEFAULT 0,
  `FechaDeuda` varchar(50) NOT NULL DEFAULT '0',
  `UltimoPago` decimal(20,6) NOT NULL DEFAULT 0.000000,
  `FechaPago` varchar(50) NOT NULL DEFAULT '0',
  `Ticket` varchar(50) NOT NULL DEFAULT '0',
  `FechaLimite` varchar(50) NOT NULL DEFAULT '0',
  `IdCliente` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`IdReporte`),
  KEY `FK_treportes_clientes_tclientes` (`IdCliente`),
  CONSTRAINT `FK_treportes_clientes_tclientes` FOREIGN KEY (`IdCliente`) REFERENCES `tclientes` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- La exportación de datos fue deseleccionada.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
