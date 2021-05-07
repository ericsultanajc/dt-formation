package sopra.formation.dao;


import java.text.ParseException;
import java.util.List;

import sopra.formation.model.Stagiaire;

public interface IStagiaireDao extends IDao<Stagiaire, Long> {
	List<Stagiaire> findAllById(Long Id) throws ParseException;
}
