--Auteur: 

--Fichier: Voyage.SQL
--Création d'une base de données pour la gestion d'une agence de voyage



--Mode
set echo off
set feedback on

-- Destruction des tables et séquences
PROMPT DESTRUCTION DES SEQUENCES et des contraintes
DROP SEQUENCE seqClient;
DROP SEQUENCE seqHotel;
DROP SEQUENCE seqVoyage;
DROP SEQUENCE seqContrat;

ALTER TABLE v_contrat DROP CONSTRAINT v_client_cliNo_fk; 
ALTER TABLE v_contrat DROP CONSTRAINT v_voyage_voyNo_fk; 
ALTER TABLE v_VOYAGE DROP CONSTRAINT v_HOTEL_HOTNo_fk; 

PROMPT destruction des tables...
DROP TABLE v_client;
DROP TABLE v_contrat;
DROP TABLE v_hotel;
DROP TABLE v_param;
DROP TABLE v_voyage;

PROMPT Création des séquences
CREATE SEQUENCE seqClient START WITH 124010;
CREATE SEQUENCE seqHotel START WITH 22010;
CREATE SEQUENCE seqVoyage START WITH 3010;
CREATE SEQUENCE seqContrat START WITH 444025;


PROMPT Création des tables et génération des données
-- Création de la TABLE v_client...
CREATE TABLE v_client (
  cliNo         NUMBER(6), 
  cliPrenom     VARCHAR2(20),
  cliNom        VARCHAR2(15),
  cliRue        VARCHAR2(30),
  cliVille      VARCHAR2(12) DEFAULT 'Montréal',
  cliTelephone  CHAR(8),
  CONSTRAINT v_client_CliNo_pk PRIMARY KEY (cliNo));

INSERT INTO v_client VALUES (124000,'Bernard', 'Triton','345 rue Contant','Montréal','568-2835');
INSERT INTO v_client VALUES (124001, 'Maurice','Gagnon','123 rue Beausite','Montréal','344-0987');
INSERT INTO v_client VALUES (124002, 'Gromit', 'Sefresti','8400 rue Montcalm','Montréal','764-0987');
INSERT INTO v_client VALUES (124003, 'Fred', 'Beauchamp','5 chemin du rock','Montréal','987-4545');
INSERT INTO v_client VALUES (124004, 'Paul', 'Tifo','256 Desnoyers','Montréal','987-4545');
INSERT INTO v_client VALUES (124005, 'Danielle', 'Roy','3489 St-Denis','Montréal','923-4545');
INSERT INTO v_client VALUES (124006, 'Denis', 'Chaput','3909 Maisonneuve','Montréal','923-4545');
INSERT INTO v_client VALUES (124007, 'Suzanne', 'Boucher','3496 St-Hubert','Montréal','923-4545');
INSERT INTO v_client VALUES (124008, 'André', 'Dufresne','1211 Iberville','Montréal','923-4545');
COMMIT;
  
-- Création de la TABLE v_contrat...
CREATE TABLE v_contrat (
   conNo         NUMBER(6), 
   conDate       DATE,
   conAcompte    NUMBER(6,2),
   conMontant    NUMBER(6,2),
   conPayer      NUMBER(6,2) DEFAULT 0,
   conTypeOcc    NUMBER(1), 
   cliNo	NUMBER(6),
   voyNo	NUMBER(4),
CONSTRAINT v_contrat_conNo_pk PRIMARY KEY (conNo),
CONSTRAINT v_contrat_conTypeOcc_ck CHECK (conTypeOcc IN (1, 2, 3, 4)));

-- Création de la TABLE v_hotel...
-- Pour la colonne hotPiscine les choix possibles signifient:
--  A: aucune piscine
--  E: piscine extérieure
--  I: piscine intérieure
--  T: piscines intérieure et extérieure
-- Pour la colonne hotCote la cote 1 est la plus basse, 5 la plus haute

