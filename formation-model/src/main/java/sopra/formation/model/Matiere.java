package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Matiere {
	private Long id;
	private String nom;
	private Integer duree;
	private List<Formateur> Formateurs = new ArrayList<>();
	private List<UE> ues = new ArrayList<>();

	public Matiere() {
		super();
	}
	
	

	public Matiere(Long id, String noms, Integer duree) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree=duree;
	}



	public Matiere(String nom, Integer duree) {
		super();
		this.nom = nom;
		this.duree = duree;
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



	public Integer getDuree() {
		return duree;
	}



	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	
	

}
