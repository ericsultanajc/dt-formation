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
		IMatiereDao matiereDAO = new MatiereDaoCsv("matieres.txt");
		IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaire.txt");

		
		List<Evaluation> evaluations = evaluationDao.findAll();

		for (Evaluation evaluation : evaluations) {
			System.out.println(evaluation);
		}
		
		
		List<Matiere> matieres=matiereDAO.findAll();
		
		for (Matiere matiere : matieres) {
			System.out.println(matieres);
		}
		
		List<Stagiaire> stagiaires=stagiaireDao.findAll();
		
		for (Matiere matiere : matieres) {
			System.out.println(matieres);
		}

		System.out.println(evaluationDao.findById(5L));
		
		System.out.println(matiereDAO.findById(1L));

		Evaluation evaluation = new Evaluation(14, 12, "Peut mieux faire");
		Matiere matiere = new Matiere(3L,"SQL", 30);

		evaluationDao.create(evaluation);
		matiereDAO.create(matiere);

		evaluation.setComportemental(18);
		evaluation.setTechnique(15);
		evaluation.setCommentaires("Grosse amélioration");
	
		evaluationDao.update(evaluation);

		evaluationDao.delete(evaluation);
		
		matiere.setDuree(3);
		matiere.setId(4L);
		matiere.setNom("Maven");
		matiereDAO.update(matiere);
		matiereDAO.delete(matiere);
	}

}
