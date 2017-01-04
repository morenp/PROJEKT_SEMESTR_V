--------------------------------------------------------
--  File created - �roda-stycznia-04-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CARRIAGES
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."CARRIAGES" 
   (	"CARRIAGE_ID" NUMBER(*,0), 
	"CLASS" NUMBER(*,0), 
	"TRAIN_ID" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table COMPARTMENTS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."COMPARTMENTS" 
   (	"COMPARTMENT_ID" NUMBER(*,0), 
	"CARRIAGE_ID" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EXECUTE_RELATIONS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."EXECUTE_RELATIONS" 
   (	"EXEC_RELATION_ID" NUMBER(*,0), 
	"TRAIN_ID" NUMBER(*,0), 
	"RELATION_ID" NUMBER(*,0), 
	"DATE_FROM" DATE, 
	"DATE_TO" DATE, 
	"TIME_FROM" TIMESTAMP (6), 
	"TIME_TO" TIMESTAMP (6)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RELATIONS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."RELATIONS" 
   (	"RELATION_ID" NUMBER(*,0), 
	"STATION_ID_FROM" NUMBER(*,0), 
	"STATION_ID_TO" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RESERVATIONS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."RESERVATIONS" 
   (	"RESERVATION_ID" NUMBER(*,0), 
	"TICKET_ID" NUMBER(*,0), 
	"USER_ID" NUMBER(*,0), 
	"COST" NUMBER(8,2), 
	"DATE" DATE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table SEATS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."SEATS" 
   (	"SEAT_ID" NUMBER(*,0), 
	"COMPARTMENT_ID" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table STATIONS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."STATIONS" 
   (	"STATION_ID" NUMBER(*,0), 
	"NAME" VARCHAR2(30 BYTE), 
	"CITY" VARCHAR2(30 BYTE), 
	"ADDRESS" VARCHAR2(60 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TICKETS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."TICKETS" 
   (	"TICKET_ID" NUMBER(*,0), 
	"TYPE" NUMBER(*,0), 
	"PRICE" NUMBER(8,2), 
	"STATUS" VARCHAR2(30 BYTE), 
	"VALID_TILL" DATE, 
	"EXEC_RELATION_ID" NUMBER(*,0), 
	"SEAT_ID" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table TRAINS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."TRAINS" 
   (	"TRAIN_ID" NUMBER(*,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "RAILWAY"."USERS" 
   (	"USER_ID" NUMBER(*,0), 
	"NAME" VARCHAR2(30 BYTE), 
	"LAST_NAME" VARCHAR2(30 BYTE), 
	"EMAIL" VARCHAR2(30 BYTE), 
	"ADDRESS" VARCHAR2(50 BYTE), 
	"DATE_OF_REGISTRATION" DATE, 
	"PASSWORD" VARCHAR2(120 BYTE), 
	"PHONE_NUMBER" VARCHAR2(20 BYTE), 
	"STATUS" VARCHAR2(30 BYTE) DEFAULT 'user'
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into RAILWAY.CARRIAGES
SET DEFINE OFF;
REM INSERTING into RAILWAY.COMPARTMENTS
SET DEFINE OFF;
REM INSERTING into RAILWAY.EXECUTE_RELATIONS
SET DEFINE OFF;
REM INSERTING into RAILWAY.RELATIONS
SET DEFINE OFF;
REM INSERTING into RAILWAY.RESERVATIONS
SET DEFINE OFF;
REM INSERTING into RAILWAY.SEATS
SET DEFINE OFF;
REM INSERTING into RAILWAY.STATIONS
SET DEFINE OFF;
REM INSERTING into RAILWAY.TICKETS
SET DEFINE OFF;
REM INSERTING into RAILWAY.TRAINS
SET DEFINE OFF;
REM INSERTING into RAILWAY.USERS
SET DEFINE OFF;
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('9','Jan','Kowalski','jkowal@gmail.com','qwertyuiop',to_date('16/12/20','RR/MM/DD'),'llIYlkzIQO8QAwVRrxG8ouhDs96Cdcbs/GZ8dpOTRA0=$IRRJq5upVehkudvRBmU9zjBNzwqAdjk33FR/eo1Vqws=','123-456-789','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('3','Zbyszek','Wodecki','zw@gmail.com','Garncarska 48 Poznan',to_date('15/08/08','RR/MM/DD'),'h1Kb7TBxX9vWmLaKsbNZnCn81qBGugakcPgPIjX5DOU=$xAL+PjWjXPMZj6HysRFGx1JKu1PR6CYIsA86+Wxvxjs=','555-555-555','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('5','j','k','jk@gmail.com','qq',to_date('16/12/17','RR/MM/DD'),'Jmb8K3jL0aIxrsWadTruavBqja1owrJcnrpd5aC9Cv0=$FW7OyLpl+4GE+sF8E6L+MuSvpex+o8tJCKODgtQf5PI=','qq','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('6','Marcin','Pancerz','marcin2523@o2.pl','Wodna 45 Krakow',to_date('16/12/17','RR/MM/DD'),'yWa30qQRJgKYdifVpFEg8bBqlLC5n7LHsw2TmLlh7uY=$hCmqePeb8KkAUQ0PV/hyRHNJkYIbdCvscDMc/x+AVQ4=','884-555-999','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('8','Jan','Kowalski','jjkowalski@gmail.com','qwertyuiop',to_date('16/12/20','RR/MM/DD'),'qw3xIUeHUSLv1BHfkKs5TxLkmLLEew2ii+6vfIuzTCg=$fu4cZKE0d4TxRP0nGG0KIB/GlwCWQDIr/bynaSz6gVo=','536-947-475','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('14','Joanna','XYZ','xyz@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'2t3ytbQgSLpu2wgH9XuT1Jp+TPTktwxb/p3o51xiuy0=$VYga3tBJwneObp5b30tTovKP5z9MqtCg6Mod5evamUs=','853-726-294','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('15','Bozena','Kowalik','bkowalik@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'fEeFZbqySP42FLudlapOnDJoKpKYB9tfyfe628Yy8Js=$M5snTellYOS1UINZiSVuKDJe9b29DWbSUL+67ALh1Is=','152-475-374','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('17','ddd','ddd','ddd@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'gPXDKst1iLOIcoqtl6DImgmusIMUcQX0zFoJsnaIIqU=$2zUigqkw0uGy/EdMm666mSNDqAzG7/ARLI0NGCqiyxY=','144-432-412','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('18','aaa','aaa','a1@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'Hb9cQ8hxHw2oMjrKRyKbwjFv9FduOOco23ooOLtOQDI=$i9rs1qGlIqVfU13AD3JPgKPHeoI/xlGsqA5gAGmEfcQ=','658235295','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('19','kkk','kkk','kkk@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'/5vrZfgyJCFtl+hBfx/Zpotmzv20XW34+5amj5aXFdM=$vjFNd3uvWegacAH7I9z4wgoXayydAz73M6bRo08V638=','65326-5737-529','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('20','ddd','d','d1@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'TlI7iXHFlb4simAdYSi8eMvf9jL4ckAoivCApgVg27A=$qIdOwVKKqS/CE178dv/N2RiFfV8gUuh3o0VJ6u/gBuM=','432156528548','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('21','Maria','Bryk','mbryk@gmail.com','qwertyuiop',to_date('16/12/27','RR/MM/DD'),'PS/jST5EVHDwokE4qqjFrH3oVEBSsyIeIry9A/tZ3LY=$dG0TLGyY99hd34mfFemgGjfiIh+risjhD8TAHSrXPL8=','71552395623','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('27','jaa','jaa','jaa@gmail.com','qwertyuiop',to_date('16/12/27','RR/MM/DD'),'6cj6cv7fgtwlylzSCr8uHRpb+ytb6sliJKQakfkW960=$B8MR0qeal8F8SGobgGva6VuKybgrdnq1zucGnkgPrAY=','6547835757','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('29','qw12','qw12','qw12@gmail.com','qwertyuiop',to_date('16/12/27','RR/MM/DD'),'PbiCsOlO3EBAZPy8nEGKIkF20Np9ZPvvkCVOXa4dJG4=$ljRUnI0CO+jG5MdlCrIBjau96KuvPNzqJANuYNLl1Gg=','6546487465','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('32','stanislaw','m','sm@gmail.com','gfeje',to_date('16/12/27','RR/MM/DD'),'Q0fH9T/Al8MuWLyhj0UxVE1pWy6nB4dukF1et9C3iCY=$dVzUKddSqdx4KKFJPhEtzjvXl7nDONfmifrWaFzDzds=','nfreg','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('4','Jan','Kowalski','jkowalski@gmail.com','xyz',to_date('16/12/17','RR/MM/DD'),'hhh','999-999-999','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('10','Anna','Kmiecik','akmiecik@gmail.com','Topolowa 25 Gdynia',to_date('16/12/21','RR/MM/DD'),'ZRZCVsh0IAifADhF6IWher2TQKr9bwau5C/MPbNZW/I=$sPbqa5TEkaaeQAoIpAk6hlcuiPOawI4XGReyy5drWmo=','831-465-741','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('11','Anna','Wolna','awolna@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'eGyz5Xyj78ghWzHIEJA6GhQkH9pYfgo8kyULZ5SyZvQ=$sZR12QyCnY8FBIEX8QH3cI46RAUzJYf4ONI2dzw7DJs=','261-596-938','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('12','Jan','Wolny','jwolny@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'CWYqOqlRTozLvEY0l76kDpdFwZiHLTkI08wzI3nzuQU=$dKS8vTi8vO9Oft7TGCxwKhtlH2vgOkbSfHnWycgpKGE=','123-624-536','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('13','Annnna','Pancerz','apancerz@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'1EPm5XORjuReD5a28H+FLzbXuE4I/N11TmdqtNXW+70=$OhKoBzoq/3kic3majZFDuH34onTg9CG8GIUpWf2MkpY=','123-456-789','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('23','sss','sss','sss@gmail.com','qwertyuiop',to_date('16/12/27','RR/MM/DD'),'uSiOX/I4/UJsBedC0cx3y3MJJAmKoLgwdfihvQ6qses=$h3ovKz9faDU6dtJYQwsTzDcrKDpULo6IcVEEXuNwIQE=','461385612','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('24','Julian','Nowicki','rrr@gmail.com','Krakowska 56 Warszawa',to_date('16/12/27','RR/MM/DD'),'M5uCnJI9iwo2nfxqrPL7PjmpR5Lrm6eTw9fsO6ArmIQ=$1/zLjzFvfx6tnzMKA+pSvukwOl3w7XO4nH/08F39dYQ=','762-535-217','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('1','Mikołaj','Kowalski','mkowalski@gmail.com','Poznańska 58 Wrocław',to_date('15/03/17','RR/MM/DD'),'h1Kb7TBxX9vWmLaKsbNZnCn81qBGugakcPgPIjX5DOU=$xAL+PjWjXPMZj6HysRFGx1JKu1PR6CYIsA86+Wxvxjs=','864-946-645','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('2','Marcin','Kowalski','anowak@gmail.com','Kwiatowa 28 Warszawa',to_date('15/08/16','RR/MM/DD'),'Ie0zM5ZSAoRNzPNMGtSyIZDsa9sMfkY5tlLiOmdgr8M=$VAttu3nG2NrugpY4jpzByG7F986rYPKFqJ0Yysrtq4E=','300-500-800','admin');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('7','Anna','Kowalczyk','akowalczyk@o2.pl','Slowackiego 45 Katowice',to_date('16/12/17','RR/MM/DD'),'cRQRXOIl/W2+uyNF85Jf4yCHxYaoP2yMUFaRBICpCag=$LR0+5G9nK/xOnVmiGCtjjmkZfmBnqCou8ZgjS8fJvzg=','882-417-468','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('16','Alicja','Kwok','akwok@gmail.com','qwertyuiop',to_date('16/12/26','RR/MM/DD'),'Wezd6C843a62M9FwhOVqIcdn9tlqpWs/UBC3lSHm1Hs=$H9a6MDBzS12LVqrKzLa3JNsD++Ar/qe8wgCgzuufIZs=','123-567-895','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('22','Dariusz','Nowobilski','dnowobilski@gmail.com','Grodzka 39/12 Krakow',to_date('16/12/27','RR/MM/DD'),'/f45jjsyRqy0V/p1KE8atBngNpW44Re0Fj8zLSFQTNk=$FioOMjgYeAsMmoqUbqMXK9su+yw67EmJV4cY8G2TLLQ=','548-754-698','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('25','aaa','sss','as@gmail.com','g',to_date('16/12/27','RR/MM/DD'),'USJcacpzZYjWYH2KnpL2N6QidSz7rNIZR1VlaEutK6E=$hzfMs5zCp4XEyiRkqxT+7QFkVUgwfM+3F/+WUh0NMm0=','g','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('26','Anna','Janta','ajanta@gmail.com','qwertyuiop',to_date('16/12/27','RR/MM/DD'),'uzM+ffl96rSstKBnfAQSAPvzECQr1GQZi7fDHxuOOMI=$pqBlUNzu5skb/jxzqcRfoq7VctYJD1aq516rXqwhmNA=','65318589','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('28','qwe','qwe','qwe@gmail.com','fwac',to_date('16/12/27','RR/MM/DD'),'3DeLbYRI6pRrievSb/b4YBkn3TqyUzDnY+Y7DtJ0Nfw=$CC7EutGOotEeNq/Lqd0Z3Ygzgj/GM1Jrv6K0wc5APMk=','gce','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('30','agnieszka','kowalska','agakowalska@gmail.com','Siwa 46, Skawina',to_date('16/12/27','RR/MM/DD'),'J6qKikOFJ7WmIPiSR1LpxuxENwf0vJNWIVjNtSXuvEY=$IrZL6DlWxhHJg1njE98enX9kKSC/GVQanoT2LaV322Y=','652-355-353','user');
Insert into RAILWAY.USERS (USER_ID,NAME,LAST_NAME,EMAIL,ADDRESS,DATE_OF_REGISTRATION,PASSWORD,PHONE_NUMBER,STATUS) values ('31','na','sh','sf@gmail.com','evwyjg',to_date('16/12/27','RR/MM/DD'),'ARj+yEzbua3qHBBZe0oM42I7txfUVYU9X+9fgCMn0/w=$edr/9WKleU85UrMIY12wr+1i1cXo152/84BYgQCOI/o=','sjhsd','user');
--------------------------------------------------------
--  DDL for Index I_USERID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "RAILWAY"."I_USERID_PK" ON "RAILWAY"."USERS" ("USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Procedure CREATE_USER
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "RAILWAY"."CREATE_USER" (
  usr_name in USERS.NAME%TYPE,
  usr_last_name in USERS.LAST_NAME%TYPE,
  usr_email in USERS.EMAIL%TYPE,
  usr_password in USERS.PASSWORD%TYPE,
  usr_address in USERS.ADDRESS%TYPE,
  usr_phone_number in USERS.PHONE_NUMBER%TYPE
)IS
  usr_date USERS.DATE_OF_REGISTRATION%TYPE;
  usr_id  USERS.USER_ID%TYPE;
  
  BEGIN
  SELECT SYSDATE into usr_date from dual;
  Select max(user_id) into usr_id from users ;
  usr_id := usr_id +1;

  INSERT INTO USERS 
  ( USER_ID, NAME, LAST_NAME, EMAIL, ADDRESS, DATE_OF_REGISTRATION, PASSWORD, PHONE_NUMBER) values
  ( usr_id,usr_name, usr_last_name,usr_email,usr_address,usr_date, usr_password,usr_phone_number);
  
END create_user;

/
--------------------------------------------------------
--  DDL for Procedure UPDATE_PROFILE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "RAILWAY"."UPDATE_PROFILE" (
usr_id in USERS.USER_ID%TYPE,
usr_name in USERS.NAME%TYPE,
usr_last_name in USERS.LAST_NAME%TYPE,
usr_address in USERS.ADDRESS%TYPE,
usr_phone_number in USERS.PHONE_NUMBER%TYPE
)IS
BEGIN
UPDATE USERS 
SET NAME = usr_name, LAST_NAME = usr_last_name, ADDRESS = usr_address, PHONE_NUMBER = usr_phone_number WHERE usr_id = USER_ID;
END update_profile;

/
--------------------------------------------------------
--  Constraints for Table EXECUTE_RELATIONS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" ADD PRIMARY KEY ("EXEC_RELATION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" MODIFY ("TIME_TO" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" MODIFY ("TIME_FROM" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" MODIFY ("DATE_TO" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" MODIFY ("DATE_FROM" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" MODIFY ("RELATION_ID" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" MODIFY ("TRAIN_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RESERVATIONS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."RESERVATIONS" ADD PRIMARY KEY ("RESERVATION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."RESERVATIONS" MODIFY ("DATE" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."RESERVATIONS" MODIFY ("COST" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."RESERVATIONS" MODIFY ("USER_ID" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."RESERVATIONS" MODIFY ("TICKET_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TICKETS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."TICKETS" ADD PRIMARY KEY ("TICKET_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."TICKETS" MODIFY ("EXEC_RELATION_ID" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."TICKETS" MODIFY ("STATUS" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."TICKETS" MODIFY ("PRICE" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."TICKETS" MODIFY ("TYPE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table STATIONS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."STATIONS" ADD PRIMARY KEY ("STATION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."STATIONS" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."STATIONS" MODIFY ("CITY" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."STATIONS" MODIFY ("NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RELATIONS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."RELATIONS" ADD PRIMARY KEY ("RELATION_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."RELATIONS" MODIFY ("STATION_ID_TO" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."RELATIONS" MODIFY ("STATION_ID_FROM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRAINS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."TRAINS" ADD PRIMARY KEY ("TRAIN_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."USERS" ADD CONSTRAINT "I_USERID_PK" PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."USERS" MODIFY ("DATE_OF_REGISTRATION" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."USERS" MODIFY ("ADDRESS" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."USERS" MODIFY ("EMAIL" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."USERS" MODIFY ("LAST_NAME" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."USERS" MODIFY ("NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SEATS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."SEATS" ADD PRIMARY KEY ("SEAT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."SEATS" MODIFY ("COMPARTMENT_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COMPARTMENTS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."COMPARTMENTS" ADD PRIMARY KEY ("COMPARTMENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."COMPARTMENTS" MODIFY ("CARRIAGE_ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CARRIAGES
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."CARRIAGES" ADD PRIMARY KEY ("CARRIAGE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "RAILWAY"."CARRIAGES" MODIFY ("TRAIN_ID" NOT NULL ENABLE);
  ALTER TABLE "RAILWAY"."CARRIAGES" MODIFY ("CLASS" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table CARRIAGES
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."CARRIAGES" ADD CONSTRAINT "TRAIN_ID" FOREIGN KEY ("TRAIN_ID")
	  REFERENCES "RAILWAY"."TRAINS" ("TRAIN_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table COMPARTMENTS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."COMPARTMENTS" ADD CONSTRAINT "CARRIAGE_ID" FOREIGN KEY ("CARRIAGE_ID")
	  REFERENCES "RAILWAY"."CARRIAGES" ("CARRIAGE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EXECUTE_RELATIONS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" ADD CONSTRAINT "REALTIONS_RELATION_ID" FOREIGN KEY ("RELATION_ID")
	  REFERENCES "RAILWAY"."RELATIONS" ("RELATION_ID") ENABLE;
  ALTER TABLE "RAILWAY"."EXECUTE_RELATIONS" ADD CONSTRAINT "TRAINS_TRAIN_ID" FOREIGN KEY ("TRAIN_ID")
	  REFERENCES "RAILWAY"."TRAINS" ("TRAIN_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RELATIONS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."RELATIONS" ADD CONSTRAINT "STATION_ID_FROM" FOREIGN KEY ("STATION_ID_FROM")
	  REFERENCES "RAILWAY"."STATIONS" ("STATION_ID") ENABLE;
  ALTER TABLE "RAILWAY"."RELATIONS" ADD CONSTRAINT "STATION_ID_TO" FOREIGN KEY ("STATION_ID_TO")
	  REFERENCES "RAILWAY"."STATIONS" ("STATION_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RESERVATIONS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."RESERVATIONS" ADD CONSTRAINT "TICKET_ID" FOREIGN KEY ("TICKET_ID")
	  REFERENCES "RAILWAY"."TICKETS" ("TICKET_ID") ENABLE;
  ALTER TABLE "RAILWAY"."RESERVATIONS" ADD CONSTRAINT "USER_ID" FOREIGN KEY ("USER_ID")
	  REFERENCES "RAILWAY"."USERS" ("USER_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table SEATS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."SEATS" ADD CONSTRAINT "COMPARTMENT_ID" FOREIGN KEY ("COMPARTMENT_ID")
	  REFERENCES "RAILWAY"."COMPARTMENTS" ("COMPARTMENT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TICKETS
--------------------------------------------------------

  ALTER TABLE "RAILWAY"."TICKETS" ADD CONSTRAINT "EXEC_RELATION_ID" FOREIGN KEY ("EXEC_RELATION_ID")
	  REFERENCES "RAILWAY"."EXECUTE_RELATIONS" ("EXEC_RELATION_ID") ENABLE;
  ALTER TABLE "RAILWAY"."TICKETS" ADD CONSTRAINT "SEAT_ID" FOREIGN KEY ("SEAT_ID")
	  REFERENCES "RAILWAY"."SEATS" ("SEAT_ID") ENABLE;
