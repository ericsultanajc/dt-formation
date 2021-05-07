package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Personne;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;
import sopra.formation.model.UE;

public class TestModel {

	public static void main(String[] args) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		
//		Stagiaire lea = new Stagiaire("lea.dumont@gmail.com");
//		lea.setCivilite(Civilite.MLLE);
//		lea.setNom("DUMONT");
//		lea.setPrenom("Léa");
//		lea.setTelephone("0606060606");
//		lea.setDtNaissance(sdf.parse("25/12/1995"));
//		lea.setNiveauEtude(NiveauEtude.BAC_8);
//
//		Adresse adrLea = new Adresse();
//
//		adrLea.setRue("5 avenue villemejan");
//		adrLea.setComplement("Résidence Diderot");
//		adrLea.setCodePostal("33600");
//		adrLea.setVille("PESSAC");
//
//		lea.setAdresse(adrLea);
//
//		Personne manon = new Stagiaire("serain.manon@yahoo.com");
//		manon.setCivilite(Civilite.MME);
//		manon.setNom("SERAIN");
//		manon.setPrenom("Manon");
//		manon.setTelephone("0645457845");
//		((Stagiaire) manon).setDtNaissance(sdf.parse("01/01/1996"));
//		((Stagiaire) manon).setNiveauEtude(NiveauEtude.BAC_5);
//		
//		manon.setAdresse(new Adresse("21 avenue du Colonel Pierre Bourgoin", "", "33000", "BORDEAUX"));
//
//		Salle wim = new Salle("San Fransisco", 15, true);
//
//		wim.setAdr(new Adresse("86 avenue JFK", "1er étage", "33700", "Mérignac"));
//
//		Formateur eric = new Formateur("e.sultan@ajc-ingenierie.fr");
//		eric.setCivilite(Civilite.M);
//		eric.setNom("SULTAN");
//		eric.setPrenom("Eric");
//		eric.setTelephone("0645104506");
//		eric.setAdresse("4 rue de Corono", "", "33160", "Saint-Médard-en-Jalles");
//		eric.setReferent(true);
//		eric.setExperience(20);
//
//		Filiere dreamTeam = new Filiere("DREAM TEAM");
//		dreamTeam.setIntitule("JAVA SPRING ANGULAR");
//		dreamTeam.setDtDebut(sdf.parse("13/04/2021"));
//		dreamTeam.setDuree(57);
//		dreamTeam.setDispositif(Dispositif.POEI);
//		dreamTeam.setReferent(eric);
//
//		dreamTeam.addStagiaire(lea);
//		dreamTeam.addStagiaire((Stagiaire) manon);
//
//		lea.setFiliere(dreamTeam);
//		((Stagiaire) manon).setFiliere(dreamTeam);
//
//		Matiere unix = new Matiere("UNIX", 1);
//
//		unix.addFormateur(eric);
//		eric.addCompetence(unix);
//
//		UE ueUnix = new UE(4738, 1, 1);
//		ueUnix.setFiliere(dreamTeam);
//		ueUnix.setFormateur(eric);
//		ueUnix.setMatiere(unix);
//		ueUnix.setSalle(wim);
//
//		dreamTeam.addUe(ueUnix);
//		eric.addUe(ueUnix);
//		unix.addUe(ueUnix);
//		wim.addUe(ueUnix);
//
//		Matiere algo = new Matiere("ALGO EN JAVA", 3);
//
//		algo.addFormateur(eric);
//		eric.addCompetence(algo);
//
//		UE ueAlgo = new UE(3326, 3, 2);
//		ueAlgo.setFiliere(dreamTeam);
//		ueAlgo.setFormateur(eric);
//		ueAlgo.setMatiere(algo);
//		ueAlgo.setSalle(wim);
//
//		dreamTeam.addUe(ueAlgo);
//		eric.addUe(ueAlgo);
//		algo.addUe(ueAlgo);
//		wim.addUe(ueAlgo);
//
//		Matiere uml = new Matiere("UML", 1);
//
//		uml.addFormateur(eric);
//		eric.addCompetence(uml);
//
//		UE ueUml = new UE(2369, 1, 3);
//		ueUml.setFiliere(dreamTeam);
//		ueUml.setFormateur(eric);
//		ueUml.setMatiere(uml);
//		ueUml.setSalle(wim);
//
//		dreamTeam.addUe(ueUml);
//		eric.addUe(ueUml);
//		uml.addUe(ueUml);
//		wim.addUe(ueUml);
//
//		Matiere javaObjet = new Matiere("JAVA OBJET", 3);
//
//		javaObjet.addFormateur(eric);
//		eric.addCompetence(javaObjet);
//
//		UE ueJavaObjet = new UE(3542, 2, 4);
//		ueJavaObjet.setFiliere(dreamTeam);
//		ueJavaObjet.setFormateur(eric);
//		ueJavaObjet.setMatiere(javaObjet);
//		ueJavaObjet.setSalle(wim);
//
//		dreamTeam.addUe(ueJavaObjet);
//		eric.addUe(ueJavaObjet);
//		javaObjet.addUe(ueJavaObjet);
//		wim.addUe(ueJavaObjet);
//
//		lea.setEvaluation(new Evaluation(15, 13, "super délégué"));
//		((Stagiaire) manon).setEvaluation(new Evaluation(16, 11, "difficultés passagères"));
//
//		System.out.println(dreamTeam);


	}

}
