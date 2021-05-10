package sopra.formation.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class TestSerialisation {

	public static void main(String[] args) throws ParseException {
		serialiser();

//		deserialiser();

	}

	private static void serialiser() throws ParseException {
		Stagiaire manon = new Stagiaire("serain.manon@yahoo.com");
		manon.setCivilite(Civilite.MME);
		manon.setNom("SERAIN");
		manon.setPrenom("Manon");
		manon.setTelephone("0645457845");
		manon.setDtNaissance(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1996"));
		manon.setNiveauEtude(NiveauEtude.BAC_5);
		
		manon.setAdresse(new Adresse("rue jfdsjfds","","",""));
				
		Filiere dreamTeam = new Filiere("DREAM TEAM");
		dreamTeam.setIntitule("JAVA SPRING ANGULAR");
		dreamTeam.setDtDebut(new SimpleDateFormat("dd/MM/yyyy").parse("13/04/2021"));
		dreamTeam.setDuree(57);
		dreamTeam.setDispositif(Dispositif.POEI);

		manon.setFiliere(dreamTeam);
		
		dreamTeam.addStagiaire(manon);
		
		
		File fichier = new File("stagiaire.ser");

		// ouverture d'un flux sur un fichier
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichier));

			

			// sérialization de l'objet
			oos.writeObject(manon);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void deserialiser() {
		File fichier = new File("evaluation.ser");

		// ouverture d'un flux sur un fichier
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(fichier));
			
			// désérialization de l'objet
			Evaluation eval = (Evaluation) ois.readObject();
			System.out.println(eval);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		

	}

}
