package sopra.formation.test;

import java.util.Date;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.dao.file.csv.StagiaireDaoCsv;
import sopra.formation.model.Civilite;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class TestDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");
		IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");
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
		
		
		Matiere matiere = new Matiere("Java", 250);

		matiereDao.create(matiere);
		
		Filiere filiere = new Filiere();
		Stagiaire stagiaire = new Stagiaire(12L, Civilite.valueOf("M"), "jojo", "lapin", "blabla@popo", "060504030201", new Date(), NiveauEtude.valueOf("BAC"), filiere, evaluation);
		
		stagiaireDao.create(stagiaire);
	
	}

}
