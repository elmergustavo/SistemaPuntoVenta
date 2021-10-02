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
CREATE DATABASE IF NOT EXISTS `punto_de_ventas` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `punto_de_ventas`;

-- Volcando estructura para tabla punto_de_ventas.alimentos
CREATE TABLE IF NOT EXISTS `alimentos` (
  `IdAl` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo_al` varchar(45) NOT NULL,
  `Nombre_al` varchar(45) NOT NULL,
  `Precio_al` decimal(10,2) NOT NULL,
  `Tipo_al` varchar(50) NOT NULL,
  PRIMARY KEY (`IdAl`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.alimentos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `alimentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `alimentos` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.categorias
CREATE TABLE IF NOT EXISTS `categorias` (
  `IdCat` int(11) NOT NULL AUTO_INCREMENT,
  `Categoria` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`IdCat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.categorias: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.cotizaciones
CREATE TABLE IF NOT EXISTS `cotizaciones` (
  `id` int(11) NOT NULL,
  `nombreCliente` varchar(45) NOT NULL,
  `fechaRecibido` date NOT NULL,
  `fechaEntrega` date NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `anticipo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.cotizaciones: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `cotizaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `cotizaciones` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.detallescotizacion
CREATE TABLE IF NOT EXISTS `detallescotizacion` (
  `pedido_id` int(11) NOT NULL,
  `platillos_especiales_id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`pedido_id`,`platillos_especiales_id`),
  KEY `fk_pedido_has_platillos_especiales_platillos_especiales1_idx` (`platillos_especiales_id`),
  KEY `fk_pedido_has_platillos_especiales_pedido1_idx` (`pedido_id`),
  CONSTRAINT `fk_pedido_has_platillos_especiales_pedido1` FOREIGN KEY (`pedido_id`) REFERENCES `pedidocotizacion` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_platillos_especiales_platillos_especiales1` FOREIGN KEY (`platillos_especiales_id`) REFERENCES `platillos_especiales` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.detallescotizacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detallescotizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `detallescotizacion` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.detalle_pedido
CREATE TABLE IF NOT EXISTS `detalle_pedido` (
  `pedido_id` int(11) NOT NULL,
  `alimentos_Id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  PRIMARY KEY (`pedido_id`,`alimentos_Id`),
  KEY `fk_pedido_has_alimentos_alimentos1_idx` (`alimentos_Id`),
  KEY `fk_pedido_has_alimentos_pedido1_idx` (`pedido_id`),
  CONSTRAINT `fk_pedido_has_alimentos_alimentos1` FOREIGN KEY (`alimentos_Id`) REFERENCES `alimentos` (`IdAl`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_pedido_has_alimentos_pedido1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.detalle_pedido: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `detalle_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_pedido` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.mesa
CREATE TABLE IF NOT EXISTS `mesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.mesa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` (`id`, `estado`) VALUES
	(1, 'D'),
	(2, 'D'),
	(3, 'D'),
	(4, 'D'),
	(5, 'D'),
	(6, 'D'),
	(7, 'D'),
	(8, 'D'),
	(9, 'D'),
	(10, 'D');
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.pedido
CREATE TABLE IF NOT EXISTS `pedido` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `estado` varchar(10) DEFAULT NULL,
  `Mesa_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_Mesa1_idx` (`Mesa_id`),
  CONSTRAINT `fk_pedido_Mesa1` FOREIGN KEY (`Mesa_id`) REFERENCES `mesa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.pedido: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.pedidocotizacion
CREATE TABLE IF NOT EXISTS `pedidocotizacion` (
  `id` int(11) NOT NULL,
  `confirmacion` tinyint(4) NOT NULL,
  `cotizaciones_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pedido_cotizaciones1_idx` (`cotizaciones_id`),
  CONSTRAINT `fk_pedido_cotizaciones1` FOREIGN KEY (`cotizaciones_id`) REFERENCES `cotizaciones` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.pedidocotizacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pedidocotizacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidocotizacion` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.platillos_especiales
CREATE TABLE IF NOT EXISTS `platillos_especiales` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.platillos_especiales: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `platillos_especiales` DISABLE KEYS */;
/*!40000 ALTER TABLE `platillos_especiales` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.suministros
CREATE TABLE IF NOT EXISTS `suministros` (
  `IdSuministro` int(11) NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(45) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Stock` int(11) NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `Categoria` varchar(45) NOT NULL,
  PRIMARY KEY (`IdSuministro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.suministros: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `suministros` DISABLE KEYS */;
/*!40000 ALTER TABLE `suministros` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.tclientes
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

-- Volcando datos para la tabla punto_de_ventas.tclientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tclientes` DISABLE KEYS */;
INSERT INTO `tclientes` (`ID`, `Nid`, `Nombre`, `Apellido`, `Email`, `Direccion`, `Telefono`, `Credito`, `Fecha`, `Imagen`) VALUES
	(2, '0001', 'Elmer Gustavo', 'pu', 'elmergustavo79@gmail.com', 'xela', '33008456', 1, '02/10/2021', _binary 0x89504E470D0A1A0A0000000D49484452000000600000006008020000006DFAE06F000000324944415478DAEDC13101000000C2A0F54F6D0D0FA000000000000000000000000000000000000000000000000000008017036C600001C67C534F0000000049454E44AE426082);
/*!40000 ALTER TABLE `tclientes` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.treportes_clientes
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

-- Volcando datos para la tabla punto_de_ventas.treportes_clientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `treportes_clientes` DISABLE KEYS */;
INSERT INTO `treportes_clientes` (`IdReporte`, `DeudaActual`, `FechaDeuda`, `UltimoPago`, `FechaPago`, `Ticket`, `FechaLimite`, `IdCliente`) VALUES
	(2, 0, '--/--/--', 0.000000, '--/--/--', '0000000000', '--/--/--', 2);
/*!40000 ALTER TABLE `treportes_clientes` ENABLE KEYS */;

-- Volcando estructura para tabla punto_de_ventas.venta
CREATE TABLE IF NOT EXISTS `venta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla punto_de_ventas.venta: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
