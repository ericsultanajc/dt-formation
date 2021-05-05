package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formateur extends Personne{
	private int experience;
	private List<Filiere> filieres = new ArrayList<Filiere>();
	private List<Matiere> matieres = new ArrayList<Matiere>();
	private List<UE> UES = new ArrayList<UE>();
	private Adresse adresse;

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	

}
