package sopra.formation.test;

import java.util.List;

import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.model.Evaluation;

public class TestDao {

	public static void main(String[] args) {
		IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");

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
