CREATE DATABASE `LOC_MNS_2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

SET default_storage_engine=INNODB;

USE LOC_MNS_2;

CREATE TABLE Documents (
                           doc_id INT PRIMARY KEY AUTO_INCREMENT,
                           doc_titre VARCHAR(50),
                           doc_type VARCHAR(50),
                           doc_date_creation DATE,
                           doc_date_echeance DATE,
                           doc_description VARCHAR(50)
);

CREATE TABLE Localisation (
                              loc_id INT PRIMARY KEY AUTO_INCREMENT,
                              loc_lieu VARCHAR(50),
                              loc_batiment VARCHAR(50),
                              loc_salle VARCHAR(50)
);

CREATE TABLE Groupe (
                        group_id INT PRIMARY KEY AUTO_INCREMENT,
                        groupe_libelle VARCHAR(50)
);

CREATE TABLE role (
                      role_id INT PRIMARY KEY AUTO_INCREMENT,
                      role_libelle VARCHAR(50)
);

CREATE TABLE Type_materiel (
                               ID_type INT PRIMARY KEY AUTO_INCREMENT,
                               type_libelle VARCHAR(50)
);

CREATE TABLE Etat_materiel (
                               etat_id INT PRIMARY KEY AUTO_INCREMENT,
                               etat_condition VARCHAR(50)
);

CREATE TABLE Utilisateurs (
                              utilisateur_id INT PRIMARY KEY AUTO_INCREMENT,
                              utilisateur_nom VARCHAR(50),
                              utilisateur_prenom VARCHAR(50),
                              utilisateur_date_naissance DATE,
                              utilisateur_telephone VARCHAR(50),
                              utilisateur_email VARCHAR(50),
                              utilisateur_date_creation DATE,
                              utilisateur_date_derniere_connexion DATE,
                              role_id INT,
                              FOREIGN KEY(role_id) REFERENCES role(role_id)
);

CREATE TABLE Demande_Pret (
                              pret_id INT PRIMARY KEY AUTO_INCREMENT,
                              pret_date_de_validation VARCHAR(50),
                              pret_date_demande DATE,
                              pret_description VARCHAR(50),
                              pret_date_emprunt DATE,
                              pret_date_fin DATE,
                              pret_action_validee BIT,
                              pret_cadre_utilisation VARCHAR(50),
                              utilisateur_id INT,
                              FOREIGN KEY(utilisateur_id) REFERENCES Utilisateurs(utilisateur_id)
);

CREATE TABLE Materiel (
                          materiel_Id INT PRIMARY KEY AUTO_INCREMENT,
                          materiel_marque VARCHAR(50),
                          materiel_ref VARCHAR(50),
                          materiel_date_achat DATE,
                          materiel_date_fin_garantie DATE,
                          materiel_date_mise_en_service DATE,
                          materiel_cout_achat VARCHAR(50),
                          ID_type INT,
                          loc_id INT,
                          FOREIGN KEY(ID_type) REFERENCES Type_materiel(ID_type),
                          FOREIGN KEY(loc_id) REFERENCES Localisation(loc_id)
);

CREATE TABLE Pannes (
                        panne_id INT PRIMARY KEY AUTO_INCREMENT,
                        panne_date DATE,
                        panne_description VARCHAR(50),
                        panne_date_prise_en_charge DATE,
                        panne_date_reparation DATE,
                        panne_cout_reparation VARCHAR(50),
                        utilisateur_id INT,
                        materiel_Id INT,
                        FOREIGN KEY(utilisateur_id) REFERENCES Utilisateurs(utilisateur_id),
                        FOREIGN KEY(materiel_Id) REFERENCES Materiel(materiel_Id)
);

CREATE TABLE Suivi (
                       suivi_id INT PRIMARY KEY AUTO_INCREMENT,
                       suivi_date_fin DATE,
                       suivi_date_debut DATE,
                       suivi_statut VARCHAR(50),
                       panne_id INT,
                       FOREIGN KEY(panne_id) REFERENCES Pannes(panne_id)
);

CREATE TABLE gerer (
                       utilisateur_id INT,
                       materiel_Id INT,
                       PRIMARY KEY(utilisateur_id, materiel_Id),
                       FOREIGN KEY(utilisateur_id) REFERENCES Utilisateurs(utilisateur_id),
                       FOREIGN KEY(materiel_Id) REFERENCES Materiel(materiel_Id)
);

CREATE TABLE type (
                      pret_id INT,
                      materiel_Id INT,
                      date_retour_reel DATE,
                      PRIMARY KEY(pret_id, materiel_Id),
                      FOREIGN KEY(pret_id) REFERENCES Demande_Pret(pret_id),
                      FOREIGN KEY(materiel_Id) REFERENCES Materiel(materiel_Id)
);

CREATE TABLE posseder (
                          doc_id INT,
                          materiel_Id INT,
                          PRIMARY KEY(doc_id, materiel_Id),
                          FOREIGN KEY(doc_id) REFERENCES Documents(doc_id),
                          FOREIGN KEY(materiel_Id) REFERENCES Materiel(materiel_Id)
);

CREATE TABLE fait_partie (
                             utilisateur_id INT,
                             group_id INT,
                             PRIMARY KEY(utilisateur_id, group_id),
                             FOREIGN KEY(utilisateur_id) REFERENCES Utilisateurs(utilisateur_id),
                             FOREIGN KEY(group_id) REFERENCES Groupe(group_id)
);

CREATE TABLE usure (
                       materiel_Id INT,
                       etat_id INT,
                       Date_de_changement DATE,
                       PRIMARY KEY(materiel_Id, etat_id),
                       FOREIGN KEY(materiel_Id) REFERENCES Materiel(materiel_Id),
                       FOREIGN KEY(etat_id) REFERENCES Etat_materiel(etat_id)
);




*********************************


CREATE TABLE LOC_MNS_2.connexion (
                                 id INT auto_increment NOT NULL,
                                 login varchar(100) NOT NULL,
                                 password varchar(100) NOT NULL,
                                 profil INT NOT null,
                                 primary key (id)
                                )
                                    ENGINE=InnoDB
                                DEFAULT CHARSET=utf8
                                COLLATE=utf8_general_ci;
                                CREATE UNIQUE INDEX connexion_id_idx USING BTREE ON LOC_MNS_2.connexion (id);

