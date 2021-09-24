package com.generation.blog.controller.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Post;
import com.generation.util.Date;


public class LoginCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("test");
		//Get Blogger from nick & psw
		user = bl.login(request.getParameter("username"), request.getParameter("cryptPass"), true).get(0);
		if(user != null) {
			request.getSession().setAttribute("user", user);
//			request.setAttribute("posts", bl.getPosts());
//			request.setAttribute("postsRecent", bl.getRecentPost("2021-09-01"));
			new HomeCommand().run(request, response);
		}
		request.getRequestDispatcher("page/loginPage.jsp").forward(request, response);
		return;
	}

}
