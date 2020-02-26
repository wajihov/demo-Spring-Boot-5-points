-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 26 Février 2020 à 18:44
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `users_database`
--

-- --------------------------------------------------------

--
-- Structure de la table `employe`
--

CREATE TABLE IF NOT EXISTS `employe` (
  `id` bigint(20) NOT NULL,
  `email` varchar(80) DEFAULT NULL,
  `name` varchar(80) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employe`
--

INSERT INTO `employe` (`id`, `email`, `name`, `password`) VALUES
(4, 'wajihov@hotmail.fr', 'wajih', '1234'),
(6, 'hassen@hotmail.fr', 'hassen', '4321');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7),
(7),
(7);

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

CREATE TABLE IF NOT EXISTS `personne` (
  `id` bigint(20) NOT NULL,
  `email_address` varchar(80) DEFAULT NULL,
  `first_name` varchar(80) NOT NULL,
  `last_name` varchar(80) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

CREATE TABLE IF NOT EXISTS `post` (
  `id` bigint(20) NOT NULL,
  `content` varchar(80) DEFAULT NULL,
  `date_post` datetime DEFAULT NULL,
  `employe_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4o2u6e5s8yb5g2ood2qgvr40k` (`employe_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `post`
--

INSERT INTO `post` (`id`, `content`, `date_post`, `employe_id`) VALUES
(1, 'femme de menage', '2019-12-31 00:00:00', 6),
(2, 'developpeur Java', '2018-10-30 00:00:00', NULL),
(3, 'developpeur .Net', '2018-10-30 00:00:00', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `post_favorite_empl`
--

CREATE TABLE IF NOT EXISTS `post_favorite_empl` (
  `favorite_post_id` bigint(20) NOT NULL,
  `favorite_empl_id` bigint(20) NOT NULL,
  KEY `FKevvw2su2ktmqnvd5r3e09eiug` (`favorite_empl_id`),
  KEY `FK1mew14pirui1vloa8o1woqnpd` (`favorite_post_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `post_favorite_empl`
--

INSERT INTO `post_favorite_empl` (`favorite_post_id`, `favorite_empl_id`) VALUES
(1, 6),
(3, 6);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK4o2u6e5s8yb5g2ood2qgvr40k` FOREIGN KEY (`employe_id`) REFERENCES `employe` (`id`);

--
-- Contraintes pour la table `post_favorite_empl`
--
ALTER TABLE `post_favorite_empl`
  ADD CONSTRAINT `FK1mew14pirui1vloa8o1woqnpd` FOREIGN KEY (`favorite_post_id`) REFERENCES `post` (`id`),
  ADD CONSTRAINT `FKevvw2su2ktmqnvd5r3e09eiug` FOREIGN KEY (`favorite_empl_id`) REFERENCES `employe` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
