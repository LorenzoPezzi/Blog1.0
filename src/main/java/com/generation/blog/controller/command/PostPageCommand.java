package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Post;

public class PostPageCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			System.out.println(request.getParameter("postid"));
			Post p = bl.getPost((Integer.parseInt(request.getParameter("postid"))), true);

			request.getSession().setAttribute("user", user);
			request.setAttribute("post", p);
			request.getRequestDispatcher("page/postPage.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			//error
		}
	}

}
