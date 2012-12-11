
-- =======================================================
PROMPT DESTRUCTION de la table NouvDept
-- =======================================================

DROP TABLE nouveau_departement;
  
-- =======================================================
PROMPT CRÉATION DE LA TABLE NouvDept
-- =======================================================

CREATE TABLE nouveau_departement(
	id  	NUMBER(2) ,
    nom    	VARCHAR2(15),
    ville   VARCHAR2(20));

-- =======================================================
PROMPT INSERTION DES ENREGISTREMENTS DANS LA TABLE NouvDept
-- =======================================================

INSERT INTO nouveau_departement values(15,'publicite','Toronto');
INSERT INTO nouveau_departement values(25,'personnel','Charlottetown');
INSERT INTO nouveau_departement values(50,'immobilisation','Edmonton');
INSERT INTO nouveau_departement values(60,'relpubl','StJean');

COMMIT;