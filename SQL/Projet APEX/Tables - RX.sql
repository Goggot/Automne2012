--Auteur: Sarto Beaudoin
--Date: Novembre 2001
--Fichier: RX.SQL
--Création d'une base de données pour la gestion des prescriptions d'une pharmacie

--Mode
set feedback off

PROMPT ***** Début de la procédure *****

PROMPT Destruction des séquences et des contraintes
DROP SEQUENCE seqClient;
DROP SEQUENCE seqPrescription;
DROP SEQUENCE seqMedicament;
DROP SEQUENCE seqMedecin;
DROP SEQUENCE seqRenou;
ALTER TABLE RX_prescription DROP CONSTRAINT RX_prescription_NoCli_fk;  
ALTER TABLE RX_prescription DROP CONSTRAINT RX_prescription_NoMedi_fk;  
ALTER TABLE RX_prescription DROP CONSTRAINT RX_prescription_NoDoc_fk;    

PROMPT Destruction des tables
DROP TABLE RX_client;
DROP TABLE RX_renouvellement;
DROP TABLE RX_medicament;
DROP TABLE RX_docteur; 
DROP TABLE RX_prescription;
PROMPT Création des séquences
CREATE SEQUENCE seqClient START WITH 20;
CREATE SEQUENCE seqPrescription START WITH 20;
CREATE SEQUENCE seqMedicament START WITH 20;
CREATE SEQUENCE seqMedecin START WITH 20;
CREATE SEQUENCE seqRenou START WITH 20; 

PROMPT Création de la table RX_client
CREATE TABLE RX_client (
  No         NUMBER(6), 
  Prenom     VARCHAR2(20),
  Nom        VARCHAR2(15),
  Rue        VARCHAR2(30),
  Ville      VARCHAR2(12) DEFAULT 'Montréal',
  Telephone  CHAR(10),
  CONSTRAINT RX_client_No_pk PRIMARY KEY (No));

INSERT INTO RX_client VALUES (1,'Bernard', 'Triton','345 rue Contant','Montréal','5145682835');
INSERT INTO RX_client VALUES (2, 'Maurice','Gagnon','123 rue Beausite','Montréal','4503440987');
INSERT INTO RX_client VALUES (3, 'Gromit', 'Sefresti','8400 rue Montcalm','Montréal','5147640987');
INSERT INTO RX_client VALUES (4, 'Fred', 'Beauchamp','5 chemin du rock','Montréal','5149874545');
INSERT INTO RX_client VALUES (5, 'Paul', 'Tifo','256 Desnoyers','Montréal','4509874545');
INSERT INTO RX_client VALUES (6, 'Danielle', 'Roy','3489 St-Denis','Montréal','5149234545');
INSERT INTO RX_client VALUES (7, 'Denis', 'Chaput','3909 Maisonneuve','Montréal','4509234545');
INSERT INTO RX_client VALUES (8, 'Suzanne', 'Boucher','3496 St-Hubert','Montréal','5149234545');
INSERT INTO RX_client VALUES (9, 'André', 'Dufresne','1211 Iberville','Montréal','5149234545');
COMMIT;

PROMPT Création de la table RX_medicament 
CREATE TABLE RX_medicament ( 
   No           NUMBER(5),  
   Nom          CHAR(25), 
   Categorie    CHAR(10),
   Prix   NUMBER(7,2), 
   CONSTRAINT RX_medicament_No_pk PRIMARY KEY (No));  
INSERT INTO RX_medicament VALUES (1,'aspirine','AI',0.50); 
INSERT INTO RX_medicament VALUES (2,'paxil','AD',2.00); 
INSERT INTO RX_medicament VALUES (3,'reactine','AH',1.15); 
INSERT INTO RX_medicament VALUES (4,'valium','SE',2.25); 
INSERT INTO RX_medicament VALUES (5,'tylenol','AN',1.00); 
INSERT INTO RX_medicament VALUES (6,'nadopen','AB',3.00); 
INSERT INTO RX_medicament VALUES (7,'tempra','AN',1.50); 
INSERT INTO RX_medicament VALUES (8,'advil','AI',1.75); 
INSERT INTO RX_medicament VALUES (9,'dilaudid','AN',2.50); 
INSERT INTO RX_medicament VALUES (10,'antarene','AI',3.00); 
INSERT INTO RX_medicament VALUES (11,'ecoprofen','AI',3.00); 
INSERT INTO RX_medicament VALUES (12,'prozac','AD',6.00); 
INSERT INTO RX_medicament VALUES (14,'claritin','AH',0.75); 

