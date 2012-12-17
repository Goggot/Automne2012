prompt PL/SQL Developer import file
prompt Created on 11 avril 2006 by suzanne
set feedback off
set define off
prompt Dropping E_COURS...
drop table E_COURS cascade constraints;
prompt Dropping E_PROGRAMME...
drop table E_PROGRAMME cascade constraints;
prompt Dropping E_ETUDIANT...
drop table E_ETUDIANT cascade constraints;
prompt Dropping E_COURSSUIVI...
drop table E_COURSSUIVI cascade constraints;
prompt Dropping E_PROGCOURS...
drop table E_PROGCOURS cascade constraints;

DROP SEQUENCE  E_COURSSUIVINO_seq;

CREATE SEQUENCE E_COURSSUIVINO_seq
  increment by 1
  START WITH 1;
prompt Creating E_COURS...
create table E_COURS(
  COURSNO   VARCHAR2(7) not null,
  COURSNOM  VARCHAR2(75),
  COURSNBH  NUMBER(3),
  COURSNBCR NUMBER(2)
);
alter table E_COURS
  add constraint COURS_PRIMARY_KEY primary key (COURSNO);
 alter table E_COURS
  add constraint COURS_COURSNO_CHECK
  check ("COURSNO" IS NOT NULL);

prompt Creating E_PROGRAMME...
create table E_PROGRAMME
(
  PROGNO      VARCHAR2(7) not null,
  PROGNOM     VARCHAR2(50),
  PROGDIPLOME NUMBER(1),
  STATUT      NUMBER(1),
  SANCTION    VARCHAR2(1)
);
alter table E_PROGRAMME
  add constraint PROGNO primary key (PROGNO);

prompt Creating E_ETUDIANT...
create table E_ETUDIANT
(
  ETUMATRICULE VARCHAR2(8) not null,
   ETUNOM       VARCHAR2(30),
  ETUDATE      DATE,
  ETUADR       VARCHAR2(40),
  ETUTEL      VARCHAR2(10),
  PROGNO       VARCHAR2(6)
);
alter table E_ETUDIANT
  add constraint ETUDIANT_PRIMARY_KEY primary key (ETUMATRICULE);
alter table E_ETUDIANT
  add constraint PROGNOETUPRO foreign key (PROGNO)
  references E_PROGRAMME (PROGNO);
alter table E_ETUDIANT
  add constraint ENTITY_OBJECT1ETUMATRICULE_CH
  check ("ETUMATRICULE" IS NOT NULL);

prompt Creating E_COURSSUIVI...
create table E_COURSSUIVI
(
  ETUMATRICULE  VARCHAR2(8) not null,
  COURSNO        VARCHAR2(7),
  CSUIVISESSION  VARCHAR2(5),
  CSUIVINOTE    NUMBER(3),
  COURSSUIVINO NUMBER(7)
);
alter table E_COURSSUIVI
  add constraint COURSSUIVINO_PRIMARY_KEY primary key (COURSSUIVINO);
alter table E_COURSSUIVI
  add constraint COURSSUIVI_COURSNO foreign key (COURSNO)
  references E_COURS (COURSNO);
alter table E_COURSSUIVI
  add constraint COURSSUIVI_ETUMATRICULE foreign key (ETUMATRICULE)
  references E_ETUDIANT (ETUMATRICULE);

prompt Creating E_PROGCOURS...
create table E_PROGCOURS
(
  PROGNO        VARCHAR2(7) not null,
  COURSNO       VARCHAR2(7) not null,
  PROGCOURSTYPE VARCHAR2(2) not null
);
alter table E_PROGCOURS
  add constraint COURNO foreign key (COURSNO)
  references E_COURS (COURSNO)
  disable;
alter table E_PROGCOURS
  add constraint PROGNOO foreign key (PROGNO)
  references E_PROGRAMME (PROGNO)
  disable;
alter table E_PROGCOURS
  add constraint E_ECOLE_PROGNO_CHECK
  check ("PROGNO" IS NOT NULL);
