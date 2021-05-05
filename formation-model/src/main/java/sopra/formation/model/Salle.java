package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
	
	private Long id;
	private String nom;
	private Integer capacite;
	private Boolean videoProjecteur;
	
	private Adresse adresse;
	private List<UE> ue = new ArrayList<>();	
	
	public Salle() {
		super();
	}
	
	public Salle(String nom, Integer capacite, Boolean videoProjecteur) {
		super();
		this.nom = nom;
		this.capacite = capacite;
		this.videoProjecteur = videoProjecteur;
	}
	
	public Salle(Long id, String nom, Integer capacite, Boolean videoProjecteur) {
		super();
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.videoProjecteur = videoProjecteur;
	}
	
	
	
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<UE> getUe() {
		return ue;
	}

	public void setUe(List<UE> ue) {
		this.ue = ue;
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
	
}
