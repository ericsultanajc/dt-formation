package sopra.formation.dao.file.csv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		try {
			return read();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Filiere findById(Long id) {
		try {
			List<Filiere> filieres = read();
			
			for(Filiere filiere : filieres) {
				if(filiere.getId() == id) {
					return filiere;
				}
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void create(Filiere obj) {
		try {
			List<Filiere> filieres = read();
			
			Long maxId = 0L;
			for(Filiere filiere : filieres) {
				if(maxId < filiere.getId()) {
					maxId = filiere.getId();
				}
			}
			
			obj.setId(++maxId);
			
			filieres.add(obj);
			
			write(filieres);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Filiere obj) {
		try {
			List<Filiere> filieres = read();
			
			int index = 0;
			boolean find = false;
			
			for (Filiere filiere : filieres) {
				if (filiere.getId() == obj.getId()) {
					find = true;
					break;
				}

				index++;
			}
			
			if(find) {
				filieres.set(index, obj);
				write(filieres);
			}
		}
		catch(ParseException e) {
			e.printStackTrace();;
		}		
	}

	@Override
	public void delete(Filiere obj) {
		deleteById(obj.getId());
	}

	@Override
	public void deleteById(Long id) {
		try {
			List<Filiere> filieres = read();
			
			int index = 0;
			boolean find = false;
			for(Filiere filiere : filieres) {
				if(filiere.getId() == id) {
					find = true;
					break;
				}
				
				index++;
			}
			
			if(find) {
				filieres.remove(index);
				
				write(filieres);
			}
		}
		catch(ParseException e) {
			e.printStackTrace();;
		}
	}
	
	private List<Filiere> read() throws ParseException {
		List<Filiere> filieres = new ArrayList<Filiere>();
		
		Path path = Paths.get(this.fileName);
		
		try {
			List<String> lines = Files.readAllLines(path);
			
			for(String line : lines) {
				String[] items = line.split(this.separator);
				
				Long id = Long.valueOf(items[0]);
				String intitule = String.valueOf(items[1]);
				String promotion = String.valueOf(items[2]);
				
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dtDebut;
				dtDebut = (Date)this.sdf.parse(items[3]);
				
				Integer duree = Integer.valueOf(items[4]);
				Dispositif dispositif = Dispositif.valueOf(items[5]);
				
				Filiere filiere = new Filiere(id, intitule, promotion, dtDebut, duree, dispositif);
				
				filieres.add(filiere);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filieres;
	}
	
	private void write(List<Filiere> filieres) {
		List<String> lines = new ArrayList<String>();
		
		for(Filiere filiere : filieres) {
			//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dtDebut = this.sdf.format(filiere.getDtDebut());
			
			StringBuilder line = new StringBuilder();
			line.append(filiere.getId());
			line.append(this.separator);
			line.append(filiere.getIntitule());
			line.append(this.separator);
			line.append(filiere.getPromotion());
			line.append(this.separator);
			line.append(dtDebut);
			line.append(this.separator);
			line.append(filiere.getDuree());
			line.append(this.separator);
			line.append(filiere.getDispositif());
			
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
