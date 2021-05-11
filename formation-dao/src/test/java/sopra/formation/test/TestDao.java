package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IFormateurDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.ISalleDao;
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
		ISalleDao salleDao = Application.getInstance().getSalleDao();

		List<Evaluation> evaluations = evaluationDao.findAll();
		List<Matiere> matieres = matiereDao.findAll();
		List<Stagiaire> stagiaires = stagiaireDao.findAll();
		List<Filiere> filieres = filiereDao.findAll();
		List<Salle> salles = salleDao.findAll();

		for (Evaluation evaluation : evaluations) {
			System.out.println(evaluation);
		}
		
		for (Matiere matiere : matieres) {
			System.out.println(matiere);
		}
		
		for (Stagiaire stagiaire : stagiaires) {
			System.out.println(stagiaire);
		}
		
		for (Filiere filiere : filieres) {
			System.out.println(filiere);
		}
		
		for (Salle salle : salles) {
			System.out.println(salle);
		}


		System.out.println(evaluationDao.findById(5L));

		Evaluation evaluation = new Evaluation(14, 12, "Peut mieux faire");
		Matiere matiere = new Matiere("francais", 5);
		Matiere matiere1 = new Matiere("maths", 12);
		Matiere matiere2 = new Matiere("anglais", 3);
		Matiere matiere3 = new Matiere("techno", 1);
		
		Filiere filiere = new Filiere("2021");
		
		//signature de stagiaire : (Long id, Civilite civilite, String nom, String prenom, String email, String telephone, Date dtNaissance, NiveauEtude niveau Etude)
		Stagiaire stagiaire1 = new Stagiaire(Civilite.MLLE, "PECQUE", "Aubeline", "aubeline.pecque@hotmail.com", "0609985235", sdf.parse("16/09/1992"), NiveauEtude.BAC_5);
		Stagiaire stagiaire2 = new Stagiaire(Civilite.M, "DUPONT", "Jean", "jean.dupont@hotmail.com", "0265842635", sdf.parse("17/10/1993"), NiveauEtude.BAC_3);

		evaluationDao.create(evaluation);
		
		

		evaluation.setComportemental(18);
		evaluation.setTechnique(15);
		evaluation.setCommentaires("Grosse amélioration");

		evaluationDao.update(evaluation);

		evaluationDao.delete(evaluation);
		
		matiereDao.create(matiere);
		matiereDao.create(matiere1);
		matiereDao.create(matiere2);
		matiereDao.create(matiere3);
		
		Salle salle1 = new Salle("Salle 32", 25, true);
		Salle salle2 = new Salle("Salle 33", 30, false);
		Salle salle3 = new Salle("Salle 34", 27, true);
		
		Adresse adresse1 = new Adresse("1 rue des champs", "", "33000", "Bordeaux");
		Adresse adresse2 = new Adresse("2 impasse toto", "", "33540", "Bordeaux ext");
		Adresse adresse3 = new Adresse("3 impasse tata", "", "32475", "Bordeaux int");
		
		salle1.setAdr(adresse1);
		salle2.setAdr(adresse2);
		salle3.setAdr(adresse3);
		
		salleDao.create(salle1);
		salleDao.create(salle2);
		salleDao.create(salle3);
		

		
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
