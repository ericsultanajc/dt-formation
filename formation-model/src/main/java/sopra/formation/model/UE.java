package sopra.formation.model;

public class UE {
	private Long id;
	private Integer code;
	private Integer duree;
	private int ordre;
	private Matiere mat;
	private Salle room;
	private Filiere filiere;
	private Formateur formateur;
	
	public UE() {
		super();
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
	public Matiere getMat() {
		return mat;
	}
	public void setMat(Matiere mat) {
		this.mat = mat;
	}
	public Salle getRoom() {
		return room;
	}
	public void setRoom(Salle room) {
		this.room = room;
	}
	public Filiere getFiliere() {
		return filiere;
	}
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
}
