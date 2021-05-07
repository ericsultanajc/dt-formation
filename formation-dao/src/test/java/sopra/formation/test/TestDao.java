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
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class TestDao {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IEvaluationDao evaluationDao = Application.getInstance().getEvaluationDao();
		IStagiaireDao stagiaireDao = Application.getInstance().getStagiaireDao();
		IMatiereDao matiereDao = Application.getInstance().getMatiereDao();
		IFiliereDao filiereDao = Application.getInstance().getFiliereDao();

				
		List<Evaluation> evaluations = evaluationDao.findAll();
		
		for (Evaluation evaluation : evaluations) {
			System.out.println(evaluation);
		}

		System.out.println(evaluationDao.findById(5L));

		Evaluation evaluation = new Evaluation(14, 12, "Peut mieux faire");

		evaluationDao.create(evaluation);
		
		Filiere filiere = new Filiere("scientifiques","2020",sdf.parse("03/09/2019"),20,Dispositif.POEI);

		evaluationDao.create(evaluation);
		filiereDao.create(filiere);
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

		adrLea.setRue("5 avenue villemejan");
		adrLea.setComplement("Résidence Diderot");
		adrLea.setCodePostal("33600");
		adrLea.setVille("PESSAC");

		lea.setAdresse(adrLea);
		
		lea.setEvaluation(evaluation);
		lea.setFiliere(filiere);
		
		
		stagiaireDao.create(lea);

		Stagiaire manon = new Stagiaire("serain.manon@yahoo.com");
		manon.setCivilite(Civilite.MME);
		manon.setNom("SERAIN");
		manon.setPrenom("Manon");
		manon.setTelephone("0645457845");
		((Stagiaire) manon).setDtNaissance(sdf.parse("01/01/1996"));
		((Stagiaire) manon).setNiveauEtude(NiveauEtude.BAC_5);
		
		stagiaireDao.create(manon);
		
//		Filiere fil1 = new Filiere();
//		fil1.setIntitule("Scientifiques");
//		fil1.setPromotion("2020");
//		fil1.setDtDebut(sdf.parse("03/09/2019"));
//		fil1.setDuree(20);
//		fil1.setDispositif(Dispositif.POEI);
//		
//		lea.setFiliere(fil1);
//		stagiaireDao.update(lea);
		
	}

}
