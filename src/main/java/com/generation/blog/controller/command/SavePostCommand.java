package com.generation.blog.controller.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Post;
import com.generation.util.Date;

public class SavePostCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String title = request.getParameter("title");
		String content = request.getParameter("contentText");
		//File path: 
		String img = "img";
		String tag = request.getParameter("tag");
		Date dop = Date.today;
		int authorID = user.getId();
		Post p = new Post(title, content, dop, authorID, img, tag.split(","), "".split(","));
		try {
			p = bl.savePost(p);
			p.setAuthor(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.getPosts().add(p);
		request.setAttribute("post", p);
		request.getRequestDispatcher("page/redirectPost.jsp").forward(request, response);
	}
}
