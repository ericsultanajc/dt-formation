package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Evaluation {
	private Long id;
	private Integer comportemental;
	private Integer technique;
	private String commentaires;
	private List<Formateur> formateur = new ArrayList<>();
	private List<UE> uE = new ArrayList<>();
	public Evaluation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getComportemental() {
		return comportemental;
	}

	public void setComportemental(Integer comportemental) {
		this.comportemental = comportemental;
	}

	public Integer getTechnique() {
		return technique;
	}

	public void setTechnique(Integer technique) {
		this.technique = technique;
	}

	public String getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(String commentaires) {
		this.commentaires = commentaires;
	}

	public List<Formateur> getFormateur() {
		return formateur;
	}

	public void setFormateur(List<Formateur> formateur) {
		this.formateur = formateur;
	}

	public List<UE> getuE() {
		return uE;
	}

	public void setuE(List<UE> uE) {
		this.uE = uE;
	}

}
