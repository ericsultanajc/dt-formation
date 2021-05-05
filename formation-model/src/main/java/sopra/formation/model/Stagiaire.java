package sopra.formation.model;

import java.util.Date;

public class Stagiaire extends Personne {

	private Date dtNaissance;
	private NiveauEtude niveauEtude;
	private Filiere filiere;
	
// ------------------------------------------------------------------------------------
	
	public Stagiaire() {
		super();
	}
	
// ------------------------------------------------------------------------------------
	
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
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
}
