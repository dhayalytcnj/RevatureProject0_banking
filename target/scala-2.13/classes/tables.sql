
CREATE TABLE if not exists Accounts (
	acctID int AUTO_INCREMENT,
	username varchar(20) UNIQUE NOT NULL,
	password varchar(20) NOT NULL,
	PRIMARY KEY (acctID)
) ;

CREATE TABLE if not exists Customers (
	acctID int UNIQUE NOT NULL,
	fname varchar(20) NOT NULL,
	lname varchar(20) NOT NULL,
	checking decimal(15,2) NOT NULL DEFAULT 0.00,
	savings decimal(15,2) NOT NULL DEFAULT 0.00,
	PRIMARY KEY (acctID),
	FOREIGN KEY (acctID) REFERENCES Accounts(acctID),
	CHECK (checking >= 0.00),
	CHECK (savings >= 0.00)
) ;

/*
insert into Accounts (username, password)
values
('bezalel', 'simmel'),
('parto', 'bamford'),
('chirstian', 'koblick'),
('anneke', 'preusig'),
('tzven', 'zielinski'),
('saniya', 'kalloufi'),
('sumant', 'peac'),
('duang', 'piveteau'),
('mary', 'sluis'),
('patricio', 'bridgland'),
('eberhardt', 'terkki'),
('berni', 'genin'),
('guoxiang', 'nooteboom'),
('kazuha', 'cappelletti'),
('cristinel', 'bouloucos'),
('kazuhide', 'peha'),
('lillian', 'haddadi'),
('mayuko', 'warwick'),
('ramzi', 'erde'),
('shahaf', 'famili'),
('bojan', 'montemayor'),
('suzette', 'pettey'),
('prasadram', 'heyers'),
('yongqiao', 'berztiss'),
('divier', 'reistad'),
('domenic', 'tempesti'),
('otmar', 'herbst'),
('elvis', 'demeyer'),
('karlten', 'joslin'),
('jeong', 'reistad'),
('arif', 'merlo'),
('bader', 'swan'),
('alain', 'chappelet'),
('adamantios', 'portugali'),
('pradeep', 'makrucki'),
('huan', 'lortz'),
('alexander', 'brender'),
('weiyi', 'meriste'),
('uri', 'lenart'),
('magy', 'stamatiou'),
('yishay', 'tzvieli'),
('mingsen', 'casley'),
('moss', 'shanbhogue'),
('lucien', 'rosenbaum'),
('zvonko', 'nyanchama'),
('florian', 'syrotiuk'),
('basil', 'tramer'),
('yinghua', 'dredge'),
('hidefumi', 'caine'),
('heping', 'nitsch'),
('sanjiv', 'zschoche'),
('mayumi', 'schueller'),
('georgy', 'dredge'),
('brenda', 'bernini'),
('ebbe', 'callaway'),
('berhard', 'mcfarlin'),
('alejandro', 'mcalpine'),
('breannda', 'billingsley'),
('tse', 'herber'),
('anoosh', 'peyn'),
('gino', 'leonhardt'),
('udi', 'jansch'),
('satosi', 'awdeh'),
('kwee', 'schusler'),
('claudi', 'stavenow'),
('charlene', 'brattka'),
('margareta', 'bierman'),
('reuven', 'garigliano'),
('hisao', 'lipner'),
('hirona', 'sidou'),
('shir', 'mcclurg'),
('mokhtar', 'bernatsky'),
('gao', 'dolinsky'),
('erez', 'ritzmann'),
('mona', 'azuma'),
('danel', 'mondadori'),
('kshitij', 'gils'),
('premal', 'baek'),
('zhongwei', 'rosen'),
('parviz', 'lortz'),
('vishv', 'zockler'),
('tuval', 'kalloufi'),
('kenroku', 'malabarba'),
('somnath', 'foote'),
('xinglin', 'eugenio'),
('jungsoon', 'syrzycki'),
('sudharsan', 'flasterstein'),
('kendra', 'hofting'),
('amabile', 'gomatam'),
('valdiodio', 'niizuma'),
('sailaja', 'desikan'),
('arumugam', 'ossenbruggen'),
('hilari', 'morton'),
('jayson', 'mandell'),
('remzi', 'waschkowski'),
('sreekrishna', 'servieres'),
('valter', 'sullins'),
('hironobu', 'haraldson'),
('perla', 'heyers'),
('paraskevi', 'luby'),
('akemi', 'birch'),
('xinyu', 'warwick'),
('hironoby', 'piveteau'),
('eben', 'aingworth'),
('dung', 'baca'),
('lunjin', 'giveon'),
('mariusz', 'prampolini'),
('xuejia', 'ullian'),
('hugo', 'rosis'),
('yuichiro', 'swick'),
('jaewon', 'syrzycki'),
('munir', 'demeyer'),
('chikara', 'rissland'),
('dayanand', 'czap'),
('kiyotoshi', 'blokdijk'),
('zhonghui', 'zyda'),
('domenick', 'peltason'),
('armon', 'fairtlough'),
('guoxia', 'ramsay'),
('ohad', 'esposito'),
('hinrich', 'randi'),
('geraldo', 'marwedel'),
('syozo', 'hiltgen'),
('kayoko', 'valtorta'),
('subir', 'baja'),
('babette', 'lamba'),
('armond', 'peir'),
('nishit', 'casperson'),
('magdalena', 'eldridge'),
('ayakannu', 'skrikant'),
('giri', 'isaak'),
('diederik', 'siprelle'),
('nathan', 'monkewich'),
('zissis', 'pintelas'),
('maren', 'hutton'),
('perry', 'shimshoni'),
('ewing', 'foong'),
('yucel', 'auria'),
('shahan', 'ishibashi'),
('tzvetan', 'hettesheimer'),
('sakthirel', 'bakhtari'),
('marla', 'brendel'),
('kemi', 'esposito'),
('chenyi', 'syang'),
('kazuhito', 'encarnacion'),
('douadi', 'azumi'),
('xiadong', 'perry'),
('zhenbing', 'perng'),
('itzchak', 'lichtner'),
('jaques', 'munro'),
('heekeun', 'majewski'),
('abdulah', 'thibadeau'),
('adas', 'nastansky'),
('sumali', 'fargier'),
('nigel', 'aloisi'),
('khedija', 'mitsuhashi'),
('serif', 'buescher'),
('debatosh', 'khasidashvili'),
('hairong', 'mellouli'),
('florina', 'eugenio'),
('karsten', 'szmurlo'),
('jagoda', 'braunmuhl'),
('miyeon', 'macedo'),
('samphel', 'siegrist'),
('duangkaew', 'rassart'),
('dharmaraja', 'stassinopoulos'),
('sampalli', 'snedden'),
('kasturi', 'jenevein'),
('herbert', 'trachtenberg'),
('shigeu', 'matzen'),
('shrikanth', 'mahmud'),
('badri', 'furudate'),
('aleksandar', 'ananiadou'),
('brendon', 'lenart'),
('pragnesh', 'iisaka'),
('valery', 'litvinov'),
('deniz', 'duclos'),
('shaw', 'wendorf'),
('sibyl', 'nooteboom'),
('moriyoshi', 'merey'),
('mechthild', 'bonifati'),
('mihalis', 'lowrie'),
('duro', 'sidhu'),
('shigehito', 'kropatsch'),
('tommaso', 'narwekar'),
('christ', 'muchinsky'),
('khalid', 'erva'),
('arve', 'fairtlough'),
('zdislav', 'nastansky'),
('mohua', 'falck'),
('masaru', 'cheshire'),
('josyula', 'hofmeyr'),
('annemarie', 'redmiles'),
('marc', 'hellwagner'),
('kasidit', 'krzyzanowski'),
('pranav', 'furedi'),
('kazuhisa', 'ranta'),
('vidya', 'awdeh'),
('idoia', 'kavraki');    

insert into Customers (acctID, fname, lname)
values
(1,'bezalel', 'simmel'),
(2,'parto', 'bamford'),
(3,'chirstian', 'koblick'),
(4,'anneke', 'preusig'),
(5,'tzven', 'zielinski'),
(6,'saniya', 'kalloufi'),
(7,'sumant', 'peac'),
(8,'duang', 'piveteau'),
(9,'mary', 'sluis'),
(10,'patricio', 'bridgland'),
(11,'eberhardt', 'terkki'),
(12,'berni', 'genin'),
(13,'guoxiang', 'nooteboom'),
(14,'kazuha', 'cappelletti'),
(15,'cristinel', 'bouloucos'),
(16,'kazuhide', 'peha'),
(17,'lillian', 'haddadi'),
(18,'mayuko', 'warwick'),
(19,'ramzi', 'erde'),
(20,'shahaf', 'famili'),
(21,'bojan', 'montemayor'),
(22,'suzette', 'pettey'),
(23,'prasadram', 'heyers'),
(24,'yongqiao', 'berztiss'),
(25,'divier', 'reistad'),
(26,'domenic', 'tempesti'),
(27,'otmar', 'herbst'),
(28,'elvis', 'demeyer'),
(29,'karlten', 'joslin'),
(30,'jeong', 'reistad'),
(31,'arif', 'merlo'),
(32,'bader', 'swan'),
(33,'alain', 'chappelet'),
(34,'adamantios', 'portugali'),
(35,'pradeep', 'makrucki'),
(36,'huan', 'lortz'),
(37,'alexander', 'brender'),
(38,'weiyi', 'meriste'),
(39,'uri', 'lenart'),
(40,'magy', 'stamatiou'),
(41,'yishay', 'tzvieli'),
(42,'mingsen', 'casley'),
(43,'moss', 'shanbhogue'),
(44,'lucien', 'rosenbaum'),
(45,'zvonko', 'nyanchama'),
(46,'florian', 'syrotiuk'),
(47,'basil', 'tramer'),
(48,'yinghua', 'dredge'),
(49,'hidefumi', 'caine'),
(50,'heping', 'nitsch'),
(51,'sanjiv', 'zschoche'),
(52,'mayumi', 'schueller'),
(53,'georgy', 'dredge'),
(54,'brenda', 'bernini'),
(55,'ebbe', 'callaway'),
(56,'berhard', 'mcfarlin'),
(57,'alejandro', 'mcalpine'),
(58,'breannda', 'billingsley'),
(59,'tse', 'herber'),
(60,'anoosh', 'peyn'),
(61,'gino', 'leonhardt'),
(62,'udi', 'jansch'),
(63,'satosi', 'awdeh'),
(64,'kwee', 'schusler'),
(65,'claudi', 'stavenow'),
(66,'charlene', 'brattka'),
(67,'margareta', 'bierman'),
(68,'reuven', 'garigliano'),
(69,'hisao', 'lipner'),
(70,'hirona', 'sidou'),
(71,'shir', 'mcclurg'),
(72,'mokhtar', 'bernatsky'),
(73,'gao', 'dolinsky'),
(74,'erez', 'ritzmann'),
(75,'mona', 'azuma'),
(76,'danel', 'mondadori'),
(77,'kshitij', 'gils'),
(78,'premal', 'baek'),
(79,'zhongwei', 'rosen'),
(80,'parviz', 'lortz'),
(81,'vishv', 'zockler'),
(82,'tuval', 'kalloufi'),
(83,'kenroku', 'malabarba'),
(84,'somnath', 'foote'),
(85,'xinglin', 'eugenio'),
(86,'jungsoon', 'syrzycki'),
(87,'sudharsan', 'flasterstein'),
(88,'kendra', 'hofting'),
(89,'amabile', 'gomatam'),
(90,'valdiodio', 'niizuma'),
(91,'sailaja', 'desikan'),
(92,'arumugam', 'ossenbruggen'),
(93,'hilari', 'morton'),
(94,'jayson', 'mandell'),
(95,'remzi', 'waschkowski'),
(96,'sreekrishna', 'servieres'),
(97,'valter', 'sullins'),
(98,'hironobu', 'haraldson'),
(99,'perla', 'heyers'),
(100,'paraskevi', 'luby'),
(101,'akemi', 'birch'),
(102,'xinyu', 'warwick'),
(103,'hironoby', 'piveteau'),
(104,'eben', 'aingworth'),
(105,'dung', 'baca'),
(106,'lunjin', 'giveon'),
(107,'mariusz', 'prampolini'),
(108,'xuejia', 'ullian'),
(109,'hugo', 'rosis'),
(110,'yuichiro', 'swick'),
(111,'jaewon', 'syrzycki'),
(112,'munir', 'demeyer'),
(113,'chikara', 'rissland'),
(114,'dayanand', 'czap'),
(115,'kiyotoshi', 'blokdijk'),
(116,'zhonghui', 'zyda'),
(117,'domenick', 'peltason'),
(118,'armon', 'fairtlough'),
(119,'guoxia', 'ramsay'),
(120,'ohad', 'esposito'),
(121,'hinrich', 'randi'),
(122,'geraldo', 'marwedel'),
(123,'syozo', 'hiltgen'),
(124,'kayoko', 'valtorta'),
(125,'subir', 'baja'),
(126,'babette', 'lamba'),
(127,'armond', 'peir'),
(128,'nishit', 'casperson'),
(129,'magdalena', 'eldridge'),
(130,'ayakannu', 'skrikant'),
(131,'giri', 'isaak'),
(132,'diederik', 'siprelle'),
(133,'nathan', 'monkewich'),
(134,'zissis', 'pintelas'),
(135,'maren', 'hutton'),
(136,'perry', 'shimshoni'),
(137,'ewing', 'foong'),
(138,'yucel', 'auria'),
(139,'shahan', 'ishibashi'),
(140,'tzvetan', 'hettesheimer'),
(141,'sakthirel', 'bakhtari'),
(142,'marla', 'brendel'),
(143,'kemi', 'esposito'),
(144,'chenyi', 'syang'),
(145,'kazuhito', 'encarnacion'),
(146,'douadi', 'azumi'),
(147,'xiadong', 'perry'),
(148,'zhenbing', 'perng'),
(149,'itzchak', 'lichtner'),
(150,'jaques', 'munro'),
(151,'heekeun', 'majewski'),
(152,'abdulah', 'thibadeau'),
(153,'adas', 'nastansky'),
(154,'sumali', 'fargier'),
(155,'nigel', 'aloisi'),
(156,'khedija', 'mitsuhashi'),
(157,'serif', 'buescher'),
(158,'debatosh', 'khasidashvili'),
(159,'hairong', 'mellouli'),
(160,'florina', 'eugenio'),
(161,'karsten', 'szmurlo'),
(162,'jagoda', 'braunmuhl'),
(163,'miyeon', 'macedo'),
(164,'samphel', 'siegrist'),
(165,'duangkaew', 'rassart'),
(166,'dharmaraja', 'stassinopoulos'),
(167,'sampalli', 'snedden'),
(168,'kasturi', 'jenevein'),
(169,'herbert', 'trachtenberg'),
(170,'shigeu', 'matzen'),
(171,'shrikanth', 'mahmud'),
(172,'badri', 'furudate'),
(173,'aleksandar', 'ananiadou'),
(174,'brendon', 'lenart'),
(175,'pragnesh', 'iisaka'),
(176,'valery', 'litvinov'),
(177,'deniz', 'duclos'),
(178,'shaw', 'wendorf'),
(179,'sibyl', 'nooteboom'),
(180,'moriyoshi', 'merey'),
(181,'mechthild', 'bonifati'),
(182,'mihalis', 'lowrie'),
(183,'duro', 'sidhu'),
(184,'shigehito', 'kropatsch'),
(185,'tommaso', 'narwekar'),
(186,'christ', 'muchinsky'),
(187,'khalid', 'erva'),
(188,'arve', 'fairtlough'),
(189,'zdislav', 'nastansky'),
(190,'mohua', 'falck'),
(191,'masaru', 'cheshire'),
(192,'josyula', 'hofmeyr'),
(193,'annemarie', 'redmiles'),
(194,'marc', 'hellwagner'),
(195,'kasidit', 'krzyzanowski'),
(196,'pranav', 'furedi'),
(197,'kazuhisa', 'ranta'),
(198,'vidya', 'awdeh'),
(199,'idoia', 'kavraki');


select count(*)
from accounts
where username = 'temp1' and password = 'pass1';
*/

    