PROMPT Création de la table RX_docteur 
CREATE TABLE RX_docteur ( 
  No          NUMBER(4),  
  Prenom     VARCHAR2(20),  
  Nom        VARCHAR2(25),  
  Rue        VARCHAR2(30),  
  Ville      VARCHAR2(20) DEFAULT 'Montréal',  
  Telephone  CHAR(10),  
CONSTRAINT RX_docteur_No_pk PRIMARY KEY (No)); 
INSERT INTO RX_docteur VALUES (1,'Sarto','Beaudoin','255 est rue Ontario','Montréal','5149823437'); 
INSERT INTO RX_docteur VALUES (2,'Sylvie','Perreault','500 Sherbrooke','Montréal','5149825278'); 
INSERT INTO RX_docteur VALUES (3,'Suzanne','Rondeau','2653 Saint-Denis','Montréal','5145623457'); 
INSERT INTO RX_docteur VALUES (4,'Eric','Labonté','3428 Saint-Norbert','Repentigny','4507823437'); 
INSERT INTO RX_docteur VALUES (5,'Laszlo','Feher','152 Jean-Talon','Longueil','4507923437'); 
INSERT INTO RX_docteur VALUES (6,'Michelle','Girard','2538 Langelier','Montréal','5145274639'); 
INSERT INTO RX_docteur VALUES (7,'Daniel','Bourry','345 Queen','Sherbrooke','4503643437'); 
INSERT INTO RX_docteur VALUES (8,'Yvan','Beaupré','1219 Flamarion','Montréal','5144563437'); 
INSERT INTO RX_docteur VALUES (9,'Jean','Deschamps','1729 Viau','Montréal','5149821836'); 
  
PROMPT Création de la table RX_prescription
CREATE TABLE RX_prescription (
   No         NUMBER(6), 
   DatePres   DATE,
   NoMedi    NUMBER(6),
   Quantite    NUMBER(4),
   NbRenou number(3),
   NoCli	NUMBER(6),
   NoDoc	NUMBER(6),
CONSTRAINT RX_prescription_No_pk PRIMARY KEY (No));

