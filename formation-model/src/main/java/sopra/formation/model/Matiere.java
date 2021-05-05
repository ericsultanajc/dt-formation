package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Matiere {
	private Long id;
	private String nom;
	private Integer matiere;
	private List<Formateur> formateur = new ArrayList<>();
	private List<UE> uE = new ArrayList<>();
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

	public List<Formateur> getFormateur() {
		return formateur;
	}

	public void setFormateur(List<Formateur> formateur) {
		this.formateur = formateur;
	}

	public List<UE> getuE() {
		return uE;
	}

	public void setuE(List<UE> uE) {
		this.uE = uE;
	}

}
