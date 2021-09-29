package com.generation.blog.model.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.generation.util.Config;
import com.generation.util.Entity;

public abstract class AbstractDAOSQLite<X extends Entity> implements DAO<X> {
	Map<Integer, X> cache = new HashMap<Integer, X>();
	String table;
	Connection conn;
	
	public AbstractDAOSQLite(String table) throws ClassNotFoundException, SQLException {
//		System.out.println(Config.conn);
		this.conn = Config.getInstance().conn;
		this.table = table;
	}
	
	
	@Override
	public X getOne(int id) {
		if(cache.containsKey(id))
			return cache.get(id);
		try{
			String sql = "SELECT * FROM "+table+" WHERE ID="+id;
			Statement cmdSql = conn.createStatement();
			ResultSet row = cmdSql.executeQuery(sql);
			X res =  row.next() ? _rowToObj(row) : null;
			cache.put(id, res);
			cmdSql.close();
			row.close();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	

	@Override
	public X addOne(X x) throws SQLException {
		//Inserisco un oggetto dentro al db tramite il metodo astratto _objToRow
		//che verrà implementato in ogni singola DAO
		Statement cmdSql = conn.createStatement();
		
		cmdSql.execute(_objToRow(x));
		cmdSql.close();
		
		//Una volta inserito l'oggetto, per recuperarne l'id, controllo l'id max (che corrisponde a quello appena inserito)
		//e riprendo l'oggetto tramite getOne e l'id maggiore.
		Statement readCmd = conn.createStatement();
		String sqlmaxid = "select max(id) as m from "+table;
		ResultSet maxRow  = readCmd.executeQuery(sqlmaxid);
		return maxRow.next() ? getOne(maxRow.getInt("m")) : null;
		
	}
	
	@Override 
	public boolean delete(int id) throws Exception {
		
		//Controllo se nel db è presente, se non è presente ritorno eccezione
		X old = getOne(id);
		if(old == null)
			throw new RuntimeException("NOT FOUND");
		
		String sql = "DELETE FROM "+table+" WHERE ID="+id;
		Statement cmdSql = conn.createStatement();
		cmdSql.execute(sql);
		cmdSql.close();
		
		//Essendo avvenuta l'eliminazione, lo tolgo anche dalla cache
		cache.remove(id);
		return true;
	}
	
	@Override
	public List<X> getAll(String condition){
		List<X> result = new ArrayList<X>();
		try {
			String sql = "SELECT * FROM "+table+" WHERE "+condition;
			Statement cmdSql = conn.createStatement();
			ResultSet rows = cmdSql.executeQuery(sql);
			
			while(rows.next()){
				X entity = _rowToObj(rows);
				if(cache.containsKey(entity.getId()))
					result.add(getOne(entity.getId()));
				else {
					cache.put(entity.getId(), entity);
					result.add(entity);
				}
			}
			return result;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}	
	}
	
	@Override
	public boolean update(String values, String condition) {
		String sql = "UPDATE "+table+" SET " + values + " WHERE " + condition + ";";
		System.out.println(sql);
		try {
			Statement cmdUp = conn.createStatement();
			return cmdUp.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	protected abstract X _rowToObj(ResultSet row) throws SQLException;
	protected abstract String _objToRow(X x);
}