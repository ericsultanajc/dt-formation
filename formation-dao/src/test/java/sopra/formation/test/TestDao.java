package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopra.formation.dao.IStagiaireDao;
import sopra.formation.dao.file.csv.StagiaireDaoCsv;
import sopra.formation.model.Civilite;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

//import sopra.formation.dao.IEvaluationDao;
//import sopra.formation.dao.file.csv.EvaluationDaoCsv;
//import sopra.formation.model.Evaluation;
//import sopra.formation.dao.IMatiereDao;
//import sopra.formation.dao.file.csv.MatiereDaoCsv;
//import sopra.formation.model.Matiere;

public class TestDao {

	public static void main(String[] args) throws ParseException {
		//		IEvaluationDao evaluationDao = new EvaluationDaoCsv("evaluations.txt");
		//
		//		List<Evaluation> evaluations = evaluationDao.findAll();
		//		
		//		IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");
		//
		//		List<Matiere> matieres = matiereDao.findAll();		

		IStagiaireDao stagiaireDao = new StagiaireDaoCsv("stagiaires.txt");
		List<Stagiaire> stagiaires = stagiaireDao.findAll();	
		
		
		System.out.println(stagiaireDao.findById(1L));
		System.out.println("----------------------------------------");

		
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		Stagiaire stagiaire = new Stagiaire(5L,"h.martin@fr");

		stagiaireDao.create(stagiaire);

		stagiaire.setCivilite(Civilite.MME);
		stagiaire.setNom("BLONDEAU");	
		stagiaire.setPrenom("Ginette");
		stagiaire.setTelephone("0241");
		stagiaire.setDtNaissance(sdf.parse("12/12/2020"));
		stagiaire.setNiveauEtude(NiveauEtude.BAC);

		stagiaireDao.update(stagiaire);

////		stagiaireDao.delete(stagiaire);

		for (Stagiaire stag : stagiaires) {
			System.out.println(stag);
		}
	}

}
