package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formateur extends Personne {
	
	private Integer experience;

	//Cardinalite
	private List<Filiere> filiere = new ArrayList();
	private List<UE> ue = new ArrayList();
	private List<Matiere> matiere = new ArrayList();
	
	public Formateur() {
		super();
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public List<Filiere> getFiliere() {
		return filiere;
	}

	public void setFiliere(List<Filiere> filiere) {
		this.filiere = filiere;
	}

	public List<UE> getUe() {
		return ue;
	}

	public void setUe(List<UE> ue) {
		this.ue = ue;
	}

	public List<Matiere> getMatiere() {
		return matiere;
	}

	public void setMatiere(List<Matiere> matiere) {
		this.matiere = matiere;
	}
	
	
	

}
