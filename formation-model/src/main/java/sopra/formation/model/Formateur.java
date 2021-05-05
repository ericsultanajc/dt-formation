package sopra.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Formateur extends Personne {
	private Integer experience;
	private List<Filiere> filieres;
	
	public Formateur() {
		this(0);
	}

	public Formateur(Integer experience) {
		super();
		this.experience = experience;
		filieres = new ArrayList<Filiere>();
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public List<Filiere> getfilieres(){
		return filieres;
	}

	public Filiere getfilieres(Long unId) {
		for (int i = 0; i < filieres.size(); i++) {
			if (filieres.get(i)!= null && filieres.get(i).getId() ==
					unId) {
				return filieres.get(i);
			}
		}
		return null;
	}

	public void ajouterFiliere(Filiere uneFiliere) {
		this.filieres.add(uneFiliere);		
	}
	
	
}
