package sopra.formation.model;

import java.util.List;

public class Matiere {
	private Long id;
	private String nom;
	private Integer duree;
	private List<Formateur> formateurs;
	private List<UE> UES;

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
		return duree;
	}

	public void setMatiere(Integer matiere) {
		this.duree = matiere;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public List<UE> getUES() {
		return UES;
	}

	public void setUES(List<UE> uES) {
		UES = uES;
	}

}
