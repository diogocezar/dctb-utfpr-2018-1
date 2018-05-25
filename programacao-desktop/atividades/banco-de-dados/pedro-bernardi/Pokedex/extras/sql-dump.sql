CREATE DATABASE  IF NOT EXISTS `pokedex` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pokedex`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pokedex
-- ------------------------------------------------------
-- Server version	5.7.19-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pokemon`
--

DROP TABLE IF EXISTS `pokemon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pokemon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `attack` int(11) NOT NULL,
  `defense` int(11) NOT NULL,
  `hp` int(11) NOT NULL,
  `sp_atk` int(11) NOT NULL,
  `sp_def` int(11) NOT NULL,
  `speed` int(11) NOT NULL,
  `height` varchar(6) NOT NULL,
  `weight` varchar(8) NOT NULL,
  `id_type` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Type` (`id_type`),
  CONSTRAINT `FK_Type` FOREIGN KEY (`id_type`) REFERENCES `type` (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=157 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pokemon`
--

LOCK TABLES `pokemon` WRITE;
/*!40000 ALTER TABLE `pokemon` DISABLE KEYS */;
INSERT INTO `pokemon` VALUES (1,'Bulbasaur',49,49,45,65,65,45,'0.71 m','6.9 kg',1),(2,'Ivysaur',62,63,60,80,80,60,'0.99 m','13.0 kg',1),(3,'Venusaur',82,83,80,100,100,80,'2.01 m','100.0 kg',1),(4,'Charmander',52,43,39,60,50,65,'0.61 m','8.5 kg',2),(5,'Charmeleon',64,58,58,80,65,80,'1.09 m','19.0 kg',2),(6,'Charizard',84,78,78,109,85,100,'1.70 m','90.5 kg',3),(7,'Squirtle',48,65,44,50,64,43,'0.51 m','9.0 kg',4),(8,'Wartortle',63,80,59,65,80,58,'0.99 m','22.5 kg',4),(9,'Blastoise',83,100,79,85,105,78,'1.60 m','85.5 kg',4),(10,'Caterpie',30,35,45,20,20,45,'0.30 m','2.9 kg',5),(11,'Metapod',20,55,50,25,25,30,'0.71 m','9.9 kg',5),(12,'Butterfree',45,50,60,90,80,70,'1.09 m','32.0 kg',6),(13,'Weedle',35,30,40,20,20,50,'0.30 m','3.2 kg',7),(14,'Kakuna',25,50,45,25,25,35,'0.61 m','10.0 kg',7),(15,'Beedrill',90,40,65,45,80,75,'0.99 m','29.5 kg',7),(16,'Pidgey',45,40,40,35,35,56,'0.30 m','1.8 kg',8),(17,'Pidgeotto',60,55,63,50,50,71,'1.09 m','30.0 kg',8),(18,'Pidgeot',80,75,83,70,70,101,'1.50 m','39.5 kg',8),(19,'Rattata',56,35,30,25,35,72,'0.30 m','3.5 kg',9),(20,'Raticate',81,60,55,50,70,97,'0.71 m','18.5 kg',9),(21,'Spearow',60,30,40,31,31,70,'0.30 m','2.0 kg',8),(22,'Fearow',90,65,65,61,61,100,'1.19 m','38.0 kg',8),(23,'Ekans',60,44,35,40,54,55,'2.01 m','6.9 kg',10),(24,'Arbok',85,69,60,65,79,80,'3.51 m','65.0 kg',10),(25,'Pikachu',55,40,35,50,50,90,'0.41 m','6.0 kg',11),(26,'Raichu',90,55,60,90,80,110,'0.79 m','30.0 kg',11),(27,'Sandshrew',75,85,50,20,30,40,'0.61 m','12.0 kg',12),(28,'Sandslash',100,110,75,45,55,65,'0.99 m','29.5 kg',12),(29,'Nidoran♀',47,52,55,40,40,41,'0.41 m','7.0 kg',10),(30,'Nidorina',62,67,70,55,55,56,'0.79 m','20.0 kg',10),(31,'Nidoqueen',92,87,90,75,85,76,'1.30 m','60.0 kg',13),(32,'Nidoran♂',57,40,46,40,40,50,'0.51 m','9.0 kg',10),(33,'Nidorino',72,57,61,55,55,65,'0.89 m','19.5 kg',10),(34,'Nidoking',102,77,81,85,75,85,'1.40 m','62.0 kg',13),(35,'Clefairy',45,48,70,60,65,35,'0.61 m','7.5 kg',9),(36,'Clefable',70,73,95,95,90,60,'1.30 m','40.0 kg',9),(37,'Vulpix',41,40,38,50,65,65,'0.61 m','9.9 kg',2),(38,'Ninetales',76,75,73,81,100,100,'1.09 m','19.9 kg',2),(39,'Jigglypuff',45,20,115,45,25,20,'0.51 m','5.5 kg',9),(40,'Wigglytuff',70,45,140,85,50,45,'0.99 m','12.0 kg',9),(41,'Zubat',45,35,40,30,40,55,'0.79 m','7.5 kg',14),(42,'Golbat',80,70,75,65,75,90,'1.60 m','55.0 kg',14),(43,'Oddish',50,55,45,75,65,30,'0.51 m','5.4 kg',1),(44,'Gloom',65,70,60,85,75,40,'0.79 m','8.6 kg',1),(45,'Vileplume',80,85,75,110,90,50,'1.19 m','18.6 kg',1),(46,'Paras',70,55,35,45,55,25,'0.30 m','5.4 kg',15),(47,'Parasect',95,80,60,60,80,30,'0.99 m','29.5 kg',15),(48,'Venonat',55,50,60,40,55,45,'0.99 m','30.0 kg',7),(49,'Venomoth',65,60,70,90,75,90,'1.50 m','12.5 kg',7),(50,'Diglett',55,25,10,35,45,95,'0.20 m','0.8 kg',12),(51,'Dugtrio',80,50,35,50,70,120,'0.71 m','33.3 kg',12),(52,'Meowth',45,35,40,40,40,90,'0.41 m','4.2 kg',9),(53,'Persian',70,60,65,65,65,115,'0.99 m','32.0 kg',9),(54,'Psyduck',52,48,50,65,50,55,'0.79 m','19.6 kg',4),(55,'Golduck',82,78,80,95,80,85,'1.70 m','76.6 kg',4),(56,'Mankey',80,35,40,35,45,70,'0.51 m','28.0 kg',16),(57,'Primeape',105,60,65,60,70,95,'0.99 m','32.0 kg',16),(58,'Growlithe',70,45,55,70,50,60,'0.71 m','19.0 kg',2),(59,'Arcanine',110,80,90,100,80,95,'1.91 m','155.0 kg',2),(60,'Poliwag',50,40,40,40,40,90,'0.61 m','12.4 kg',4),(61,'Poliwhirl',65,65,65,50,50,90,'0.99 m','20.0 kg',4),(62,'Poliwrath',95,95,90,70,90,70,'1.30 m','54.0 kg',17),(63,'Abra',20,15,25,105,55,90,'0.89 m','19.5 kg',18),(64,'Kadabra',35,30,40,120,70,105,'1.30 m','56.5 kg',18),(65,'Alakazam',50,45,55,135,95,120,'1.50 m','48.0 kg',18),(66,'Machop',80,50,70,35,35,35,'0.79 m','19.5 kg',16),(67,'Machoke',100,70,80,50,60,45,'1.50 m','70.5 kg',16),(68,'Machamp',130,80,90,65,85,55,'1.60 m','130.0 kg',16),(69,'Bellsprout',75,35,50,70,30,40,'0.71 m','4.0 kg',1),(70,'Weepinbell',90,50,65,85,45,55,'0.99 m','6.4 kg',1),(71,'Victreebel',105,65,80,100,70,70,'1.70 m','15.5 kg',1),(72,'Tentacool',40,35,40,50,100,70,'0.89 m','45.5 kg',19),(73,'Tentacruel',70,65,80,80,120,100,'1.60 m','55.0 kg',19),(74,'Geodude',80,100,40,30,30,20,'0.41 m','20.0 kg',20),(75,'Graveler',95,115,55,45,45,35,'0.99 m','105.0 kg',20),(76,'Golem',120,130,80,55,65,45,'1.40 m','300.0 kg',20),(77,'Ponyta',85,55,50,65,65,90,'0.99 m','30.0 kg',2),(78,'Rapidash',100,70,65,80,80,105,'1.70 m','95.0 kg',2),(79,'Slowpoke',65,65,90,40,40,15,'1.19 m','36.0 kg',21),(80,'Slowbro',75,110,95,100,80,30,'1.60 m','78.5 kg',21),(81,'Magnemite',35,70,25,95,55,45,'0.30 m','6.0 kg',11),(82,'Magneton',60,95,50,120,70,70,'0.99 m','60.0 kg',11),(83,'Farfetch\'d',65,55,52,58,62,60,'0.79 m','15.0 kg',8),(84,'Doduo',85,45,35,35,35,75,'1.40 m','39.2 kg',8),(85,'Dodrio',110,70,60,60,60,100,'1.80 m','85.2 kg',8),(86,'Seel',45,55,65,45,70,45,'1.09 m','90.0 kg',4),(87,'Dewgong',70,80,90,70,95,70,'1.70 m','120.0 kg',22),(88,'Grimer',80,50,80,40,50,25,'0.89 m','30.0 kg',10),(89,'Muk',105,75,105,65,100,50,'1.19 m','30.0 kg',10),(90,'Shellder',65,100,30,45,25,40,'0.30 m','4.0 kg',4),(91,'Cloyster',95,180,50,85,45,70,'1.50 m','132.5 kg',22),(92,'Gastly',35,30,30,100,35,80,'1.30 m','0.1 kg',23),(93,'Haunter',50,45,45,115,55,95,'1.60 m','0.1 kg',23),(94,'Gengar',65,60,60,130,75,110,'1.50 m','40.5 kg',23),(95,'Onix',45,160,35,30,45,70,'8.79 m','210.0 kg',20),(96,'Drowzee',48,45,60,43,90,42,'0.99 m','32.4 kg',18),(97,'Hypno',73,70,85,73,115,67,'1.60 m','75.6 kg',18),(98,'Krabby',105,90,30,25,25,50,'0.41 m','6.5 kg',4),(99,'Kingler',130,115,55,50,50,75,'1.30 m','60.0 kg',4),(100,'Voltorb',30,50,40,55,55,100,'0.51 m','10.4 kg',11),(101,'Electrode',50,70,60,80,80,140,'1.19 m','66.6 kg',11),(102,'Exeggcute',40,80,60,60,45,40,'0.41 m','2.5 kg',24),(103,'Exeggutor',95,85,95,125,65,55,'2.01 m','120.0 kg',24),(104,'Cubone',50,95,50,40,50,35,'0.41 m','6.5 kg',12),(105,'Marowak',80,110,60,50,80,45,'0.99 m','45.0 kg',12),(106,'Hitmonlee',120,53,50,35,110,87,'1.50 m','49.8 kg',16),(107,'Hitmonchan',105,79,50,35,110,76,'1.40 m','50.2 kg',16),(108,'Lickitung',55,75,90,60,75,30,'1.19 m','65.5 kg',9),(109,'Koffing',65,95,40,60,45,35,'0.61 m','1.0 kg',10),(110,'Weezing',90,120,65,85,70,60,'1.19 m','9.5 kg',10),(111,'Rhyhorn',85,95,80,30,30,25,'0.99 m','115.0 kg',25),(112,'Rhydon',130,120,105,45,45,40,'1.91 m','120.0 kg',25),(113,'Chansey',5,5,250,35,105,50,'1.09 m','34.6 kg',9),(114,'Tangela',55,115,65,100,40,60,'0.99 m','35.0 kg',26),(115,'Kangaskhan',95,80,105,40,80,90,'2.21 m','80.0 kg',9),(116,'Horsea',40,70,30,70,25,60,'0.41 m','8.0 kg',4),(117,'Seadra',65,95,55,95,45,85,'1.19 m','25.0 kg',4),(118,'Goldeen',67,60,45,35,50,63,'0.61 m','15.0 kg',4),(119,'Seaking',92,65,80,65,80,68,'1.30 m','39.0 kg',4),(120,'Staryu',45,55,30,70,55,85,'0.79 m','34.5 kg',4),(121,'Starmie',75,85,60,100,85,115,'1.09 m','80.0 kg',21),(122,'Mr. Mime',45,65,40,100,120,90,'1.30 m','54.5 kg',18),(123,'Scyther',110,80,70,55,80,105,'1.50 m','56.0 kg',6),(124,'Jynx',50,35,65,115,95,95,'1.40 m','40.6 kg',27),(125,'Electabuzz',83,57,65,95,85,105,'1.09 m','30.0 kg',11),(126,'Magmar',95,57,65,100,85,93,'1.30 m','44.5 kg',2),(127,'Pinsir',125,100,65,55,70,85,'1.50 m','55.0 kg',5),(128,'Tauros',100,95,75,40,70,110,'1.40 m','88.4 kg',9),(129,'Magikarp',10,55,20,15,20,80,'0.89 m','10.0 kg',4),(130,'Gyarados',125,79,95,60,100,81,'6.50 m','235.0 kg',28),(131,'Lapras',85,80,130,85,95,60,'2.49 m','220.0 kg',22),(132,'Ditto',48,48,48,48,48,48,'0.30 m','4.0 kg',9),(133,'Eevee',55,50,55,45,65,55,'0.30 m','6.5 kg',9),(134,'Vaporeon',65,60,130,110,95,65,'0.99 m','29.0 kg',4),(135,'Jolteon',65,60,65,110,95,130,'0.79 m','24.5 kg',11),(136,'Flareon',130,60,65,95,110,65,'0.89 m','25.0 kg',2),(137,'Porygon',60,70,65,85,75,40,'0.79 m','36.5 kg',9),(138,'Omanyte',40,100,35,90,55,35,'0.41 m','7.5 kg',29),(139,'Omastar',60,125,70,115,70,55,'0.99 m','35.0 kg',29),(140,'Kabuto',80,90,30,55,45,55,'0.51 m','11.5 kg',29),(141,'Kabutops',115,105,60,65,70,80,'1.30 m','40.5 kg',29),(142,'Aerodactyl',105,65,80,60,75,130,'1.80 m','59.0 kg',30),(143,'Snorlax',110,65,160,65,110,30,'2.11 m','460.0 kg',9),(144,'Articuno',85,100,90,95,125,85,'1.70 m','55.4 kg',31),(145,'Zapdos',90,85,90,125,90,100,'1.60 m','52.6 kg',32),(146,'Moltres',100,90,90,125,85,90,'2.01 m','60.0 kg',3),(147,'Dratini',64,45,41,50,50,50,'1.80 m','3.3 kg',33),(148,'Dragonair',84,65,61,70,70,70,'3.99 m','16.5 kg',33),(149,'Dragonite',134,95,91,100,100,80,'2.21 m','210.0 kg',34),(150,'Mewtwo',110,90,106,154,90,130,'2.01 m','122.0 kg',18),(151,'Mew',100,100,100,100,100,100,'0.41 m','4.0 kg',18),(153,'Bulb',50,80,20,65,65,45,'0.71 m','6.9 kg',1);
/*!40000 ALTER TABLE `pokemon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `pokemon_list`
--

DROP TABLE IF EXISTS `pokemon_list`;
/*!50001 DROP VIEW IF EXISTS `pokemon_list`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `pokemon_list` AS SELECT 
 1 AS `id_type`,
 1 AS `id`,
 1 AS `name`,
 1 AS `attack`,
 1 AS `defense`,
 1 AS `hp`,
 1 AS `sp_atk`,
 1 AS `sp_def`,
 1 AS `speed`,
 1 AS `height`,
 1 AS `weight`,
 1 AS `type0`,
 1 AS `type1`,
 1 AS `weaknesses0`,
 1 AS `weaknesses1`,
 1 AS `weaknesses2`,
 1 AS `weaknesses3`,
 1 AS `weaknesses4`,
 1 AS `weaknesses5`,
 1 AS `weaknesses6`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `id_type` int(11) NOT NULL AUTO_INCREMENT,
  `type0` varchar(15) NOT NULL,
  `type1` varchar(15) DEFAULT NULL,
  `weaknesses0` varchar(15) DEFAULT NULL,
  `weaknesses1` varchar(15) DEFAULT NULL,
  `weaknesses2` varchar(15) DEFAULT NULL,
  `weaknesses3` varchar(15) DEFAULT NULL,
  `weaknesses4` varchar(15) DEFAULT NULL,
  `weaknesses5` varchar(15) DEFAULT NULL,
  `weaknesses6` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Grass','Poison','Fire','Ice','Flying','Psychic',NULL,NULL,NULL),(2,'Fire',NULL,'Water','Ground','Rock',NULL,NULL,NULL,NULL),(3,'Fire','Flying','Water','Electric','Rock',NULL,NULL,NULL,NULL),(4,'Water',NULL,'Electric','Grass',NULL,NULL,NULL,NULL,NULL),(5,'Bug',NULL,'Fire','Flying','Rock',NULL,NULL,NULL,NULL),(6,'Bug','Flying','Fire','Electric','Ice','Flying','Rock',NULL,NULL),(7,'Bug','Poison','Fire','Flying','Psychic','Rock',NULL,NULL,NULL),(8,'Normal','Flying','Electric','Rock',NULL,NULL,NULL,NULL,NULL),(9,'Normal',NULL,'Fighting',NULL,NULL,NULL,NULL,NULL,NULL),(10,'Poison',NULL,'Ground','Psychic',NULL,NULL,NULL,NULL,NULL),(11,'Electric',NULL,'Ground',NULL,NULL,NULL,NULL,NULL,NULL),(12,'Ground',NULL,'Water','Grass','Ice',NULL,NULL,NULL,NULL),(13,'Poison','Ground','Water','Ice','Ground','Psychic',NULL,NULL,NULL),(14,'Poison','Flying','Electric','Ice','Psychic','Rock',NULL,NULL,NULL),(15,'Bug','Grass','Fire','Ice','Poison','Flying','Bug','Rock',NULL),(16,'Fighting',NULL,'Flying','Psychic','Fairy',NULL,NULL,NULL,NULL),(17,'Water','Fighting','Electric','Grass','Flying','Psychic','Fairy',NULL,NULL),(18,'Psychic',NULL,'Bug','Ghost','Dark',NULL,NULL,NULL,NULL),(19,'Water','Poison','Electric','Ground','Psychic',NULL,NULL,NULL,NULL),(20,'Rock','Ground','Water','Grass','Ice','Fighting','Ground','Steel',NULL),(21,'Water','Psychic','Electric','Grass','Bug','Ghost','Dark',NULL,NULL),(22,'Water','Ice','Electric','Grass','Fighting','Rock',NULL,NULL,NULL),(23,'Ghost','Poison','Ground','Psychic','Ghost','Dark',NULL,NULL,NULL),(24,'Grass','Psychic','Fire','Ice','Poison','Flying','Bug','Ghost','Dark'),(25,'Ground','Rock','Water','Grass','Ice','Fighting','Ground','Steel',NULL),(26,'Grass',NULL,'Fire','Ice','Poison','Flying','Bug',NULL,NULL),(27,'Ice','Psychic','Fire','Bug','Rock','Ghost','Dark','Steel',NULL),(28,'Water','Flying','Electric','Rock',NULL,NULL,NULL,NULL,NULL),(29,'Rock','Water','Electric','Grass','Fighting','Ground',NULL,NULL,NULL),(30,'Rock','Flying','Water','Electric','Ice','Rock','Steel',NULL,NULL),(31,'Ice','Flying','Fire','Electric','Rock','Steel',NULL,NULL,NULL),(32,'Electric','Flying','Ice','Rock',NULL,NULL,NULL,NULL,NULL),(33,'Dragon',NULL,'Ice','Dragon','Fairy',NULL,NULL,NULL,NULL),(34,'Dragon','Flying','Ice','Rock','Dragon','Fairy',NULL,NULL,NULL);
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'pokedex'
--
/*!50003 DROP FUNCTION IF EXISTS `create_pokemon` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `create_pokemon`(
  `name` varchar(10),
  `attack` int(11),
  `defense` int(11),
  `hp` int(11),
  `sp_atk` int(11),
  `sp_def` int(11),
  `speed` int(11),
  `height` varchar(6),
  `weight` varchar(8),
  `type0` varchar(15)
  ) RETURNS int(11)
BEGIN
	DECLARE ID_TYPE INT;
    SET ID_TYPE = create_type(`type0`);
    INSERT INTO pokemon(`name`,`attack`,`defense`,`hp`,`sp_atk`,`sp_def`,`speed`,`height`,`weight`,`id_type`) VALUES(`name`,`attack`,`defense`,`hp`,`sp_atk`,`sp_def`,`speed`,`height`,`weight`,ID_TYPE);
RETURN 1;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `create_type` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `create_type`(
  `type0` varchar(15)
  ) RETURNS int(11)
    DETERMINISTIC
BEGIN
DECLARE ID_TYPE INT;
    SET ID_TYPE = (SELECT id_type FROM type WHERE type.type0 = type0 LIMIT 1);
    IF ID_TYPE IS NULL THEN
    INSERT INTO type(`type0`) VALUES (type0);
	SET ID_TYPE = (SELECT LAST_INSERT_ID());
    END IF;
    RETURN ID_TYPE;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `pokemon_list`
--

/*!50001 DROP VIEW IF EXISTS `pokemon_list`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `pokemon_list` AS select `pokemon`.`id_type` AS `id_type`,`pokemon`.`id` AS `id`,`pokemon`.`name` AS `name`,`pokemon`.`attack` AS `attack`,`pokemon`.`defense` AS `defense`,`pokemon`.`hp` AS `hp`,`pokemon`.`sp_atk` AS `sp_atk`,`pokemon`.`sp_def` AS `sp_def`,`pokemon`.`speed` AS `speed`,`pokemon`.`height` AS `height`,`pokemon`.`weight` AS `weight`,`type`.`type0` AS `type0`,`type`.`type1` AS `type1`,`type`.`weaknesses0` AS `weaknesses0`,`type`.`weaknesses1` AS `weaknesses1`,`type`.`weaknesses2` AS `weaknesses2`,`type`.`weaknesses3` AS `weaknesses3`,`type`.`weaknesses4` AS `weaknesses4`,`type`.`weaknesses5` AS `weaknesses5`,`type`.`weaknesses6` AS `weaknesses6` from (`pokemon` join `type` on((`pokemon`.`id_type` = `type`.`id_type`))) order by `pokemon`.`id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-25  4:35:59
