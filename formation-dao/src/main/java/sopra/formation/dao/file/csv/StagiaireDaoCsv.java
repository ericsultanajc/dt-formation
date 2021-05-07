package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Civilite;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoCsv implements IStagiaireDao{
	
	private final String fileName;
	private final String separator = ";";

	public StagiaireDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	public List<Stagiaire> findAll() {
		return read();
	}

	private List<Stagiaire> read() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Path path = Paths.get(this.fileName);

		try {
			List<String> lines = Files.readAllLines(path);

			for (String line : lines) {
				String[] items = line.split(this.separator);

				Long id = Long.valueOf(items[0]);
				Civilite civilite = Civilite.valueOf(items[1]);
				String nom = String.valueOf(items[2]);
				String prenom = String.valueOf(items[3]);
				String email = String.valueOf(items[4]);
				String telephone = String.valueOf(items[5]);
				Date dtNaissance = Date.valueOf(items[6]);
				NiveauEtude niveauEtude = NiveauEtude.valueOf(items[7]);
				
				Stagiaire stagiaire = new Stagiaire(id, civilite, nom, prenom, email, telephone, dtNaissance, niveauEtude);

				stagiaires.add(stagiaire);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return stagiaires;
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

	private void write(List<Stagiaire> stagiaires) {
		List<String> lines = new ArrayList<String>();

		for (Stagiaire stagiaire : stagiaires) {
			StringBuilder line = new StringBuilder();
			line.append(stagiaire.getId());
			line.append(this.separator);
			line.append(stagiaire.getCivilite());
			line.append(this.separator);
			line.append(stagiaire.getNom());
			line.append(this.separator);
			line.append(stagiaire.getPrenom());
			line.append(this.separator);
			line.append(stagiaire.getEmail());
			line.append(this.separator);
			line.append(stagiaire.getTelephone());
			line.append(this.separator);
			line.append(stagiaire.getDtNaissance());
			line.append(this.separator);
			line.append(stagiaire.getNiveauEtude());
			line.append(this.separator);
			line.append(this.separator);
			lines.add(line.toString());
		}

		Path path = Paths.get(this.fileName);

		try {
			Files.write(path, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void create(Stagiaire obj) {
		List<Stagiaire> stagiaires = read();

		Long maxId = 0L;
		for (Stagiaire stagiaire : stagiaires) {
			if (maxId < stagiaire.getId()) {
				maxId = stagiaire.getId();
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

		for (Stagiaire stagiaire : stagiaires) {
			if (stagiaire.getId() == obj.getId()) {
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

		for (Stagiaire stagiaire : stagiaires) {
			if (stagiaire.getId() == id) {
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

}
