package sopra.formation.model;

import java.util.List;

public class Formateur extends Personne {

	private Integer experience;
	private List<Filiere> filieres;
	private List<UE> UES;
	private List<Matiere> matieres;

	public Formateur() {
		super();
	}

	public Formateur(Integer experience) {
		super();
		this.experience = experience;
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

	public List<UE> getUES() {
		return UES;
	}

	public void setUES(List<UE> uES) {
		UES = uES;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}
	
	
	
}
