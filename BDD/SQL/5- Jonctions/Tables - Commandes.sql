DROP TABLE  Categories;
DROP TABLE  Clients;
DROP TABLE  Commandes;
DROP TABLE  Details_Commandes;
DROP TABLE  Employes;
DROP TABLE  Fournisseurs;
DROP table Produits;

CREATE TABLE Categories
(Code_Categorie    NUMBER(6) PRIMARY KEY,
Nom_Categorie   VARCHAR2(25),
Description  VARCHAR2(100) );

CREATE TABLE Clients
(Code_Client    VARCHAR2(5) PRIMARY KEY,
Societe   VARCHAR2(40),
Adresse    VARCHAR2(60),
Ville  VARCHAR2(30),
Code_Postal  VARCHAR2(10),
Pays  VARCHAR2(15),
Telephone   VARCHAR2(24),
Fax   VARCHAR2(24));

CREATE TABLE Commandes
(No_Commande   NUMBER(6) PRIMARY KEY,
Code_Client   VARCHAR2(5),
No_Employe   NUMBER(6),
Port  NUMBER(8,2));

CREATE TABLE Details_Commandes
(No_Commande   NUMBER(6)  ,
Ref_Produit  NUMBER(6),
Prix_Unitaire  NUMBER(8,2),
Quantite     NUMBER(5),
Remise   NUMBER(8,2));

CREATE TABLE Employes
(No_Employe    NUMBER(6) PRIMARY KEY,
Rend_Compte  NUMBER(6),
Nom    VARCHAR2(40),
Prenom  VARCHAR2(30),
Fonction  VARCHAR2(30),
Titre  VARCHAR2(5),
Date_Naissance   DATE,
Date_Embauche  DATE,
Salaire  NUMBER(8,2),
Commission   NUMBER(8,2));

CREATE TABLE Fournisseurs
(No_Fournisseur    NUMBER(6) PRIMARY KEY,
Société   VARCHAR2(40),
Adresse   VARCHAR2(60),
Ville    VARCHAR2(30),
Code_Postal   VARCHAR2(10),
Pays   VARCHAR2(15),
Telephone   VARCHAR2(24),
Fax   VARCHAR2(24));

CREATE TABLE Produits
(Ref_Produit   NUMBER(6) PRIMARY KEY,
Nom_Produit   VARCHAR2(40),
No_Fournisseur  NUMBER(6),
Code_Categorie   NUMBER(6),
Quantité   VARCHAR2(30),
Prix_Unitaire   NUMBER(8,2),
Unites_Stock    NUMBER(5),
Unites_Commandees  NUMBER(5),
Indisponible  NUMBER(1));