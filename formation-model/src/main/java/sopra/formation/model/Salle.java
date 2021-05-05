package sopra.formation.model;
import java.util.List;
import java.util.ArrayList;

public class Salle {
	private Long id;
	private String nom;
	private Integer capacite;
	private Boolean videoProjecter;
	private Adresse adresse;
	private List<UE> ues = new ArrayList<UE>();
	
	public Salle() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCapacite() {
		return capacite;
	}

	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}

	public Boolean getVideoProjecter() {
		return videoProjecter;
	}

	public void setVideoProjecter(Boolean videoProjecter) {
		this.videoProjecter = videoProjecter;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<UE> getUes() {
		return ues;
	}

	public void setUes(List<UE> ues) {
		this.ues = ues;
	}
	
	
}
