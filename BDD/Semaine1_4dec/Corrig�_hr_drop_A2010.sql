Rem


SOLUTION 1:

DROP SEQUENCE departments_seq;
DROP SEQUENCE employees_seq;
DROP SEQUENCE locations_seq;

DROP TABLE regions     CASCADE CONSTRAINTS;
DROP TABLE departments CASCADE CONSTRAINTS;
DROP TABLE locations   CASCADE CONSTRAINTS;
DROP TABLE jobs        CASCADE CONSTRAINTS;
DROP TABLE job_history CASCADE CONSTRAINTS;
DROP TABLE employees   CASCADE CONSTRAINTS;
DROP TABLE countries   CASCADE CONSTRAINTS;  

COMMIT;

OU SOLUTION 2 :

a)détruire la FK department _id de la table employees 
b) drop table JOB HISTORY 
c) détruire les autres tables

OU SOLUTION3 :

pour chacune contrainte et chaque table:

ALTER TABLE  nomdelatable DROP CONSTRAINTS nomdelacontraintes;

DROP TABLE nomdelatable
