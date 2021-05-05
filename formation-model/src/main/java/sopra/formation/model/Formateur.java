package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formateur extends Personne {
	
	private Integer experience;
	
	private List<Matiere> listMatieres = new ArrayList<Matiere>();
	private List<UE> listUE = new ArrayList<UE>();
	private List<Filiere> listFilieres = new ArrayList<Filiere>();
	

	
	public Formateur() {
		super();
	}

	
	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}


	public List<Matiere> getListMatieres() {
		return listMatieres;
	}


	public void setListMatieres(List<Matiere> listMatieres) {
		this.listMatieres = listMatieres;
	}


	public List<UE> getListUE() {
		return listUE;
	}


	public void setListUE(List<UE> listUE) {
		this.listUE = listUE;
	}


	public List<Filiere> getListFilieres() {
		return listFilieres;
	}


	public void setListFilieres(List<Filiere> listFilieres) {
		this.listFilieres = listFilieres;
	}
	
	

}
