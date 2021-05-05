package sopra.formation.model;

import java.util.Date;

public class Stagiaire extends Personne {
	 private Date dtnaissance;
	 private NiveauEtude niveauEtude;
	 private Evaluation eval;
	 public Stagiaire() {
		super();
	 }
	public Date getDtnaissance() {
		return dtnaissance;
	}
	public void setDtnaissance(Date dtnaissance) {
		this.dtnaissance = dtnaissance;
	}
	public NiveauEtude getNiveauEtude() {
		return niveauEtude;
	}
	public void setNiveauEtude(NiveauEtude niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	 
 
 
}
