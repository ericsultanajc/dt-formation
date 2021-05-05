package sopra.formation.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Filiere {
	
	private Long id;
	private String intitule;
	private String promotion;
	private Date dtDebut;
	private Integer duree;
	private Dispositif dispositif;
	
	
	private Formateur formateur;
	private List<Stagiaire> stagiaire = new ArrayList<>();
	private List<UE> ue = new ArrayList<>();
			
	
	public Filiere() {
		super();
	}
				
	
	public Filiere(String intitule, String promotion, Date dtDebut, Integer duree, Dispositif dispositif) {
		super();
		this.intitule = intitule;
		this.promotion = promotion;
		this.dtDebut = dtDebut;
		this.duree = duree;
		this.dispositif = dispositif;
	}
	
	public Filiere(Long id, String intitule, String promotion, Date dtDebut, Integer duree, Dispositif dispositif) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.promotion = promotion;
		this.dtDebut = dtDebut;
		this.duree = duree;
		this.dispositif = dispositif;
	}


	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public List<Stagiaire> getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(List<Stagiaire> stagiaire) {
		this.stagiaire = stagiaire;
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
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getPromotion() {
		return promotion;
	}
	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}
	public Date getDtDebut() {
		return dtDebut;
	}
	public void setDtDebut(Date dtDebut) {
		this.dtDebut = dtDebut;
	}
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	public Dispositif getDispositif() {
		return dispositif;
	}
	public void setDispositif(Dispositif dispositif) {
		this.dispositif = dispositif;
	}
	
	
	

}
