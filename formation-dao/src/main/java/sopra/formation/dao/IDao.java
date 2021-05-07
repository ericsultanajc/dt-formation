package sopra.formation.dao;

import java.text.SimpleDateFormat;
import java.util.List;

public interface IDao<T,PK> {
	public final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public List<T> findAll();

	public T findById(PK id);

	public void create(T obj);

	public void update(T obj);

	public void delete(T obj);

	public void deleteById(PK id);
}
