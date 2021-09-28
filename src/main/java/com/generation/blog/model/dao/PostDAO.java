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
	
	public int getUpdatePostLike(int id, String nick) {
		String sql = "SELECT * FROM POST WHERE ID="+id;
		ResultSet row;
		try {
			row = conn.createStatement().executeQuery(sql);
			int like = row.getString("likes").split(",").length;
			String bloggerLike = "";
			for(String name : row.getString("likes").split(","))
				if(nick.equals(name)) {
					if(row.getString("likes").split(",").length == 1)
						bloggerLike = row.getString("likes").replace(name , "");
					else
						bloggerLike = row.getString("likes").replace(","+name , "");
					
					cache.get(id).setLike(bloggerLike.split(","));
					System.out.println(bloggerLike);
					String sqlUp = "UPDATE POST SET LIKES='"+bloggerLike+"' WHERE ID="+id;
					conn.createStatement().execute(sqlUp);
					return --like;
				}			
			
			if(row.getString("likes").isEmpty())
				bloggerLike = nick;
			else {
				like++;
				bloggerLike = row.getString("likes") + "," + nick;
			}
			cache.get(id).setLike(bloggerLike.split(","));
			String sqlUp = "UPDATE POST SET LIKES='"+bloggerLike+"' WHERE ID="+id;
			conn.createStatement().execute(sqlUp);
			return like;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
