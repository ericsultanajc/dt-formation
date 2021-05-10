package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.Application;
import sopra.formation.dao.IFormateurDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Civilite;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;

public class FormateurDaoCsv implements IFormateurDao {
	private final String fileName;
	private final String fileNameCompetence;
	private final String separator = ";";

	public FormateurDaoCsv(String fileName, String fileNameCompetence) {
		super();
		this.fileName = fileName;
		this.fileNameCompetence = fileNameCompetence;
	}

	@Override
	public List<Formateur> findAll() {
		List<Formateur> formateurs = read();
		return formateurs;
	}

	@Override
	public Formateur findById(Long id) {
		List<Formateur> formateurs = read();

		for (Formateur formateur : formateurs) {
			if (formateur.getId() == id) {
				return formateur;
			}
		}

		return null;
	}

	@Override
	public void create(Formateur obj) {
		List<Formateur> formateurs = read();

		Long max = 0L;
		for (Formateur formateur : formateurs) {
			if (formateur.getId() > max) {
				max = formateur.getId();
			}
		}

		obj.setId(++max);

		formateurs.add(obj);

		write(formateurs);
	}

	@Override
	public void update(Formateur obj) {
		List<Formateur> formateurs = read();

		boolean found = false;
		int position;
		for (position = 0; position < formateurs.size(); position++) {
			Formateur formateur = formateurs.get(position);

			if (formateur.getId() == obj.getId()) {
				found = true;
				break;
			}
		}

		if (found) {
			formateurs.set(position, obj);

			write(formateurs);
		}
	}

	@Override
	public void delete(Formateur obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		List<Formateur> formateurs = read();

		boolean found = false;
		int position;
		for (position = 0; position < formateurs.size(); position++) {
			Formateur formateur = formateurs.get(position);

			if (formateur.getId() == id) {
				found = true;
				break;
			}
		}

		if (found == true) {
			formateurs.remove(position);

			write(formateurs);
		}
	}

	private List<Formateur> read() {
		List<Formateur> formateurs = new ArrayList<Formateur>();

		Path path = Paths.get(this.fileName);
		Path pathCompetence = Paths.get(this.fileNameCompetence);

		if (path.toFile().exists()) {

			try {
				List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
				List<String> linesCompetences = Files.readAllLines(pathCompetence, StandardCharsets.UTF_8);

				for (String line : lines) {
					String[] items = line.split(this.separator, -1);

					Long id = Long.valueOf(items[0]);
					Civilite civilite = !items[1].isBlank() ? Civilite.valueOf(items[1]) : null;
					String nom = items[2];
					String prenom = items[3];
					String email = items[4];
					Boolean referent = items[5].contentEquals("O") ? true : false;
					Integer experience = !items[6].isBlank() ? Integer.valueOf(items[6]) : null;
					String rue = items[7];
					String complement = items[8];
					String codePostal = items[9];
					String ville = items[10];

					Formateur formateur = new Formateur();
					formateur.setId(id);
					formateur.setCivilite(civilite);
					formateur.setNom(nom);
					formateur.setPrenom(prenom);
					formateur.setEmail(email);
					formateur.setReferent(referent);
					formateur.setExperience(experience);

					Adresse adresse = new Adresse(rue, complement, codePostal, ville);

					formateur.setAdresse(adresse);
					
					for (String lineCompetence : linesCompetences) {
						String[] itemsCompetence = lineCompetence.split(this.separator, -1);

						Long idFormateur = Long.valueOf(itemsCompetence[0]);
						Long idMatiere = Long.valueOf(itemsCompetence[1]);

						if (idFormateur == id) {
							Matiere matiere = Application.getInstance().getMatiereDao().findById(idMatiere);
							formateur.getCompetences().add(matiere);
						}
					}

					formateurs.add(formateur);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return formateurs;
	}

	private void write(List<Formateur> formateurs) {
		List<String> lines = new ArrayList<String>();
		List<String> linesCompetence = new ArrayList<String>();

		Path path = Paths.get(this.fileName);
		Path pathCompetence = Paths.get(this.fileNameCompetence);

		for (Formateur formateur : formateurs) {
			StringBuilder sb = new StringBuilder();

			sb.append(formateur.getId()).append(this.separator);
			sb.append(formateur.getCivilite()).append(this.separator);
			sb.append(formateur.getNom()).append(this.separator);
			sb.append(formateur.getPrenom()).append(this.separator);
			sb.append(formateur.getEmail()).append(this.separator);
			sb.append(formateur.getReferent() ? "O" : "N").append(this.separator);
			sb.append(formateur.getExperience()).append(this.separator);
			if (formateur.getAdresse() != null) {
				sb.append(formateur.getAdresse().getRue()).append(this.separator);
				sb.append(formateur.getAdresse().getComplement()).append(this.separator);
				sb.append(formateur.getAdresse().getCodePostal()).append(this.separator);
				sb.append(formateur.getAdresse().getVille());
			} else {
				sb.append(this.separator);
				sb.append(this.separator);
				sb.append(this.separator);
			}

			String line = sb.toString();

			lines.add(line);

			for (Matiere matiere : formateur.getCompetences()) {
				if (matiere.getId() != null) {
					StringBuilder stringBuilder = new StringBuilder();
					stringBuilder.append(formateur.getId()).append(this.separator);
					stringBuilder.append(matiere.getId());

					linesCompetence.add(stringBuilder.toString());
				}
			}
		}

		try {
			Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING,
					StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			Files.write(pathCompetence, linesCompetence, StandardCharsets.UTF_8,
					StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
