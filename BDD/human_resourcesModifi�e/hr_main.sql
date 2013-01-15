rem
rem Header: hr_main.sql 09-jan-01
rem
rem Copyright (c) 2001, Oracle Corporation.  All rights reserved.  
rem
rem Owner  : ahunold
rem
rem NAME
rem   hr_main.sql - Main script for HR schema
rem
rem DESCRIPTON
rem   HR (Human Resources) is the smallest and most simple one 
rem   of the Sample Schemas
rem   
rem NOTES
rem   Run as SYS or SYSTEM
rem
rem MODIFIED   (MM/DD/YY)
rem   ahunold   08/28/01 - roles
rem   ahunold   07/13/01 - NLS Territory
rem   ahunold   04/13/01 - parameter 5, notes, spool
rem   ahunold   03/29/01 - spool
rem   ahunold   03/12/01 - prompts
rem   ahunold   03/07/01 - hr_analz.sql
rem   ahunold   03/03/01 - HR simplification, REGIONS table
rem   ngreenbe  06/01/00 - created
rem   le 15 oct enlever le analz, ajouter un champ mot de passe à Employees

SET ECHO OFF


ALTER SESSION SET NLS_LANGUAGE=American;
ALTER SESSION SET NLS_TERRITORY=America;

--
-- create tables, sequences and constraint
--
--
@ c:\human_resourcesModifiée\hr_drop

--@?/demo/schema/human_resources/hr_cre

@ c:\human_resourcesModifiée\hr_cre

-- populate tables
--@?/demo/schema/human_resources/hr_popul

@ c:\human_resourcesModifiée\hr_popul


-- create indexes


--@?/demo/schema/human_resources/hr_idx

--@ c:\human_resources\hr_idx
-- create procedural objects
--

--@?/demo/schema/human_resources/hr_code
--@ c:\human_resources\hr_code

-- add comments to tables and columns

--@?/demo/schema/human_resources/hr_comnt

--@ c:\human_resources\hr_comnt
-- gather schema statistics
--

--rem @?/demo/schema/human_resources/hr_analz

spool off
