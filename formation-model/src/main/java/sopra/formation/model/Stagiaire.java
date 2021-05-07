package sopra.formation.model;

import java.util.Date;

public class Stagiaire extends Personne {
	 private Date dtnaissance;
	 private NiveauEtude niveauEtude;
	 private Evaluation eval;
	 private Filiere filiere;
	 public Filiere getFiliere() {
		return filiere;
	}


	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}


	public Stagiaire() {
		super();
	 }
	
	public Stagiaire(String mail) {
		super(mail);
	 }
	
	 
	 
	public Stagiaire(Civilite civilite, String nom, String prenom, String email, String tel,Date dtnaissance, NiveauEtude niveauEtude) {
		super(civilite,nom,prenom,email,tel);
		this.dtnaissance = dtnaissance;
		this.niveauEtude = niveauEtude;
	}


	public Evaluation getEval() {
		return eval;
	}


	public void setEval(Evaluation eval) {
		this.eval = eval;
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
