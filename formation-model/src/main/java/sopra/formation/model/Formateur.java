package sopra.formation.model;

public class Formateur extends Personne {
	private Integer experience;

	public Formateur() {
		super();
	}
	
	

	public Formateur(Civilite civilite, String nom, String prenom, String email, String tel,Integer experience) {
		super(civilite,nom,prenom,email,tel);
		this.experience = experience;
	}



	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	
}
