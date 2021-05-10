package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.dao.ISalleDao;
import sopra.formation.model.Adresse;
import sopra.formation.model.Salle;

public class SalleDaoCsv implements ISalleDao {
	private final String fileName;
	private final String separator = ";";

	public SalleDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<Salle> findAll() {
		return read();
	}

	@Override
	public Salle findById(Long id) {
		List<Salle> salles = read();

		for (Salle salle : salles) {
			if (salle.getId() == id) {
				return salle;
			}
		}

		return null;
	}

	@Override
	public void create(Salle obj) {
		List<Salle> salles = read();

		Long max = 0L;
		for (Salle salle : salles) {
			if (salle.getId() > max) {
				max = salle.getId();
			}
		}

		obj.setId(++max);

		salles.add(obj);

		write(salles);
	}

	@Override
	public void update(Salle obj) {
		List<Salle> salles = read();

		boolean found = false;
		int position;
		for (position = 0; position < salles.size(); position++) {
			Salle salle = salles.get(position);

			if (salle.getId() == obj.getId()) {
				found = true;
				break;
			}
		}

		if (found) {
			salles.set(position, obj);

			write(salles);
		}
	}

	@Override
	public void delete(Salle obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		List<Salle> salles = read();

		boolean found = false;
		int position;
		for (position = 0; position < salles.size(); position++) {
			Salle salle = salles.get(position);

			if (salle.getId() == id) {
				found = true;
				break;
			}
		}

		if (found == true) {
			salles.remove(position);

			write(salles);
		}
	}

	private List<Salle> read() {
		List<Salle> salles = new ArrayList<Salle>();

		Path path = Paths.get(this.fileName);

		if (path.toFile().exists()) {

			try {
				List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

				for (String line : lines) {
					String[] items = line.split(this.separator, -1);

					Long id = Long.valueOf(items[0]);
					String nom = items[1];
					Integer capacite = !items[2].isBlank() ? Integer.valueOf(items[2]) : null;
					Boolean videoProjecteur = items[3].contentEquals("O") ? true : false;
					String rue = items[4];
					String complement = items[5];
					String codePostal = items[6];
					String ville = items[7];

					Salle salle = new Salle();
					salle.setId(id);
					salle.setNom(nom);
					salle.setCapacite(capacite);
					salle.setVideoProjecteur(videoProjecteur);

					Adresse adresse = new Adresse(rue, complement, codePostal, ville);
					salle.setAdr(adresse);

					salles.add(salle);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return salles;
	}

	private void write(List<Salle> salles) {
		Path path = Paths.get(this.fileName);

		List<String> lines = new ArrayList<String>();
		for (Salle salle : salles) {
			StringBuilder sb = new StringBuilder();

			sb.append(salle.getId()).append(this.separator);
			sb.append(salle.getNom()).append(this.separator);
			sb.append(salle.getCapacite()).append(this.separator);
			sb.append(salle.getVideoProjecteur() ? "O" : "N").append(this.separator);
			if (salle.getAdr() != null) {
				sb.append(salle.getAdr().getRue()).append(this.separator);
				sb.append(salle.getAdr().getComplement()).append(this.separator);
				sb.append(salle.getAdr().getCodePostal()).append(this.separator);
				sb.append(salle.getAdr().getVille());
			} else {
				sb.append(this.separator);
				sb.append(this.separator);
				sb.append(this.separator);
			}

			lines.add(sb.toString());
		}

		try {
			Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
