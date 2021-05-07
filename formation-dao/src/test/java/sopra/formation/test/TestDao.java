package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.dao.file.csv.SalleDaoCsv;
import sopra.formation.dao.file.csv.StagiaireDaoCsv;
import sopra.formation.model.Civilite;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;

public class TestDao {

	public static void main(String[] args) {
		IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");
		IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");
		ISalleDao salleDao = new SalleDaoCsv("salles.txt");
		IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaires.txt");

		List<Evaluation> evaluations = evaluationDao.findAll();

		for (Evaluation evaluation : evaluations) {
			System.out.println(evaluation);
		}

		System.out.println(evaluationDao.findById(5L));

		Evaluation evaluation = new Evaluation(14, 12, "Peut mieux faire");

		evaluationDao.create(evaluation);
//
//		evaluation.setComportemental(18);
//		evaluation.setTechnique(15);
//		evaluation.setCommentaires("Grosse amélioration");
//
//		evaluationDao.update(evaluation);

//		evaluationDao.delete(evaluation);
		
		Stagiaire lea = new Stagiaire("lea.dumont@gmail.com");
		lea.setCivilite(Civilite.MLLE);
		lea.setNom("DUMONT");
		lea.setPrenom("Léa");
		lea.setTelephone("0606060606");
		lea.setDtNaissance(sdf.parse("25/12/1995"));
		lea.setNiveauEtude(NiveauEtude.BAC_8);

		Adresse adrLea = new Adresse();

		evaluationDao.delete(evaluation);
		
		//---------------------Test matiereDao---------------------------//
		
		List<Matiere> matieres = matiereDao.findAll();
		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}
		
		System.out.println(matiereDao.findById(2L));
		
		Matiere matiere = new Matiere("Chimie", 2);
		matiereDao.create(matiere);
		
		matiere.setNom("Chimie organique");
		matiere.setDuree(4);

		matiereDao.update(matiere);

		matiereDao.delete(matiere);
		
		//-------------------Test salleDao-----------------------------//
		
		List<Salle> salles = salleDao.findAll();
		for (Salle salle : salles) {
			System.out.println(salle);
		}

		System.out.println(salleDao.findById(5L));

		Salle salle = new Salle("s205", 35, true);
		salleDao.create(salle);

		salle.setCapacite(25);
		salle.setNom("s210");
		salle.setVideoProjecteur(false);

		salleDao.update(salle);

		salleDao.delete(salle);
		
		//-------------------Test stagiaireDao-----------------------------//
		
		List<Stagiaire> stagiaires = stagiaireDao.findAll();
		for (Stagiaire stagiere : stagiaires) {
			System.out.println(stagiere);
		}

		System.out.println(stagiaireDao.findById(6L));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Stagiaire stagiaire = new Stagiaire("ld@gmail.com");
		stagiaire.setCivilite(Civilite.MLLE);
		stagiaire.setNom("Dumont");
		stagiaire.setPrenom("Léa");
		stagiaire.setTelephone("0509090909");	
		//stagiaire.setDtNaissance(new Date());

		String dateInString = "1997-12-25";
		try {
			Date dt = sdf.parse(dateInString);
			stagiaire.setDtNaissance(dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		Date dt = new Date();
//		dt.setYear(3897);
//		dt.setMonth(11);
//		dt.setDate(25);
//		stagiaire.setDtNaissance(dt);
		
		stagiaire.setNiveauEtude(NiveauEtude.BAC_5);
		stagiaireDao.create(stagiaire);

		stagiaire.setCivilite(Civilite.MME);
		stagiaire.setTelephone("0606060606");

		stagiaireDao.update(stagiaire);

		stagiaireDao.delete(stagiaire);




		
		
	}

}