INSERT INTO v_contrat VALUES
(444001, TO_DATE('01072000','DDMMYYYY'), 100.00, 940.58, 940.58, 1, 124001, 3002);
INSERT INTO v_contrat VALUES
(444002, TO_DATE('25062000','DDMMYYYY'), 100.00, 940.58, 800.00, 2, 124002, 3002);
INSERT INTO v_contrat VALUES
(444003, TO_DATE('29121999','DDMMYYYY'), 100.00, 940.58, 700.00, 2, 124002, 3002);
INSERT INTO v_contrat VALUES
(444004, TO_DATE('07062000','DDMMYYYY'), 90.00,    1343.21,   90.00, 3, 124003, 3003);
INSERT INTO v_contrat VALUES
(444005, TO_DATE('03062005','DDMMYYYY'), 100.00,    940.58,  250.00, 1, 124003, 3002);
INSERT INTO v_contrat VALUES
(444006, TO_DATE('01012005','DDMMYYYY'), 90.00, 1343.21, 1000.00, 1, 124000, 3003);
INSERT INTO v_contrat VALUES
(444007, TO_DATE('28012005','DDMMYYYY'), 90.00, 1343.21, 1250.00, 2, 124000,3003);
INSERT INTO v_contrat VALUES
(444008, TO_DATE('15022005','DDMMYYYY'), 50.00, 400.70, 350.70, 2, 124001, 3004);
INSERT INTO v_contrat VALUES
(444009,TO_DATE('23022005','DDMMYYYY'), 50.00, 400.70, 250.00, 3,  124001, 3004);
INSERT INTO v_contrat VALUES
(444010, TO_DATE('01042005','DDMMYYYY'), 100.00, 940.58, 940.58, 2, 124002, 3002);
INSERT INTO v_contrat VALUES
(444011, TO_DATE('25032005','DDMMYYYY'), 90.00, 1343.21, 1000.00, 4, 124003, 3003);
INSERT INTO v_contrat VALUES
(444012, TO_DATE('28022005','DDMMYYYY'), 50.00, 400.70, 342.70, 2, 124003, 3004);
INSERT INTO v_contrat VALUES
(444013, TO_DATE('28022005','DDMMYYYY'), 20.00, 109.00, 80.00, 2, 124003, 3005);
INSERT INTO v_contrat VALUES
(444014, TO_DATE('28022005','DDMMYYYY'), 20.00, 125.50, 90.00, 2, 124003, 3006);
INSERT INTO v_contrat VALUES
(444015, TO_DATE('28022005','DDMMYYYY'), 300.00, 1312.40, 1012.40, 2, 124003, 3001);
INSERT INTO v_contrat VALUES
(444016, TO_DATE('28022005','DDMMYYYY'), 90.00, 1343.21, 800.00, 2, 124003, 3003);
INSERT INTO v_contrat VALUES
(444017, TO_DATE('28022005','DDMMYYYY'), 20.00, 125.50, 90.00, 2, 124003, 3006);
INSERT INTO v_contrat VALUES
(444018, TO_DATE('28022005','DDMMYYYY'), 30.00, 143.70, 100.00, 2, 124003, 3007);
INSERT INTO v_contrat VALUES
(444019, TO_DATE('12022006','DDMMYYYY'), 30.00, 143.70, 110.70, 2, 124004, 3007);
INSERT INTO v_contrat VALUES
(444020, TO_DATE('07062006','DDMMYYYY'), 30.00, 143.70, 70.00, 2, 124005, 3007);
INSERT INTO v_contrat VALUES
(444021, TO_DATE('13022006','DDMMYYYY'), 30.00, 143.70, 80.00, 2, 124006, 3007);
INSERT INTO v_contrat VALUES
(444022, TO_DATE('15052001','DDMMYYYY'), 300.00, 1312.40, 1200.00, 2, 124007, 3001);
INSERT INTO v_contrat VALUES
(444023, TO_DATE('22062001','DDMMYYYY'), 1312.40, 1312.40, 900.00, 2, 124008, 3001);
COMMIT;

CREATE TABLE v_Hotel (
   hotNo           NUMBER(5), 
   hotNom          CHAR(25),
   hotCote         NUMBER(1),
   hotPiscine      CHAR(1),    
   hotNbChambreTot NUMBER(3),
CONSTRAINT v_hotel_hotNo_pk PRIMARY KEY (hotNo),
CONSTRAINT v_Hotel_hotCote_ck CHECK (hotCote IN (1,2,3,4,5)),
CONSTRAINT v_Hotel_hotPiscine_ck CHECK (hotPiscine IN ('A','E','I', 'T')));

INSERT INTO v_hotel VALUES (22000,'Ritz,Boston',5,'I',224);
INSERT INTO v_hotel VALUES (22001,'Days INN Boston',3,'A',62);
INSERT INTO v_hotel VALUES (22002,'Cocorico Toronto',4,'E',165);
INSERT INTO v_hotel VALUES (22003,'Gouverneur Tadoussac',3,'E',64);
INSERT INTO v_hotel VALUES (22004,'Maison Dufour,Tadoussac',2,'E',53);
INSERT INTO v_hotel VALUES (22005,'Universel,Montréal',3,'A',65);
INSERT INTO v_hotel VALUES (22006,'Delta Montréal',1,'I',155);
INSERT INTO v_hotel VALUES (22007,'Delta Boston',2,'I',130);
INSERT INTO v_hotel VALUES (22008,'Delta Toronto',3,'E',216);
INSERT INTO v_hotel VALUES (22009,'Bonaventure Montréal',2,'A',202);
COMMIT;

