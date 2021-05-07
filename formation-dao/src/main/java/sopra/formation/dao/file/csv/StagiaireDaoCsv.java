package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.model.Civilite;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoCsv extends PersonneDaoCsv {
	private final String fileName;
	private final String separator = ";";
	
	public StagiaireDaoCsv(String fileName) {
		super(fileName);
		this.fileName = fileName;
	}

	public List<Stagiaire> findAll() {
		return read();
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
	
	private List<Stagiaire> read() {
		
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Path path = Paths.get(this.fileName);

		try {
			List<String> lines = Files.readAllLines(path);

			for (String line : lines) {
				String[] items = line.split(this.getSeparator());

				Long id = Long.valueOf(items[0]);
				Civilite civilite = Civilite.valueOf(items[1]);
				String nom = items[2];
				String prenom = items[3];
				String email = items[4];
				String telephone = items[5];
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
			
			lines.add(line.toString());
		}

		Path path = Paths.get(this.fileName);

		try {
			Files.write(path, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public List<Stagiaire> findAllByNom(String nom) {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		for (Stagiaire stagiaire : read()) {
			if (stagiaire.getNom() == nom) {
				stagiaires.add(stagiaire);
			}
		}
		
		return stagiaires;
	
	}
	
}