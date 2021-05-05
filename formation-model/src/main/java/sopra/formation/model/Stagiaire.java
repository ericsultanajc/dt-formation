package sopra.formation.model;

import java.sql.Date;

public class Stagiaire {
	private Date dtNaissance;
	private NiveauEtude niveauEtude;
	
	private Evaluation evaluation;
	private Filiere filiere;
	
	public Stagiaire() {
		super();
	}
	
	public Stagiaire(Date dtNaissance, NiveauEtude niveauEtude) {
		super();
		this.dtNaissance = dtNaissance;
		this.niveauEtude = niveauEtude;
	}
	
	
	
	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
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
