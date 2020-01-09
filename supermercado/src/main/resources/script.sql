-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.62 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para supermercado
DROP DATABASE IF EXISTS `supermercado`;
CREATE DATABASE IF NOT EXISTS `supermercado` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `supermercado`;

-- Volcando estructura para tabla supermercado.categoria
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.categoria: ~8 rows (aproximadamente)
DELETE FROM `categoria`;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` (`id`, `nombre`) VALUES
	(9, 'berria'),
	(2, 'electrodomesticos'),
	(10, 'mock1578486009755'),
	(11, 'mock1578486012740'),
	(1, 'mock1578558475550'),
	(3, 'musica'),
	(8, 'new'),
	(4, 'nueva');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.producto
DROP TABLE IF EXISTS `producto`;
CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `precio` float NOT NULL DEFAULT '0',
  `imagen` varchar(150) NOT NULL DEFAULT '0',
  `descripcion` varchar(50) NOT NULL DEFAULT '0',
  `descuento` int(11) NOT NULL DEFAULT '0',
  `id_usuario` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `fecha_modificacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_productio_tiene_usuario_idx` (`id_usuario`),
  KEY `FK_categoria` (`id_categoria`),
  CONSTRAINT `FK_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`),
  CONSTRAINT `FK_productio_tiene_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.producto: ~10 rows (aproximadamente)
