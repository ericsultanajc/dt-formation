package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.file.csv.EvaluationDaoCsv;
import sopra.formation.dao.file.csv.FiliereDaoCsv;
import sopra.formation.dao.file.csv.MatiereDaoCsv;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Matiere;

public class TestDao {

	public static void main(String[] args) {

		// TEST EVALUATION //////////////////////////////////////////////////////////////////////
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
		
		// TEST FILIERE /////////////////////////////////////////////////////////////////////////
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date1;
		Date date2;
		Date date3;
		Date date4;
		
		try {
			date1 = (Date)sdf.parse("13/04/2021");
			date2 = (Date)sdf.parse("02/09/2021");
			date3 = (Date)sdf.parse("24/01/2022");
			date4 = (Date)sdf.parse("15/03/2022");
			
			IFiliereDao filiereDao = new FiliereDaoCsv("filieres.txt");
			
			Filiere filiere1 = new Filiere("J2EE", "Dream Team", date1, 3, Dispositif.POEI);
			Filiere filiere2 = new Filiere(".NET", "Dream Pas Team", date2, 4, Dispositif.PROA);
			Filiere filiere3 = new Filiere("COBOLT", "Holé Holé", date3, 2, Dispositif.POEC);
			Filiere filiere4 = new Filiere("C++", "Mucho Banana", date4, 6, Dispositif.CPRO);
			
			filiereDao.create(filiere1);
			filiereDao.create(filiere2);
			filiereDao.create(filiere3);
			filiereDao.create(filiere4);
			
			filiere1.setDispositif(Dispositif.CPRO);
			filiere1.setDtDebut(date4);
			filiere1.setIntitule("Python & R");
			
			filiereDao.update(filiere1);
			
			filiereDao.delete(filiere3);
			
			System.out.println(filiereDao.findById(4L));
			
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		// TEST ADRESSE /////////////////////////////////////////////////////////////////////////
		
		// TEST FORMATEUR ///////////////////////////////////////////////////////////////////////
		
		// TEST MATIERE /////////////////////////////////////////////////////////////////////////
		IMatiereDao matiereDao = new MatiereDaoCsv("matieres.txt");
		
		List<Matiere> matieres = matiereDao.findAll();

		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}
		
		Matiere matiere2 = matiereDao.findById(2L);
		System.out.println(matiere2);
		
		Matiere matiere4 = new Matiere("Angular", 5);
		matiereDao.create(matiere4);
		
		matiere2.setDuree(12);
		matiere2.setNom("Méthode agile");
		matiereDao.update(matiere2);
		
		matiereDao.deleteById(4L);
		
		// TEST PERSONNE ////////////////////////////////////////////////////////////////////////
		
		// TEST SALLE ///////////////////////////////////////////////////////////////////////////
		
		// TEST STAGIAIRE ///////////////////////////////////////////////////////////////////////
		
		// TEST UE //////////////////////////////////////////////////////////////////////////////
	}

}
