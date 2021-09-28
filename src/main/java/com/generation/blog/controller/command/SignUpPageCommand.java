package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpPageCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("page/signUpPage.jsp").forward(request, response);
		
	}

}
