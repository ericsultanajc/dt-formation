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
	
	private List<UE> listUE = new ArrayList<UE>();
	private Formateur formateur;
	private List<Stagiaire> listStagiaires = new ArrayList<Stagiaire>();
	
	
	public Filiere() {
		super();
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


	public List<UE> getListUE() {
		return listUE;
	}


	public void setListUE(List<UE> listUE) {
		this.listUE = listUE;
	}


	public Formateur getFormateur() {
		return formateur;
	}


	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}


	public List<Stagiaire> getListStagiaires() {
		return listStagiaires;
	}


	public void setListStagiaires(List<Stagiaire> listStagiaires) {
		this.listStagiaires = listStagiaires;
	}
	
	

}
