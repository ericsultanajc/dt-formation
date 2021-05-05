package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formateur extends Personne {

	private Integer experience;
	private List<Filiere> filieres = new ArrayList<Filiere>();
	private List<Matiere> matieres = new ArrayList<Matiere>();
	private List<UE> ues = new ArrayList<UE>();
	
// ------------------------------------------------------------------------------------
	
	public Formateur() {
		super();
	}

// ------------------------------------------------------------------------------------
	
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public List<Filiere> getFilieres() {
		return filieres;
	}
	public void setFilieres(List<Filiere> filieres) {
		this.filieres = filieres;
	}
	public List<Matiere> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	public List<UE> getUes() {
		return ues;
	}
	public void setUes(List<UE> ues) {
		this.ues = ues;
	}
}
