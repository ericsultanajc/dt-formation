package sopra.formation.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Salle;
import sopra.formation.model.Stagiaire;
import sopra.formation.model.UE;

public class TestModel {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Stagiaire Baptiste = new Stagiaire(Civilite.M,"Dessandier","Baptiste","baptiste.dessandier@gmail.com","0624472830",dt.parse("28/10/1995 00:00"),NiveauEtude.BAC_5);
		Stagiaire Flo = new Stagiaire(Civilite.M,"MARRIS","Florian","flo.marris@gmail.com","0626673547",dt.parse("28/07/1997 00:00"),NiveauEtude.BAC_5);
		Formateur eric = new Formateur(Civilite.M,"MARRIS","Florian","flo.marris@gmail.com","0626673547",20);
		Evaluation evalbat=new Evaluation(10,10,"RIEN A DIRE");
		Evaluation evalflo=new Evaluation(9,9,"RIEN A DIRE NON PLUS");
		Baptiste.setEval(evalbat);
		Flo.setEval(evalflo);
		Filiere filieresopra= new Filiere("J2EE","2021",dt.parse("12/04/2021 09:00"),3,Dispositif.POEI);
		Baptiste.setFiliere(filieresopra);
		Flo.setFiliere(filieresopra);
		Adresse salleformasopra = new Adresse("20 avenue de Pythagore","","33700","Mérignac");
		Adresse adrbat = new Adresse("45 rue des Carmélites","Appartement 15","86000","Poitiers");
		Adresse adrflo = new Adresse("69 rue des SansDents","","59067","Bergues");
		Adresse adreric = new Adresse ("56 rue des Lilas","","33449","Saint-Médard en Jalles");
		Baptiste.setAdresse(adrbat);
		Flo.setAdresse(adrflo);
		eric.setAdresse(adreric);
		Salle sallesopra = new Salle("Salle Schrödinger",25,false);
		sallesopra.setAdresse(salleformasopra);
		Matiere bddmysql = new Matiere();
		UE bdd = new UE();
	}

}
