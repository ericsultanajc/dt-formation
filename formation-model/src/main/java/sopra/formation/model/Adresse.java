package sopra.formation.model;

public class Adresse {
	
	private String rue;
	private String complement;
	private String codePostal;
	private String ville;
	
	//Cardinalite
	private Salle salle;
	private Personne personne;
	
	public Adresse() {
		super();
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}



	public Salle getSalle() {
		return salle;
	}



	public void setSalle(Salle salle) {
		this.salle = salle;
	}



	public Personne getPersonne() {
		return personne;
	}



	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	

}
