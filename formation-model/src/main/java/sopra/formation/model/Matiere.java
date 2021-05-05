package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Matiere {
	private Long id;
	private String nom;
	private Integer matiere;
	
	private List<UE> ue = new ArrayList<>();
	private Formateur formateur;
	
	
	
	

	public Matiere() {
		super();
	}
	
	
	
	

	public List<UE> getUe() {
		return ue;
	}





	public void setUe(List<UE> ue) {
		this.ue = ue;
	}





	public Formateur getFormateur() {
		return formateur;
	}





	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
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
