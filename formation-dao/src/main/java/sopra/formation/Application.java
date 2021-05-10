package sopra.formation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IFormateurDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.dao.IUEDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.dao.file.csv.FiliereDaoCsv;
import sopra.formation.dao.file.csv.FormateurDaoCsv;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.dao.file.csv.SalleDaoCsv;
import sopra.formation.dao.file.csv.StagiaireDaoCsv;
import sopra.formation.dao.file.csv.UEDaoCsv;
import sopra.formation.dao.sql.EvaluationDaoSql;
import sopra.formation.dao.sql.MatiereDaoSql;
import sopra.formation.dao.sql.SalleDaoSql;

public class Application {
	private static Application instance = null;

	private final IEvaluationDao evaluationDao = new EvaluationDaoSql();
	private final IFiliereDao filiereDao = new FiliereDaoCsv("filieres.txt");
	private final IFormateurDao formateurDao = new FormateurDaoCsv("formateurs.txt", "competences.txt");
	private final IMatiereDao matiereDao = new MatiereDaoSql();
	private final ISalleDao salleDao = new SalleDaoSql();
	private final IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaires.txt");
	private final IUEDao ueDao = new UEDaoCsv("ues.txt");

	private Application() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
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

	public ISalleDao getSalleDao() {
		return salleDao;
	}

	public IStagiaireDao getStagiaireDao() {
		return stagiaireDao;
	}

	public IUEDao getUeDao() {
		return ueDao;
	}
	
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/formation", "root", "admin");
	}

}
