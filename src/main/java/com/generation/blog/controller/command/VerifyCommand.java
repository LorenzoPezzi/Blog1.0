package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nick = request.getParameter("nick");
		bl.updateBlogger(" VERIFIED=1", " NICKNAME='"+nick+"'");
		user = bl.getBloggers(" NICKNAME='"+nick+"'", true).get(0);
		request.getSession().setAttribute("user", user);
		new HomeCommand().run(request, response);
	}

}
