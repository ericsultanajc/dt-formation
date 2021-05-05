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
	private List<UE> ues;
	
	public Filiere(){
		this(0l, null, null, null, 0, null);
	}
	
	public Filiere(Long id, String intitule, String promotion, Date dtDebut, Integer duree, Dispositif dispositif) {
		super();
		this.id = id;
		this.intitule = intitule;
		this.promotion = promotion;
		this.dtDebut = dtDebut;
		this.duree = duree;
		this.dispositif = dispositif;
		ues = new ArrayList<UE>();
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
