package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
	private int id;
	private String nom;
	private int capacite;
	private boolean videoProjecteur;
	private Adresse adresse;
	private List<UE> UES = new ArrayList<UE>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public boolean isVideoProjecteur() {
		return videoProjecteur;
	}
	public void setVideoProjecteur(boolean videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}
	
	

}
