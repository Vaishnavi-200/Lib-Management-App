-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 11, 2023 at 12:32 PM
-- Server version: 10.5.20-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id19512314_library`
--

-- --------------------------------------------------------

--
-- Table structure for table `TABLE_BOOK`
--

CREATE TABLE `TABLE_BOOK` (
  `bookid` varchar(100) DEFAULT NULL,
  `bookname` varchar(100) DEFAULT NULL,
  `authorname` varchar(100) DEFAULT NULL,
  `sem` varchar(100) DEFAULT NULL,
  `dept` varchar(100) DEFAULT NULL,
  `publishyear` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `TABLE_BOOK`
--

INSERT INTO `TABLE_BOOK` (`bookid`, `bookname`, `authorname`, `sem`, `dept`, `publishyear`) VALUES
('122', 'os', 'jerry', '2', 'cse', '2001'),
('123', 'python', 'bheem', '3', 'cse', '2002'),
('123', 'python', 'bheem', '3', 'cse', '2002'),
('125', 'web', 'jagu', '5', 'cse', '2004'),
('126', 'c', 'chutki', '6', 'cse', '2005'),
('127', 'c++', 'kalia', '7', 'cse', '2006'),
('dg', 'dj', 'fj', 'dg', 'db', 'fn'),
('34', 'gds', 'dgj', '3', 'cse', '2001'),
('123', 'java', 'jjj', '4', 'cse', '2022'),
('123', 'web', 'raju', '7', 'cse', '2022'),
('123', 'java', 'vaishnavi', '4', 'cse', '2011'),
('123', 'java', 'vaishnavi', '4', 'cse', '2011');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
