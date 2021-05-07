package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.dao.file.csv.StagiaireDaoCsv;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Matiere;

import sopra.formation.model.Civilite;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class TestDao {

	public static void main(String[] args) {
		IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");
		IMatiereDao matiereDao = new MatiereDaoCsv("matiere.txt");
		IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaire.txt");

		List<Evaluation> evaluations = evaluationDao.findAll();
		
		for (Evaluation evaluation : evaluations) {
			System.out.println(evaluation);
		}
		
		
		System.out.println(evaluationDao.findById(5L));
		
		

		Evaluation evaluation = new Evaluation(14, 12, "Peut mieux faire");

		evaluationDao.create(evaluation);

		evaluation.setComportemental(18);
		evaluation.setTechnique(15);
		evaluation.setCommentaires("Grosse amélioration");

		evaluationDao.update(evaluation);

		evaluationDao.delete(evaluation);
		
		//***************************************************************
		
		
		
		List<Matiere> matieres = matiereDao.findAll();

		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}
		
		System.out.println(matiereDao.findById(1L));
		Matiere matiere = new Matiere("algo", 5);

		matiereDao.create(matiere);

		matiere.setNom("Maven");
		matiere.setDuree(15);
		

		matiereDao.update(matiere);

		matiereDao.delete(matiere);
	

	List<Stagiaire>stagiaires = stagiaireDao.findAll();

	for (Stagiaire stagiaire : stagiaires) {
		System.out.println(stagiaire);
	}
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	System.out.println(stagiaireDao.findById(1L));
	Stagiaire stagiaire = new Stagiaire();

	stagiaireDao.create(stagiaire);
	
	
	stagiaire.setCivilite(Civilite.M);
	stagiaire.setNom("dupond");
	stagiaire.setPrenom("Roger");
	stagiaire.setEmail("blabla");
	stagiaire.setTelephone("15");
	try {
		stagiaire.setDtNaissance(dateFormat.parse("15/12/1998"));
	} catch (ParseException e) {
		
		e.printStackTrace();
	}
	stagiaire.setNiveauEtude(NiveauEtude.BAC_8);
	

	stagiaireDao.update(stagiaire);

	//stagiaireDao.delete(stagiaire);
}
}
