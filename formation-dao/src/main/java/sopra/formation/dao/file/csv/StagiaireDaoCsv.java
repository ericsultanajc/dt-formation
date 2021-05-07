package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.dao.IStagiaire;
import sopra.formation.model.Civilite;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoCsv implements IStagiaire {
	private final String fileName;
	private final String separator = ";";
	
	public StagiaireDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	
	
	
	@Override
	public List<Stagiaire> findAll() throws ParseException {
		return read();
	}

	@Override
	public Stagiaire findById(Long id) throws ParseException {
		List<Stagiaire> stagiaires = read();

		for (Stagiaire stagiaire : stagiaires) {
			if (stagiaire.getId() == id) {
				return stagiaire;
			}
		}

		return null;
	}

	@Override
	public void create(Stagiaire obj) throws ParseException {
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

	@Override
	public void update(Stagiaire obj) throws ParseException {
		List<Stagiaire> stagiaires;
	
			stagiaires = read();
	

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

	@Override
	public void delete(Stagiaire obj) {
		deleteById(obj.getId());

	}

	@Override
	public void deleteById(Long id) throws ParseException {
		List<Stagiaire> stagiaires;

			stagiaires = read();
	
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

	private List<Stagiaire> read() throws ParseException {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Path path = Paths.get(this.fileName);

		try {
			List<String> lines = Files.readAllLines(path);

			for (String line : lines) {
				String[] items = line.split(this.separator);
				SimpleDateFormat dateformat = new SimpleDateFormat("dd,MM,yy");
				Long id = Long.valueOf(items[0]);
				Civilite civilite = Civilite.valueOf(items[1]);
				String nom = items[2];
				String prenom = items[3];
				String email = items[4];
				String telephone = items[5];
				java.util.Date dtnaissance = dateformat.parse(items[6]);
				NiveauEtude niveauetude = NiveauEtude.valueOf(items[7]);
				Long filiereID = Long.valueOf(items[8]);
				Long evaluationID = Long.valueOf(items[9]);
				
				Filiere filiere = (new FiliereDaoCsv("filieres.txt").findById(filiereID));
				Evaluation evaluation = (new EvaluationDaoCsv("evaluations.txt").findById(evaluationID));
				
				Stagiaire stagiaire = new Stagiaire(id, civilite, nom, prenom, email, telephone, dtnaissance, niveauetude, filiere, evaluation);

				stagiaires.add(stagiaire);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return stagiaires;

	}

	public void write(List<Stagiaire> stagiaires) {
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
			line.append(stagiaire.getFiliere().getId());
			line.append(this.separator);
			line.append(stagiaire.getEvaluation().getId());

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
