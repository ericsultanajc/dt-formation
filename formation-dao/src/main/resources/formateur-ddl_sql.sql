DROP SCHEMA IF EXISTS formation;
CREATE SCHEMA formation DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

USE formation;

create table COMPETENCE 
(
   FORMATEUR_ID         int(11)           not null,
   MATIERE_ID           int(11)           not null,
   constraint PK_COMPETENCE primary key (FORMATEUR_ID, MATIERE_ID)
);

create table EVALUATION 
(
   ID                   int(11)           not null auto_increment,
   COMPORTEMENTALE      int(11)           not null,
   TECHNIQUE            int(11)           not null,
   COMMENTAIRES         VARCHAR(255),
   constraint PK_EVALUATION primary key (ID)
);

create table FILIERE 
(
   ID                   int(11)           not null auto_increment,
   INTITULE             VARCHAR(100)        not null,
   PROMOTION            VARCHAR(100),
   DT_DEBUT             DATE,
   DUREE                int(3),
   DISPOSITIF           VARCHAR(10)          not null,
   REFERENT_ID          int(11),
   constraint PK_FILIERE primary key (ID)
);

create table MATIERE 
(
   ID                   int(11)          not null auto_increment,
   NOM                  VARCHAR(100)        not null,
   DUREE                int(3)            not null,
   constraint PK_MATIERE primary key (ID)
);

create table PERSONNE 
(
   ID                   int(11)           not null auto_increment,
   DISC                 VARCHAR(15)         not null,
   CIVILITE             VARCHAR(10),
   NOM                  VARCHAR(100)        not null,
   PRENOM               VARCHAR(100),
   EMAIL                VARCHAR(255)        not null,
   TELEPHONE            VARCHAR(15),
   DT_NAISSANCE         DATE,
   NIVEAU_ETUDE         VARCHAR(10),
   REFERENT             CHAR(1),
   EXPERIENCE           int(3),
   RUE                  VARCHAR(255),
   COMPLEMENT           VARCHAR(100),
   CODE_POSTAL          VARCHAR(10),
   VILLE                VARCHAR(255),
   FILIERE_ID           int(11),
   EVALUATION_ID        int(11),
   constraint PK_PERSONNE primary key (ID)
);

create table SALLE 
(
   ID                   int(11)           not null auto_increment,
   NOM                  VARCHAR(100),
   CAPACITE             int(3),
   VIDEO_PROJECTEUR     CHAR(1),
   RUE                  VARCHAR(255),
   COMPLEMENT           VARCHAR(100),
   CODE_POSTAL          VARCHAR(10),
   VILLE                VARCHAR(255),
   constraint PK_SALLE primary key (ID)
);

create table UE 
(
   ID                   int(11)           not null auto_increment,
   CODE                 int(5)            not null,
   DUREE                int(3)            not null,
   ORDRE                int(2)            not null,
   FILIERE_ID           int(11),
   MATIERE_ID           int(11),
   FORMATEUR_ID         int(11),
   SALLE_ID             int(11),
   constraint PK_UE primary key (ID)
);

alter table COMPETENCE
   add constraint FK_COMPETEN_REFERENCE_MATIERE foreign key (MATIERE_ID)
      references MATIERE (ID);

alter table COMPETENCE
   add constraint FK_COMPETEN_REFERENCE_PERSONNE foreign key (FORMATEUR_ID)
      references PERSONNE (ID);

alter table FILIERE
   add constraint FK_FILIERE_REFERENCE_PERSONNE foreign key (REFERENT_ID)
      references PERSONNE (ID);

alter table PERSONNE
   add constraint FK_PERSONNE_REFERENCE_FILIERE foreign key (FILIERE_ID)
      references FILIERE (ID);
      
alter table PERSONNE
   add constraint FK_PERSONNE_REF_EVALUATION foreign key (EVALUATION_ID)
      references EVALUATION (ID);

alter table UE
   add constraint FK_UE_REFERENCE_PERSONNE foreign key (FORMATEUR_ID)
      references PERSONNE (ID);

alter table UE
   add constraint FK_UE_REFERENCE_MATIERE foreign key (MATIERE_ID)
      references MATIERE (ID);

alter table UE
   add constraint FK_UE_REFERENCE_SALLE foreign key (SALLE_ID)
      references SALLE (ID);

alter table UE
   add constraint FK_UE_REFERENCE_FILIERE foreign key (FILIERE_ID)
      references FILIERE (ID);
      
SELECT *
FROM matiere;

SELECT *
from salle;

DESCRIBE matiere;
describe salle;

SELECT *
FROM personne;
