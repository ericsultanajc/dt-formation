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

import sopra.formation.dao.IDao;
import sopra.formation.dao.IFiliereDao;
import sopra.formation.model.Dispositif;
import sopra.formation.model.Filiere;

public class FiliereDaoCsv implements IFiliereDao {

	private final String fileName;
	private final String separator = ";";
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public FiliereDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<Filiere> findAll() {
		return read();
	}

	@Override
	public Filiere findById(Long id) {
		List<Filiere> filieres = read();

		for (Filiere filiere : filieres) {
			if (filiere.getId() == id) {
				return filiere;
			}
		}

		return null;
	}

	@Override
	public void create(Filiere obj) {
		List<Filiere> filieres = read();

		Long max = 0L;
		for (Filiere filiere : filieres) {
			if (filiere.getId() > max) {
				max = filiere.getId();
			}
		}

		obj.setId(++max);

		filieres.add(obj);

		write(filieres);
	}

	@Override
	public void update(Filiere obj) {
		List<Filiere> filieres = read();

		boolean found = false;
		int position;
		for (position = 0; position < filieres.size(); position++) {
			Filiere filiere = filieres.get(position);

			if (filiere.getId() == obj.getId()) {
				found = true;
				break;
			}
		}

		if (found) {
			filieres.set(position, obj);

			write(filieres);
		}
	}

	public void delete(Filiere obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		List<Filiere> filieres = read();

		boolean found = false;
		int position;
		for (position = 0; position < filieres.size(); position++) {
			Filiere filiere = filieres.get(position);

			if (filiere.getId() == id) {
				found = true;
				break;
			}
		}

		if (found == true) {
			filieres.remove(position);

			write(filieres);
		}
	}
	
	private void write(List<Filiere> filieres) {
		List<String> lines = new ArrayList<String>();
		
		for(Filiere filiere : filieres) {

	private List<Filiere> read() {
		List<Filiere> filieres = new ArrayList<Filiere>();

		Path path = Paths.get(this.fileName);

		if (path.toFile().exists()) {
			try {
				List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

				for (String line : lines) {
					String[] items = line.split(this.separator, -1);

					Long id = Long.valueOf(items[0]);
					String intitule = items[1];
					String promotion = items[2];
					Date dtDebut = null;
					try {
						dtDebut = sdf.parse(items[3]);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Integer duree = !items[4].isBlank() ? Integer.valueOf(items[4]) : null;
					Dispositif dispositif = !items[5].isBlank() ? Dispositif.valueOf(items[5]) : null;
//					Long idReferent = !items[6].isBlank() ? Long.valueOf(items[6]) : null;

					Filiere filiere = new Filiere();
					filiere.setId(id);
					filiere.setIntitule(intitule);
					filiere.setPromotion(promotion);
					filiere.setDtDebut(dtDebut);
					filiere.setDuree(duree);
					filiere.setDispositif(dispositif);

//					if (idReferent != null) {
//						Formateur formateur = Application.getInstance().getFormateurDao().find(idReferent);
//
//						filiere.setReferent(formateur);
//					}

					filieres.add(filiere);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return filieres;
	}

	private void write(List<Filiere> filieres) {
		Path path = Paths.get(this.fileName);

		List<String> lines = new ArrayList<String>();
		for (Filiere filiere : filieres) {
			StringBuilder sb = new StringBuilder();

			sb.append(filiere.getId()).append(this.separator);
			sb.append(filiere.getIntitule()).append(this.separator);
			sb.append(filiere.getPromotion()).append(this.separator);
			sb.append(sdf.format(filiere.getDtDebut())).append(this.separator);
			sb.append(filiere.getDuree()).append(this.separator);
			sb.append(filiere.getDispositif()).append(this.separator);

//			if (filiere.getReferent() != null && filiere.getReferent().getId() != null) {
//				sb.append(filiere.getReferent().getId());
//			}

			lines.add(sb.toString());
		}

		try {
			Files.write(path, lines, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
