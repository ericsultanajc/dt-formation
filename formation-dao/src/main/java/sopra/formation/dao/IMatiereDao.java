package sopra.formation.dao;

import java.util.List;

import sopra.formation.model.Matiere;

public interface IMatiereDao extends IDao<Matiere, Long>{
	List<Matiere> findAllByFormateurById(Long idFormateur);
}
