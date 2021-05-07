package sopra.formation.model;

import java.util.Date;

public class Stagiaire extends Personne {
	private Date dtNaissance;
	private NiveauEtude niveauEtude;
	private Filiere filiere;
	private Evaluation evaluation;

	public Stagiaire(Long id, Civilite civilite, String nom, String prenom, String email, String telephone, java.sql.Date dtNaissance2, NiveauEtude niveauEtude2) {
		super(id, civilite, nom, prenom, email, telephone);
		this.dtNaissance=dtNaissance2;
		this.niveauEtude=niveauEtude2;
	}
	
	public Stagiaire(Civilite civilite, String nom, String prenom, String email, String telephone, Date dtNaissance2, NiveauEtude niveauEtude2) {
		super(civilite, nom, prenom, email, telephone);
		this.dtNaissance=dtNaissance2;
		this.niveauEtude=niveauEtude2;
	}

	public Stagiaire(String email) {
		super(email);
	}

	public Stagiaire(Long id, String email) {
		super(id, email);
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

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}

	@Override
	public String toString() {
		return "Stagiaire [dtNaissance=" + dtNaissance + ", niveauEtude=" + niveauEtude + ", evaluation=" + evaluation
				+ ", " + super.toString() + "]";
	}

}
