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
import sopra.formation.dao.IUEDao;
import sopra.formation.model.Filiere;
import sopra.formation.model.Formateur;
import sopra.formation.model.Matiere;
import sopra.formation.model.Salle;
import sopra.formation.model.UE;

public class UEDaoCsv implements IUEDao {
	private final String fileName;
	private final String separator = ";";

	public UEDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public List<UE> findAll() {
		return read();
	}

	@Override
	public UE findById(Long id) {
		List<UE> ues = read();

		for (UE ue : ues) {
			if (ue.getId() == id) {
				return ue;
			}
		}

		return null;
	}

	@Override
	public void create(UE obj) {
		List<UE> ues = read();

		Long max = 0L;
		for (UE ue : ues) {
			if (ue.getId() > max) {
				max = ue.getId();
			}
		}

		obj.setId(++max);

		ues.add(obj);

		write(ues);
	}

	@Override
	public void update(UE obj) {
		List<UE> ues = read();

		boolean found = false;
		int position;
		for (position = 0; position < ues.size(); position++) {
			UE ue = ues.get(position);

			if (ue.getId() == obj.getId()) {
				found = true;
				break;
			}
		}

		if (found) {
			ues.set(position, obj);

			write(ues);
		}
	}

	@Override
	public void delete(UE obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		List<UE> ues = read();

		boolean found = false;
		int position;
		for (position = 0; position < ues.size(); position++) {
			UE ue = ues.get(position);

			if (ue.getId() == id) {
				found = true;
				break;
			}
		}

		if (found == true) {
			ues.remove(position);

			write(ues);
		}
	}

	private List<UE> read() {
		List<UE> ues = new ArrayList<UE>();

		Path path = Paths.get(this.fileName);

		if (path.toFile().exists()) {
			try {
				List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

				for (String line : lines) {
					String[] items = line.split(this.separator, -1);

					Long id = Long.valueOf(items[0]);
					Integer code = Integer.valueOf(items[1]);
					Integer duree = Integer.valueOf(items[2]);
					Integer ordre = Integer.valueOf(items[3]);
					Long idFiliere = !items[4].isBlank() ? Long.valueOf(items[4]) : null;
					Long idFormateur = !items[5].isBlank() ? Long.valueOf(items[5]) : null;
					Long idMatiere = !items[6].isBlank() ? Long.valueOf(items[6]) : null;
					Long idSalle = !items[7].isBlank() ? Long.valueOf(items[7]) : null;

					UE ue = new UE();
					ue.setId(id);
					ue.setCode(code);
					ue.setDuree(duree);
					ue.setOrdre(ordre);

					if (idFiliere != null) {
						Filiere filiere = Application.getInstance().getFiliereDao().findById(idFiliere);
						ue.setFiliere(filiere);
					}

					if (idFormateur != null) {
						Formateur formateur = Application.getInstance().getFormateurDao().findById(idFormateur);
						ue.setFormateur(formateur);
					}

					if (idMatiere != null) {
						Matiere matiere = Application.getInstance().getMatiereDao().findById(idMatiere);
						ue.setMatiere(matiere);
					}

					if (idSalle != null) {
						Salle salle = Application.getInstance().getSalleDao().findById(idSalle);
						ue.setSalle(salle);
					}

					ues.add(ue);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ues;
	}

	private void write(List<UE> ues) {
		Path path = Paths.get(this.fileName);

		List<String> lines = new ArrayList<String>();

		for (UE ue : ues) {
			StringBuilder sb = new StringBuilder();

			sb.append(ue.getId()).append(this.separator);
			sb.append(ue.getCode()).append(this.separator);
			sb.append(ue.getDuree()).append(this.separator);
			sb.append(ue.getOrdre()).append(this.separator);

			if (ue.getFiliere() != null && ue.getFiliere().getId() != null) {
				sb.append(ue.getFiliere().getId()).append(this.separator);
			} else {
				sb.append(this.separator);
			}

			if (ue.getFormateur() != null && ue.getFormateur().getId() != null) {
				sb.append(ue.getFormateur().getId()).append(this.separator);
			} else {
				sb.append(this.separator);
			}

			if (ue.getMatiere() != null && ue.getMatiere().getId() != null) {
				sb.append(ue.getMatiere().getId()).append(this.separator);
			} else {
				sb.append(this.separator);
			}

			if (ue.getSalle() != null && ue.getSalle().getId() != null) {
				sb.append(ue.getSalle().getId());
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
