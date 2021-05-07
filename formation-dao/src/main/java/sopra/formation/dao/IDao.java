package sopra.formation.dao;

import java.util.List;

public interface IDao<T,PK> {		//T et PL sont génériques : ont peut les remplacer dans 
	public List<T> findAll();		//les classes filles pour changer les types 

	public T findById(PK id);

	public void create(T obj);

	public void update(T obj);

	public void delete(T obj);

	public void deleteById(PK id);
}
