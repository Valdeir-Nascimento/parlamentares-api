-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: camara_api
-- ------------------------------------------------------
-- Server version	5.6.34-log

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
-- Table structure for table `despesa`
--

DROP TABLE IF EXISTS `despesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `despesa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_despesa` datetime(6) NOT NULL,
  `tipo_despesa` varchar(255) NOT NULL,
  `tipo_documento` varchar(255) NOT NULL,
  `valor_liquido` double NOT NULL,
  `parlamentar_id` bigint(20) NOT NULL,
  `mes` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjpxy2sdp7gfnb37gkact7xsnc` (`parlamentar_id`),
  CONSTRAINT `FKjpxy2sdp7gfnb37gkact7xsnc` FOREIGN KEY (`parlamentar_id`) REFERENCES `parlamentar` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `despesa`
--

LOCK TABLES `despesa` WRITE;
/*!40000 ALTER TABLE `despesa` DISABLE KEYS */;
INSERT INTO `despesa` VALUES (1,'2020-11-11 00:00:00.000000','MANUTENÇÃO DE ESCRITÓRIO DE APOIO À ATIVIDADE PARLAMENTAR','Nota Fiscal',42.66,1,'NOVEMBRO'),(2,'2020-12-11 00:00:00.000000','MANUTENÇÃO DE ESCRITÓRIO DE APOIO À ATIVIDADE PARLAMENTAR','Nota Fiscal',76.66,1,'DEZEMBRO'),(3,'2020-08-11 00:00:00.000000','MANUTENÇÃO DE ESCRITÓRIO DE APOIO À ATIVIDADE PARLAMENTAR','Nota Fiscal',560,1,'AGOSTO'),(4,'2020-11-16 00:00:00.000000','COMBUSTÍVEIS E LUBRIFICANTES','Nota Fiscal',100,2,'NOVEMBRO'),(5,'2020-12-01 00:00:00.000000','MANUTENÇÃO DE ESCRITÓRIO DE APOIO À ATIVIDADE PARLAMENTAR','Nota Fiscal',179.8,2,'DEZEMBRO'),(6,'2020-10-05 00:00:00.000000','COMBUSTÍVEIS E LUBRIFICANTES','Nota Fiscal',100,2,'OUTUBRO');
/*!40000 ALTER TABLE `despesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parlamentar`
--

DROP TABLE IF EXISTS `parlamentar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parlamentar` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_nascimento` datetime(6) NOT NULL,
  `foto` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `partido` varchar(255) NOT NULL,
  `sexo` varchar(255) NOT NULL,
  `uf` varchar(255) NOT NULL,
  `visualizacoes` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parlamentar`
--

LOCK TABLES `parlamentar` WRITE;
/*!40000 ALTER TABLE `parlamentar` DISABLE KEYS */;
INSERT INTO `parlamentar` VALUES (1,'1980-10-15 00:00:00.000000','https://www.camara.leg.br/internet/deputado/bandep/204554.jpg','Abílio Santana','PL','M','BA',1),(2,'1970-02-19 00:00:00.000000','https://www.camara.leg.br/internet/deputado/bandep/204521.jpg','Abou Anni','PSL','M','SP',1),(3,'1975-05-23 00:00:00.000000','https://www.camara.leg.br/internet/deputado/bandep/204379.jpg','Acácio Favacho','PROS','M','SP',1),(4,'1979-09-10 00:00:00.000000','https://www.camara.leg.br/internet/deputado/bandep/204379.jpg','Eder Mauro','PROS','M','SP',1),(5,'1985-06-17 00:00:00.000000','https://www.camara.leg.br/internet/deputado/bandep/204379.jpg','Coronel Neil','PROS','M','SP',1),(6,'1970-07-20 00:00:00.000000','https://www.camara.leg.br/internet/deputado/bandep/204379.jpg','Zequinha Marinho','PROS','M','SP',1),(7,'1972-08-11 00:00:00.000000','https://www.camara.leg.br/internet/deputado/bandep/204379.jpg','Abdon Neves','PROS','M','SP',1);
/*!40000 ALTER TABLE `parlamentar` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-02 23:46:39
