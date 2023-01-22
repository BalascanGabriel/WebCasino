package dao;

import java.util.List;

public interface IDao<T> {

	public List<T> findAll();
	public void save(T o);
	
}