INSERT INTO RX_prescription VALUES (1,TO_DATE('01072001','DDMMYYYY'),1,50,3,1,4);
INSERT INTO RX_prescription VALUES (2,TO_DATE('15072001','DDMMYYYY'),1,25,4,2,5); 
INSERT INTO RX_prescription VALUES (3,TO_DATE('22072001','DDMMYYYY'),2,40,5,3,6); 
INSERT INTO RX_prescription VALUES (4,TO_DATE('28072001','DDMMYYYY'),2,50,3,4,7); 
INSERT INTO RX_prescription VALUES (5,TO_DATE('01082001','DDMMYYYY'),3,20,4,5,8); 
INSERT INTO RX_prescription VALUES (6,TO_DATE('12082001','DDMMYYYY'),3,30,5,6,9); 
INSERT INTO RX_prescription VALUES (7,TO_DATE('15082001','DDMMYYYY'),4,50,6,7,1); 
INSERT INTO RX_prescription VALUES (8,TO_DATE('17082001','DDMMYYYY'),4,40,1,8,2); 
INSERT INTO RX_prescription VALUES (9,TO_DATE('22082001','DDMMYYYY'),5,29,2,9,3); 
INSERT INTO RX_prescription VALUES (10,TO_DATE('24082001','DDMMYYYY'),5,30,0,1,4); 
INSERT INTO RX_prescription VALUES (11,TO_DATE('26082001','DDMMYYYY'),6,20,0,1,5); 
INSERT INTO RX_prescription VALUES (12,TO_DATE('28082001','DDMMYYYY'),6,50,0,2,6); 
INSERT INTO RX_prescription VALUES (13,TO_DATE('01092001','DDMMYYYY'),7,50,3,3,6); 
INSERT INTO RX_prescription VALUES (14,TO_DATE('08092001','DDMMYYYY'),7,29,3,4,7); 
INSERT INTO RX_prescription VALUES (15,TO_DATE('12092001','DDMMYYYY'),8,40,2,5,8); 
INSERT INTO RX_prescription VALUES (16,TO_DATE('18092001','DDMMYYYY'),8,20,1,6,9); 
INSERT INTO RX_prescription VALUES (17,TO_DATE('24092001','DDMMYYYY'),9,30,1,7,1); 
INSERT INTO RX_prescription VALUES (18,TO_DATE('26092001','DDMMYYYY'),9,30,3,8,2); 
INSERT INTO RX_prescription VALUES (19,TO_DATE('01102001','DDMMYYYY'),10,40,3,9,3); 
INSERT INTO RX_prescription VALUES (20,TO_DATE('01102001','DDMMYYYY'),10,50,0,1,4);
INSERT INTO RX_prescription VALUES (21,TO_DATE('16102001','DDMMYYYY'),11,40,2,2,5);
INSERT INTO RX_prescription VALUES (22,TO_DATE('18102001','DDMMYYYY'),12,60,3,3,6);
INSERT INTO RX_prescription VALUES (23,TO_DATE('02112001','DDMMYYYY'),12,70,1,4,7);
INSERT INTO RX_prescription VALUES (24,TO_DATE('04112001','DDMMYYYY'),12,30,0,5,8);
INSERT INTO RX_prescription VALUES (25,TO_DATE('29112001','DDMMYYYY'),14,30,3,6,9);



PROMPT Création de la table RX_renouvellement 
CREATE TABLE RX_renouvellement ( 
  No         NUMBER(6),  
  NoPres     number(6),
CONSTRAINT RX_renouvellement_No_pk PRIMARY KEY (No)); 

INSERT INTO RX_renouvellement VALUES (1,16);
INSERT INTO RX_renouvellement VALUES (2,5);
INSERT INTO RX_renouvellement VALUES (3,3);
INSERT INTO RX_renouvellement VALUES (4,5);
INSERT INTO RX_renouvellement VALUES (5,7);
INSERT INTO RX_renouvellement VALUES (6,7);
INSERT INTO RX_renouvellement VALUES (7,5);




prompt	Création des contraintes de référence
ALTER TABLE RX_prescription 
	ADD CONSTRAINT RX_prescription_NoCli_fk  
	FOREIGN KEY(NoCli) REFERENCES RX_client(No) on delete cascade; 
ALTER TABLE RX_prescription  
	ADD CONSTRAINT RX_prescription_NoMedi_fk  
	FOREIGN KEY(NoMedi) REFERENCES RX_medicament(No); 
ALTER TABLE RX_prescription
	ADD CONSTRAINT RX_prescription_NoDoc_fk  
	FOREIGN KEY(NoDoc) REFERENCES RX_docteur(No); 
ALTER TABLE RX_renouvellement
	ADD CONSTRAINT RX_renouvellement_NoPres_fk  
	FOREIGN KEY(NoPres) REFERENCES RX_prescription(No) on delete cascade; 
	
	
DROP TABLE RX_Categorie;

CREATE TABLE RX_Categorie
(CodeCat  VARCHAR2(4) PRIMARY KEY,
NomCat   VARCHAR2(25) ,
Section     NUMBER(4));

INSERT INTO RX_Categorie
VALUES ('AB','antibiotique',2);

INSERT INTO RX_Categorie
VALUES ('AD','antidépresseur',4);

INSERT INTO RX_Categorie
VALUES ('AH','antihistaminique',6);

INSERT INTO RX_Categorie
VALUES ('AI','anti-inflammatoire',5);

INSERT INTO RX_Categorie
VALUES ('AN','analgésique',5);

INSERT INTO RX_Categorie
VALUES ('SE','sédatif',7);

prompt ***** Fin de la procédure *****