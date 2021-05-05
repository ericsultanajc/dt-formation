package sopra.formation.model;

import java.util.Date;

public class Stagiaire extends Personne{
	private Date dtNaissance;
	private NiveauEtude niveauEtude;
	private Evaluation evaluation;
	private Filiere filiere;
	
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
