<<<<<<< HEAD
package com.generation.blog.controller.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Post;

public class TagCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		List<Post> posts = bl.getPosts(" TAGS LIKE '%"+ request.getParameter("tag") +"%'", false);
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("page/tagPage.jsp").forward(request, response);
	
	}

}
=======
package com.generation.blog.controller.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Post;

public class TagCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Post> posts = bl.getPosts(" TAGS='%"+ request.getParameter("tag") +"%'", false);
		request.setAttribute("posts", posts);
		request.getRequestDispatcher("page/tagPage.jsp").forward(request, response);
	
	}

}
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
