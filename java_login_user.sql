-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 10, 2018 at 06:17 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 5.6.36

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_login_user`
--
Create database java_login_user;
-- --------------------------------------------------------

--
-- Table structure for table `stu_data`
--

CREATE TABLE `stu_data` (
  `stu_id` varchar(20) NOT NULL,
  `stu_fname` varchar(50) DEFAULT NULL,
  `stu_lname` varchar(50) DEFAULT NULL,
  `stu_age` varchar(5) DEFAULT NULL,
  `stu_address` varchar(50) DEFAULT NULL,
  `stu_father_name` varchar(50) DEFAULT NULL,
  `stu_mother_name` varchar(50) DEFAULT NULL,
  `stu_phone` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stu_data`
--

INSERT INTO `stu_data` (`stu_id`, `stu_fname`, `stu_lname`, `stu_age`, `stu_address`, `stu_father_name`, `stu_mother_name`, `stu_phone`) VALUES
('173-35-257', 'Eshan', 'Rahman', '24', 'Jani na', 'Hello', 'Hello', '64654464655'),
('173-35-258', 'MD Shahed', 'Talukder', '21', 'East Adalotpara', 'MD Shah Alam Talukder', 'Gulshan Akter', '01762178238'),
('234551', 'aslkdf', 'laksdjfa', '3', 'asldkfj', 'alsdkjfas', 'alsdfja', '298347523');

-- --------------------------------------------------------

--
-- Table structure for table `the_app_user`
--

CREATE TABLE `the_app_user` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_uname` varchar(50) NOT NULL,
  `u_upass` varchar(20) NOT NULL,
  `u_bdate` varchar(10) NOT NULL,
  `u_address` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `the_app_user`
--

INSERT INTO `the_app_user` (`u_id`, `u_fname`, `u_lname`, `u_uname`, `u_upass`, `u_bdate`, `u_address`) VALUES
(8, 'shahed', 'talukder', 'shahed', '12345', '07/09/1997', 'Pochinki, Erangel, pubg'),
(9, 'shahed', 'shahed', 'shahed34', '12345', '1245124351', 'sdfgsdfg'),
(10, 'Shahed', 'Talukder', 'shahed5123', '12345', '07/09/1998', 'Khagan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `stu_data`
--
ALTER TABLE `stu_data`
  ADD PRIMARY KEY (`stu_id`);

--
-- Indexes for table `the_app_user`
--
ALTER TABLE `the_app_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `the_app_user`
--
ALTER TABLE `the_app_user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
