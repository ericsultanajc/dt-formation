package sopra.formation.dao;

import java.util.List;

import sopra.formation.model.Evaluation;

public interface IEvaluationDao extends IDao<Evaluation, Long>{
	List<Evaluation> findAllByTechnique(Integer technique);
}
