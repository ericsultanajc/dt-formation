package sopra.formation.model;

public class Salle {
	private Long id;
	private String nom;
	private Integer capacite;
	private Boolean videoProjecteur;
	private Adresse adresse;
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
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	public Boolean getVideoProjecteur() {
		return videoProjecteur;
	}
	public void setVideoProjecteur(Boolean videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
