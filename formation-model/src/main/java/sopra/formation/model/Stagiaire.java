package sopra.formation.model;

public class Stagiaire extends Personne {

		private String dtNaissance;
		private NiveauEtude niveauEtude;
		private Evaluation evaluation;
		
		public Stagiaire() {
			this(null,null);
		}
		
		public Stagiaire(String dtNaissance, NiveauEtude niveauEtude) {
			super();
			this.dtNaissance = dtNaissance;
			this.niveauEtude = niveauEtude;
		}
		public String getDtNaissance() {
			return dtNaissance;
		}
		public void setDtNaissance(String dtNaissance) {
			this.dtNaissance = dtNaissance;
		}
		public NiveauEtude getNiveauEtude() {
			return niveauEtude;
		}
		public void setNiveauEtude(NiveauEtude niveauEtude) {
			this.niveauEtude = niveauEtude;
		}

		public Evaluation getEvaluation() {
			return evaluation;
		}

		public void setEvaluation(Evaluation evaluation) {
			this.evaluation = evaluation;
		}
		
		
		
}
