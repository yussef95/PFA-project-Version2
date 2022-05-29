-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : dim. 29 mai 2022 à 02:11
-- Version du serveur : 10.4.20-MariaDB
-- Version de PHP : 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `testo`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom_utilisateur` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id`, `email`, `nom_utilisateur`, `password`) VALUES
(5, 'admin@gmail.com', 'admin', '$2a$10$CrYIo2gm9XDtwUbm8AJate4sEi47g45cjjTjwf/NOkZB9W5Yd1q/y');

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `description` text DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `id_publication` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `concours`
--

CREATE TABLE `concours` (
  `description` text DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `id_publication` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `concours`
--

INSERT INTO `concours` (`description`, `titre`, `id_publication`) VALUES
('plus de details !', 'Concours de onee 2022', 12);

-- --------------------------------------------------------

--
-- Structure de la table `conseiller`
--

CREATE TABLE `conseiller` (
  `email` varchar(255) DEFAULT NULL,
  `isaprouv` bit(1) NOT NULL,
  `nom_complet` varchar(255) DEFAULT NULL,
  `nom_utilisateur` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_etablissement` int(11) DEFAULT NULL,
  `id_secteur_orientation` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `conseiller`
--

INSERT INTO `conseiller` (`email`, `isaprouv`, `nom_complet`, `nom_utilisateur`, `password`, `id_utilisateur`, `id_etablissement`, `id_secteur_orientation`) VALUES
('conseiller1@gmail.com', b'1', 'cn1', 'conseiller1', '1234conseiller1', 14, 2, 5);

-- --------------------------------------------------------

--
-- Structure de la table `etablissement`
--

CREATE TABLE `etablissement` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etablissement`
--

INSERT INTO `etablissement` (`id`, `libelle`) VALUES
(1, 'ziri'),
(2, 'abdelmoumen'),
(3, 'med6');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `email` varchar(255) DEFAULT NULL,
  `nom_complet` varchar(255) DEFAULT NULL,
  `nom_utilisateur` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_etablissement` int(11) DEFAULT NULL,
  `id_niveau_scolaire` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`email`, `nom_complet`, `nom_utilisateur`, `password`, `id_utilisateur`, `id_etablissement`, `id_niveau_scolaire`) VALUES
('etudiant3@gmail.com', 'youssef oufkir', 'oufyou', '81dc9bdb52d04dc20036dbd8313ed055', 12, 2, 3),
('Etudiant3@gmail.com', 'salhi yassen', 'Etudiant3', '$2a$10$UpvBzx54yopKbh6DPR1g6OJ4tVv85CElZ9UGme0D6CP/5Z8UM.w0e', 16, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

CREATE TABLE `evenement` (
  `description` text DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `id_publication` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `evenement`
--

INSERT INTO `evenement` (`description`, `titre`, `id_publication`) VALUES
('plus de details sur ce sujet!', 'orientation universitaire!', 11),
('hahahaha', 'hhhhhhhhhhh', 13),
('plus de details.....', 'orientation', 14),
('plus detail', 'hhhhhhhhhhh', 15),
('plus de details.....', 'orientation', 16),
('plus de details.....', 'orientation', 17);

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Structure de la table `message`
--

CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `id_conseiller` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `message`
--

INSERT INTO `message` (`id`, `description`, `email`, `objet`, `id_conseiller`) VALUES
(9, 'plus', 'soufkir489@gmail.com', 'orientation', 14),
(10, 'plus', 'oufkiryussef12@gmail.com', 'concours', 13),
(11, 'comment faire une bonne orientation ?', 'etudiant3@gmail.com', 'apres bac ', 13),
(12, 'quel est les meilleurs branches', 'oufkir@gmail.com', 'les brenches', 13);

-- --------------------------------------------------------

--
-- Structure de la table `niveau_scolaire`
--

CREATE TABLE `niveau_scolaire` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `niveau_scolaire`
--

INSERT INTO `niveau_scolaire` (`id`, `libelle`) VALUES
(1, '1ére année collège'),
(2, '2éme année collège'),
(3, '3éme année collège');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `email` varchar(255) DEFAULT NULL,
  `isaprouv` bit(1) NOT NULL,
  `nom_complet` varchar(255) DEFAULT NULL,
  `nom_utilisateur` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `id_utilisateur` int(11) NOT NULL,
  `id_etablissement` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `publication`
--

CREATE TABLE `publication` (
  `id` int(11) NOT NULL,
  `id_conseiller` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `publication`
--

INSERT INTO `publication` (`id`, `id_conseiller`) VALUES
(11, 14),
(12, NULL),
(13, NULL),
(14, NULL),
(15, NULL),
(16, NULL),
(17, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `secteur_orientation`
--

CREATE TABLE `secteur_orientation` (
  `id` int(11) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `secteur_orientation`
--

INSERT INTO `secteur_orientation` (`id`, `libelle`) VALUES
(1, 'science'),
(2, 'lettre'),
(3, 'technique'),
(4, 'economique'),
(5, 'science');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`) VALUES
(14),
(15),
(16);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id_publication`);

--
-- Index pour la table `concours`
--
ALTER TABLE `concours`
  ADD PRIMARY KEY (`id_publication`);

--
-- Index pour la table `conseiller`
--
ALTER TABLE `conseiller`
  ADD PRIMARY KEY (`id_utilisateur`),
  ADD KEY `FKlkxk54o2r60pb3k1qecnnm59i` (`id_etablissement`),
  ADD KEY `FKsbduylk9yu36f99vkbwj9279h` (`id_secteur_orientation`);

--
-- Index pour la table `etablissement`
--
ALTER TABLE `etablissement`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id_utilisateur`),
  ADD KEY `FK5obg6wprjjkl6k23eyyoobafu` (`id_etablissement`),
  ADD KEY `FK31lqrgh3go6xx06ihfeg5jm5q` (`id_niveau_scolaire`);

--
-- Index pour la table `evenement`
--
ALTER TABLE `evenement`
  ADD PRIMARY KEY (`id_publication`);

--
-- Index pour la table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4p69028q8d9ksmqcs9ichi8bm` (`id_conseiller`);

--
-- Index pour la table `niveau_scolaire`
--
ALTER TABLE `niveau_scolaire`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`id_utilisateur`),
  ADD KEY `FKn7dm0hjxp3f3m82s4dn9g7snx` (`id_etablissement`);

--
-- Index pour la table `publication`
--
ALTER TABLE `publication`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKehfkp1gkpwbcac4fkxs5rqs0y` (`id_conseiller`);

--
-- Index pour la table `secteur_orientation`
--
ALTER TABLE `secteur_orientation`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `etablissement`
--
ALTER TABLE `etablissement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `message`
--
ALTER TABLE `message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `niveau_scolaire`
--
ALTER TABLE `niveau_scolaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `publication`
--
ALTER TABLE `publication`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `secteur_orientation`
--
ALTER TABLE `secteur_orientation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
