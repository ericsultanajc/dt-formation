package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Salle {
	
	private Long id;
	private String nom;
	private Integer capacite;
	private Boolean videoProjecteur;
	private Adresse adresse;
	private List<UE> ues;
	
	public Salle() {
		this(0l,null,0,null);
	}
	
	public Salle(Long id, String nom, Integer capacite, Boolean videoProjecteur) {
		super();
		this.id = id;
		this.nom = nom;
		this.capacite = capacite;
		this.videoProjecteur = videoProjecteur;
		ues = new ArrayList<UE>();
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
	
	public List<UE> getUes(){
		return ues;
	}

	public UE getUE(Long unId) {
		for (int i = 0; i < ues.size(); i++) {
			if (ues.get(i)!= null && ues.get(i).getId() ==
					unId) {
				return ues.get(i);
			}
		}
		return null;
	}

	public void ajouterUE(UE unUE) {
		this.ues.add(unUE);		
	}

}
