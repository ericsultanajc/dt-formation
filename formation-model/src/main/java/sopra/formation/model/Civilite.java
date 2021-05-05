package sopra.formation.model;

public enum Civilite {
<<<<<<< HEAD
	M, MME, MLLE;
=======
	M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");

	private final String label;

	private Civilite(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

>>>>>>> main
}
