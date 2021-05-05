package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Personne {
	
	private Long id;
	private Civilite civilite;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private Adresse adress;
	private List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	private List<Formateur> formateurs = new ArrayList<Formateur>();
	
// ------------------------------------------------------------------------------------
	
	public Personne() {
		super();
	}
	
// ------------------------------------------------------------------------------------	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Adresse getAdress() {
		return adress;
	}
	public void setAdress(Adresse adress) {
		this.adress = adress;
	}
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	public List<Formateur> getFormateurs() {
		return formateurs;
	}
	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}
	
	
}
