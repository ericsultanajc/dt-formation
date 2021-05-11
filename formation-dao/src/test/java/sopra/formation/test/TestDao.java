package sopra.formation.test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;

public class TestDao {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IEvaluationDao evaluationDao = Application.getInstance().getEvaluationDao();
		IStagiaireDao stagiaireDao = Application.getInstance().getStagiaireDao();
		IMatiereDao matiereDao = Application.getInstance().getMatiereDao();
		IFiliereDao filiereDao = Application.getInstance().getFiliereDao();
		ISalleDao salleDao = Application.getInstance().getSalleDao();
		
//		Stagiaire lea = new Stagiaire("lea.dumont@gmail.com");
//		lea.setCivilite(Civilite.MLLE);
//		lea.setNom("DUMONT");
//		lea.setPrenom("Léa");
//		lea.setTelephone("0606060606");
//		lea.setDtNaissance(sdf.parse("25/12/1995"));
//		lea.setNiveauEtude(NiveauEtude.BAC_8);
//		lea.setEvaluation(evaluationDao.findById(1L));
//		lea.setFiliere(filiereDao.findById(1L));
//
//		stagiaireDao.create(lea);
//		stagiaireDao.deleteById(1L);
//		
//		List<Stagiaire> stagiaires = stagiaireDao.findAll();
//		
//		for(Stagiaire stagiaire : stagiaires) {
//			System.out.println(stagiaire);
//		}
				
//		List<Evaluation> evaluations = evaluationDao.findAll();
//
//		for (Evaluation evaluation : evaluations) {
//			System.out.println(evaluation);
//		}
//
//		System.out.println(evaluationDao.findById(5L));

		

//		Evaluation evaluation = new Evaluation(14, 12, "Peut mieux faire");
//
//		evaluationDao.create(evaluation);
//		
//		
//
//		evaluation.setComportemental(18);
//		evaluation.setTechnique(15);
//		evaluation.setCommentaires("Grosse amélioration");
//
//		evaluationDao.update(evaluation);
//
//		evaluationDao.delete(evaluation);
		
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
//		lea.setEvaluation(evaluation);
//		
//		
//		stagiaireDao.create(lea);
//
//		Stagiaire manon = new Stagiaire("serain.manon@yahoo.com");
//		manon.setCivilite(Civilite.MME);
//		manon.setNom("SERAIN");
//		manon.setPrenom("Manon");
//		manon.setTelephone("0645457845");
//		((Stagiaire) manon).setDtNaissance(sdf.parse("01/01/1996"));
//		((Stagiaire) manon).setNiveauEtude(NiveauEtude.BAC_5);
//		
//		stagiaireDao.create(manon);
//		
//		Filiere dreamTeam = new Filiere("DREAM TEAM");
//		dreamTeam.setIntitule("JAVA SPRING ANGULAR");
//		dreamTeam.setDtDebut(sdf.parse("13/04/2021"));
//		dreamTeam.setDuree(57);
//		dreamTeam.setDispositif(Dispositif.POEI);
//		
//		
//
//		manon.setFiliere(dreamTeam);
//		
//		filiereDao.create(dreamTeam);
//		
//		stagiaireDao.update(manon);
		
//		Matiere m1 = new Matiere("J2EE", 3);
//		Matiere m2 = new Matiere("COBOL", 6);
//		Matiere m3 = new Matiere("C/C++", 12);
//		matiereDao.create(m1);
//		matiereDao.create(m2);
//		matiereDao.create(m3);
//		
//		List<Matiere> matieres = matiereDao.findAll();
//	
//		System.out.println(Arrays.toString(matieres.toArray()));
//		
//		Matiere m3bis = matiereDao.findById(m3.getId());
//	
//		System.out.println(m3bis);
//		
//		m2.setNom("Python & R");
//		m2.setDuree(1);
//		matiereDao.update(m2);
		
//		matiereDao.deleteById(1L);
//		matiereDao.deleteById(2L);
//		matiereDao.deleteById(3L);
//		matiereDao.deleteById(4L);
//		
//		Salle s1 = new Salle("B12", 45, true);
//		// salleDao.create(s1);
//		
//		Adresse a1 = new Adresse("rue Georges Bonnac", "3ème étage", "33000", "Bordeaux");
//		s1.setAdr(a1);
//		
//		salleDao.update(s1);
		
		
		java.util.Date d = null;
		try {
			d = sdf.parse("15/03/1995");
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
//		Stagiaire s = new Stagiaire(Civilite.M, "Poul", "Tristan", "tristan.poul@hotmail.fr", "0665590784", d, NiveauEtude.BAC_5);
	
//		stagiaireDao.create(s);
		
//		Adresse a1 = new Adresse("rue Georges Bonnac", "3ème étage", "33000", "Bordeaux");
//		s.setAdresse(a1);
		
		Stagiaire s = stagiaireDao.findById(10L);
		System.out.println(s);
		
//		stagiaireDao.update(s);
		
//		stagiaireDao.deleteById(6L);
//		stagiaireDao.deleteById(7L);
//		stagiaireDao.deleteById(9L);
		
	}

}
