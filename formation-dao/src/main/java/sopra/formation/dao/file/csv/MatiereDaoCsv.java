package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
	
	//0000000000000000000000000000000000000000000000000000000000
	public List<Matiere> findAll() {
		return read();
	}
	
	//0000000000000000000000000000000000000000000000000000000000
	//signature de matiere : (Long id, String nom, Integer duree)
	private List<Matiere> read() {
		List<Matiere> matieres = new ArrayList<Matiere>();

		Path path = Paths.get(this.fileName);

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

		return matieres;
	}
	
	//0000000000000000000000000000000000000000000000000000000000

	public Matiere findById(Long id) {
		List<Matiere> matieres = read();

		for (Matiere matiere : matieres) {
			if (matiere.getId() == id) {
				return matiere;
			}
		}

		return null;
	}
	
	//0000000000000000000000000000000000000000000000000000000000

	public void create(Matiere obj) {
		List<Matiere> matieres = read();

		Long maxId = 0L;
		for (Matiere mat : matieres) {
			if (maxId < mat.getId()) {
				maxId = mat.getId();
			}
		}

		obj.setId(++maxId);

		matieres.add(obj);

		write(matieres);
	}
	
	//0000000000000000000000000000000000000000000000000000000000
	
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
			Files.write(path, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//0000000000000000000000000000000000000000000000000000000000

	public void update(Matiere obj) {
		List<Matiere> matieres = read();
		
		int index = 0;
		boolean find = false;

		for (Matiere mat : matieres) {
			if (mat.getId() == obj.getId()) {
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
	
	//0000000000000000000000000000000000000000000000000000000000
		

	public void delete(Matiere obj) {
		deleteById(obj.getId());
	}
	
	//0000000000000000000000000000000000000000000000000000000000
	
	public void deleteById(Long id) {
		List<Matiere> matieres = read();

		int index = 0;
		boolean find = false;

		for (Matiere mat : matieres) {
			if (mat.getId() == id) {
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

	//000000000000000000000000000000000000000000000000000000000000000000000000000000000000000


	public List<Matiere> findAllByNom(String nom) {
		List<Matiere> matieres = new ArrayList<Matiere>();

		for (Matiere matiere : read()) {
			if (matiere.getNom() == nom) {
				matieres.add(matiere);
			}
		}

		return matieres;
	}
}