prompt Loading E_COURS.  
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B11', 'Programmation structurée', 60, 6);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B12', 'Outil et matériels  ', 45, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B21', 'Programmation avancée', 45, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B22', 'Système d''exploitation', 30, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B31', 'Structures de données', 45, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B32', 'Administration Linux ', 45, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B33', 'Concepts de l''orientée objet', 45, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B41', 'Gestion de projet', 45, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B51', 'Dévelopement de système', 45, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B42', 'Exploitation des Bases de données', 45, 3);
insert into E_COURS (COURSNO, COURSNOM, COURSNBH, COURSNBCR)
values ('400-B53', 'Communication', 45, 3);
commit;
prompt 11 records loaded
prompt Loading E_PROGRAMME...
insert into E_PROGRAMME (PROGNO, PROGNOM, PROGDIPLOME, STATUT, SANCTION)
values ('400.10', 'Informatique', 1, 2, 'D');
insert into E_PROGRAMME (PROGNO, PROGNOM, PROGDIPLOME, STATUT, SANCTION)
values ('400.20', 'Informatique', 1, 2, 'A');
insert into E_PROGRAMME (PROGNO, PROGNOM, PROGDIPLOME, STATUT, SANCTION)
values ('400.30', 'Informatique', 0, 1, 'M');
insert into E_PROGRAMME (PROGNO, PROGNOM, PROGDIPLOME, STATUT, SANCTION)
values ('401.10', 'Sciences de la nature', 1, 1, 'D');
insert into E_PROGRAMME (PROGNO, PROGNOM, PROGDIPLOME, STATUT, SANCTION)
values ('401.20', 'Technique  génie  électrique', 1, 1, 'D');
insert into E_PROGRAMME (PROGNO, PROGNOM, PROGDIPLOME, STATUT, SANCTION)
values ('401.30', 'Technique  design industriel', 1, 1, 'D');
commit;
prompt 6 records loaded
prompt Loading E_ETUDIANT...
insert into E_ETUDIANT (ETUMATRICULE, ETUNOM, ETUDATE, ETUADR, ETUTEL, PROGNO)
values ('RONDSU', 'Suzanne Rondeau', to_date('01-01-2006', 'dd-mm-yyyy'), '345 rue des Érables Montréal', '5143468754', '400.10');
insert into E_ETUDIANT (ETUMATRICULE, ETUNOM, ETUDATE, ETUADR, ETUTEL, PROGNO)
values ('DAIGLE', 'Normand Daigle', to_date('07-02-2006', 'dd-mm-yyyy'), '67 rue Édouard ', '5159875421', '400.20');
insert into E_ETUDIANT (ETUMATRICULE, ETUNOM, ETUDATE, ETUADR, ETUTEL, PROGNO)
values ('DAGERO', 'Robert Dagenais', to_date('02-02-2006', 'dd-mm-yyyy'), '23 rue des Ormes', '5147890378', '400.10');
insert into E_ETUDIANT (ETUMATRICULE, ETUNOM, ETUDATE, ETUADR, ETUTEL, PROGNO)
values ('GAGNLI', 'Line Gagnon', to_date('01-03-2001', 'dd-mm-yyyy'), '59 rue Pelletier', '5140976543', '401.10');
insert into E_ETUDIANT (ETUMATRICULE, ETUNOM, ETUDATE, ETUADR, ETUTEL, PROGNO)
values ('CHAPDE', 'Denis Chaput', to_date('22-02-2006', 'dd-mm-yyyy'), '490 rue Gauthier', '5148954323', '400.10');
insert into E_ETUDIANT (ETUMATRICULE, ETUNOM, ETUDATE, ETUADR, ETUTEL, PROGNO)
values ('GIROAL', 'Alain Giroux', to_date('14-02-2006', 'dd-mm-yyyy'), '4967 rue Rita', '5149832456', '400.20');
insert into E_ETUDIANT (ETUMATRICULE, ETUNOM, ETUDATE, ETUADR, ETUTEL, PROGNO)
values ('SENEDI', 'Diane Seney', to_date('22-02-2006', 'dd-mm-yyyy'), '34 rue Fournier', '5146789322', '400.20');
insert into E_ETUDIANT (ETUMATRICULE, ETUNOM, ETUDATE, ETUADR, ETUTEL, PROGNO)
values ('MONCA', 'Catherine Monty', to_date('22-02-2006', 'dd-mm-yyyy'), '790 rue St-Denis', '5136893222', '400.10');
commit;
prompt 8 records loaded
prompt Loading E_COURSSUIVI...
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('CHAPDE', '400-B11', 'A-05', 87, 1);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('DAGERO', '400-B12', 'A-05', 67, 2);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('CHAPDE', '400-B21', 'A-05', 71,3);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('MONCA', '400-B11', 'A-05', 67,4);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('DAIGLE', '400-B11', 'A-05', 77, 5);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('CHAPDE', '400-B32', 'A-05', 88, 6);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('DAGERO', '400-B33', 'A-05', 89, 7);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('CHAPDE', '400-B22', 'H-04', 67, 8);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('CHAPDE', '400-B41', 'H-04', 61,9);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('SENEDI', '400-B51', 'H-04', 78, 10);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('RONDSU', '400-B53', 'H-04', 66, 11);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('RONDSU', '400-B53', 'H-04', 88, 12);
insert into E_COURSSUIVI (ETUMATRICULE, COURSNO, CSUIVISESSION, CSUIVINOTE, COURSSUIVINO)
values ('RONDSU', '400-B51', 'H-04', 82,13);
commit;
prompt 13 records loaded
prompt Loading E_PROGCOURS...
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.10', '400-B11', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.10', '400-B12', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.10', '400-B21', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.10', '400-B22', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.10', '400-B31', 'op');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.10', '400-B32', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B11', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B12', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B21', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B22', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B31', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B32', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B33', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B41', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B42', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B51', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.20', '400-B53', 'op');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.30', '400-B11', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.30', '400-B12', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.30', '400-B21', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.30', '400-B22', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.30', '400-B31', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.30', '400-B32', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('400.30', '400-B33', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('401.10', '400-B53', 'op');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('401.20', '400-B51', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('401.20', '400-B11', 'ob');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('401.20', '400-B21', 'op');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('401.10', '400-B11', 'op');
insert into E_PROGCOURS (PROGNO, COURSNO, PROGCOURSTYPE)
values ('401.10', '400-B31', 'op');
commit;
prompt 30 records loaded
set feedback on
set define on
prompt Done.

