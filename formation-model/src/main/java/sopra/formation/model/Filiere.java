package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filiere {
	private Long id;
	private String intitule;
	private String promotion;
	private Date dtDebut;
	private Integer duree;
	private Dispositif dispositif;
	private List<UE> ues= new ArrayList<>();
	private List<Stagiaire> stagiaires = new ArrayList<>();
	private Formateur referent;
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
	public List<UE> getUes() {
		return ues;
	}
	public void setUes(List<UE> ues) {
		this.ues = ues;
	}
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	public Formateur getReferent() {
		return referent;
	}
	public void setReferent(Formateur referent) {
		this.referent = referent;
	}
	
	
}
