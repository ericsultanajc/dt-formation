package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IFormateurDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Civilite;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;

public class TestDao {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IEvaluationDao evaluationDao = Application.getInstance().getEvaluationDao();
		IStagiaireDao stagiaireDao = Application.getInstance().getStagiaireDao();
		IFormateurDao formateurDao = Application.getInstance().getFormateurDao();
		IMatiereDao matiereDao = Application.getInstance().getMatiereDao();
		IFiliereDao filiereDao = Application.getInstance().getFiliereDao();

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
		
//		Stagiaire lea = new Stagiaire("lea.dumont@gmail.com");
//		lea.setCivilite(Civilite.MLLE);
//		lea.setNom("DUMONT");
//		lea.setPrenom("Léa");
//		lea.setTelephone("0606060606");
//		lea.setDtNaissance(sdf.parse("25/12/1995"));
//		lea.setNiveauEtude(NiveauEtude.BAC_8);
//
//		Adresse adrLea = new Adresse();
//
//		adrLea.setRue("5 avenue villemejan");
//		adrLea.setComplement("Résidence Diderot");
//		adrLea.setCodePostal("33600");
//		adrLea.setVille("PESSAC");
//
//		lea.setAdresse(adrLea);
//		
//		lea.setEvaluation(evaluation);
//		
//		
//		stagiaireDao.create(lea);
//
//		Stagiaire manon = new Stagiaire("serain.manon@yahoo.com");
//		manon.setCivilite(Civilite.MME);
//		manon.setNom("SERAIN");
//		manon.setPrenom("Manon");
//		manon.setTelephone("0645457845");
//		((Stagiaire) manon).setDtNaissance(sdf.parse("01/01/1996"));
//		((Stagiaire) manon).setNiveauEtude(NiveauEtude.BAC_5);
//		
//		stagiaireDao.create(manon);
//		
//		Filiere dreamTeam = new Filiere("DREAM TEAM");
//		dreamTeam.setIntitule("JAVA SPRING ANGULAR");
//		dreamTeam.setDtDebut(sdf.parse("13/04/2021"));
//		dreamTeam.setDuree(57);
//		dreamTeam.setDispositif(Dispositif.POEI);
//		
//		
//
//		manon.setFiliere(dreamTeam);
//		
//		filiereDao.create(dreamTeam);
//		
//		stagiaireDao.update(manon);
		
		Formateur eric = new Formateur("e.sultan@ajc-ingenierie.fr");
		eric.setCivilite(Civilite.M);
		eric.setNom("SULTAN");
		eric.setPrenom("Eric");
		eric.setTelephone("0645104506");
		eric.setAdresse("4 rue de Corono", "", "33160", "Saint-Médard-en-Jalles");
		eric.setReferent(true);
		eric.setExperience(20);
		
		formateurDao.create(eric);
		
		Matiere unix = new Matiere("UNIX", 1);
		matiereDao.create(unix);
		
		Matiere html = new Matiere("HTML", 2);
		matiereDao.create(html);
		
		eric.addCompetence(unix);
		eric.addCompetence(html);
		
		formateurDao.update(eric);
		
//		unix.addFormateur(eric); côté esclave non nécessaire pour la synchronisation en BDD
//		html.addFormateur(eric);
//		
//		matiereDao.update(unix);
//		matiereDao.update(html);
		
	}

}
