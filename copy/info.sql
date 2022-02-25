-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: smart_banking
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `cards`
--

DROP TABLE IF EXISTS `cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cards` (
  `id` int NOT NULL AUTO_INCREMENT,
  `master_card` int DEFAULT NULL,
  `visa_classic` int DEFAULT NULL,
  `credit_card` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_master_card_cards_idx` (`master_card`),
  KEY `fk_visa_classic_cards_idx` (`visa_classic`),
  KEY `fk_credit_card_cards_idx` (`credit_card`),
  CONSTRAINT `fk_credit_card_cards` FOREIGN KEY (`credit_card`) REFERENCES `credit_cards` (`id`),
  CONSTRAINT `fk_master_card_cards` FOREIGN KEY (`master_card`) REFERENCES `master_cards` (`id`),
  CONSTRAINT `fk_visa_classic_cards` FOREIGN KEY (`visa_classic`) REFERENCES `visa_classic` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cards`
--

LOCK TABLES `cards` WRITE;
/*!40000 ALTER TABLE `cards` DISABLE KEYS */;
INSERT INTO `cards` VALUES (2,2,2,2),(3,3,3,3),(4,4,4,4),(6,6,6,6);
/*!40000 ALTER TABLE `cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `credit_cards`
--

DROP TABLE IF EXISTS `credit_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credit_cards` (
  `id` int NOT NULL AUTO_INCREMENT,
  `balance` varchar(45) DEFAULT NULL,
  `payment_limit` varchar(45) DEFAULT NULL,
  `withdrawal_limit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credit_cards`
--

LOCK TABLES `credit_cards` WRITE;
/*!40000 ALTER TABLE `credit_cards` DISABLE KEYS */;
INSERT INTO `credit_cards` VALUES (2,'5000','200','300'),(3,'5000','200','300'),(4,'5000','200','300'),(6,'5000','200','300');
/*!40000 ALTER TABLE `credit_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `master_cards`
--

DROP TABLE IF EXISTS `master_cards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `master_cards` (
  `id` int NOT NULL AUTO_INCREMENT,
  `balance` varchar(45) DEFAULT NULL,
  `payment_limit` varchar(45) DEFAULT NULL,
  `withdrawal_limit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `master_cards`
--

LOCK TABLES `master_cards` WRITE;
/*!40000 ALTER TABLE `master_cards` DISABLE KEYS */;
INSERT INTO `master_cards` VALUES (2,'4500','150','200'),(3,'4500','100','150'),(4,'3500','100','400'),(6,'4500','100','150');
/*!40000 ALTER TABLE `master_cards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `first name` varchar(45) DEFAULT NULL,
  `last name` varchar(45) DEFAULT NULL,
  `id_cards` int DEFAULT NULL,
  `iban` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cards_users_idx` (`id_cards`),
  CONSTRAINT `fk_cards_users` FOREIGN KEY (`id_cards`) REFERENCES `cards` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'nesumico','2','ico','Пловдив','Hristo','Voinov',2,'BGN236766'),(3,'petur','3','petur@gmail.com','Варна','Petur','Ivanov',3,'BGN331864'),(4,'marto','4','marto@gmail.com','Пловдив','Martin','Todorov',4,'BGN632002'),(6,'ivan','0000','ivan@gmail.com','София','Ivan','Petrov',6,'BGN861961');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visa_classic`
--

DROP TABLE IF EXISTS `visa_classic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visa_classic` (
  `id` int NOT NULL AUTO_INCREMENT,
  `balance` varchar(45) DEFAULT NULL,
  `payment_limit` varchar(45) DEFAULT NULL,
  `withdrawal_limit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visa_classic`
--

LOCK TABLES `visa_classic` WRITE;
/*!40000 ALTER TABLE `visa_classic` DISABLE KEYS */;
INSERT INTO `visa_classic` VALUES (2,'2000','50','100'),(3,'2000','50','100'),(4,'2000','50','100'),(6,'2000','50','100');
/*!40000 ALTER TABLE `visa_classic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-16 10:02:21
