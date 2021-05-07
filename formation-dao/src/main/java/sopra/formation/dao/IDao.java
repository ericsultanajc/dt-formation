package sopra.formation.dao;

import java.text.ParseException;
import java.util.List;

public interface IDao<T,PK> {
	public List<T> findAll() throws ParseException;

	public T findById(PK id) throws ParseException;

	public void create(T obj) throws ParseException;

	public void update(T obj) throws ParseException;

	public void delete(T obj) throws ParseException;

	public void deleteById(PK id) throws ParseException;
}
