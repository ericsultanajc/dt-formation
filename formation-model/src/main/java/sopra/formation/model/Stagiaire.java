package sopra.formation.model;

import java.util.Date;

public class Stagiaire {
	
	private Date dtNaissance;
	private NiveauEtude niveauEtude ;
	
	public Stagiaire() {
		super();
	}
	
	public Stagiaire(Date dtNaissance, NiveauEtude niveauEtude) {
		super();
		this.dtNaissance = dtNaissance;
		this.niveauEtude = niveauEtude;
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public NiveauEtude getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(NiveauEtude niveauEtude) {
		this.niveauEtude = niveauEtude;
	}
	

}
