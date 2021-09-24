package com.generation.blog.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import com.generation.blog.model.entities.Post;
import com.generation.util.Date;

public class PostDAO extends AbstractDAOSQLite<Post>{

	public PostDAO(String table) throws ClassNotFoundException, SQLException {
		super(table);
	}

	
	
	
	@Override
	protected Post _rowToObj(ResultSet row) throws SQLException {
		
		if(row.getString("tags") == null)
			return new Post(row.getInt("id"), row.getString("title"), row.getString("content"), 
					Date.toEuropean(row.getString("dop")),row.getInt("BLOGGERID") , row.getString("IMGPOST"), "".split(","),
					row.getString("likes").split(","));
		
		return new Post(row.getInt("id"), row.getString("title"), row.getString("content"), 
				Date.toEuropean(row.getString("dop")),row.getInt("BLOGGERID"), row.getString("IMGPOST"), row.getString("tags").split(","),
				row.getString("likes").split(","));
	}


	@Override
	protected String _objToRow(Post x) {
		String sql = "INSERT INTO POST (TITLE, CONTENT, DOP, BLOGGERID, IMGPOST, TAGS, LIKES) VALUES ('[title]', '[content]', '[dop]',"
				+ "[bloggerid], '[img]', '[tags]', '')";
		
		sql = sql.replace("[title]", x.getTitle());
		sql = sql.replace("[content]", x.getContent());
		sql = sql.replace("[dop]", x.getDop().toAmerican());
		sql = sql.replace("[bloggerid]", x.getBloggerID()+"");
		sql = sql.replace("[img]", x.getImg());
		sql = sql.replace("[tags]", x.getTagsString());
		
		System.out.println(sql);
		return sql;
	}

}
