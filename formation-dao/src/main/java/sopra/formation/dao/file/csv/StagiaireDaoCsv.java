package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IStagiaireDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Evaluation;
import sopra.formation.model.Filiere;
import sopra.formation.model.NiveauEtude;
import sopra.formation.model.Stagiaire;

public class StagiaireDaoCsv implements IStagiaireDao {
	private final String fileName;
	private final String separator = ";";
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public StagiaireDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<Stagiaire> findAll() {
		List<Stagiaire> stagiaires = read();
		return stagiaires;
	}

	@Override
	public Stagiaire findById(Long id) {
		List<Stagiaire> stagiaires = read();

		for (Stagiaire stagiaire : stagiaires) {
			if (stagiaire.getId() == id) {
				return stagiaire;
			}
		}

		return null;
	}

	@Override
	public void create(Stagiaire obj) {
		List<Stagiaire> stagiaires = read();

		Long max = 0L;
		for (Stagiaire stagiaire : stagiaires) {
			if (stagiaire.getId() > max) {
				max = stagiaire.getId();
			}
		}

//		Equivalence du foreach avec un for classique
//		for (int i = 0; i < stagiaires.size(); i++) {
//			Stagiaire stagiaire = stagiaires.get(i);
//			if (stagiaire.getId() > max) {
//				max = stagiaire.getId();
//			}
//		}

		obj.setId(++max);

		stagiaires.add(obj);

		write(stagiaires);
	}

	@Override
	public void update(Stagiaire obj) {
		List<Stagiaire> stagiaires = read();

		boolean found = false;
		int position;
		for (position = 0; position < stagiaires.size(); position++) {
			Stagiaire stagiaire = stagiaires.get(position);

			if (stagiaire.getId() == obj.getId()) {
				found = true;
				break;
			}
		}

		if (found) {
			stagiaires.set(position, obj);

			write(stagiaires);
		}
	}

	@Override
	public void delete(Stagiaire obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		List<Stagiaire> stagiaires = read();

		boolean found = false;
		int position;
		for (position = 0; position < stagiaires.size(); position++) {
			Stagiaire stagiaire = stagiaires.get(position);

			if (stagiaire.getId() == id) {
				found = true;
				break;
			}
		}

		if (found == true) {
			stagiaires.remove(position);

			write(stagiaires);
		}
	}

	private List<Stagiaire> read() {
		List<Stagiaire> stagiaires = new ArrayList<Stagiaire>();

		Path path = Paths.get(this.fileName);

		if (path.toFile().exists()) {

			try {
				List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

				for (String line : lines) {
					String[] items = line.split(this.separator, -1);

					Long id = Long.valueOf(items[0]);
					Civilite civilite = items[1].length() > 0 ? Civilite.valueOf(items[1]) : null;
					String nom = items[2];
					String prenom = items[3];
					String email = items[4];
					Date dtNaissance = null;
					try {
						dtNaissance = sdf.parse(items[5]);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					NiveauEtude niveauEtude = items[6].length() > 0 ? NiveauEtude.valueOf(items[6]) : null;
					String rue = items[7];
					String complement = items[8];
					String codePostal = items[9];
					String ville = items[10];
					Long idEvaluation = !items[11].isBlank() ? Long.valueOf(items[11]) : null;
					Long idFiliere = !items [12].isBlank() ? Long.valueOf(items[12]) : null;

					Stagiaire stagiaire = new Stagiaire(id, email);
					stagiaire.setCivilite(civilite);
					stagiaire.setNom(nom);
					stagiaire.setPrenom(prenom);
					stagiaire.setDtNaissance(dtNaissance);
					stagiaire.setNiveauEtude(niveauEtude);

					Adresse adresse = new Adresse(rue, complement, codePostal, ville);

					stagiaire.setAdresse(adresse);

					if (idEvaluation != null) {
						Evaluation evaluation = Application.getInstance().getEvaluationDao().findById(idEvaluation);
						stagiaire.setEvaluation(evaluation);
					}
					
					if (idFiliere != null) {
						Filiere filiere = Application.getInstance().getFiliereDao().findById(idFiliere);
						stagiaire.setFiliere(filiere);
					}

					stagiaires.add(stagiaire);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return stagiaires;
	}

	private void write(List<Stagiaire> stagiaires) {
		Path path = Paths.get(this.fileName);

		List<String> lines = new ArrayList<String>();

		for (Stagiaire stagiaire : stagiaires) {
			StringBuilder sb = new StringBuilder();

			sb.append(stagiaire.getId()).append(this.separator);
			sb.append(stagiaire.getCivilite()).append(this.separator);
			sb.append(stagiaire.getNom()).append(this.separator);
			sb.append(stagiaire.getPrenom()).append(this.separator);
			sb.append(stagiaire.getEmail()).append(this.separator);
			sb.append(sdf.format(stagiaire.getDtNaissance())).append(this.separator);
			sb.append(stagiaire.getNiveauEtude()).append(this.separator);
			if (stagiaire.getAdresse() != null) {
				sb.append(stagiaire.getAdresse().getRue()).append(this.separator);
				sb.append(stagiaire.getAdresse().getComplement()).append(this.separator);
				sb.append(stagiaire.getAdresse().getCodePostal()).append(this.separator);
				sb.append(stagiaire.getAdresse().getVille()).append(this.separator);
			} else {
				sb.append(this.separator);
				sb.append(this.separator);
				sb.append(this.separator);
				sb.append(this.separator);
			}
			if (stagiaire.getEvaluation() != null && stagiaire.getEvaluation().getId() != null) {
				sb.append(stagiaire.getEvaluation().getId()).append(this.separator);
			}
			else {
				sb.append(this.separator);
			}
			
			if (stagiaire.getFiliere() != null && stagiaire.getFiliere().getId() != null) {
				sb.append(stagiaire.getFiliere().getId());
			}

			String line = sb.toString();

			lines.add(line);
		}

		try {
			Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
