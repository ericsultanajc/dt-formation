package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class TestMatiereSql {
	
	public static void main(String[] args) throws ParseException {
		
		
		IEvaluationDao evaluationDao = Application.getInstance().getEvaluationDao();
		IStagiaireDao stagiaireDao = Application.getInstance().getStagiaireDao();
		IMatiereDao matiereDao = Application.getInstance().getMatiereDao();
		IFiliereDao filiereDao = Application.getInstance().getFiliereDao();

		List<Matiere> matieres = matiereDao.findAll();

		System.out.println(matiereDao.findById(5L));

		Matiere matiere = new Matiere("JAVA", 12);

		matiereDao.create(matiere);
		System.out.println(matiereDao.findAll());
		
		matiere.setNom("UML");
		matiere.setDuree(15);
		
		matiereDao.update(matiere);
		
		
		
	

		/**evaluationDao.update(evaluation);

		evaluationDao.delete(evaluation);*/

	}
}

