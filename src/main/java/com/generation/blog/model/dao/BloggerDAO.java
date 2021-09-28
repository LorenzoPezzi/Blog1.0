<<<<<<< HEAD
package com.generation.blog.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.generation.blog.model.entities.Admin;
import com.generation.blog.model.entities.Blogger;
import com.generation.util.Date;

public class BloggerDAO extends AbstractDAOSQLite<Blogger>{

	public BloggerDAO(String table) throws ClassNotFoundException, SQLException {
		super(table);
	}
	
	public Blogger getOne(String nickname) {
		for(Map.Entry<Integer, Blogger> entry : cache.entrySet()) {
			if(entry.getValue().getNickname().equals(nickname))
				return entry.getValue();
		}
		try{
			String sql = "SELECT FROM "+table+" WHERE NICKNAME="+nickname;
			Statement cmdSql = conn.createStatement();
			ResultSet row = cmdSql.executeQuery(sql);
			Blogger res =  row.next() ? _rowToObj(row) : null;
			cache.put(res.getId(), res);
			cmdSql.close();
			row.close();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected Blogger _rowToObj(ResultSet row) throws SQLException {
		if(row.getString("DTYPE").equals("admin"))
			return new Admin(row.getInt("ID"), row.getString("NICKNAME"), row.getString("EMAIL"),
					row.getString("PASSWORD"), row.getString("BIO"), Date.toEuropean(row.getString("DOB")), row.getString("IMGBLOGGER"), row.getInt("VERIFIED"));
		
		return Blogger.make(row.getInt("ID"), row.getString("NICKNAME"), row.getString("EMAIL"),
				row.getString("PASSWORD"), row.getString("BIO"), Date.toEuropean(row.getString("DOB")), row.getString("IMGBLOGGER"), row.getInt("VERIFIED"));
	}

	@Override
	protected String _objToRow(Blogger b) {
		String sql = "INSERT INTO BLOGGER (NICKNAME, EMAIL, PASSWORD, BIO, DOB, IMGBLOGGER, VERIFIED) VALUES"
				+ " ('[nickname]','[email]','[password]','[bio]','[dob]','[img]', [verified])";
		sql = sql.replace("[nickname]", b.getNickname());
		sql = sql.replace("[email]", b.getEmail());
		sql = sql.replace("[password]", b.getPassword());
		sql = sql.replace("[bio]", b.getBio());
		sql = sql.replace("[dob]", b.getDob().toAmerican());
		sql = sql.replace("[img]", b.getImg());
		sql = sql.replace("[verified]", b.getVerified()+"");
		return sql;
	}

}
=======
package com.generation.blog.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.generation.blog.model.entities.Blogger;
import com.generation.util.Date;

public class BloggerDAO extends AbstractDAOSQLite<Blogger>{

	public BloggerDAO(String table) throws ClassNotFoundException, SQLException {
		super(table);
	}
	
	public Blogger getOne(String nickname) {
		for(Map.Entry<Integer, Blogger> entry : cache.entrySet()) {
			if(entry.getValue().getNickname().equals(nickname))
				return entry.getValue();
		}
		try{
			String sql = "SELECT FROM "+table+" WHERE NICKNAME="+nickname;
			Statement cmdSql = conn.createStatement();
			ResultSet row = cmdSql.executeQuery(sql);
			Blogger res =  row.next() ? _rowToObj(row) : null;
			cache.put(res.getId(), res);
			cmdSql.close();
			row.close();
			return res;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	protected Blogger _rowToObj(ResultSet row) throws SQLException {
		return Blogger.make(row.getInt("ID"), row.getString("NICKNAME"), row.getString("EMAIL"),
				row.getString("PASSWORD"), row.getString("BIO"), Date.toEuropean(row.getString("DOB")), row.getString("IMGBLOGGER"), row.getInt("VERIFIED"));
	}

	@Override
	protected String _objToRow(Blogger b) {
		String sql = "INSERT INTO BLOGGER (NICKNAME, EMAIL, PASSWORD, BIO, DOB, IMGBLOGGER, VERIFIED) VALUES"
				+ " ('[nickname]','[email]','[password]','[bio]','[dob]','[img]', [verified])";
		sql = sql.replace("[nickname]", b.getNickname());
		sql = sql.replace("[email]", b.getEmail());
		sql = sql.replace("[password]", b.getPassword());
		sql = sql.replace("[bio]", b.getBio());
		sql = sql.replace("[dob]", b.getDob().toAmerican());
		sql = sql.replace("[img]", b.getImg());
		sql = sql.replace("[verified]", b.getVerified()+"");
		return sql;
	}

}
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
