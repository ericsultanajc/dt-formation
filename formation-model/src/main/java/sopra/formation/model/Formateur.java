package sopra.formation.model;

public class Formateur extends Personne {
	private Integer experience;
	
	public Formateur() {
		this(0);
	}

	public Formateur(Integer experience) {
		super();
		this.experience = experience;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	
	
}
