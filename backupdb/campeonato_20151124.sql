SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE TABLE IF NOT EXISTS `Campeonato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

INSERT INTO `Campeonato` (`id`, `descricao`) VALUES
(2, 'Quarta Show');

CREATE TABLE IF NOT EXISTS `Classificacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `colocacao` int(11) NOT NULL,
  `derrotas` int(11) NOT NULL,
  `empates` int(11) NOT NULL,
  `golsContra` int(11) NOT NULL,
  `golsPro` int(11) NOT NULL,
  `jogos` int(11) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `pontos` int(11) NOT NULL,
  `vitorias` int(11) NOT NULL,
  `grupo_id` bigint(20) DEFAULT NULL,
  `time_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_oprsb9dvyrpq4djmri9oaawkg` (`grupo_id`),
  KEY `FK_aa5bd817lf0xk7qlqd58cmxgh` (`time_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;


INSERT INTO `Classificacao` (`id`, `colocacao`, `derrotas`, `empates`, `golsContra`, `golsPro`, `jogos`, `observacao`, `pontos`, `vitorias`, `grupo_id`, `time_id`) VALUES
(1, 1, 0, 1, 29, 45, 6, 'N', 16, 5, 1, 1),
(2, 3, 4, 0, 38, 36, 6, 'N', 6, 2, 1, 2),
(3, 2, 3, 1, 40, 32, 6, 'N', 7, 2, 1, 3),
(4, 4, 3, 2, 36, 30, 6, 'N', 5, 1, 1, 4);


CREATE TABLE IF NOT EXISTS `ClassificacaoHist` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `colocacao` int(11) NOT NULL,
  `derrotas` int(11) NOT NULL,
  `empates` int(11) NOT NULL,
  `golsContra` int(11) NOT NULL,
  `golsPro` int(11) NOT NULL,
  `jogos` int(11) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `pontos` int(11) NOT NULL,
  `rodada` int(11) NOT NULL,
  `vitorias` int(11) NOT NULL,
  `grupo_id` bigint(20) NOT NULL,
  `time_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_3rdf6embjonw8w27t6kw0rfjj` (`grupo_id`),
  KEY `FK_9i4wd21qwqjsyif0biox4f50` (`time_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=49 ;


INSERT INTO `ClassificacaoHist` (`id`, `colocacao`, `derrotas`, `empates`, `golsContra`, `golsPro`, `jogos`, `observacao`, `pontos`, `rodada`, `vitorias`, `grupo_id`, `time_id`) VALUES
(1, 1, 0, 0, 5, 10, 1, 'N', 3, 1, 1, 1, 1),
(2, 2, 0, 1, 6, 6, 1, 'N', 1, 1, 0, 1, 3),
(3, 2, 0, 1, 6, 6, 1, 'N', 1, 1, 0, 1, 4),
(4, 4, 1, 0, 10, 5, 1, 'N', 0, 1, 0, 1, 2),
(5, 1, 0, 1, 12, 17, 2, 'N', 4, 2, 1, 1, 1),
(6, 2, 1, 0, 12, 14, 2, 'N', 3, 2, 1, 1, 2),
(7, 3, 0, 2, 13, 13, 2, 'N', 2, 2, 0, 1, 4),
(8, 4, 1, 1, 15, 8, 2, 'N', 1, 2, 0, 1, 3),
(13, 1, 0, 1, 16, 25, 3, 'N', 7, 3, 2, 1, 1),
(14, 2, 1, 0, 13, 21, 3, 'N', 6, 3, 2, 1, 2),
(15, 3, 1, 2, 20, 14, 3, 'N', 2, 3, 0, 1, 4),
(16, 4, 2, 1, 23, 12, 3, 'N', 1, 3, 0, 1, 3),
(25, 1, 0, 1, 23, 33, 4, 'N', 10, 4, 3, 1, 1),
(26, 2, 2, 0, 21, 28, 4, 'N', 6, 4, 2, 1, 2),
(27, 3, 2, 1, 29, 19, 4, 'N', 4, 4, 1, 1, 3),
(28, 4, 2, 2, 27, 20, 4, 'N', 2, 4, 0, 1, 4),
(37, 1, 0, 1, 27, 38, 5, 'N', 13, 5, 4, 1, 1),
(38, 2, 2, 1, 33, 30, 5, 'N', 7, 5, 2, 1, 3),
(39, 3, 3, 0, 32, 32, 5, 'N', 6, 5, 2, 1, 2),
(40, 4, 3, 2, 32, 24, 5, 'N', 2, 5, 0, 1, 4),
(45, 1, 0, 1, 29, 45, 6, 'N', 16, 6, 5, 1, 1),
(46, 2, 3, 1, 40, 32, 6, 'N', 7, 6, 2, 1, 3),
(47, 3, 4, 0, 38, 36, 6, 'N', 6, 6, 2, 1, 2),
(48, 4, 3, 2, 36, 30, 6, 'N', 5, 6, 1, 1, 4);


CREATE TABLE IF NOT EXISTS `Edicao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `campeonato_id` bigint(20) DEFAULT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `tipoEdicao_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_eqwbve7ha3k14r5aguxy1rkgj` (`campeonato_id`),
  KEY `FK_gt4uebg6iqqrkajvbcks4tjnx` (`status_id`),
  KEY `FK_2l79tso3wlfr6uypki83qsv2o` (`tipoEdicao_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

INSERT INTO `Edicao` (`id`, `descricao`, `campeonato_id`, `status_id`, `tipoEdicao_id`) VALUES
(1, 'Liga dos Campeões 2015', 2, 2, 1);


CREATE TABLE IF NOT EXISTS `Escalacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `jogo_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_tl5amntr39lv37y66nqu0utj3` (`jogo_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;


INSERT INTO `Escalacao` (`id`, `jogo_id`) VALUES
(1, 1),
(2, 2),
(3, 4),
(4, 5),
(5, 6),
(6, 7),
(7, 8),
(8, 9),
(9, 10),
(10, 11),
(11, 12),
(12, 13);


CREATE TABLE IF NOT EXISTS `Evento` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `imgName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tc5xavari6dxcyksg3hnkjl1` (`descricao`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

INSERT INTO `Evento` (`id`, `descricao`, `imgName`) VALUES
(1, 'Gol', 'gol.png'),
(2, 'Carto Amarelo', 'cartao-amarelo.png'),
(3, 'Carto Vermelho', 'cartao-vermelho.png'),
(4, 'Cartï¿½o Amarelo', 'cartao-amarelo.png'),
(5, 'Cartï¿½o Vermelho', 'cartao-vermelho.png');


CREATE TABLE IF NOT EXISTS `Fase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `sigla` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;


INSERT INTO `Fase` (`id`, `descricao`, `sigla`) VALUES
(1, '1Âª fase (fase de grupos)', '1'),
(2, 'Pontos Corridos', 'P'),
(3, '2Âª fase (Mata-Mata)', '2');


CREATE TABLE IF NOT EXISTS `Grupo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `edicao_id` bigint(20) DEFAULT NULL,
  `fase_id` bigint(20) NOT NULL,
  `status_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2tb1n57v2yyi9m3c2yare2weu` (`edicao_id`),
  KEY `FK_3nkjrmnvre9u3liasivoxc35k` (`fase_id`),
  KEY `FK_pk9i9amr9s1imx06xjja3aprx` (`status_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

INSERT INTO `Grupo` (`id`, `descricao`, `edicao_id`, `fase_id`, `status_id`) VALUES
(1, 'Serie A', 1, 1, 2);

CREATE TABLE IF NOT EXISTS `Harbito` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `campeonato_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_sg9pya0xfbiqirihrt65w8quo` (`campeonato_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

INSERT INTO `Harbito` (`id`, `nome`, `campeonato_id`) VALUES
(1, 'Zé', 2);

CREATE TABLE IF NOT EXISTS `Jogador` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(40) NOT NULL,
  `uriFoto` varchar(255) DEFAULT NULL,
  `campeonato_id` bigint(20) DEFAULT NULL,
  `posicao_id` bigint(20) NOT NULL,
  `apelido` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4258tqi7x636xo5u4cda959jx` (`campeonato_id`),
  KEY `FK_kk6ywqtgkt8wroq02bi0md5re` (`posicao_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=43 ;

INSERT INTO `Jogador` (`id`, `nome`, `uriFoto`, `campeonato_id`, `posicao_id`, `apelido`) VALUES
(1, 'Renato', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 1, NULL),
(2, 'Banana', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(3, 'Rogerio', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(4, 'Jorginho', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(5, 'Esquilo', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(6, 'Bruno', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(7, 'Júlio', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(8, 'Dú Magrelo', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(9, 'Mariano', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(10, 'Bizoga', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(11, 'Ivo', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 1, NULL),
(12, 'Dú Trator', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(13, 'Markos', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(14, 'Maradona', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(15, 'Andy', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(16, 'Marcinho', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(17, 'Dú Alemão', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(18, 'Ton', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(19, 'Paolo', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(20, 'Gzuisss', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(21, 'Lili', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 1, NULL),
(22, 'Rodrigo', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(23, 'Samor', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(24, 'Biruta', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(25, 'Denis', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(26, 'Deninho', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(27, 'Nicolas', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(28, 'Renan', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(29, 'Boy', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(30, 'Alexandre Gordinho', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(31, 'Fábio', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 1, NULL),
(32, 'Carlinhos', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(33, 'B. Pertubado', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(34, 'Andy 2', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(35, 'Ailton', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(36, 'Renatinho', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(37, 'Dê', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(38, 'Kauê', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(39, 'Jean', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 1, NULL),
(40, 'Diego', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(41, 'Leandro', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL),
(42, 'Vítor.irmão do Dê', '/jcampeonato/static/core/img/jogador_no_photo.png', 2, 2, NULL);


CREATE TABLE IF NOT EXISTS `JogadorEscalado` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `escalacao_id` bigint(20) DEFAULT NULL,
  `jogador_id` bigint(20) DEFAULT NULL,
  `time_id` bigint(20) DEFAULT NULL,
  `posicao_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gsvn2p1ygd309dpqa5fas30tr` (`escalacao_id`),
  KEY `FK_9i6m8scqrqhlqv47d40glmmpi` (`jogador_id`),
  KEY `FK_rqesw0rn7e63rip8fu80o31pv` (`time_id`),
  KEY `FK_p6fw067ctwx1rmkb2f68mopxq` (`posicao_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=249 ;


INSERT INTO `JogadorEscalado` (`id`, `escalacao_id`, `jogador_id`, `time_id`, `posicao_id`) VALUES
(1, 1, 1, 1, 1),
(2, 1, 2, 1, 2),
(3, 1, 3, 1, 2),
(4, 1, 4, 1, 2),
(5, 1, 5, 1, 2),
(6, 1, 6, 1, 2),
(7, 1, 7, 1, 2),
(9, 1, 9, 1, 2),
(10, 1, 10, 1, 2),
(11, 1, 11, 2, 1),
(12, 1, 12, 2, 2),
(13, 1, 13, 2, 2),
(14, 1, 14, 2, 2),
(15, 1, 15, 2, 2),
(16, 1, 16, 2, 2),
(17, 1, 17, 2, 2),
(18, 1, 18, 2, 2),
(19, 1, 19, 2, 2),
(20, 1, 20, 2, 2),
(21, 2, 21, 3, 1),
(22, 2, 22, 3, 2),
(23, 2, 23, 3, 2),
(24, 2, 24, 3, 2),
(25, 2, 25, 3, 2),
(26, 2, 26, 3, 2),
(27, 2, 27, 3, 2),
(28, 2, 28, 3, 2),
(29, 2, 29, 3, 2),
(30, 2, 30, 3, 2),
(31, 2, 31, 4, 1),
(32, 2, 32, 4, 2),
(33, 2, 33, 4, 2),
(34, 2, 34, 4, 2),
(35, 2, 35, 4, 2),
(36, 2, 36, 4, 2),
(37, 2, 37, 4, 2),
(38, 2, 38, 4, 2),
(39, 2, 39, 4, 2),
(41, 3, 11, 2, 1),
(42, 3, 12, 2, 2),
(43, 3, 13, 2, 2),
(44, 3, 14, 2, 2),
(45, 3, 15, 2, 2),
(46, 3, 16, 2, 2),
(47, 3, 17, 2, 2),
(48, 3, 18, 2, 2),
(49, 3, 19, 2, 2),
(50, 3, 20, 2, 2),
(51, 3, 21, 3, 1),
(52, 3, 22, 3, 2),
(53, 3, 23, 3, 2),
(54, 3, 24, 3, 2),
(55, 3, 25, 3, 2),
(57, 3, 27, 3, 2),
(58, 3, 28, 3, 2),
(59, 3, 29, 3, 2),
(60, 3, 30, 3, 2),
(61, 4, 31, 4, 1),
(62, 4, 32, 4, 2),
(63, 4, 33, 4, 2),
(64, 4, 34, 4, 2),
(65, 4, 35, 4, 2),
(66, 4, 36, 4, 2),
(67, 4, 37, 4, 2),
(68, 4, 38, 4, 2),
(69, 4, 39, 4, 2),
(71, 4, 1, 1, 1),
(72, 4, 2, 1, 2),
(73, 4, 3, 1, 2),
(74, 4, 4, 1, 2),
(75, 4, 5, 1, 2),
(76, 4, 6, 1, 2),
(77, 4, 7, 1, 2),
(78, 4, 8, 1, 2),
(79, 4, 9, 1, 2),
(80, 4, 10, 1, 2),
(81, 5, 21, 3, 1),
(82, 5, 22, 3, 2),
(83, 5, 23, 3, 2),
(84, 5, 24, 3, 2),
(85, 5, 25, 3, 2),
(87, 5, 27, 3, 2),
(88, 5, 28, 3, 2),
(89, 5, 29, 3, 2),
(90, 5, 30, 3, 2),
(91, 5, 1, 1, 1),
(92, 5, 2, 1, 2),
(93, 5, 3, 1, 2),
(94, 5, 4, 1, 2),
(95, 5, 5, 1, 2),
(96, 5, 6, 1, 2),
(97, 5, 7, 1, 2),
(98, 5, 8, 1, 2),
(99, 5, 9, 1, 2),
(100, 5, 10, 1, 2),
(101, 5, 41, 3, 2),
(102, 6, 31, 4, 1),
(103, 6, 32, 4, 2),
(104, 6, 33, 4, 2),
(105, 6, 34, 4, 2),
(106, 6, 35, 4, 2),
(107, 6, 36, 4, 2),
(108, 6, 37, 4, 2),
(109, 6, 38, 4, 2),
(110, 6, 39, 4, 2),
(112, 6, 11, 2, 1),
(113, 6, 12, 2, 2),
(114, 6, 13, 2, 2),
(115, 6, 14, 2, 2),
(116, 6, 15, 2, 2),
(117, 6, 16, 2, 2),
(118, 6, 17, 2, 2),
(119, 6, 18, 2, 2),
(120, 6, 19, 2, 2),
(121, 6, 20, 2, 2),
(122, 7, 21, 3, 1),
(123, 7, 22, 3, 2),
(124, 7, 23, 3, 2),
(125, 7, 24, 3, 2),
(126, 7, 25, 3, 2),
(128, 7, 27, 3, 2),
(129, 7, 28, 3, 2),
(130, 7, 29, 3, 2),
(131, 7, 30, 3, 2),
(132, 7, 41, 3, 2),
(134, 7, 32, 4, 2),
(135, 7, 33, 4, 2),
(136, 7, 34, 4, 2),
(137, 7, 35, 4, 2),
(138, 7, 36, 4, 2),
(139, 7, 37, 4, 2),
(140, 7, 38, 4, 2),
(143, 8, 1, 1, 1),
(144, 8, 2, 1, 2),
(145, 8, 3, 1, 2),
(146, 8, 4, 1, 2),
(147, 8, 5, 1, 2),
(148, 8, 6, 1, 2),
(149, 8, 7, 1, 2),
(150, 8, 8, 1, 2),
(151, 8, 9, 1, 2),
(152, 8, 10, 1, 2),
(153, 8, 11, 2, 1),
(154, 8, 12, 2, 2),
(155, 8, 13, 2, 2),
(156, 8, 14, 2, 2),
(157, 8, 15, 2, 2),
(158, 8, 16, 2, 2),
(159, 8, 17, 2, 2),
(160, 8, 18, 2, 2),
(161, 8, 19, 2, 2),
(162, 8, 20, 2, 2),
(163, 7, 42, 4, 2),
(164, 7, 39, 4, 1),
(165, 9, 1, 1, 1),
(166, 9, 8, 1, 2),
(167, 9, 3, 1, 2),
(168, 9, 10, 1, 2),
(169, 9, 5, 1, 2),
(170, 9, 7, 1, 2),
(171, 9, 2, 1, 2),
(172, 9, 9, 1, 2),
(173, 9, 4, 1, 2),
(174, 9, 6, 1, 2),
(175, 9, 39, 4, 1),
(177, 9, 34, 4, 2),
(178, 9, 42, 4, 2),
(179, 9, 36, 4, 2),
(180, 9, 38, 4, 2),
(181, 9, 33, 4, 2),
(182, 9, 40, 4, 2),
(183, 9, 35, 4, 2),
(184, 9, 37, 4, 2),
(185, 9, 32, 4, 2),
(186, 10, 11, 2, 1),
(187, 10, 18, 2, 2),
(188, 10, 13, 2, 2),
(189, 10, 20, 2, 2),
(190, 10, 15, 2, 2),
(191, 10, 17, 2, 2),
(192, 10, 12, 2, 2),
(193, 10, 19, 2, 2),
(194, 10, 14, 2, 2),
(195, 10, 16, 2, 2),
(196, 10, 21, 3, 1),
(197, 10, 41, 3, 2),
(198, 10, 26, 3, 2),
(199, 10, 28, 3, 2),
(200, 10, 23, 3, 2),
(201, 10, 30, 3, 2),
(202, 10, 25, 3, 2),
(203, 10, 27, 3, 2),
(204, 10, 22, 3, 2),
(205, 10, 29, 3, 2),
(206, 10, 24, 3, 2),
(207, 11, 1, 1, 1),
(208, 11, 3, 1, 2),
(209, 11, 10, 1, 2),
(210, 11, 5, 1, 2),
(211, 11, 7, 1, 2),
(212, 11, 2, 1, 2),
(213, 11, 9, 1, 2),
(214, 11, 4, 1, 2),
(215, 11, 6, 1, 2),
(216, 11, 8, 1, 2),
(217, 11, 21, 3, 1),
(218, 11, 28, 3, 2),
(219, 11, 23, 3, 2),
(220, 11, 30, 3, 2),
(221, 11, 25, 3, 2),
(222, 11, 27, 3, 2),
(223, 11, 22, 3, 2),
(224, 11, 29, 3, 2),
(225, 11, 24, 3, 2),
(226, 11, 41, 3, 2),
(227, 11, 26, 3, 2),
(228, 12, 11, 2, 1),
(229, 12, 20, 2, 2),
(230, 12, 15, 2, 2),
(231, 12, 17, 2, 2),
(232, 12, 12, 2, 2),
(233, 12, 19, 2, 2),
(234, 12, 14, 2, 2),
(235, 12, 16, 2, 2),
(236, 12, 18, 2, 2),
(237, 12, 13, 2, 2),
(239, 12, 39, 4, 1),
(240, 12, 42, 4, 2),
(241, 12, 36, 4, 2),
(242, 12, 38, 4, 2),
(243, 12, 33, 4, 2),
(244, 12, 40, 4, 2),
(245, 12, 35, 4, 2),
(246, 12, 37, 4, 2),
(247, 12, 32, 4, 2),
(248, 12, 34, 4, 2);

CREATE TABLE IF NOT EXISTS `JogadorEscalado_Evento` (
  `jogadoresEscalados_id` bigint(20) NOT NULL,
  `eventos_id` bigint(20) NOT NULL,
  KEY `FK_1tsysgcobpjmql99tnhinflq3` (`eventos_id`),
  KEY `FK_3u82p13yipdv9tfns3npds76k` (`jogadoresEscalados_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `JogadorEscalado_Evento` (`jogadoresEscalados_id`, `eventos_id`) VALUES
(4, 1),
(4, 1),
(6, 1),
(6, 1),
(7, 1),
(10, 1),
(5, 1),
(5, 1),
(5, 1),
(5, 1),
(5, 2),
(17, 1),
(17, 1),
(17, 1),
(19, 1),
(19, 1),
(25, 1),
(27, 1),
(27, 1),
(27, 1),
(27, 1),
(28, 1),
(32, 1),
(34, 1),
(35, 1),
(36, 1),
(36, 1),
(38, 1),
(42, 1),
(44, 1),
(45, 1),
(45, 1),
(49, 1),
(49, 1),
(47, 1),
(47, 1),
(48, 1),
(58, 1),
(58, 1),
(58, 2),
(59, 2),
(59, 2),
(59, 3),
(66, 1),
(66, 1),
(67, 1),
(67, 1),
(69, 1),
(64, 1),
(64, 2),
(65, 1),
(65, 2),
(68, 2),
(68, 3),
(74, 1),
(74, 1),
(75, 1),
(77, 1),
(77, 1),
(77, 1),
(80, 1),
(95, 1),
(96, 1),
(96, 1),
(96, 1),
(96, 2),
(97, 1),
(98, 2),
(99, 1),
(99, 1),
(99, 1),
(100, 2),
(101, 1),
(87, 1),
(87, 1),
(85, 1),
(85, 2),
(115, 1),
(121, 1),
(121, 1),
(120, 1),
(120, 1),
(120, 1),
(120, 2),
(114, 3),
(118, 1),
(118, 3),
(108, 1),
(108, 2),
(106, 2),
(103, 3),
(126, 1),
(126, 1),
(132, 1),
(132, 1),
(128, 1),
(129, 1),
(129, 1),
(136, 1),
(137, 1),
(138, 1),
(139, 1),
(139, 1),
(139, 1),
(148, 1),
(148, 1),
(148, 1),
(151, 1),
(152, 1),
(146, 2),
(149, 1),
(149, 1),
(149, 1),
(149, 2),
(157, 1),
(160, 1),
(161, 1),
(161, 1),
(161, 1),
(161, 1),
(161, 1),
(161, 2),
(173, 1),
(169, 1),
(170, 1),
(170, 1),
(174, 1),
(179, 1),
(184, 1),
(180, 1),
(178, 1),
(181, 2),
(194, 1),
(190, 1),
(191, 1),
(191, 1),
(196, 2),
(204, 1),
(206, 1),
(202, 1),
(197, 1),
(197, 1),
(197, 1),
(203, 1),
(203, 1),
(203, 1),
(203, 1),
(199, 1),
(208, 1),
(210, 1),
(215, 1),
(213, 1),
(213, 1),
(214, 1),
(211, 1),
(223, 1),
(218, 1),
(237, 1),
(229, 1),
(230, 1),
(230, 1),
(247, 1),
(247, 1),
(245, 1),
(246, 1),
(242, 1),
(242, 1);

CREATE TABLE IF NOT EXISTS `JogadorInfoEdicao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cartaoAmarelo` int(11) NOT NULL,
  `cartaoVermelho` int(11) NOT NULL,
  `gols` int(11) NOT NULL,
  `jogos` int(11) NOT NULL,
  `edicao_id` bigint(20) DEFAULT NULL,
  `jogador_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_dn0v8m6oyjwtfja8bq4ov70mi` (`edicao_id`),
  KEY `FK_d69iqmsl45cccakvpxlpqkvmx` (`jogador_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=43 ;

INSERT INTO `JogadorInfoEdicao` (`id`, `cartaoAmarelo`, `cartaoVermelho`, `gols`, `jogos`, `edicao_id`, `jogador_id`) VALUES
(1, 0, 0, 0, 6, 1, 1),
(2, 0, 0, 0, 6, 1, 2),
(3, 0, 0, 1, 6, 1, 3),
(4, 1, 0, 6, 6, 1, 4),
(5, 1, 0, 8, 6, 1, 5),
(6, 1, 0, 10, 6, 1, 6),
(7, 1, 0, 11, 6, 1, 7),
(8, 0, 0, 6, 6, 1, 9),
(9, 1, 0, 3, 6, 1, 10),
(10, 0, 0, 0, 6, 1, 11),
(11, 0, 0, 1, 6, 1, 12),
(12, 0, 1, 1, 6, 1, 13),
(13, 0, 0, 3, 6, 1, 14),
(14, 0, 0, 6, 6, 1, 15),
(15, 0, 0, 0, 6, 1, 16),
(16, 0, 1, 8, 6, 1, 17),
(17, 0, 0, 2, 6, 1, 18),
(18, 2, 0, 12, 6, 1, 19),
(19, 0, 0, 3, 6, 1, 20),
(20, 1, 0, 0, 6, 1, 21),
(21, 0, 0, 2, 6, 1, 22),
(22, 0, 0, 0, 6, 1, 23),
(23, 0, 0, 1, 6, 1, 24),
(24, 1, 0, 5, 6, 1, 25),
(25, 0, 0, 0, 3, 1, 26),
(26, 0, 0, 11, 6, 1, 27),
(27, 1, 0, 7, 6, 1, 28),
(28, 2, 1, 0, 6, 1, 29),
(29, 0, 0, 0, 6, 1, 30),
(30, 0, 0, 0, 3, 1, 31),
(31, 0, 1, 3, 6, 1, 32),
(32, 1, 0, 0, 6, 1, 33),
(33, 1, 0, 3, 6, 1, 34),
(34, 2, 0, 4, 6, 1, 35),
(35, 0, 0, 6, 6, 1, 36),
(36, 1, 0, 8, 6, 1, 37),
(37, 1, 1, 4, 6, 1, 38),
(38, 0, 0, 1, 6, 1, 39),
(39, 1, 0, 0, 5, 1, 8),
(40, 0, 0, 6, 4, 1, 41),
(41, 0, 0, 0, 2, 1, 40),
(42, 0, 0, 1, 3, 1, 42);


CREATE TABLE IF NOT EXISTS `Jogo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataHora` date DEFAULT NULL,
  `resultadoA` int(11) NOT NULL,
  `resultadoB` int(11) NOT NULL,
  `rodada` int(11) NOT NULL,
  `sequencia` int(11) NOT NULL,
  `grupo_id` bigint(20) NOT NULL,
  `harbito_id` bigint(20) NOT NULL,
  `local_id` bigint(20) NOT NULL,
  `status_id` bigint(20) DEFAULT NULL,
  `timeA_id` bigint(20) NOT NULL,
  `timeB_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_1wscaya5l52wn9pyvvs97klm0` (`grupo_id`),
  KEY `FK_59amoqh3eioja0ug6fo3gc3ug` (`harbito_id`),
  KEY `FK_fltbxs6el2hg08h2ef95gd5r` (`local_id`),
  KEY `FK_baapslx6esp3j98fg0cgybj5u` (`status_id`),
  KEY `FK_m51rvkk4ccjpwlyo0ne2noiug` (`timeA_id`),
  KEY `FK_sh98s14glfisfq50ipjcbcfds` (`timeB_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;


INSERT INTO `Jogo` (`id`, `dataHora`, `resultadoA`, `resultadoB`, `rodada`, `sequencia`, `grupo_id`, `harbito_id`, `local_id`, `status_id`, `timeA_id`, `timeB_id`) VALUES
(1, '2015-10-07', 10, 5, 1, 1, 1, 1, 1, 3, 1, 2),
(2, '2015-10-07', 6, 6, 1, 2, 1, 1, 1, 3, 3, 4),
(4, '2015-10-21', 9, 2, 2, 4, 1, 1, 1, 3, 2, 3),
(5, '2015-10-21', 7, 7, 2, 5, 1, 1, 1, 3, 4, 1),
(6, '2015-10-28', 4, 8, 3, 6, 1, 1, 1, 3, 3, 1),
(7, '2015-10-28', 1, 7, 3, 7, 1, 1, 1, 3, 4, 2),
(8, '2015-11-04', 7, 6, 4, 8, 1, 1, 1, 3, 3, 4),
(9, '2015-11-04', 8, 7, 4, 9, 1, 1, 1, 3, 1, 2),
(10, '2015-11-11', 5, 4, 5, 1, 1, 1, 1, 3, 1, 4),
(11, '2015-11-11', 4, 11, 5, 2, 1, 1, 1, 3, 2, 3),
(12, '2015-11-18', 7, 2, 6, 1, 1, 1, 1, 3, 1, 3),
(13, '2015-11-18', 4, 6, 6, 2, 1, 1, 1, 3, 2, 4);


CREATE TABLE IF NOT EXISTS `Local` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(20) NOT NULL,
  `campeonato_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_te306k4uibixh3e3m97v8q9yr` (`campeonato_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;


INSERT INTO `Local` (`id`, `descricao`, `campeonato_id`) VALUES
(1, 'Poaense', 2);

CREATE TABLE IF NOT EXISTS `Perfil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;


INSERT INTO `Perfil` (`id`, `descricao`) VALUES
(1, 'Administrador'),
(2, 'Cadastrar/Editar Partidas e alterar resultado dos Jogos.'),
(3, 'Altera somente resultado dos jogos.');

CREATE TABLE IF NOT EXISTS `Posicao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `imgName` varchar(255) DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ao7n0wl2hdy6s10o191cfj53m` (`sigla`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;


INSERT INTO `Posicao` (`id`, `descricao`, `imgName`, `sigla`) VALUES
(1, 'Goleiro', 'golerio_24x24.png', 'GK'),
(2, 'Linha', 'chuteira_32.png', 'AT');


CREATE TABLE IF NOT EXISTS `Status` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `imgName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_kf55su4jwl0songatslysxlbn` (`descricao`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;


INSERT INTO `Status` (`id`, `descricao`, `imgName`) VALUES
(1, 'Pendente', 'interrogacao.png'),
(2, 'Andamento', 'bola_32.png'),
(3, 'Finalizado', 'apito_24.png');


CREATE TABLE IF NOT EXISTS `Time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `campeonato_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_srdj9bort96eiqrhgg17sanso` (`campeonato_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;


INSERT INTO `Time` (`id`, `nome`, `campeonato_id`) VALUES
(1, 'Croacia', 2),
(2, 'Black', 2),
(3, 'PSG', 2),
(4, 'Sem Controle', 2);


CREATE TABLE IF NOT EXISTS `Time_Jogador` (
  `times_id` bigint(20) NOT NULL,
  `jogadores_id` bigint(20) NOT NULL,
  KEY `FK_angdl79l3d2djqoacrtr9s0ia` (`jogadores_id`),
  KEY `FK_hdo7p5kb4igncq66ygw0x3h8v` (`times_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `Time_Jogador` (`times_id`, `jogadores_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(2, 11),
(2, 12),
(2, 13),
(2, 14),
(2, 15),
(2, 16),
(2, 17),
(2, 18),
(2, 19),
(2, 20),
(3, 21),
(3, 22),
(3, 23),
(3, 24),
(3, 25),
(3, 26),
(3, 27),
(3, 28),
(3, 29),
(3, 30),
(3, 41),
(4, 31),
(4, 32),
(4, 33),
(4, 34),
(4, 35),
(4, 36),
(4, 37),
(4, 38),
(4, 39),
(4, 40),
(4, 42);


CREATE TABLE IF NOT EXISTS `TipoEdicao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;


INSERT INTO `TipoEdicao` (`id`, `descricao`) VALUES
(1, '1a fase (fase de Grupo) e Mata-mata'),
(2, 'Pontos Corridos'),
(3, 'Mata-Mata');


CREATE TABLE IF NOT EXISTS `Usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `dataCadastro` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4tdehxj7dh8ghfc68kbwbsbll` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;


INSERT INTO `Usuario` (`id`, `email`, `nome`, `senha`, `dataCadastro`) VALUES
(1, 'diegolirio.dl@gmail.com', 'Diego Lirio', '198586', '2015-10-01'),
(2, 'maradona@quartashow.com', 'Maradona', '654321', '2015-10-01');


CREATE TABLE IF NOT EXISTS `UsuarioPerfilCampeonato` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `campeonato_id` bigint(20) DEFAULT NULL,
  `perfil_id` bigint(20) DEFAULT NULL,
  `usuario_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_i8ku8cas8pea2sq48qbc0xww6` (`campeonato_id`),
  KEY `FK_jei2151eulwcqy06jld4km8t2` (`perfil_id`),
  KEY `FK_o6a5g4vhdchf1gy7glesf0hra` (`usuario_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;


INSERT INTO `UsuarioPerfilCampeonato` (`id`, `campeonato_id`, `perfil_id`, `usuario_id`) VALUES
(2, 2, 1, 1),
(3, 2, 2, 2);

ALTER TABLE `Classificacao`
  ADD CONSTRAINT `FK_aa5bd817lf0xk7qlqd58cmxgh` FOREIGN KEY (`time_id`) REFERENCES `Time` (`id`),
  ADD CONSTRAINT `FK_oprsb9dvyrpq4djmri9oaawkg` FOREIGN KEY (`grupo_id`) REFERENCES `Grupo` (`id`);

ALTER TABLE `ClassificacaoHist`
  ADD CONSTRAINT `FK_3rdf6embjonw8w27t6kw0rfjj` FOREIGN KEY (`grupo_id`) REFERENCES `Grupo` (`id`),
  ADD CONSTRAINT `FK_9i4wd21qwqjsyif0biox4f50` FOREIGN KEY (`time_id`) REFERENCES `Time` (`id`);

ALTER TABLE `Edicao`
  ADD CONSTRAINT `FK_2l79tso3wlfr6uypki83qsv2o` FOREIGN KEY (`tipoEdicao_id`) REFERENCES `TipoEdicao` (`id`),
  ADD CONSTRAINT `FK_eqwbve7ha3k14r5aguxy1rkgj` FOREIGN KEY (`campeonato_id`) REFERENCES `Campeonato` (`id`),
  ADD CONSTRAINT `FK_gt4uebg6iqqrkajvbcks4tjnx` FOREIGN KEY (`status_id`) REFERENCES `Status` (`id`);

ALTER TABLE `Escalacao`
  ADD CONSTRAINT `FK_tl5amntr39lv37y66nqu0utj3` FOREIGN KEY (`jogo_id`) REFERENCES `Jogo` (`id`);

ALTER TABLE `Grupo`
  ADD CONSTRAINT `FK_2tb1n57v2yyi9m3c2yare2weu` FOREIGN KEY (`edicao_id`) REFERENCES `Edicao` (`id`),
  ADD CONSTRAINT `FK_3nkjrmnvre9u3liasivoxc35k` FOREIGN KEY (`fase_id`) REFERENCES `Fase` (`id`),
  ADD CONSTRAINT `FK_pk9i9amr9s1imx06xjja3aprx` FOREIGN KEY (`status_id`) REFERENCES `Status` (`id`);

ALTER TABLE `Harbito`
  ADD CONSTRAINT `FK_sg9pya0xfbiqirihrt65w8quo` FOREIGN KEY (`campeonato_id`) REFERENCES `Campeonato` (`id`);

ALTER TABLE `Jogador`
  ADD CONSTRAINT `FK_4258tqi7x636xo5u4cda959jx` FOREIGN KEY (`campeonato_id`) REFERENCES `Campeonato` (`id`),
  ADD CONSTRAINT `FK_kk6ywqtgkt8wroq02bi0md5re` FOREIGN KEY (`posicao_id`) REFERENCES `Posicao` (`id`);

ALTER TABLE `JogadorEscalado`
  ADD CONSTRAINT `FK_9i6m8scqrqhlqv47d40glmmpi` FOREIGN KEY (`jogador_id`) REFERENCES `Jogador` (`id`),
  ADD CONSTRAINT `FK_gsvn2p1ygd309dpqa5fas30tr` FOREIGN KEY (`escalacao_id`) REFERENCES `Escalacao` (`id`),
  ADD CONSTRAINT `FK_p6fw067ctwx1rmkb2f68mopxq` FOREIGN KEY (`posicao_id`) REFERENCES `Posicao` (`id`),
  ADD CONSTRAINT `FK_rqesw0rn7e63rip8fu80o31pv` FOREIGN KEY (`time_id`) REFERENCES `Time` (`id`);

ALTER TABLE `JogadorEscalado_Evento`
  ADD CONSTRAINT `FK_1tsysgcobpjmql99tnhinflq3` FOREIGN KEY (`eventos_id`) REFERENCES `Evento` (`id`),
  ADD CONSTRAINT `FK_3u82p13yipdv9tfns3npds76k` FOREIGN KEY (`jogadoresEscalados_id`) REFERENCES `JogadorEscalado` (`id`);

ALTER TABLE `JogadorInfoEdicao`
  ADD CONSTRAINT `FK_d69iqmsl45cccakvpxlpqkvmx` FOREIGN KEY (`jogador_id`) REFERENCES `Jogador` (`id`),
  ADD CONSTRAINT `FK_dn0v8m6oyjwtfja8bq4ov70mi` FOREIGN KEY (`edicao_id`) REFERENCES `Edicao` (`id`);

ALTER TABLE `Jogo`
  ADD CONSTRAINT `FK_1wscaya5l52wn9pyvvs97klm0` FOREIGN KEY (`grupo_id`) REFERENCES `Grupo` (`id`),
  ADD CONSTRAINT `FK_59amoqh3eioja0ug6fo3gc3ug` FOREIGN KEY (`harbito_id`) REFERENCES `Harbito` (`id`),
  ADD CONSTRAINT `FK_baapslx6esp3j98fg0cgybj5u` FOREIGN KEY (`status_id`) REFERENCES `Status` (`id`),
  ADD CONSTRAINT `FK_fltbxs6el2hg08h2ef95gd5r` FOREIGN KEY (`local_id`) REFERENCES `Local` (`id`),
  ADD CONSTRAINT `FK_m51rvkk4ccjpwlyo0ne2noiug` FOREIGN KEY (`timeA_id`) REFERENCES `Time` (`id`),
  ADD CONSTRAINT `FK_sh98s14glfisfq50ipjcbcfds` FOREIGN KEY (`timeB_id`) REFERENCES `Time` (`id`);

ALTER TABLE `Local`
  ADD CONSTRAINT `FK_te306k4uibixh3e3m97v8q9yr` FOREIGN KEY (`campeonato_id`) REFERENCES `Campeonato` (`id`);

ALTER TABLE `Time`
  ADD CONSTRAINT `FK_srdj9bort96eiqrhgg17sanso` FOREIGN KEY (`campeonato_id`) REFERENCES `Campeonato` (`id`);

ALTER TABLE `Time_Jogador`
  ADD CONSTRAINT `FK_angdl79l3d2djqoacrtr9s0ia` FOREIGN KEY (`jogadores_id`) REFERENCES `Jogador` (`id`),
  ADD CONSTRAINT `FK_hdo7p5kb4igncq66ygw0x3h8v` FOREIGN KEY (`times_id`) REFERENCES `Time` (`id`);

ALTER TABLE `UsuarioPerfilCampeonato`
  ADD CONSTRAINT `FK_i8ku8cas8pea2sq48qbc0xww6` FOREIGN KEY (`campeonato_id`) REFERENCES `Campeonato` (`id`),
  ADD CONSTRAINT `FK_jei2151eulwcqy06jld4km8t2` FOREIGN KEY (`perfil_id`) REFERENCES `Perfil` (`id`),
  ADD CONSTRAINT `FK_o6a5g4vhdchf1gy7glesf0hra` FOREIGN KEY (`usuario_id`) REFERENCES `Usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
