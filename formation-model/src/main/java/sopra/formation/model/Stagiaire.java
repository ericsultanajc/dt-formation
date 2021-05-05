package sopra.formation.model;

import java.sql.Date;

public class Stagiaire {
	private Date dtNaissance;
	private NiveauEtude niveauEtude;
	
	
	
	
	
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
