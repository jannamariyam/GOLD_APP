-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 10, 2022 at 07:16 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `goldf`
--

-- --------------------------------------------------------

--
-- Table structure for table `accountdb`
--

CREATE TABLE `accountdb` (
  `slno` int(11) NOT NULL,
  `acc_no` varchar(25) NOT NULL,
  `bank` varchar(50) NOT NULL,
  `ifsc` varchar(10) NOT NULL,
  `accname` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accountdb`
--

INSERT INTO `accountdb` (`slno`, `acc_no`, `bank`, `ifsc`, `accname`) VALUES
(2, '456789098', 'South Indian Bank', '123bgsd34', 'Aplusgoldin');

-- --------------------------------------------------------

--
-- Table structure for table `auth_group`
--

CREATE TABLE `auth_group` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `auth_group_permissions`
--

CREATE TABLE `auth_group_permissions` (
  `id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `auth_permission`
--

CREATE TABLE `auth_permission` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `content_type_id` int(11) NOT NULL,
  `codename` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `auth_permission`
--

INSERT INTO `auth_permission` (`id`, `name`, `content_type_id`, `codename`) VALUES
(1, 'Can add log entry', 1, 'add_logentry'),
(2, 'Can change log entry', 1, 'change_logentry'),
(3, 'Can delete log entry', 1, 'delete_logentry'),
(4, 'Can view log entry', 1, 'view_logentry'),
(5, 'Can add permission', 2, 'add_permission'),
(6, 'Can change permission', 2, 'change_permission'),
(7, 'Can delete permission', 2, 'delete_permission'),
(8, 'Can view permission', 2, 'view_permission'),
(9, 'Can add group', 3, 'add_group'),
(10, 'Can change group', 3, 'change_group'),
(11, 'Can delete group', 3, 'delete_group'),
(12, 'Can view group', 3, 'view_group'),
(13, 'Can add user', 4, 'add_user'),
(14, 'Can change user', 4, 'change_user'),
(15, 'Can delete user', 4, 'delete_user'),
(16, 'Can view user', 4, 'view_user'),
(17, 'Can add content type', 5, 'add_contenttype'),
(18, 'Can change content type', 5, 'change_contenttype'),
(19, 'Can delete content type', 5, 'delete_contenttype'),
(20, 'Can view content type', 5, 'view_contenttype'),
(21, 'Can add session', 6, 'add_session'),
(22, 'Can change session', 6, 'change_session'),
(23, 'Can delete session', 6, 'delete_session'),
(24, 'Can view session', 6, 'view_session');

-- --------------------------------------------------------

--
-- Table structure for table `auth_user`
--

CREATE TABLE `auth_user` (
  `id` int(11) NOT NULL,
  `password` varchar(128) NOT NULL,
  `last_login` datetime(6) DEFAULT NULL,
  `is_superuser` tinyint(1) NOT NULL,
  `username` varchar(150) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(150) NOT NULL,
  `email` varchar(254) NOT NULL,
  `is_staff` tinyint(1) NOT NULL,
  `is_active` tinyint(1) NOT NULL,
  `date_joined` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `auth_user_groups`
--

CREATE TABLE `auth_user_groups` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `auth_user_user_permissions`
--

CREATE TABLE `auth_user_user_permissions` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cusid` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `email` varchar(25) NOT NULL,
  `dob` date NOT NULL,
  `nominee` varchar(25) NOT NULL,
  `nph` varchar(15) NOT NULL,
  `address` varchar(100) NOT NULL,
  `pin` varchar(8) NOT NULL,
  `dist` varchar(25) NOT NULL,
  `acc` varchar(25) NOT NULL,
  `jdate` date NOT NULL,
  `lid` int(11) NOT NULL,
  `aadr` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cusid`, `name`, `phone`, `email`, `dob`, `nominee`, `nph`, `address`, `pin`, `dist`, `acc`, `jdate`, `lid`, `aadr`) VALUES
(1, 'aa', 'aa', 'aa', '2000-01-01', 'aas', 'sss', '', 'eed', 'xx', 'ssd', '2021-01-01', 4, 'xxx'),
(2, 'dd', '4566', 'd', '2020-09-02', 'sds', '23445', '', '67009', 'xcvcx', 'dsd45', '2020-09-08', 9, '7727727'),
(3, 'dd', '4566', 'd', '2020-09-02', 'sds', '23445', '', '67009', 'xcvcx', 'dsd45', '2020-09-08', 10, '7727727'),
(4, 'dfd', '9089786789', 'a@gmail.com', '2020-09-08', 'bgbh', '8907895670', '', '45654', 'ghgg', 'gfhf676', '2020-09-08', 11, '6546'),
(5, 'dfd', '9089786789', 'a@gmail.com', '2020-09-08', 'bgbh', '8907895670', '', '45654', 'ghgg', 'gfhf676', '2020-09-08', 12, '6546'),
(6, 'nn', '9089098789', 'm@gmail.com', '2020-09-09', 'dfdf', '4556789067', '', '673003', 'fgf', 'fdg45', '2020-09-09', 13, '545'),
(7, 'nm', '9090890789', 'nm@gmail.com', '1900-01-19', 'nn', '9098890909', '', '674990', 'hfgg', 'urruf44', '2022-02-02', 21, '78900'),
(8, 'nm', '9090890789', 'nm@gmail.com', '1900-01-19', 'nn', '9098890909', '', '674990', 'hfgg', 'urruf44', '2022-02-02', 22, '78900'),
(9, 'jan', '1234567891', 'janna1@gmail.com', '1997-12-15', 'sab', '2365123456', '', '234123', 'sd', '1234rew', '2022-02-09', 23, '123446788'),
(10, 'noofa', '6789234578', 'noofa@gmail.com', '1998-02-16', 'anu', '6789456723', '', '567567', 'clct', '5465787yui', '2022-02-10', 24, '89876567'),
(11, 'reem', '9087654321', 'reem@gmail.com', '2000-01-17', 'rinsha', '5674562345', '', '343465', 'mlprm', '3456778334', '2022-02-10', 25, '345567');

-- --------------------------------------------------------

--
-- Table structure for table `django_admin_log`
--

CREATE TABLE `django_admin_log` (
  `id` int(11) NOT NULL,
  `action_time` datetime(6) NOT NULL,
  `object_id` longtext DEFAULT NULL,
  `object_repr` varchar(200) NOT NULL,
  `action_flag` smallint(5) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `django_content_type`
--

CREATE TABLE `django_content_type` (
  `id` int(11) NOT NULL,
  `app_label` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_content_type`
--

INSERT INTO `django_content_type` (`id`, `app_label`, `model`) VALUES
(1, 'admin', 'logentry'),
(3, 'auth', 'group'),
(2, 'auth', 'permission'),
(4, 'auth', 'user'),
(5, 'contenttypes', 'contenttype'),
(6, 'sessions', 'session');

-- --------------------------------------------------------

--
-- Table structure for table `django_migrations`
--

CREATE TABLE `django_migrations` (
  `id` int(11) NOT NULL,
  `app` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `applied` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `django_migrations`
--

INSERT INTO `django_migrations` (`id`, `app`, `name`, `applied`) VALUES
(1, 'contenttypes', '0001_initial', '2022-01-05 22:04:31.174412'),
(2, 'auth', '0001_initial', '2022-01-05 22:04:42.758162'),
(3, 'admin', '0001_initial', '2022-01-05 22:04:58.959205'),
(4, 'admin', '0002_logentry_remove_auto_add', '2022-01-05 22:05:07.236623'),
(5, 'admin', '0003_logentry_add_action_flag_choices', '2022-01-05 22:05:07.518060'),
(6, 'contenttypes', '0002_remove_content_type_name', '2022-01-05 22:05:09.507487'),
(7, 'auth', '0002_alter_permission_name_max_length', '2022-01-05 22:05:09.828038'),
(8, 'auth', '0003_alter_user_email_max_length', '2022-01-05 22:05:10.183793'),
(9, 'auth', '0004_alter_user_username_opts', '2022-01-05 22:05:10.273573'),
(10, 'auth', '0005_alter_user_last_login_null', '2022-01-05 22:05:11.872816'),
(11, 'auth', '0006_require_contenttypes_0002', '2022-01-05 22:05:11.935983'),
(12, 'auth', '0007_alter_validators_add_error_messages', '2022-01-05 22:05:12.018902'),
(13, 'auth', '0008_alter_user_username_max_length', '2022-01-05 22:05:12.417706'),
(14, 'auth', '0009_alter_user_last_name_max_length', '2022-01-05 22:05:13.048996'),
(15, 'auth', '0010_alter_group_name_max_length', '2022-01-05 22:05:13.552500'),
(16, 'auth', '0011_update_proxy_permissions', '2022-01-05 22:05:13.688922'),
(17, 'sessions', '0001_initial', '2022-01-05 22:05:16.606305');

-- --------------------------------------------------------

--
-- Table structure for table `django_session`
--

CREATE TABLE `django_session` (
  `session_key` varchar(40) NOT NULL,
  `session_data` longtext NOT NULL,
  `expire_date` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fixed`
--

CREATE TABLE `fixed` (
  `slno` int(11) NOT NULL,
  `price1` int(5) NOT NULL,
  `price2` int(5) NOT NULL,
  `price3` int(5) NOT NULL,
  `price4` int(5) NOT NULL,
  `price5` int(5) NOT NULL,
  `price6` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fixed`
--

INSERT INTO `fixed` (`slno`, `price1`, `price2`, `price3`, `price4`, `price5`, `price6`) VALUES
(1, 100, 200, 500, 1000, 5000, 10000);

-- --------------------------------------------------------

--
-- Table structure for table `gold_status`
--

CREATE TABLE `gold_status` (
  `g_id` int(11) NOT NULL,
  `image` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `gold_status`
--

INSERT INTO `gold_status` (`g_id`, `image`) VALUES
(1, 'back.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `uid` int(11) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  `utype` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`uid`, `uname`, `pwd`, `utype`) VALUES
(1, 'admin', 'admin', 'admin'),
(2, 'cdd', 'asss', 'customer'),
(3, 'cdd', 'asss', 'customer'),
(4, 'c', 'c', 'customer'),
(5, 'u', 'u', 'customer'),
(10, 'u', 'u', 'customer'),
(11, 'w', 'w', 'customer'),
(12, 'w', 'w', 'customer'),
(13, 'aa', 'aa', 'customer'),
(14, 'jan22', '22', 'customer'),
(15, 'jan22', '22', 'customer'),
(16, 'jan22', '22', 'customer'),
(17, 'jan22', '22', 'customer'),
(18, 'n', 'n', 'customer'),
(19, 'n', 'n', 'customer'),
(20, 'm', 'm', 'customer'),
(21, 'u', 'u', 'customer'),
(22, 'u', 'u', 'customer'),
(23, 'jansab', '123', 'customer'),
(24, 'noofa4', '44', 'customer'),
(25, 'reem3', '34', 'customer');

-- --------------------------------------------------------

--
-- Table structure for table `package`
--

CREATE TABLE `package` (
  `p_id` int(11) NOT NULL,
  `scheme_id` int(11) NOT NULL,
  `type` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `package`
--

INSERT INTO `package` (`p_id`, `scheme_id`, `type`) VALUES
(1, 1, 'bbb');

-- --------------------------------------------------------

--
-- Table structure for table `penalty`
--

CREATE TABLE `penalty` (
  `pn_id` int(11) NOT NULL,
  `package` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  `penalty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `penalty`
--

INSERT INTO `penalty` (`pn_id`, `package`, `type`, `penalty`) VALUES
(1, 'jd', 'jdj', 4),
(2, 'jd', 'fixed', 2),
(3, 'jd', 'fixed', 4),
(4, 'jd', 'variable', 2),
(5, 'jd', 'dsad', 2),
(6, 'reg', 'grg', 4),
(7, 'jd', 'fixed', 4),
(8, '100', 'fixed', 4),
(9, '100-200', 'variable', 4);

-- --------------------------------------------------------

--
-- Table structure for table `price_fixed`
--

CREATE TABLE `price_fixed` (
  `fixed_id` int(11) NOT NULL,
  `pamount` int(11) NOT NULL,
  `gamount` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `price_fixed`
--

INSERT INTO `price_fixed` (`fixed_id`, `pamount`, `gamount`) VALUES
(1, 35920, 4490);

-- --------------------------------------------------------

--
-- Table structure for table `reward`
--

CREATE TABLE `reward` (
  `rduration` varchar(25) NOT NULL,
  `rper` varchar(11) NOT NULL,
  `type` varchar(11) NOT NULL,
  `plan` varchar(15) NOT NULL,
  `rwid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reward`
--

INSERT INTO `reward` (`rduration`, `rper`, `type`, `plan`, `rwid`) VALUES
('12', '50', 'Fixed', '100', 6),
('12', '50', 'Fixed', '200', 7),
('12', '50', 'Fixed', '500', 8),
('12', '50', 'Fixed', '1000', 9),
('12', '70', 'Fixed', '5000', 12),
('12', '70', 'Fixed', '10000', 14);

-- --------------------------------------------------------

--
-- Table structure for table `scheme`
--

CREATE TABLE `scheme` (
  `scheme_id` int(11) NOT NULL,
  `scheme_name` varchar(50) NOT NULL,
  `duration` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `scheme`
--

INSERT INTO `scheme` (`scheme_id`, `scheme_name`, `duration`) VALUES
(1, 'abc', 'duration1');

-- --------------------------------------------------------

--
-- Table structure for table `variable`
--

CREATE TABLE `variable` (
  `slno` int(11) NOT NULL,
  `price1` varchar(25) NOT NULL,
  `price2` varchar(25) NOT NULL,
  `price3` varchar(25) NOT NULL,
  `price4` varchar(25) NOT NULL,
  `price5` varchar(25) NOT NULL,
  `price6` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `variable`
--

INSERT INTO `variable` (`slno`, `price1`, `price2`, `price3`, `price4`, `price5`, `price6`) VALUES
(1, '100-200', '200-500', '500-1000', '1000-2000', '2000-5000', '2000-10000');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accountdb`
--
ALTER TABLE `accountdb`
  ADD PRIMARY KEY (`slno`);

--
-- Indexes for table `auth_group`
--
ALTER TABLE `auth_group`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_group_permissions_group_id_permission_id_0cd325b0_uniq` (`group_id`,`permission_id`),
  ADD KEY `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` (`permission_id`);

--
-- Indexes for table `auth_permission`
--
ALTER TABLE `auth_permission`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_permission_content_type_id_codename_01ab375a_uniq` (`content_type_id`,`codename`);

--
-- Indexes for table `auth_user`
--
ALTER TABLE `auth_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_user_groups_user_id_group_id_94350c0c_uniq` (`user_id`,`group_id`),
  ADD KEY `auth_user_groups_group_id_97559544_fk_auth_group_id` (`group_id`);

--
-- Indexes for table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `auth_user_user_permissions_user_id_permission_id_14a6b632_uniq` (`user_id`,`permission_id`),
  ADD KEY `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` (`permission_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cusid`);

--
-- Indexes for table `django_content_type`
--
ALTER TABLE `django_content_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `django_content_type_app_label_model_76bd3d3b_uniq` (`app_label`,`model`);

--
-- Indexes for table `django_migrations`
--
ALTER TABLE `django_migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `django_session`
--
ALTER TABLE `django_session`
  ADD PRIMARY KEY (`session_key`),
  ADD KEY `django_session_expire_date_a5c62663` (`expire_date`);

--
-- Indexes for table `fixed`
--
ALTER TABLE `fixed`
  ADD PRIMARY KEY (`slno`);

--
-- Indexes for table `gold_status`
--
ALTER TABLE `gold_status`
  ADD PRIMARY KEY (`g_id`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `package`
--
ALTER TABLE `package`
  ADD PRIMARY KEY (`p_id`);

--
-- Indexes for table `penalty`
--
ALTER TABLE `penalty`
  ADD PRIMARY KEY (`pn_id`);

--
-- Indexes for table `price_fixed`
--
ALTER TABLE `price_fixed`
  ADD PRIMARY KEY (`fixed_id`);

--
-- Indexes for table `reward`
--
ALTER TABLE `reward`
  ADD PRIMARY KEY (`rwid`);

--
-- Indexes for table `scheme`
--
ALTER TABLE `scheme`
  ADD PRIMARY KEY (`scheme_id`);

--
-- Indexes for table `variable`
--
ALTER TABLE `variable`
  ADD PRIMARY KEY (`slno`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accountdb`
--
ALTER TABLE `accountdb`
  MODIFY `slno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `auth_group`
--
ALTER TABLE `auth_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `auth_permission`
--
ALTER TABLE `auth_permission`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `auth_user`
--
ALTER TABLE `auth_user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cusid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `django_content_type`
--
ALTER TABLE `django_content_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `django_migrations`
--
ALTER TABLE `django_migrations`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `fixed`
--
ALTER TABLE `fixed`
  MODIFY `slno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `gold_status`
--
ALTER TABLE `gold_status`
  MODIFY `g_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `package`
--
ALTER TABLE `package`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `penalty`
--
ALTER TABLE `penalty`
  MODIFY `pn_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `price_fixed`
--
ALTER TABLE `price_fixed`
  MODIFY `fixed_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `reward`
--
ALTER TABLE `reward`
  MODIFY `rwid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `scheme`
--
ALTER TABLE `scheme`
  MODIFY `scheme_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `variable`
--
ALTER TABLE `variable`
  MODIFY `slno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `auth_group_permissions`
--
ALTER TABLE `auth_group_permissions`
  ADD CONSTRAINT `auth_group_permissio_permission_id_84c5c92e_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  ADD CONSTRAINT `auth_group_permissions_group_id_b120cbf9_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`);

--
-- Constraints for table `auth_permission`
--
ALTER TABLE `auth_permission`
  ADD CONSTRAINT `auth_permission_content_type_id_2f476e4b_fk_django_co` FOREIGN KEY (`content_type_id`) REFERENCES `django_content_type` (`id`);

--
-- Constraints for table `auth_user_groups`
--
ALTER TABLE `auth_user_groups`
  ADD CONSTRAINT `auth_user_groups_group_id_97559544_fk_auth_group_id` FOREIGN KEY (`group_id`) REFERENCES `auth_group` (`id`),
  ADD CONSTRAINT `auth_user_groups_user_id_6a12ed8b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`);

--
-- Constraints for table `auth_user_user_permissions`
--
ALTER TABLE `auth_user_user_permissions`
  ADD CONSTRAINT `auth_user_user_permi_permission_id_1fbb5f2c_fk_auth_perm` FOREIGN KEY (`permission_id`) REFERENCES `auth_permission` (`id`),
  ADD CONSTRAINT `auth_user_user_permissions_user_id_a95ead1b_fk_auth_user_id` FOREIGN KEY (`user_id`) REFERENCES `auth_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
