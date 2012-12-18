DROP TABLE emp;
DROP TABLE dept;
  

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
        values(7839,'Roy','president',null,to_date('17/11/81','/dd/mm/yy'),5000,null,10);
INSERT INTO emp
        values(7782,'Cabana','gestion',7839,to_date('09/06/81','/dd/mm/yy'),2450,null,10);
INSERT INTO emp
        values(7698,'Bourque','gestion',7839,to_date('01/9/81','/dd/mm/yy'),2850,null,30);
INSERT INTO emp
        values(7844,'Paquette','vendeur',7698,to_date('08/9/81','/dd/mm/yy'),1500,0,30);
INSERT INTO emp
        values(7566,'Joly','gestion',7839,to_date('02/4/81','/dd/mm/yy'),2975,null,20);
INSERT INTO emp
        values(7876,'Adam','commis',7566,to_date('11/7/87','/dd/mm/yy'),1100,null,20);
INSERT INTO emp
        values(7900,'Genereux','commis',7698,to_date('03/12/81','/dd/mm/yy'),950,null,30);
INSERT INTO emp
        values(7902,'Fontaine','analyste',7566,to_date('03/05/81','/dd/mm/yy'),3000,null,20);
INSERT INTO emp
        values(7934,'Parent','commis',7782,to_date('23/1/82','/dd/mm/yy'),1300,null,10);
INSERT INTO emp
        values(7369,'Rivet','commis',7902,to_date('17/12/80','/dd/mm/yy'),800,null,20);
INSERT INTO emp
        values(7499,'Demers','vendeur',7698,to_date('20/2/81','/dd/mm/yy'),1600,300,30);
INSERT INTO emp
        values(7521,'Tremblay','vendeur',7698,to_date('22/2/81','/dd/mm/yy'),1250,500,30);
INSERT INTO emp
        values(7654,'Martin','vendeur',7698,to_date('28/9/81','/dd/mm/yy'),1250,1400,30);

COMMIT;
