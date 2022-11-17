-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: filmovi
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film` (
  `sifra` int NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) NOT NULL,
  `godina` int NOT NULL,
  `zanr` varchar(50) NOT NULL,
  PRIMARY KEY (`sifra`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'The Truman Show',1998,'komedija'),(2,'Star Wars',1977,'naucna fantastika'),(3,'The Terminator',1984,'akcija'),(4,'Die Hard',1988,'akcija'),(5,'Inception',2010,'avanturisticki'),(7,'Central intelligance',2016,'komedija'),(8,'Ride Along',2010,'komedija'),(9,'The Upside',2017,'komedija');
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glumac`
--

DROP TABLE IF EXISTS `glumac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `glumac` (
  `idg` int NOT NULL AUTO_INCREMENT,
  `ime` varchar(30) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `godinaRodjenja` int NOT NULL,
  PRIMARY KEY (`idg`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glumac`
--

LOCK TABLES `glumac` WRITE;
/*!40000 ALTER TABLE `glumac` DISABLE KEYS */;
INSERT INTO `glumac` VALUES (1,'Bruce','Willis',1955),(2,'Jim','Carrey',1962),(3,'Mark','Hamil',1951),(4,'Michael','Biehn',1956),(5,'Leonardo','DiCaprion',1974),(10,'Kevin','Hart',1979);
/*!40000 ALTER TABLE `glumac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `glumi`
--

DROP TABLE IF EXISTS `glumi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `glumi` (
  `idg` int NOT NULL,
  `sifra` int NOT NULL,
  `uloga` varchar(50) NOT NULL,
  `honorar` decimal(10,3) NOT NULL,
  PRIMARY KEY (`idg`,`sifra`),
  KEY `FK_glumi2` (`sifra`),
  CONSTRAINT `FK_glumi` FOREIGN KEY (`idg`) REFERENCES `glumac` (`idg`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_glumi2` FOREIGN KEY (`sifra`) REFERENCES `film` (`sifra`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `glumi`
--

LOCK TABLES `glumi` WRITE;
/*!40000 ALTER TABLE `glumi` DISABLE KEYS */;
INSERT INTO `glumi` VALUES (1,4,'John McClane',126300.000),(2,1,'Truman Burbank',87560.000),(3,2,'Luke Skywalker',96000.000),(4,3,'Kyle Reese',66000.000),(5,5,'Cobb',187000.000),(10,7,'Calvin',170000.000),(10,8,'Ben',99000.000),(10,9,'Dell',243000.000);
/*!40000 ALTER TABLE `glumi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-17 18:52:10
