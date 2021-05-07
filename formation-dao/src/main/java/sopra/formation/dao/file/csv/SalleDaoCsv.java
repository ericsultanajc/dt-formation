package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.dao.ISalleDao;
import sopra.formation.model.Salle;

public class SalleDaoCsv implements ISalleDao {

	private final String fileName;
	private final String separator = ";";

	public SalleDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	public List<Salle> findAll() {
		return read();
	}

	public Salle findById(Long id) {
		List<Salle> salles = read();

		for (Salle salle : salles) {
			if (salle.getId() == id) {
				return salle;
			}
		}

		return null;
	}

	public void create(Salle obj) {
		List<Salle> salles = read();

		Long maxId = 0L;
		for (Salle sal : salles) {
			if (maxId < sal.getId()) {
				maxId = sal.getId();
			}
		}

		obj.setId(++maxId);

		salles.add(obj);

		write(salles);
	}

	public void update(Salle obj) {
		List<Salle> salles = read();

		int index = 0;
		boolean find = false;

		for (Salle sal : salles) {
			if (sal.getId() == obj.getId()) {
				find = true;
				break;
			}

			index++;
		}

		if (find) {
			salles.set(index, obj);

			write(salles);
		}
	}

	public void delete(Salle obj) {
		deleteById(obj.getId());
	}

	public void deleteById(Long id) {
		List<Salle> salles = read();

		int index = 0;
		boolean find = false;

		for (Salle sal : salles) {
			if (sal.getId() == id) {
				find = true;
				break;
			}

			index++;
		}

		if (find) {
			salles.remove(index);

			write(salles);
		}
	}

	private List<Salle> read() {
		List<Salle> salles = new ArrayList<Salle>();

		Path path = Paths.get(this.fileName);

		try {
			List<String> lines = Files.readAllLines(path);

			for (String line : lines) {
				String[] items = line.split(this.separator);

				Long id = Long.valueOf(items[0]);
				String nom = items[1];
				Integer capacite = Integer.valueOf(items[2]);
				Boolean videoProjecteur = Boolean.valueOf(items[3]);

				Salle salle = new Salle(id, nom, capacite, videoProjecteur);

				salles.add(salle);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return salles;
	}

	private void write(List<Salle> salles) {
		List<String> lines = new ArrayList<String>();

		for (Salle salle : salles) {
			StringBuilder line = new StringBuilder();
			line.append(salle.getId());
			line.append(this.separator);
			line.append(salle.getNom());
			line.append(this.separator);
			line.append(salle.getCapacite());
			line.append(this.separator);
			line.append(salle.getVideoProjecteur());

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
