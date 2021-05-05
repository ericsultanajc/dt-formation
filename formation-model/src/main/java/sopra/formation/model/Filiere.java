package sopra.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filiere {
	private long id;
	private String intitule;
	private String promotion;
	private Date dtDebut;
	private int duree;
	private Dispositif dispositif;
	private List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	private List<UE> UES = new ArrayList<UE>();
	private Formateur formateur;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Dispositif getDispositif() {
		return dispositif;
	}
	public void setDispositif(Dispositif dispositif) {
		this.dispositif = dispositif;
	}
	

}
