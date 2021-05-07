package sopra.formation.test;

import java.util.List;

import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.dao.file.csv.StagiaireDaoCsv;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Matiere;
import sopra.formation.model.Stagiaire;

public class TestDao {

	public static void main(String[] args) {
		IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");
		IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");
		IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaires.txt");

		List <Stagiaire> stagiaires = stagiaireDao.findAll();
		Stagiaire stagiaire = new Stagiaire(5,"MME", "Perey", "Flo", "xxx.ffg@gmail.com", "0557930018", , 10/10/1996, "BAC3");
		stagiaireDao.create(stagiaire);
		stagiaireDao.update(stagiaire);
		stagiaireDao.delete(stagiaire);
		
		List <Matiere> matieres = matiereDao.findAll();
		
		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}
		
		Matiere matiere = new Matiere("geo",20);
		matiereDao.create(matiere);
		matiereDao.update(matiere);
		matiereDao.delete(matiere);
		
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
	}

}
