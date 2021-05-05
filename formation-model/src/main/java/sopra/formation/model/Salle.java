package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
	
	private Long id;
	private String nim;
	private Integer capacite;
	private Boolean videoProjecteur;
	
	//Cardinalite
	private List<UE> ue = new ArrayList();
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


	public String getNim() {
		return nim;
	}


	public void setNim(String nim) {
		this.nim = nim;
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


	public List<UE> getUe() {
		return ue;
	}


	public void setUe(List<UE> ue) {
		this.ue = ue;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	

}
