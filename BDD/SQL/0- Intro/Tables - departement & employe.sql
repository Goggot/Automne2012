SET ECHO OFF

-- =======================================================
PROMPT DESTRUCTION DES TABLES
-- =======================================================

DROP TABLE employe;
DROP TABLE departement;  


-- =======================================================
PROMPT CRÉATION DES TABLES
-- =======================================================

CREATE TABLE departement (
	id		NUMBER(2),
	nom 	VARCHAR2(15),
	ville	VARCHAR2(20),
	CONSTRAINT pk_dept PRIMARY KEY (id)
);

CREATE TABLE employe (
	id				NUMBER(4),
	id_departement	NUMBER(2),
	id_patron		NUMBER(4),
	nom				VARCHAR2(15),
	poste       	VARCHAR2(10),
	date_embauche 	DATE,
	salaire			NUMBER(7,2),
	commission		NUMBER(7,2),
	CONSTRAINT pk_emp PRIMARY KEY (id),
	CONSTRAINT fk_emp_dept FOREIGN KEY (id_departement) REFERENCES departement(id),
	CONSTRAINT fk_emp_patron FOREIGN KEY (id_patron) REFERENCES employe(id)
);

-- =======================================================
PROMPT INSERTION DES ENREGISTREMENTS DANS LES TABLES
-- =======================================================

INSERT INTO departement VALUES (10,'comptabilite','Montreal');
INSERT INTO departement VALUES (20,'recherche','Ottawa');
INSERT INTO departement VALUES (30,'ventes','Vancouver');
INSERT INTO departement VALUES (40,'operations','Calgary');

INSERT INTO employe VALUES (7839,null,null,'Roy','president',to_date('17/11/1981','dd/mm/yyyy'),5000,null);
INSERT INTO employe VALUES (7782,10,7839,'Cabana','gestion',to_date('9/6/1981','dd/mm/yyyy'),2450,null);
INSERT INTO employe VALUES (7698,30,7839,'Bourque','gestion',to_date('01/9/1981','dd/mm/yyyy'),2850,null);
INSERT INTO employe VALUES (7844,30,7698,'Paquette','vendeur',to_date('08/9/1981','dd/mm/yyyy'),1500,0);
INSERT INTO employe VALUES (7566,20,7839,'Joly','gestion',to_date('02/4/1981','dd/mm/yyyy'),2975,null);
INSERT INTO employe VALUES (7876,20,7566,'Adam','commis',to_date('11/7/1987','dd/mm/yyyy'),1100,null);
INSERT INTO employe VALUES (7900,30,7698,'Genereux','commis',to_date('03/12/1981','dd/mm/yyyy'),950,null);
INSERT INTO employe VALUES (7902,20,7566,'Fontaine','analyste',to_date('03/05/1981','dd/mm/yyyy'),3000,null);
INSERT INTO employe VALUES (7934,10,7782,'Parent','commis',to_date('23/1/1982','dd/mm/yyyy'),1300,null);
INSERT INTO employe VALUES (7369,20,7902,'Rivet','commis',to_date('17/12/1980','dd/mm/yyyy'),800,null);
INSERT INTO employe VALUES (7499,30,7698,'Demers','vendeur',to_date('20/2/1981','dd/mm/yyyy'),1600,300);
INSERT INTO employe VALUES (7521,30,7698,'Tremblay','vendeur',to_date('22/2/1981','dd/mm/yyyy'),1250,500);
INSERT INTO employe VALUES (7654,30,7698,'Martin','vendeur',to_date('28/9/1981','dd/mm/yyyy'),1250,1400);
INSERT INTO employe VALUES (7788,20,7566,'Bergeron','analyste',to_date('07/06/1987','dd/mm/yyyy'),3000,NULL);

COMMIT;

SET ECHO ON
