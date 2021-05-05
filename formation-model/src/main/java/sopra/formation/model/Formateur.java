package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formateur {
	
	private Integer experience;
	
	private List<Filiere> filiere = new ArrayList<>();
	private List<UE> ue = new ArrayList<>();
	
	
	
	
	
	public Formateur() {
		super();		
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
	
	
	

}
