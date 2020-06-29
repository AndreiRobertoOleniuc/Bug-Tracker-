-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 29. Jun 2020 um 17:32
-- Server-Version: 10.4.8-MariaDB
-- PHP-Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `bugtracker`
--
drop DATABASE if EXISTS bugtracker;
create DATABASE bugtracker;
use bugtracker;
-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bugs`
--

CREATE TABLE `bugs` (
  `idBug` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` enum('Open','In Processing','Fixed') NOT NULL,
  `datum` date NOT NULL,
  `programmingL` enum('java','python','javascript','html','css','c#') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `bugs`
--

INSERT INTO `bugs` (`idBug`, `name`, `status`, `datum`, `programmingL`) VALUES
(1, 'HaLog Fix', 'Open', '2020-06-01', 'python'),
(2, 'Download Sorter', 'Open', '2020-06-02', 'python'),
(3, 'Bug Tracker', 'In Processing', '2020-06-19', 'java');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `idUser` int(11) NOT NULL,
  `prename` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`idUser`, `prename`, `surname`, `email`, `password`) VALUES
(1, 'Andrei', 'Oleniuc', 'andrei@gmail.com', '1234'),
(2, 'Tim', 'Scholl', 'tim@gmail.com', '1234'),
(3, 'Shenia', 'Scherer', 'shenia@gmail.com', '1234');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `verwaltung`
--

CREATE TABLE `verwaltung` (
  `idVerwaltung` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `idBug` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `verwaltung`
--

INSERT INTO `verwaltung` (`idVerwaltung`, `idUser`, `idBug`) VALUES
(1, 1, 3),
(2, 3, 2),
(3, 2, 1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bugs`
--
ALTER TABLE `bugs`
  ADD PRIMARY KEY (`idBug`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`idUser`);

--
-- Indizes für die Tabelle `verwaltung`
--
ALTER TABLE `verwaltung`
  ADD PRIMARY KEY (`idVerwaltung`),
  ADD KEY `fk_Verwaltung_user` (`idUser`),
  ADD KEY `fk_Verwaltung_bugs1` (`idBug`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bugs`
--
ALTER TABLE `bugs`
  MODIFY `idBug` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `verwaltung`
--
ALTER TABLE `verwaltung`
  MODIFY `idVerwaltung` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `verwaltung`
--
ALTER TABLE `verwaltung`
  ADD CONSTRAINT `fk_Verwaltung_bugs1` FOREIGN KEY (`idBug`) REFERENCES `bugs` (`idBug`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Verwaltung_user` FOREIGN KEY (`idUser`) REFERENCES `user` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
