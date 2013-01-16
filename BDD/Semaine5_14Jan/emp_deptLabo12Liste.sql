DROP TABLE emp CASCADE CONSTRAINTS;
DROP TABLE dept CASCADE CONSTRAINTS;
  

CREATE TABLE dept
        (nodept  number(2) primary key,
        nomd    varchar2(14),
        ville   varchar2(13));
INSERT INTO dept
        values(10,'comptabilite','Montreal');
INSERT INTO dept
        values(20,'recherche','Ottawa');
INSERT INTO dept
        values(30,'ventes','Vancouver');
INSERT INTO dept
        values(40,'operations','Calgary');
INSERT INTO dept
        values(50,'operations','Montreal');

CREATE TABLE emp
        (noemp      number(4) primary key,
        nome        varchar2(10),
        poste       varchar2(10),
        nopatron    number(4) references emp,
        datembauche date,
        sal         number(7,2),
        comm        number(7,2),
        nodept      number(2) references dept);
INSERT INTO emp
        values(7839,'Roy','president',null, 
   to_date('07/04/2008','dd/mm/yyyy'),5000,0,10);
INSERT INTO emp
        values(7782,'Cabana','gestion',7839,to_date('09/05/2007','dd/mm/yyyy'),2450,0,10);
INSERT INTO emp
        values(7698,'Bourque','gestion',7839,to_date('02/06/2009','dd/mm/yyyy'),2850,0,30);
INSERT INTO emp
        values(7844,'Paquette','vendeur',7698,to_date('05/01/2010','dd/mm/yyyy'),1500,0.15,30);
INSERT INTO emp
        values(7566,'Joly','gestion',7839,to_date('09/03/2009','dd/mm/yyyy'),2975,0,50);
INSERT INTO emp
        values(7876,'Adam','commis',7566,to_date('19/04/2009','dd/mm/yyyy'),1100,0,20);
INSERT INTO emp
        values(7900,'Genereux','commis',7698,to_date('08/03/2009','dd/mm/yyyy'),950,0,30);
INSERT INTO emp
        values(7902,'Fontaine','analyste',7566,to_date('09/03/2009','dd/mm/yyyy'),3000,0,50);
INSERT INTO emp
        values(7934,'Parent','commis',7782,to_date('19/03/2009','dd/mm/yyyy'),1300,0,10);
INSERT INTO emp
        values(7369,'Rivet','commis',7902,to_date('22/03/2009','dd/mm/yyyy'),800,0,20);
INSERT INTO emp
        values(7499,'Demers','vendeur',7698,to_date('21/05/2008','dd/mm/yyyy'),1600,0.10,30);
INSERT INTO emp
        values(7521,'Tremblay','vendeur',7698,to_date('22/07/2008','dd/mm/yyyy'),1250,0.05,30);
INSERT INTO emp
        values(7654,'Martin','vendeur',7698,to_date('21/05/2008','dd/mm/yyyy'),1250,0.01,30);

COMMIT;