package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
	private Long id;
	private String nom;
	private Integer capacite;
	private Boolean videoProjecteur;
	private Adresse adresse;
	private List<UE> ues= new ArrayList<>();
	public Salle() {
		super();
	}
	
	
	public Salle(Long id, String nom, Integer capacite, Boolean videoProjecteur) {
		super();
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.videoProjecteur = videoProjecteur;
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
