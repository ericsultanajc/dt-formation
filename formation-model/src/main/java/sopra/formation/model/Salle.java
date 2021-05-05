package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
	
	private Long id;
	private String nom;
	private Integer capacite;
	private Boolean videoProjecteur;
	
	private List<UE> listUE = new ArrayList<UE>();
	private Adresse adresse;
	
	
	public Salle() {
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

	public List<UE> getListUE() {
		return listUE;
	}

	public void setListUE(List<UE> listUE) {
		this.listUE = listUE;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	};
	
	

}
