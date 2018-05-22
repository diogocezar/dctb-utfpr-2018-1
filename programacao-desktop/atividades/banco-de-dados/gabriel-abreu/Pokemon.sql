-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 22/05/2018 às 03:39
-- Versão do servidor: 10.1.32-MariaDB
-- Versão do PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `Pokemon`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Pokemon`
--

CREATE TABLE `Pokemon` (
  `name` varchar(40) COLLATE utf8_bin NOT NULL,
  `level` int(11) NOT NULL,
  `hp` int(11) NOT NULL,
  `agility` int(11) NOT NULL,
  `attack` int(11) NOT NULL,
  `defense` int(11) NOT NULL,
  `specialAttack` int(11) NOT NULL,
  `specialDefense` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Fazendo dump de dados para tabela `Pokemon`
--

INSERT INTO `Pokemon` (`name`, `level`, `hp`, `agility`, `attack`, `defense`, `specialAttack`, `specialDefense`) VALUES
('Blastoise', 3, 2, 3, 4, 5, 67, 7),
('Charizard', 20, 1000, 20, 30, 75, 54, 87),
('Gyardos', 30, 20, 30, 40, 50, 60, 70),
('Pikachu2', 3, 2, 3, 4, 5, 6, 7),
('Psyduck', 10, 20, 78, 45, 56, 23, 20),
('Togepi', 3, 2, 3, 4, 5, 6, 7);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `Pokemon`
--
ALTER TABLE `Pokemon`
  ADD PRIMARY KEY (`name`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
