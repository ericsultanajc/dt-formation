package sopra.formation;

import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.dao.file.csv.StagiaireDaoCsv;

public class Application {
	private static Application instance = null;

	private final IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");
	private final IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaires.txt");
	private final IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");

	private Application() {

	}

	public static Application getInstance() {
		if (instance == null) {
			instance = new Application();
		}

		return instance;
	}

	public IEvaluationDao getEvaluationDao() {
		return evaluationDao;
	}

	public IStagiaireDao getStagiaireDao() {
		return stagiaireDao;
	}

	public IMatiereDao getMatiereDao() {
		return matiereDao;
	}
	
}
