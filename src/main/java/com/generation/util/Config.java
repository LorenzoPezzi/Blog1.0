package com.generation.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.generation.blog.model.bl.*;
import com.generation.blog.model.dao.*;

public class Config {
	private static Config instance = null;
	public Connection conn;
	public BlogBL bl;
	
	public static Config getInstance() throws ClassNotFoundException, SQLException {
		if(instance == null) {
			instance = new Config();
			instance._init();
		}
		return instance;
	}
	
	private Config() throws ClassNotFoundException, SQLException {}
	
	private void _init() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		String filePath = "C:\\filePath\\blog.db";
		conn = DriverManager.getConnection("jdbc:sqlite:"+ filePath);
		
		bl = new FirstBlogBL(new PostDAO("POST"), new BloggerDAO("BLOGGER"), new CommentDAO("COMMENTS"));
	}
	
	
	
}
