
SELECT e.id, e.nom, d.ville
FROM employe e, departement d
WHERE e.id_departement = d.id