DELETE FROM `producto`;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` (`id`, `nombre`, `precio`, `imagen`, `descripcion`, `descuento`, `id_usuario`, `id_categoria`, `fecha_modificacion`) VALUES
	(1, 'Leche', 0, '0', '0', 0, 1, 1, '2020-01-09 13:08:08'),
	(2, 'Cafe', 0, '0', '0', 0, 1, 2, '2020-01-09 13:08:08'),
	(3, 'Tortilla', 0, '0', '0', 0, 1, 3, '2020-01-09 13:08:08'),
	(4, 'Zumo de naranja', 0, '0', '0', 0, 1, 1, '2020-01-09 13:08:08'),
	(7, 'Technics SL-1200 mk3', 1243.54, 'https://image.flaticon.com/icons/png/512/372/372627.png', 'Plato ', 23, 1, 2, '2020-01-09 13:08:08'),
	(8, 'qewqeqr', 23123, 'https://image.flaticon.com/icons/png/512/372/372627.png', 'faedasd', 23, 1, 1, '2020-01-09 13:08:08'),
	(9, 'Cola Cao', 13, ':v', 'Polvos de cacao', 25, 2, 2, '2020-01-09 13:08:08'),
	(11, 'Morcilla', 14, 'imahe', 'morcillona rica de burgos', 0, 2, 1, '2020-01-09 13:08:08'),
	(12, 'Morcilla de burgos', 14, 'imahe', 'morcillona rica de burgos', 0, 2, 1, '2020-01-09 13:08:08'),
	(13, 'Queso Manchego', 14, 'imahe', 'morcillona rica de burgos  o', 0, 2, 1, '2020-01-09 13:26:04');
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.rol
DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.rol: ~2 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`) VALUES
	(1, 'administrador '),
	(2, 'usuario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla supermercado.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `contrasenia` int(11) NOT NULL,
  `id_rol` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `FK_usuario_rol` (`id_rol`),
  CONSTRAINT `FK_usuario_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla supermercado.usuario: ~2 rows (aproximadamente)
DELETE FROM `usuario`;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `nombre`, `contrasenia`, `id_rol`) VALUES
	(1, 'admin', 123456, 1),
	(2, 'dolores', 456789, 2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;

-- Volcando estructura para procedimiento supermercado.pa_categoria_delete
DROP PROCEDURE IF EXISTS `pa_categoria_delete`;
DELIMITER //
CREATE PROCEDURE `pa_categoria_delete`(
	IN `p_id_categoria` INT
)
BEGIN

-- crear nuevo registro
DELETE FROM  categoria WHERE id = p_id_categoria;


END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_getall
DROP PROCEDURE IF EXISTS `pa_categoria_getall`;
DELIMITER //
CREATE PROCEDURE `pa_categoria_getall`()
    DETERMINISTIC
BEGIN

-- Nuestro primer PA
/*Tiene pinta de que tambien admite comentarios de bloque*/
SELECT id, nombre FROM categoria order by nombre ASC LIMIT 500;




END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_getbyid
DROP PROCEDURE IF EXISTS `pa_categoria_getbyid`;
DELIMITER //
CREATE PROCEDURE `pa_categoria_getbyid`(
	IN `p_id` INT
)
BEGIN
	
	SELECT id, nombre FROM categoria WHERE id = p_id;
	
END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_insert
DROP PROCEDURE IF EXISTS `pa_categoria_insert`;
DELIMITER //
CREATE PROCEDURE `pa_categoria_insert`(
	IN `p_nombre` VARCHAR(100),
	OUT `p_id` INT
)
BEGIN

-- crear nuevo registro
INSERT INTO categoria (nombre) VALUES (p_nombre);

-- obtener el ID generado y setearlo al parametro de salida
SET p_id = LAST_INSERT_ID();

-- retornar el ID


END//
DELIMITER ;

-- Volcando estructura para procedimiento supermercado.pa_categoria_update
DROP PROCEDURE IF EXISTS `pa_categoria_update`;
DELIMITER //
CREATE PROCEDURE `pa_categoria_update`(
	IN `p_id_categoria` INT,
	IN `p_nombre` VARCHAR(100)
)
BEGIN
-- crear nuevo registro
UPDATE categoria SET nombre = p_nombre WHERE id = p_id_categoria;


END//
DELIMITER ;

-- Volcando estructura para función supermercado.HELLO_WORLD
DROP FUNCTION IF EXISTS `HELLO_WORLD`;
DELIMITER //
CREATE FUNCTION `HELLO_WORLD`() RETURNS varchar(20) CHARSET utf8
    DETERMINISTIC
BEGIN


	RETURN "hello world";
END//
DELIMITER ;

-- Volcando estructura para función supermercado.HELLO_WORLD2
DROP FUNCTION IF EXISTS `HELLO_WORLD2`;
DELIMITER //
CREATE FUNCTION `HELLO_WORLD2`(
	`pNombre` VARCHAR(50)
) RETURNS varchar(100) CHARSET utf8
BEGIN

	DECLARE nombre VARCHAR(100) DEFAULT 'anonimo';

	IF(TRIM(pNombre)  != '') THEN 
	SET nombre = TRIM(pNombre);
	
	END IF;

-- return "Hello" + pNimbre (Error)

RETURN CONCAT ("Hello", " ", nombre);

END//
DELIMITER ;

-- Volcando estructura para disparador supermercado.tbi_producto
DROP TRIGGER IF EXISTS `tbi_producto`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='';
DELIMITER //
CREATE TRIGGER `tbi_producto` BEFORE INSERT ON `producto` FOR EACH ROW BEGIN
/*
	Comprobar que el descuento sea entre 0 y 100
	si descuento < 0 = 0
	si descuento > 100 = 100
*/

IF NEW.descuento < 0 
	THEN SET NEW.descuento = 0;
END IF;
IF NEW.descuento > 100 
	then SET NEW.descuento = 100; 
END IF;


END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador supermercado.tbu_producto
DROP TRIGGER IF EXISTS `tbu_producto`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='';
DELIMITER //
CREATE TRIGGER `tbu_producto` BEFORE UPDATE ON `producto` FOR EACH ROW BEGIN


IF NEW.descuento < 0 THEN BEGIN
SET NEW.descuento = 0;
END;
END IF;

IF NEW.descuento > 100 THEN BEGIN
SET NEW.descuento = 100;
END;
END IF;



END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
