package sopra.formation.model;

public class UE {
	private long id;
	private int code;
	private int duree;
	private int ordre;
	private Filiere filiere;
	private Formateur formateur;
	private Matiere matiere;
	private Salle salle;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public int getOrdre() {
		return ordre;
	}
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	
	

}
