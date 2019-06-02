-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 01, 2019 lúc 03:38 PM
-- Phiên bản máy phục vụ: 10.1.34-MariaDB
-- Phiên bản PHP: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `student_manager_information`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `point_infor`
--
-- Error reading structure for table student_manager_information.point_infor: #1932 - Table 'student_manager_information.point_infor' doesn't exist in engine
-- Error reading data for table student_manager_information.point_infor: #1064 - You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FROM `student_manager_information`.`point_infor`' at line 1

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student_information`
--

CREATE TABLE `student_information` (
  `rollNumber` varchar(6) NOT NULL,
  `fullName` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL,
  `iDCardNumber` varchar(9) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `gender` int(11) NOT NULL DEFAULT '2',
  `email` varchar(30) NOT NULL,
  `status` int(1) DEFAULT NULL,
  `mediumScore` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `student_information`
--

INSERT INTO `student_information` (`rollNumber`, `fullName`, `dob`, `address`, `iDCardNumber`, `phoneNumber`, `gender`, `email`, `status`, `mediumScore`) VALUES
('D00123', 'Luu cung Tuan', '2019-05-10', 'Hung yen', '5656565', '987564222', 0, 'tuan@gmail.com', 0, 0),
('D00597', 'le van vien', '2019-05-01', 'Ninh binh', '164623374', '0962675735', 0, 'vien@gmail.com', 1, 0),
('D00598', 'Doan thi nhung', '2019-05-09', 'Nam dinh', '0123456', '0123456', 1, 'nhungdoan@gmail.com', 2, 0),
('D00623', 'VietNam', '2019-06-14', 'nb', '0000', '00000', 1, 'levien0914@gmail.com', 1, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subject`
--

CREATE TABLE `subject` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `status` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `subject`
--

INSERT INTO `subject` (`id`, `name`, `status`) VALUES
('T002', 'C#', 0),
('T001', 'Java', 0),
('1', 'sql', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(300) NOT NULL,
  `salt` varchar(255) NOT NULL,
  `rollNumber` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`username`, `password`, `salt`, `rollNumber`) VALUES
('VienLe', '1', '', 'D00597');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `student_information`
--
ALTER TABLE `student_information`
  ADD UNIQUE KEY `rollnumber` (`rollNumber`),
  ADD UNIQUE KEY `ID_Card` (`iDCardNumber`),
  ADD UNIQUE KEY `phone_number` (`phoneNumber`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Chỉ mục cho bảng `subject`
--
ALTER TABLE `subject`
  ADD UNIQUE KEY `name_subject` (`name`),
  ADD UNIQUE KEY `Id_Subject` (`id`) USING BTREE;

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `rollnumber` (`rollNumber`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
