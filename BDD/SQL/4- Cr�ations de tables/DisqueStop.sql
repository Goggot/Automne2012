CREATE TABLE disques(
id              NUMBER(7),
titre           VARCHAR2(255) NOT NULL,
prix            NUMBER(3,2) NOT NULL,
date_sortie     DATE NOT NULL,
quantite        NUMBER(7) NOT NULL,
id_categorie    NUMBER(2) NOT NULL,
id_compositeur  NUMBER(7) NOT NULL,

CONSTRAINT pk_disques PRIMARY KEY(id),
CONSTRAINT uk_disques_id_compositeur UNIQUE(id_compositeur),
CONSTRAINT ck_disques_prix CHECK (prix > 0),
CONSTRAINT ck_disques_date CHECK (date_sortie > TO_DATE('01/01/1900', 'DD/MM/YYYY'))
);

CREATE TABLE compositeurs(
id          NUMBER(7),
groupe      VARCHAR2(255) NOT NULL,
nom_artiste VARCHAR(255) NOT NULL,
id_ville    NUMBER(2) NOT NULL,

CONSTRAINT pk_compositeurs PRIMARY KEY(id),
CONSTRAINT uk_conpositeurs_nom_art UNIQUE(nom_artiste),
CONSTRAINT uk_conpositeurs_nom_groupe UNIQUE(groupe),
CONSTRAINT fk_compositeurs_nom FOREIGN KEY (id) REFERENCES disques(id_compositeur) ON DELETE CASCADE
);

CREATE TABLE categories(
id     NUMBER(2),
nom    VARCHAR(255) NOT NULL,

CONSTRAINT pk_categories PRIMARY KEY(id)
);

CREATE TABLE ville(
id  NUMBER(2),
nom VARCHAR(255) NOT NULL,

CONSTRAINT pk_ville PRIMARY KEY(id)
);

CREATE SEQUENCE seq_disques START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_compositeurs START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_categories START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_ville START WITH 1 INCREMENT BY 1;

INSERT INTO categories (id, nom) VALUES (1, 'Francophone');
INSERT INTO categories (id, nom) VALUES (2, 'Populaire');
INSERT INTO categories (id, nom) VALUES (3, 'Urbain');
INSERT INTO categories (id, nom) VALUES (4, 'Classique');
INSERT INTO categories (id, nom) VALUES (5, 'Autre');