-- Création de la table parametres...
CREATE TABLE v_param (
  tauxTVQ       NUMBER(3,3),
  tauxTPS       NUMBER(3,3),
  minAcompte 	  NUMBER(2,2),
  delaiPaiement NUMBER(3,0));

INSERT INTO v_param VALUES (0.070, 0.080, 0.15, 30);
COMMIT;

-- Création de la TABLE v_voyage...
CREATE TABLE v_voyage (
  voyNo          NUMBER(4), 
  voyDestination CHAR(20),
  voyDateDepart  DATE,
  voyDateArrive  DATE,
  voyRepas       NUMBER(1), 
  voyNbPlace     NUMBER(3,0),
  voyActivité	   VARCHAR2(76),
  hotNo	         NUMBER(5),
  tarifSimple    NUMBER(6,2),
  tarifDouble    NUMBER(6,2),
  tarifTriple    NUMBER(6,2),
  tarifQuadruple NUMBER(6,2),
  nbChambreRes   NUMBER(3),
CONSTRAINT v_voyage_No_pk PRIMARY KEY (voyNo),
CONSTRAINT v_voyage_voyRepas_ck CHECK (voyRepas IN(0,1,2)));

INSERT INTO v_voyage VALUES
(3000, 'Montréal', TO_DATE('15061999','DDMMYYYY'), TO_DATE('17061999','DDMMYYYY'), 2, 46,
'Match des Alouettes,entrée à la ronde',22005, 115, 105, 99, 95, 16);
INSERT INTO v_voyage VALUES
(3001, 'Boston', TO_DATE('05012000','DDMMYYYY'), TO_DATE('15012000','DDMMYYYY'), 1, 34,
'visite du Vieux-Boston et des musées', 22001, 1179, 975, 839, 699, 16);
INSERT INTO v_voyage VALUES
(3002, 'Tadoussac',TO_DATE('02072000','DDMMYYYY'), TO_DATE('24072000','DDMMYYYY'), 2, 6,
'excursion aux baleines,plongée sous-marine',22004, 399, 349, 329, 319, 2);
INSERT INTO v_voyage VALUES 
(3003, 'New-York', TO_DATE('03032000','DDMMYYYY'),TO_DATE('10032000','DDMMYYYY'), 2, 6,
'Visite des musées et des quartiers',22001, 1529, 1399, 1199, 1089, 2);
INSERT INTO v_voyage VALUES
(3004, 'Toronto', TO_DATE('04042001','DDMMYYYY'), TO_DATE('11042001','DDMMYYYY'), 2, 6,
'Visite du quartier chinois et tour CN',22008, 2109, 1999, 1799, 1450, 2);
INSERT INTO v_voyage VALUES
(3005, 'Montréal', TO_DATE('04042000','DDMMYYYY'), TO_DATE('11042000','DDMMYYYY'), 2, 6,
'Biodôme',null, null, null, null, null, 0);
INSERT INTO v_voyage VALUES
(3006, 'Montréal', TO_DATE('04042000','DDMMYYYY'), TO_DATE('11042000','DDMMYYYY'), 2, 6,
'Centre Molson',null, null, null, null, null, 0);
INSERT INTO v_voyage VALUES
(3007, 'Montréal', TO_DATE('04042000','DDMMYYYY'), TO_DATE('11042000','DDMMYYYY'), 2, 6,
'Stade Olympique et Jardin Botanique',null, null, null, null, null, 0);
INSERT INTO v_voyage VALUES
(3008, 'Montréal', TO_DATE('04042000','DDMMYYYY'), TO_DATE('11042000','DDMMYYYY'), 2, 6,
'Musée Juste pour rire et ISI',null, null, null, null, null, 0);
COMMIT;


prompt	Création des contraintes de référence

ALTER TABLE v_contrat 
	ADD CONSTRAINT v_client_cliNo_fk 
	FOREIGN KEY(cliNo) REFERENCES v_client(cliNo);

ALTER TABLE v_contrat 
	ADD CONSTRAINT v_voyage_voyNo_fk 
	FOREIGN KEY(voyNo) REFERENCES v_voyage(voyNo);

ALTER TABLE v_VOYAGE
	ADD CONSTRAINT v_HOTEL_HOTNo_fk 
	FOREIGN KEY(HOTNo) REFERENCES v_HOTEL(HOTNo);

COMMIT;






