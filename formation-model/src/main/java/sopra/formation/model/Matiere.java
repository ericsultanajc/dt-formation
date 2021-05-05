package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Matiere {
	private Long id;
	private String nom;
	private Integer matiere;
	
	private List<UE> listUE = new ArrayList<UE>();
	private List<Formateur> listFormateurs = new ArrayList<Formateur>();

	
	public Matiere() {
		super();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getMatiere() {
		return matiere;
	}

	public void setMatiere(Integer matiere) {
		this.matiere = matiere;
	}


	public List<UE> getListUE() {
		return listUE;
	}


	public void setListUE(List<UE> listUE) {
		this.listUE = listUE;
	}


	public List<Formateur> getListFormateurs() {
		return listFormateurs;
	}


	public void setListFormateurs(List<Formateur> listFormateurs) {
		this.listFormateurs = listFormateurs;
	}

}
