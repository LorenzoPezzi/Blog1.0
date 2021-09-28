package com.generation.blog.controller.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateProfileCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		bl.updateBlogger("BIO='"+request.getParameter("contentText")+"', IMGBLOGGER='"+request.getParameter("img")+"'", " ID="+user.getId());
		
		user.setBio(request.getParameter("contentText"));
		user.setImg(request.getParameter("img"));
		request.setAttribute("user", user);
		request.getRequestDispatcher("page/optionPage.jsp").forward(request, response);
	}

}
