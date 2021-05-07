package sopra.formation;

import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.dao.IUEDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.dao.file.csv.FiliereDaoCsv;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.dao.file.csv.SalleDaoCsv;
import sopra.formation.dao.file.csv.StagiaireDaoCsv;
import sopra.formation.dao.file.csv.UEDaoCsv;

public class Application {
	private static Application instance = null;

	private final IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");
	private final IFiliereDao filiereDao = new FiliereDaoCsv("filieres.txt");
	private final IFormateurDao formateurDao = new FormateurDaoCsv("formateurs.txt", "competences.txt");
	private final IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");
	private final ISalleDao salleDao = new SalleDaoCsv("salles.txt");
	private final IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaires.txt");
	private final IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");
	private final IFiliereDao filiereDao = new FiliereDaoCsv ("filieres.txt");

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

	public IFiliereDao getFiliereDao() {
		return filiereDao;
	}

	public IFormateurDao getFormateurDao() {
		return formateurDao;
	}

	public IMatiereDao getMatiereDao() {
		return matiereDao;
	}
	
	public IFiliereDao getFiliereDao() {
		return filiereDao;
	}
	
}
