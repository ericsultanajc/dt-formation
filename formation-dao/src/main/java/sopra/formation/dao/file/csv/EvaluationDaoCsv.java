package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import sopra.formation.dao.IEvaluationDao;
import sopra.formation.model.Evaluation;

public class EvaluationDaoCsv implements IEvaluationDao {

	private final String fileName;
	private final String separator = ";";

	public EvaluationDaoCsv(String fileName) {
		super();
		this.fileName = fileName;
	}

	public List<Evaluation> findAll() {
		return read();
	}

	public Evaluation findById(Long id) {
		List<Evaluation> evaluations = read();

		for (Evaluation evaluation : evaluations) {
			if (evaluation.getId() == id) {
				return evaluation;
			}
		}

		return null;
	}

	public void create(Evaluation obj) {
		List<Evaluation> evaluations = read();

		Long maxId = 0L;
		for (Evaluation eval : evaluations) {
			if (maxId < eval.getId()) {
				maxId = eval.getId();
			}
		}

		obj.setId(++maxId);

		evaluations.add(obj);

		write(evaluations);
	}

	public void update(Evaluation obj) {
		List<Evaluation> evaluations = read();

		int index = 0;
		boolean find = false;

		for (Evaluation eval : evaluations) { 
			if (eval.getId() == obj.getId()) {
				find = true;
				break;
			}

			index++;
		}
		
		if (find) {
			evaluations.set(index, obj);

			write(evaluations);
		}
	}

	public void delete(Evaluation obj) {
		deleteById(obj.getId());
	}
	
	public void deleteById(Long id) {
		List<Evaluation> evaluations = read();
		
		int index = 0;
		boolean find = false;

		for (Evaluation eval : evaluations) {
			if (eval.getId() == id) {
				find = true;
				break;
			}

			index++;
		}
		
		if (find) {
			evaluations.remove(index);

			write(evaluations);
		}
	}

	private List<Evaluation> read() {
		List<Evaluation> evaluations = new ArrayList<Evaluation>();

		Path path = Paths.get(this.fileName);

		try {
			List<String> lines = Files.readAllLines(path);

			for (String line : lines) {
				String[] items = line.split(this.separator);

				Long id = Long.valueOf(items[0]);
				Integer comportemental = Integer.valueOf(items[1]);
				Integer technique = Integer.valueOf(items[2]);
				String commentaires = items[3];

				Evaluation evaluation = new Evaluation(id, comportemental, technique, commentaires);

				evaluations.add(evaluation);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return evaluations;
	}

	private void write(List<Evaluation> evaluations) {
		List<String> lines = new ArrayList<String>();

		for (Evaluation evaluation : evaluations) {
			StringBuilder line = new StringBuilder();
			line.append(evaluation.getId());
			line.append(this.separator);
			line.append(evaluation.getComportemental());
			line.append(this.separator);
			line.append(evaluation.getTechnique());
			line.append(this.separator);
			line.append(evaluation.getCommentaires());

			lines.add(line.toString());
		}

		Path path = Paths.get(this.fileName);

		try {
			Files.write(path, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Evaluation> findAllByTechnique(Integer technique) {
		List<Evaluation> evaluations = new ArrayList<Evaluation>();

		for (Evaluation evaluation : read()) {
			if (evaluation.getTechnique() == technique) {
				evaluations.add(evaluation);
			}
		}
		
		return evaluations;
	}
}
