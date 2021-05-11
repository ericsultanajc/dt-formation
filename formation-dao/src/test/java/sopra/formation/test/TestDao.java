package sopra.formation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IEvaluationDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.dao.IMatiereDao;
import sopra.formation.dao.ISalleDao;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;

public class TestDao {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		IEvaluationDao evaluationDao = Application.getInstance().getEvaluationDao();
		IStagiaireDao stagiaireDao = Application.getInstance().getStagiaireDao();
		IMatiereDao matiereDao = Application.getInstance().getMatiereDao();
		IFiliereDao filiereDao = Application.getInstance().getFiliereDao();
		ISalleDao salleDao = Application.getInstance().getSalleDao();

		
//		List<Evaluation> evaluations = evaluationDao.findAll();
//		List<Filiere> filieres = filiereDao.findAll();
//		
//
//		for (Evaluation evaluation : evaluations) {
//			System.out.println(evaluation);
//		}
//		
//		
//		List<Matiere> matieres=matiereDao.findAll();
//		
//		for (Matiere matiere : matieres) {
//			System.out.println(matieres);
//		}
//		
//		List<Stagiaire> stagiaires=stagiaireDao.findAll();
//		
//		for (Matiere matiere : matieres) {
//			System.out.println(matieres);
//		}
//
//		System.out.println(evaluationDao.findById(5L));
//		
//		System.out.println(matiereDao.findById(1L));
//
//		Evaluation evaluation = new Evaluation(14, 12, "Peut mieux faire");
//		Matiere matiere = new Matiere(3L,"SQL", 30);
//
//		evaluationDao.create(evaluation);

//		evaluation.setComportemental(18);
//		evaluation.setTechnique(15);
//		evaluation.setCommentaires("Grosse amélioration");
//
//		evaluationDao.update(evaluation);

//		evaluationDao.delete(evaluation);
		
		

//		evaluation.setComportemental(18);
//		evaluation.setTechnique(15);
//		evaluation.setCommentaires("Grosse amélioration");
//
//		evaluationDao.update(evaluation);
//
//		evaluationDao.delete(evaluation);
		
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
		
		
		
//		Matiere math = new Matiere();
//		Matiere svt = new Matiere();
//		Matiere anglais = new Matiere();
//		
//		
//		math.setNom("math");
//		math.setDuree(6);
//		matiereDao.create(math);
//		
//		
//		svt.setNom("svt");
//		svt.setDuree(5);
//		matiereDao.create(svt);
//		
//		
//		anglais.setNom("anglais");
//		anglais.setDuree(2);
//		matiereDao.create(anglais);
		
		
		
		Salle s1 = new Salle();
		Salle s2 = new Salle();
		Salle s3 = new Salle();
		
		Adresse adrS1=new Adresse();
		
		s1.setNom("Pyhtagoe");
		s1.setCapacite(25);
		s1.setVideoProjecteur(true);
		adrS1.setRue("Pythagore");
		adrS1.setComplement("2");
		adrS1.setCodePostal("33000");
		adrS1.setVille("Bordeaux");
		s1.setAdr(adrS1);
		
		salleDao.create(s1);
		
		
//		Adresse adrS2=new Adresse("Wilson", "4", "13001", "Marseille");
//		
//		s2.setNom("Thales");
//		s2.setCapacite(25);
//		s2.setVideoProjecteur(true);
//		s2.setAdr(adrS2);
//		
//		salleDao.create(s2);
		
		s1.setCapacite(30);
		salleDao.update(s1);
		
		
		
	}
	
	

}
