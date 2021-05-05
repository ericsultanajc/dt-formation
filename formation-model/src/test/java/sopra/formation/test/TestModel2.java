package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import sopra.formation.model.Civilite;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;
import sopra.formation.model.UE;

public class TestModel2 {
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		
		Stagiaire stagiaire1 = new Stagiaire("aubeline.pecque@hotmail.com");
		stagiaire1.setNom("PECQUE");
		stagiaire1.setPrenom("Aubeline");
		stagiaire1.setCivilite(Civilite.MLLE);
		stagiaire1.setTelephone("0609985235");
		stagiaire1.setDtNaissance(sdf.parse("16/09/1992"));
		stagiaire1.setNiveauEtude(NiveauEtude.BAC_5);
		stagiaire1.setAdresse("10 rue Roland Cazenave", "Hameau de la bergère", "65100", "LOURDES");
		
		Stagiaire stagiaire2 = new Stagiaire("aubeline.pecque@hotmail.fr");
		stagiaire2.setNom("PECQUEE");
		stagiaire2.setPrenom("Aubelinee");
		stagiaire2.setCivilite(Civilite.MME);
		stagiaire2.setTelephone("0609985236");
		stagiaire2.setDtNaissance(sdf.parse("16/09/1993"));
		stagiaire2.setNiveauEtude(NiveauEtude.BAC_5);
		stagiaire2.setAdresse("10 rue Roland", "Hameau", "64000", "PAU");
		
		Evaluation evaluation1 = new Evaluation(20, 10, "Un travail de maitre");
		stagiaire1.setEvaluation(evaluation1);
		
		Formateur formateur1 = new Formateur("eric@gmail.com");
		formateur1.setNom("SULTAN");
		formateur1.setPrenom("Eric");
		formateur1.setExperience(20);
		
		Filiere sopraSteria = new Filiere("2021");
		sopraSteria.getStagiaires().add(stagiaire1);
		sopraSteria.getStagiaires().add(stagiaire2);
		
		sopraSteria.setReferent(formateur1);
		
		Matiere java = new Matiere(1l, "java", 5);
		Matiere javaJ2E = new Matiere(2l, "javaJ2E", 10);
		Matiere sql = new Matiere(3l, "sql", 3);
		
		formateur1.getCompetences().add(java);
		formateur1.getCompetences().add(javaJ2E);
		formateur1.getCompetences().add(sql);
		
		UE coursJava = new UE(1, 10, 1);
		UE coursJavaJ2E = new UE(2, 10, 2);
		UE coursSql = new UE(3, 2, 3);
		
		

		
	}
}
