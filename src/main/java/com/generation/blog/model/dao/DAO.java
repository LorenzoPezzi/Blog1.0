package com.generation.blog.model.dao;
import java.sql.SQLException;
import java.util.List;

import com.generation.util.Entity;

public interface DAO<X extends Entity> {

	X getOne(int id);
	X addOne(X x) throws SQLException;
	
	/**
	 * Il metodo default avvia lo stesso metodo che definisce
	 * ma senza il parametro, lo imposta dentro e richiama il metodo sopra
	 * @param condition
	 * @return
	 */
	List<X> getAll(String condition);
	default List<X> getAll(){
		return getAll("1=1");
	}
	
	void delete(int id) throws Exception;
	default void delete(X x) throws Exception {
		delete(x.getId());
	}
	
	
}
