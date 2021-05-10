package sopra.formation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Filiere implements Serializable {
	private Long id;
	private String intitule;
	private String promotion;
	private Date dtDebut;
	private Integer duree;
	private Dispositif dispositif;
	private List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	private List<UE> ues = new ArrayList<UE>();
	private Formateur referent;

	public Filiere() {
		super();
	}

	public Filiere(String promotion) {
		super();
		this.promotion = promotion;
	}

	public Filiere(Long id, String promotion) {
		super();
		this.id = id;
		this.promotion = promotion;
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

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public void addStagiaire(Stagiaire stagiaire) {
		this.stagiaires.add(stagiaire);
	}

	public List<UE> getUes() {
		return ues;
	}

	public void setUes(List<UE> ues) {
		this.ues = ues;
	}

	public void addUe(UE ue) {
		this.ues.add(ue);
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

	@Override
	public String toString() {
		return "Filiere [intitule=" + intitule + ", promotion=" + promotion + ", dtDebut=" + dtDebut + ", duree="
				+ duree + ", dispositif=" + dispositif + ", stagiaires=" + stagiaires + ", ues=" + ues + ", referent="
				+ referent + "]";
	}

}
