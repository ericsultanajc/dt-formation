package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formateur extends Personne {
	private Integer experience;
	private List<Matiere> matiere = new ArrayList<>();
	private List<UE> uE = new ArrayList<>();
	private List<Filiere> filiere = new ArrayList<>();
	public Formateur() {
		super();
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public List<Matiere> getMatiere() {
		return matiere;
	}
	public void setMatiere(List<Matiere> matiere) {
		this.matiere = matiere;
	}
	public List<UE> getuE() {
		return uE;
	}
	public void setuE(List<UE> uE) {
		this.uE = uE;
	}
	public List<Filiere> getFiliere() {
		return filiere;
	}
	public void setFiliere(List<Filiere> filiere) {
		this.filiere = filiere;
	}
	
	
}
