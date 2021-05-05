package sopra.formation.model;

import java.util.List;
import java.util.ArrayList;

public class Matiere {
	private Long id;
	private String nom;
	private Integer matiere;
	private List<UE> ues = new ArrayList<UE>();
	private List<Formateur> formateurs = new ArrayList<Formateur>();

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

	public List<UE> getUes() {
		return ues;
	}

	public void setUes(List<UE> ues) {
		this.ues = ues;
	}
	
	

}
