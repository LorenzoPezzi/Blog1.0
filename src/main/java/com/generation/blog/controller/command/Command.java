
package com.generation.blog.controller.command;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.generation.blog.model.bl.BlogBL;
import com.generation.blog.model.bl.FirstBlogBL;
import com.generation.blog.model.entities.Blogger;
import com.generation.util.Config;

	

public abstract class Command {
	protected static Blogger user;
	protected BlogBL bl;
	
	
	public Command() {
		try {
			Config init = Config.getInstance();
			bl = init.bl;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public abstract void run( HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;
}