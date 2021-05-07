package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;


public class StagiaireDaoCsv implements IStagiaireDao {
	
	private final String fileName;
	private final String separator = ";";

	public StagiaireDaoCsv(String fileName) {
			super();
			this.fileName = fileName;
		}

	public List<Stagiaire> findAll() {		
		
			return read() ;
		}

	public Stagiaire findById(Long id) {
			List<Stagiaire> stagiaires = read();
			
			for (Stagiaire stagiaire : stagiaires) {
				if (stagiaire.getId() == id) {
					return stagiaire;
			}
		}
			return null;
	}
	
	
	public void create(Stagiaire obj) {
		List<Stagiaire> stagiaires = read();
		
		Long maxId = 0L;
		for (Stagiaire mat : stagiaires) {
			if (maxId < mat.getId()) {
				maxId = mat.getId();
			}
		}

		obj.setId(++maxId);

		stagiaires.add(obj);

		write(stagiaires);
		
	}

	public void update(Stagiaire obj) {
		List<Stagiaire> stagiaires = read();

		int index = 0;
		boolean find = false;

		for (Stagiaire st : stagiaires) {
			if (st.getId() == obj.getId()) {
				find = true;
				break;
			}

			index++;
		}
		
		if (find) {
			stagiaires.set(index, obj);

			write(stagiaires);
		}
	}

	public void delete(Stagiaire obj) {
		deleteById(obj.getId());
	}
	
	public void deleteById(Long id) {
		List<Stagiaire> stagiaires = read();
		
		int index = 0;
		boolean find = false;

		for (Stagiaire st : stagiaires) {
			if (st.getId() == id) {
				find = true;
				break;
			}

			index++;
		}
		
		if (find) {
			stagiaires.remove(index);

			write(stagiaires);
		}
	}
	
	

	private List<Stagiaire> read() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Path path = Paths.get(this.fileName);

		try {
			List<String> lines = Files.readAllLines(path);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			for (String line : lines) {
				String[] items = line.split(this.separator);

				Long id = Long.valueOf(items[0]);
				Civilite civilite = Civilite.valueOf(items[1]);
				String nom = String.valueOf(items[2]);
				String prenom = String.valueOf(items[3]);
				String email = String.valueOf(items[4]);
				String telephone = String.valueOf(items[5]);
				Adresse adresse = Adresse.valueOf(items[6]);
				Date dtNaissance = dateFormat.parse(items[7]);
				NiveauEtude niveauEtude = NiveauEtude.valueOf(items[8]);
				
				Stagiaire stagiaire = new Stagiaire(id,civilite, nom, prenom, email, telephone, adresse, dtNaissance, niveauEtude);

				stagiaires.add(stagiaire);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return stagiaires;
	}
	
	private void write(List<Stagiaire> matieres) {
		List<String> lines = new ArrayList<String>();

		for (Stagiaire matiere : matieres) {
			StringBuilder line = new StringBuilder();
			line.append(matiere.getId());
			line.append(this.separator);
			line.append(matiere.getCivilite());
			line.append(this.separator);
			line.append(matiere.getNom());
			line.append(this.separator);
			line.append(matiere.getPrenom());
			line.append(this.separator);
			line.append(matiere.getEmail());
			line.append(this.separator);
			line.append(matiere.getAdresse());
			line.append(this.separator);
			line.append(matiere.getTelephone());
			line.append(this.separator);
			line.append(matiere.getDtNaissance());
			line.append(this.separator);
			line.append(matiere.getNiveauEtude());
			
				
			lines.add(line.toString());
		}

		Path path = Paths.get(this.fileName);

		try {
			Files.write(path, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
