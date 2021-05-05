package sopra.formation.model;

	
public class Adresse {
		
		private Long id;
		private String rue;
		private String complement;
		private String codePostal;
		private String ville;
		private String pays;
		
		private Salle salle;
		private Personne personne;
		
		
		
		// Constructeur
		
		public Adresse() {
			this(null,null,null,null,null,null);
		}
		
		public Adresse(Long id, String rue, String complement, String codePostal, String ville, String pays) {
			this.id = id;
			this.rue = rue;
			this.complement = complement;
			this.codePostal = codePostal;
			this.ville = ville;
			this.pays = pays;
		}
		
		//Getter / SEtter
		
		
		
		
		public Long getId() {
			return id;
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

		public void setId(Long id) {
			this.id = id;
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

		public String getPays() {
			return pays;
		}

		public void setPays(String pays) {
			this.pays = pays;
		}


}
