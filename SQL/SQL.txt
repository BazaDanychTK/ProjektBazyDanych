--------------------------------------------------------
--  File created - œroda-maja-27-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Type OPLATA
--------------------------------------------------------

  CREATE OR REPLACE TYPE "HR"."OPLATA" as object (
id_oplaty NUMBER(10),
czy_zaplacona NUMBER(10),
termin DATE);

/
--------------------------------------------------------
--  DDL for Type OPLATY_TAB
--------------------------------------------------------

  CREATE OR REPLACE TYPE "HR"."OPLATY_TAB" as table of oplata;

/
--------------------------------------------------------
--  DDL for Sequence KLIENT_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."KLIENT_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OPLATA_ZA_USLUGE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."OPLATA_ZA_USLUGE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence OPLATA_ZA_USLUGE_SEQ1
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."OPLATA_ZA_USLUGE_SEQ1"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence RODZAJ_LACZA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."RODZAJ_LACZA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence UMOWA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."UMOWA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence USLUGA_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "HR"."USLUGA_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 21 CACHE 20 NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table KLIENT
--------------------------------------------------------

  CREATE TABLE "HR"."KLIENT" 
   (	"ID" NUMBER(10,0), 
	"IMIE" VARCHAR2(50 BYTE), 
	"NAZWISKO" VARCHAR2(50 BYTE), 
	"KOD_POCZTOWY" VARCHAR2(10 BYTE), 
	"ULICA" VARCHAR2(50 BYTE), 
	"NUMER_LOKALU" VARCHAR2(10 BYTE), 
	"TEL_KONTAKT" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table MIEJSCOWOSC
--------------------------------------------------------

  CREATE TABLE "HR"."MIEJSCOWOSC" 
   (	"KOD_POCZTOWY" VARCHAR2(10 BYTE), 
	"NAZWA" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table OPLATA_ZA_USLUGE
--------------------------------------------------------

  CREATE TABLE "HR"."OPLATA_ZA_USLUGE" 
   (	"ID" NUMBER(10,0), 
	"ID_UMOWY" NUMBER(10,0), 
	"CZY_ZAPLACONE" NUMBER(10,0) DEFAULT -1, 
	"TERMIN_PLATNOSCI" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RODZAJ_LACZA
--------------------------------------------------------

  CREATE TABLE "HR"."RODZAJ_LACZA" 
   (	"ID" NUMBER(10,0), 
	"NAZWA" VARCHAR2(50 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table UMOWA
--------------------------------------------------------

  CREATE TABLE "HR"."UMOWA" 
   (	"ID" NUMBER(10,0), 
	"ID_USLUGI" NUMBER(10,0), 
	"ID_KLIENTA" NUMBER(10,0), 
	"DATA_START" DATE, 
	"DATA_KONIEC" DATE, 
	"KWOTA_ZOBOWIAZANIA" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USLUGA
--------------------------------------------------------

  CREATE TABLE "HR"."USLUGA" 
   (	"ID" NUMBER(10,0), 
	"NAZWA" VARCHAR2(50 BYTE), 
	"PREDKOSC_LACZA" NUMBER(10,0), 
	"RODZAJ_LACZA_ID" NUMBER(10,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into HR.KLIENT
SET DEFINE OFF;
Insert into HR.KLIENT (ID,IMIE,NAZWISKO,KOD_POCZTOWY,ULICA,NUMER_LOKALU,TEL_KONTAKT) values ('6','Pawe³','Trojnar','35-302','Rejtana','2','203 203 230');
REM INSERTING into HR.MIEJSCOWOSC
SET DEFINE OFF;
Insert into HR.MIEJSCOWOSC (KOD_POCZTOWY,NAZWA) values ('37-403','Pysznica');
Insert into HR.MIEJSCOWOSC (KOD_POCZTOWY,NAZWA) values ('35-302','Rzeszów');
REM INSERTING into HR.OPLATA_ZA_USLUGE
SET DEFINE OFF;
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('29','30','-1',to_date('20/06/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('17','28','1',to_date('20/06/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('30','31','-1',to_date('20/06/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('18','28','1',to_date('20/07/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('19','28','1',to_date('20/08/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('20','28','1',to_date('20/09/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('21','28','1',to_date('20/10/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('22','28','1',to_date('20/11/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('23','28','1',to_date('20/12/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('24','28','-1',to_date('21/01/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('25','28','-1',to_date('21/02/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('26','28','-1',to_date('21/03/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('27','28','-1',to_date('21/04/01','RR/MM/DD'));
Insert into HR.OPLATA_ZA_USLUGE (ID,ID_UMOWY,CZY_ZAPLACONE,TERMIN_PLATNOSCI) values ('28','28','-1',to_date('21/05/01','RR/MM/DD'));
REM INSERTING into HR.RODZAJ_LACZA
SET DEFINE OFF;
Insert into HR.RODZAJ_LACZA (ID,NAZWA) values ('3','Swiat³owodowe');
Insert into HR.RODZAJ_LACZA (ID,NAZWA) values ('4','Radiowe');
Insert into HR.RODZAJ_LACZA (ID,NAZWA) values ('5','Tradycyjne - skrêtka cat5e');
REM INSERTING into HR.UMOWA
SET DEFINE OFF;
Insert into HR.UMOWA (ID,ID_USLUGI,ID_KLIENTA,DATA_START,DATA_KONIEC,KWOTA_ZOBOWIAZANIA) values ('30','17','6',to_date('20/05/01','RR/MM/DD'),to_date('20/06/01','RR/MM/DD'),'12');
Insert into HR.UMOWA (ID,ID_USLUGI,ID_KLIENTA,DATA_START,DATA_KONIEC,KWOTA_ZOBOWIAZANIA) values ('31','17','6',to_date('20/05/01','RR/MM/DD'),to_date('20/06/01','RR/MM/DD'),'12');
Insert into HR.UMOWA (ID,ID_USLUGI,ID_KLIENTA,DATA_START,DATA_KONIEC,KWOTA_ZOBOWIAZANIA) values ('28','17','6',to_date('20/05/01','RR/MM/DD'),to_date('21/05/01','RR/MM/DD'),'50');
REM INSERTING into HR.USLUGA
SET DEFINE OFF;
Insert into HR.USLUGA (ID,NAZWA,PREDKOSC_LACZA,RODZAJ_LACZA_ID) values ('17','FIBER - 100/10','100','3');
--------------------------------------------------------
--  DDL for Index SYS_C007243
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007243" ON "HR"."RODZAJ_LACZA" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007246
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007246" ON "HR"."USLUGA" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007254
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007254" ON "HR"."KLIENT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007257
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007257" ON "HR"."MIEJSCOWOSC" ("KOD_POCZTOWY") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007264
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007264" ON "HR"."UMOWA" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007272
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007272" ON "HR"."OPLATA_ZA_USLUGE" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger DODAJ_MIESIECZNE_ZOBOWIAZANIA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."DODAJ_MIESIECZNE_ZOBOWIAZANIA" 
AFTER INSERT ON UMOWA 
FOR EACH ROW
BEGIN
    DECLARE 
        record_exists INTEGER;
        newdate DATE :=:NEW.DATA_START;
        newdateend DATE := :NEW.data_koniec;
        newid NUMBER := :NEW.id;
    BEGIN SELECT MONTHS_BETWEEN (newdateend,newdate) INTO record_exists FROM DUAL;
        IF record_exists is not null THEN 
          FOR l_counter IN 1..record_exists
          LOOP
            INSERT INTO oplata_za_usluge(id_umowy,termin_platnosci) VALUES(newid,ADD_MONTHS(newdate, l_counter));
          END LOOP;
            
        END IF;
    END;
END;
/
ALTER TRIGGER "HR"."DODAJ_MIESIECZNE_ZOBOWIAZANIA" ENABLE;
--------------------------------------------------------
--  DDL for Trigger KLIENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."KLIENT_TRG" 
BEFORE INSERT ON KLIENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT KLIENT_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "HR"."KLIENT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger OPLATA_ZA_USLUGE_TRG1
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."OPLATA_ZA_USLUGE_TRG1" 
BEFORE INSERT ON OPLATA_ZA_USLUGE 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT OPLATA_ZA_USLUGE_SEQ1.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "HR"."OPLATA_ZA_USLUGE_TRG1" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RODZAJ_LACZA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."RODZAJ_LACZA_TRG" 
BEFORE INSERT ON RODZAJ_LACZA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT RODZAJ_LACZA_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "HR"."RODZAJ_LACZA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger UMOWA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."UMOWA_TRG" 
BEFORE INSERT ON UMOWA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT UMOWA_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "HR"."UMOWA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USLUGA_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."USLUGA_TRG" 
BEFORE INSERT ON USLUGA 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT USLUGA_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "HR"."USLUGA_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Package DODAJ
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "HR"."DODAJ" AS 
    PROCEDURE RODZAJ_LACZA(in_nazwa IN VARCHAR2,err_message OUT VARCHAR2);
	PROCEDURE USLUGE(in_nazwa IN VARCHAR2,in_predkosc_lacza IN NUMBER,in_rodzaj_lacza IN NUMBER,err_message OUT VARCHAR2);
	PROCEDURE KLIENTA(in_imie IN VARCHAR2,in_nazwisko IN VARCHAR2,in_kod_pocztowy IN VARCHAR2,in_ulica IN VARCHAR2,in_numer_lokalu IN VARCHAR2,in_tel IN VARCHAR2,err_message OUT VARCHAR2);
    PROCEDURE MIEJSCOWOSC(in_kod_pocztowy IN VARCHAR2,in_nazwa IN VARCHAR2,err_message OUT VARCHAR2);
    PROCEDURE UMOWE(in_id_uslugi IN NUMBER,in_id_klienta IN NUMBER,in_data_start IN DATE,in_data_stop IN DATE,in_kwota IN VARCHAR2,err_message OUT VARCHAR2);
END;

/
--------------------------------------------------------
--  DDL for Package USUN
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE "HR"."USUN" AS 
    PROCEDURE rodzaj_lacza(in_id IN NUMBER, err_message OUT VARCHAR2);
    PROCEDURE miejscowosc(in_kod_pocztowy IN VARCHAR2,err_message OUT VARCHAR2);
    PROCEDURE usluge(in_id IN NUMBER, err_message OUT VARCHAR2);
    PROCEDURE klienta(in_id IN NUMBER, err_message OUT VARCHAR2);
    PROCEDURE umowe(in_id IN NUMBER,err_message OUT VARCHAR2);
END;

/
--------------------------------------------------------
--  DDL for Package Body DODAJ
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "HR"."DODAJ" IS

    PROCEDURE RODZAJ_LACZA(
    in_nazwa IN VARCHAR2,
    err_message OUT VARCHAR2) IS
    BEGIN
        IF in_nazwa is not null THEN
            DECLARE record_exists INTEGER;
            BEGIN SELECT COUNT(*) INTO record_exists FROM RODZAJ_LACZA 
            WHERE nazwa = in_nazwa AND ROWNUM = 1; 
                IF record_exists = 1 THEN 
                    err_message:='Error - taki rodzaj ³¹cza ju¿ istnieje.';
                ELSE 
                    INSERT INTO RODZAJ_LACZA (nazwa) VALUES (in_nazwa);
                    err_message:='Info - rodzaj ³¹cza dodany';
                END IF; 
            END;
        ELSE
            err_message:='Error - musisz podaæ nazwê ³¹cza.';
        END IF;
    END;


	PROCEDURE USLUGE(
    in_nazwa IN VARCHAR2,
	in_predkosc_lacza IN NUMBER,
	in_rodzaj_lacza IN NUMBER,
    err_message OUT VARCHAR2) IS
    BEGIN
        IF in_nazwa is not null THEN
            DECLARE record_exists INTEGER;
            BEGIN SELECT COUNT(*) INTO record_exists FROM USLUGA 
            WHERE nazwa = in_nazwa AND ROWNUM = 1; 
                IF record_exists = 1 THEN 
                    err_message:='Error - taka us³uga ju¿ istnieje.';
                ELSE 
					IF in_predkosc_lacza is not null AND in_rodzaj_lacza is not null THEN
						INSERT INTO USLUGA (NAZWA,PREDKOSC_LACZA,RODZAJ_LACZA_ID) VALUES (in_nazwa,in_predkosc_lacza,in_rodzaj_lacza);
						err_message:='Info - us³uga dodana.';
					END IF;
					IF in_predkosc_lacza is null AND in_rodzaj_lacza is null THEN
						INSERT INTO USLUGA (NAZWA) VALUES (in_nazwa);
						err_message:='Info - us³uga dodana.';
					END IF;
					IF in_predkosc_lacza is not null AND in_rodzaj_lacza is null THEN
						err_message:='Error - podaj rodzaj ³¹cza.';
					END IF;
					IF in_predkosc_lacza is null AND in_rodzaj_lacza is not null THEN
						err_message:='Error - podaj prêdkoœæ ³¹cza.';
					END IF;
                END IF; 
            END;
        ELSE
            err_message:='Error - musisz podaæ nazwê us³ugi.';
        END IF;
    END;

	PROCEDURE KLIENTA(
    in_imie IN VARCHAR2,
	in_nazwisko IN VARCHAR2,
	in_kod_pocztowy IN VARCHAR2,
	in_ulica IN VARCHAR2,
	in_numer_lokalu IN VARCHAR2,
	in_tel IN VARCHAR2,
    err_message OUT VARCHAR2) IS
    BEGIN
        IF in_imie is not null THEN
		    IF in_nazwisko is not null THEN
				DECLARE record_exists INTEGER;
				BEGIN SELECT COUNT(*) INTO record_exists FROM KLIENT 
				WHERE imie = in_imie AND nazwisko = in_nazwisko AND ROWNUM = 1; 
					IF record_exists = 1 THEN 
						err_message:='Error - taki klient ju¿ istnieje w bazie.';
					ELSE 
						IF REGEXP_LIKE (in_kod_pocztowy, '([0-9]{2}\-[0-9]{3})') THEN 
							IF in_ulica is not null THEN 
                                    IF REGEXP_LIKE (in_numer_lokalu, '(\d+[a-zA-Z]?\/?\d*)') THEN 
                                        IF REGEXP_LIKE (in_tel, '(^[0-9]{3} {1}[0-9]{3} {1}[0-9]{3}$)') THEN 
                                            DECLARE record_exists INTEGER;
                                            BEGIN SELECT COUNT(*) INTO record_exists FROM MIEJSCOWOSC 
                                            WHERE kod_pocztowy = in_kod_pocztowy AND ROWNUM = 1; 
                                            	IF record_exists = 1 THEN 
                                                    INSERT INTO KLIENT (IMIE,NAZWISKO,KOD_POCZTOWY,ULICA,NUMER_LOKALU,TEL_KONTAKT) VALUES (in_imie,in_nazwisko,in_kod_pocztowy,in_ulica,in_numer_lokalu,in_tel);
                                                    err_message:='Info - klient dodany do bazy.';
                                                ELSE 
                                                    err_message:='Error - jaka to miejscowoœæ? Dodaj j¹ do bazy.';
                                                END IF;
                                            END;
                                        ELSE
                                            err_message:='Error - nieprawid³owy numer telefonu - dozwolony format xxx xxx xxx.';
                                        END IF;
                                    ELSE
                                        err_message:='Error - nieprawid³owy numer lokalu np 22/2.';
                                    END IF;
							ELSE
								err_message:='Error - wpisz nazwê ulicy.';
							END IF;
						ELSE
							err_message:='Error - podano nieprawid³owy format kodu pocztowego. Poprawny format: xx-xxx.';
						END IF;
					END IF; 
				END;
			ELSE
				err_message:='Error - musisz podaæ nazwisko klienta.';
			END IF;
        ELSE
            err_message:='Error - musisz podaæ imiê klienta.';
        END IF;
    END;
    
    PROCEDURE MIEJSCOWOSC(
    in_kod_pocztowy IN VARCHAR2,
    in_nazwa IN VARCHAR2,
    err_message OUT VARCHAR2) IS
    BEGIN
        IF in_nazwa is not null THEN
            IF REGEXP_LIKE (in_kod_pocztowy, '([0-9]{2}\-[0-9]{3})') THEN 
                DECLARE record_exists INTEGER;
                BEGIN SELECT COUNT(*) INTO record_exists FROM MIEJSCOWOSC 
                WHERE kod_pocztowy = in_kod_pocztowy AND ROWNUM = 1; 
                    IF record_exists = 1 THEN 
                        err_message:='Error - taka miejscowoœæ jest ju¿ w bazie.';
                    ELSE 
                        INSERT INTO miejscowosc (kod_pocztowy,nazwa) VALUES (in_kod_pocztowy,in_nazwa);
                        err_message:='Info - miejscowoœæ dodana';
                    END IF; 
                END;
            ELSE
                err_message:='Error - podano nieprawid³owy format kodu pocztowego. Poprawny format: xx-xxx.';
            END IF;
        ELSE
            err_message:='Error - musisz podaæ nazwê miejscowoœci.';
        END IF;
    END;
    
    PROCEDURE UMOWE(
    in_id_uslugi IN NUMBER,
    in_id_klienta IN NUMBER,
    in_data_start IN DATE,
    in_data_stop IN DATE,
    in_kwota IN VARCHAR2,
    err_message OUT VARCHAR2) IS
    BEGIN
        if in_kwota is not null THEN
            BEGIN
                INSERT INTO UMOWA (id_uslugi,id_klienta,data_start,data_koniec,kwota_zobowiazania) VALUES (in_id_uslugi,in_id_klienta,in_data_start,in_data_stop,TO_NUMBER(in_kwota));
            EXCEPTION  -- exception handlers begin
                WHEN VALUE_ERROR THEN  -- handles 'division by zero' error
                    err_message:='Error - kwota musi mieæ wartoœæ liczbow¹.';
                    ROLLBACK;
            END;  -- exception handlers and block end here
        ELSE
            err_message:='Error - kwota musi mieæ wartoœæ liczbow¹.';
        END IF;
    END;


END;

/
--------------------------------------------------------
--  DDL for Package Body USUN
--------------------------------------------------------

  CREATE OR REPLACE PACKAGE BODY "HR"."USUN" IS

    PROCEDURE rodzaj_lacza(
    in_id IN NUMBER,
    err_message OUT VARCHAR2)IS
    BEGIN
        DECLARE record_exists INTEGER;
        BEGIN SELECT COUNT(*) INTO record_exists FROM usluga 
        WHERE rodzaj_lacza_id = in_id AND ROWNUM = 1; 
            IF record_exists = 1 THEN 
                err_message:='Error - istnieje przypisana us³uga';
            ELSE 
                DELETE FROM rodzaj_lacza WHERE id = in_id;
                    err_message:='Info - obiekt usuniêty z bazy';
            END IF; 
        END;
    END;
    
    PROCEDURE miejscowosc(
    in_kod_pocztowy IN VARCHAR2,
    err_message OUT VARCHAR2)IS
    BEGIN
        DECLARE record_exists INTEGER;
        BEGIN SELECT COUNT(*) INTO record_exists FROM klient 
        WHERE kod_pocztowy = in_kod_pocztowy AND ROWNUM = 1; 
            IF record_exists = 1 THEN 
                err_message:='Error - istnieje klient z tej miejscowoœci';
            ELSE 
                DELETE FROM miejscowosc WHERE kod_pocztowy = in_kod_pocztowy;
                    err_message:='Info - miejscowoœæ usuniêta z bazy';
            END IF; 
        END;
    END;
    
    PROCEDURE usluge(
    in_id IN NUMBER,
    err_message OUT VARCHAR2)IS
    BEGIN
        DECLARE record_exists INTEGER;
        BEGIN SELECT COUNT(*) INTO record_exists FROM umowa 
        WHERE id_uslugi = in_id AND ROWNUM = 1; 
            IF record_exists = 1 THEN 
                err_message:='Error - ta usluga jest przedmiotem umowy';
            ELSE 
                DELETE FROM usluga WHERE id = in_id;
                    err_message:='Info - us³uga usuniêta z bazy';
            END IF; 
        END;
    END;   
    
    PROCEDURE klienta(
    in_id IN NUMBER,
    err_message OUT VARCHAR2)IS
    BEGIN
        DECLARE record_exists INTEGER;
        BEGIN SELECT COUNT(*) INTO record_exists FROM umowa 
        WHERE id_klienta = in_id AND ROWNUM = 1; 
            IF record_exists = 1 THEN 
                err_message:='Error - ten klient ma u nas wykupione us³ugi';
            ELSE 
                DELETE FROM klient WHERE id = in_id;
                    err_message:='Info - klient usuniêty z bazy';
            END IF; 
        END;
    END; 
    
    PROCEDURE umowe(
    in_id IN NUMBER,
    err_message OUT VARCHAR2)IS
    BEGIN
        DELETE FROM umowa WHERE id = in_id;
        err_message:='Info - umowa rozwi¹zana';
    END; 


END;

/
--------------------------------------------------------
--  DDL for Function OPLATY_DLA_UMOWY_O_ID
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "HR"."OPLATY_DLA_UMOWY_O_ID" (in_id_umowy IN NUMBER)
    RETURN oplaty_tab 
is
return_value oplaty_tab;

BEGIN
    select oplata(id,czy_zaplacone,TERMIN_PLATNOSCI)
    bulk collect into return_value
    from oplata_za_usluge WHERE id = in_id_umowy;
    RETURN return_value;
END;

/
--------------------------------------------------------
--  DDL for Function ZAMIEN_STRING_NA_LICZBE
--------------------------------------------------------

  CREATE OR REPLACE FUNCTION "HR"."ZAMIEN_STRING_NA_LICZBE" 
(
  IN_CIAG_ZNAKOW IN VARCHAR2 
) RETURN NUMBER AS 
BEGIN
    RETURN TO_NUMBER(IN_CIAG_ZNAKOW);
END ZAMIEN_STRING_NA_LICZBE;

/
--------------------------------------------------------
--  Constraints for Table KLIENT
--------------------------------------------------------

  ALTER TABLE "HR"."KLIENT" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."KLIENT" MODIFY ("TEL_KONTAKT" NOT NULL ENABLE);
  ALTER TABLE "HR"."KLIENT" MODIFY ("NUMER_LOKALU" NOT NULL ENABLE);
  ALTER TABLE "HR"."KLIENT" MODIFY ("ULICA" NOT NULL ENABLE);
  ALTER TABLE "HR"."KLIENT" MODIFY ("KOD_POCZTOWY" NOT NULL ENABLE);
  ALTER TABLE "HR"."KLIENT" MODIFY ("NAZWISKO" NOT NULL ENABLE);
  ALTER TABLE "HR"."KLIENT" MODIFY ("IMIE" NOT NULL ENABLE);
  ALTER TABLE "HR"."KLIENT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table MIEJSCOWOSC
--------------------------------------------------------

  ALTER TABLE "HR"."MIEJSCOWOSC" ADD PRIMARY KEY ("KOD_POCZTOWY")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."MIEJSCOWOSC" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "HR"."MIEJSCOWOSC" MODIFY ("KOD_POCZTOWY" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table OPLATA_ZA_USLUGE
--------------------------------------------------------

  ALTER TABLE "HR"."OPLATA_ZA_USLUGE" MODIFY ("TERMIN_PLATNOSCI" NOT NULL ENABLE);
  ALTER TABLE "HR"."OPLATA_ZA_USLUGE" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."OPLATA_ZA_USLUGE" MODIFY ("CZY_ZAPLACONE" NOT NULL ENABLE);
  ALTER TABLE "HR"."OPLATA_ZA_USLUGE" MODIFY ("ID_UMOWY" NOT NULL ENABLE);
  ALTER TABLE "HR"."OPLATA_ZA_USLUGE" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RODZAJ_LACZA
--------------------------------------------------------

  ALTER TABLE "HR"."RODZAJ_LACZA" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."RODZAJ_LACZA" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "HR"."RODZAJ_LACZA" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table UMOWA
--------------------------------------------------------

  ALTER TABLE "HR"."UMOWA" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."UMOWA" MODIFY ("KWOTA_ZOBOWIAZANIA" NOT NULL ENABLE);
  ALTER TABLE "HR"."UMOWA" MODIFY ("DATA_KONIEC" NOT NULL ENABLE);
  ALTER TABLE "HR"."UMOWA" MODIFY ("DATA_START" NOT NULL ENABLE);
  ALTER TABLE "HR"."UMOWA" MODIFY ("ID_KLIENTA" NOT NULL ENABLE);
  ALTER TABLE "HR"."UMOWA" MODIFY ("ID_USLUGI" NOT NULL ENABLE);
  ALTER TABLE "HR"."UMOWA" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USLUGA
--------------------------------------------------------

  ALTER TABLE "HR"."USLUGA" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."USLUGA" MODIFY ("NAZWA" NOT NULL ENABLE);
  ALTER TABLE "HR"."USLUGA" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table KLIENT
--------------------------------------------------------

  ALTER TABLE "HR"."KLIENT" ADD CONSTRAINT "FK_MIEJSCOWOSC" FOREIGN KEY ("KOD_POCZTOWY")
	  REFERENCES "HR"."MIEJSCOWOSC" ("KOD_POCZTOWY") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table OPLATA_ZA_USLUGE
--------------------------------------------------------

  ALTER TABLE "HR"."OPLATA_ZA_USLUGE" ADD CONSTRAINT "FK_UMOWA" FOREIGN KEY ("ID_UMOWY")
	  REFERENCES "HR"."UMOWA" ("ID") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table UMOWA
--------------------------------------------------------

  ALTER TABLE "HR"."UMOWA" ADD CONSTRAINT "FK_KLIENT" FOREIGN KEY ("ID_KLIENTA")
	  REFERENCES "HR"."KLIENT" ("ID") ENABLE;
  ALTER TABLE "HR"."UMOWA" ADD CONSTRAINT "FK_USLUGA" FOREIGN KEY ("ID_USLUGI")
	  REFERENCES "HR"."USLUGA" ("ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USLUGA
--------------------------------------------------------

  ALTER TABLE "HR"."USLUGA" ADD CONSTRAINT "FK_RODZAJ_LACZA" FOREIGN KEY ("RODZAJ_LACZA_ID")
	  REFERENCES "HR"."RODZAJ_LACZA" ("ID") ENABLE;
