package sopra.formation.model;

public class UE {

		private Long id;
		private Integer code;
		private Integer duree;
		private int ordre;
		private Salle salle;
		private Filiere filiere;
		
		public UE() {
			this(0l,0,0,0);
		}
		
		public UE(Long id, Integer code, Integer duree, int ordre) {
			super();
			this.id = id;
			this.code = code;
			this.duree = duree;
			this.ordre = ordre;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Integer getCode() {
			return code;
		}
		public void setCode(Integer code) {
			this.code = code;
		}
		public Integer getDuree() {
			return duree;
		}
		public void setDuree(Integer duree) {
			this.duree = duree;
		}
		public int getOrdre() {
			return ordre;
		}
		public void setOrdre(int ordre) {
			this.ordre = ordre;
		}

		public Salle getSalle() {
			return salle;
		}

		public void setSalle(Salle salle) {
			this.salle = salle;
		}

		public Filiere getFiliere() {
			return filiere;
		}

		public void setFiliere(Filiere filiere) {
			this.filiere = filiere;
		}
		
		
		
}
