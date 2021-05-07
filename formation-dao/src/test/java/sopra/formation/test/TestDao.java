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
import sopra.formation.model.Civilite;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class TestDao {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");
		IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");
		IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaires.txt");

		List<Evaluation> evaluations = evaluationDao.findAll();
		List<Matiere> matieres = matiereDao.findAll();
		List<Stagiaire> stagiaires = stagiaireDao.findAll();

		for (Evaluation evaluation : evaluations) {
			System.out.println(evaluation);
		}
		
		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}
		
		for (Stagiaire stagiaire : stagiaires) {
			System.out.println(stagiaire);
		}

		System.out.println(evaluationDao.findById(5L));

		Evaluation evaluation = new Evaluation(14, 12, "Peut mieux faire");
		Matiere matiere = new Matiere("francais", 5);
		Matiere matiere1 = new Matiere("maths", 12);
		Matiere matiere2 = new Matiere("anglais", 3);
		Matiere matiere3 = new Matiere("techno", 1);
		
		//signature de stagiaire : (Long id, Civilite civilite, String nom, String prenom, String email, String telephone, Date dtNaissance, NiveauEtude niveau Etude)
		Stagiaire stagiaire1 = new Stagiaire(Civilite.MLLE, "PECQUE", "Aubeline", "aubeline.pecque@hotmail.com", "0609985235", sdf.parse("16/09/1992"), NiveauEtude.BAC_5);
		Stagiaire stagiaire2 = new Stagiaire(Civilite.M, "DUPONT", "Jean", "jean.dupont@hotmail.com", "0265842635", sdf.parse("17/10/1993"), NiveauEtude.BAC_3);

		evaluationDao.create(evaluation);
		matiereDao.create(matiere);
		matiereDao.create(matiere1);
		matiereDao.create(matiere2);
		matiereDao.create(matiere3);
		
		stagiaireDao.create(stagiaire1);
		stagiaireDao.create(stagiaire2);
		
		

		evaluation.setComportemental(18);
		evaluation.setTechnique(15);
		evaluation.setCommentaires("Grosse amélioration");

		evaluationDao.update(evaluation);

		evaluationDao.delete(evaluation);
		
		matiere.setNom("sport");
		matiere.setDuree(4);
		
		matiereDao.update(matiere);
		
	}

}
