package sopra.formation.model;

public class Matiere {
	private Long id;
	private String nom;
	private Integer matiere;

	
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

}
