package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Matiere {
	private Long id;
	private String nom;
	private Integer matiere;
	private List<Formateur> Formateurs = new ArrayList<>();
	private List<UE> ues = new ArrayList<>();

	public Matiere() {
		super();
	}
	
	

	public Matiere(Long id, String nom, Integer matiere) {
		super();
		this.id = id;
		this.nom = nom;
		this.matiere = matiere;
	}


	
	public List<Formateur> getFormateurs() {
		return Formateurs;
	}



	public void setFormateurs(List<Formateur> formateurs) {
		Formateurs = formateurs;
	}



	public List<UE> getUes() {
		return ues;
	}



	public void setUes(List<UE> ues) {
		this.ues = ues;
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

}
