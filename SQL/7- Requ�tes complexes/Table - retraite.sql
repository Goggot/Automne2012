DROP SEQUENCE seq_retraite;

CREATE SEQUENCE seq_retraite
 			INCREMENT BY 10
 			START WITH 1000
 			MAXVALUE 6999;

DROP TABLE retraite;

CREATE TABLE retraite(
	id 				NUMBER(4),
	id_patron 		NUMBER(4),
	id_departement	NUMBER(4),
	nom     		VARCHAR2(10),
	poste			VARCHAR2(20),
	date_embauche 	DATE,
	salaire_retraite NUMBER(7,2),
	commission		NUMBER(7,2)
);

INSERT INTO retraite (id, id_patron, id_departement, nom, poste, date_embauche, salaire_retraite, commission) VALUES
						 (seq_retraite.NEXTVAL,7902, 20, 'Magnan', 'analyste', TO_DATE('05/06/1972','dd/mm/yyyy'), 1200, NULL); 
