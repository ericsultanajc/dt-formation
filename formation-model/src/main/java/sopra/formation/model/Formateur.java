package sopra.formation.model;

import java.util.List;
import java.util.ArrayList;

public class Formateur extends Personne {
	private Integer experience;
	private List<Filiere> filieres = new ArrayList<Filiere>();
	private List<UE> ues = new ArrayList<UE>();
	
	public Formateur() {
		super();
	}

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

	public List<UE> getUes() {
		return ues;
	}

	public void setUes(List<UE> ues) {
		this.ues = ues;
	}
	
	
}
