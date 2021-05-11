package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.dao.IMatiereDao;
import sopra.formation.model.Matiere;

public class MatiereDaoCsv implements IMatiereDao {
	private final String fileName;
	private final String separator = ";";

	public MatiereDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	public List<Matiere> findAll() {
		return read();
	}

	public Matiere findById(Long id) {
		List<Matiere> matieres = read();

		for (Matiere matiere : matieres) {
			if (matiere.getId() == id) {
				return matiere;
			}
		}

		return null;
	}

	public void create(Matiere obj) {
		List<Matiere> matieres = read();

		Long maxId = 0L;
		for (Matiere matiere : matieres) {
			if (maxId < matiere.getId()) {
				maxId = matiere.getId();
			}
		}

		obj.setId(++maxId);

		matieres.add(obj);

		write(matieres);
	}

	public void update(Matiere obj) {
		List<Matiere> matieres = read();

		int index = 0;
		boolean find = false;

		for (Matiere matiere : matieres) {
			if (matiere.getId() == obj.getId()) {
				find = true;
				break;
			}

			index++;
		}

		if (find) {
			matieres.set(index, obj);

			write(matieres);
		}
	}

	public void delete(Matiere obj) {
		deleteById(obj.getId());
	}

	public void deleteById(Long id) {
		List<Matiere> matieres = read();

		int index = 0;
		boolean find = false;

		for (Matiere matiere : matieres) {
			if (matiere.getId() == id) {
				find = true;
				break;
			}

			index++;
		}

		if (find) {
			matieres.remove(index);

			write(matieres);
		}
	}

	private List<Matiere> read() {
		List<Matiere> matieres = new ArrayList<Matiere>();

		Path path = Paths.get(this.fileName);

		if (path.toFile().exists()) {
			try {
				List<String> lines = Files.readAllLines(path);

				for (String line : lines) {
					String[] items = line.split(this.separator);

					Long id = Long.valueOf(items[0]);
					String nom = items[1];
					Integer duree = Integer.valueOf(items[2]);

					Matiere matiere = new Matiere(id, nom, duree);

					matieres.add(matiere);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return matieres;
	}

	private void write(List<Matiere> matieres) {
		List<String> lines = new ArrayList<String>();

		for (Matiere matiere : matieres) {
			StringBuilder line = new StringBuilder();
			line.append(matiere.getId());
			line.append(this.separator);
			line.append(matiere.getNom());
			line.append(this.separator);
			line.append(matiere.getDuree());

			lines.add(line.toString());
		}

		Path path = Paths.get(this.fileName);

		try {
			Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Matiere> findAllByFormateurById(Long idFormateur) {
		// TODO Auto-generated method stub
		return null;
	}
}
