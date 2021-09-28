<<<<<<< HEAD
package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Blogger;


public class ProfileCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getSession().setAttribute("user", user);
		
		if(user.getNickname().equals(request.getParameter("nick"))) {
			request.getRequestDispatcher("page/userPage.jsp").forward(request, response);
			return;
		}
		request.setAttribute("blogger", bl.getBloggers(" NICKNAME='"+request.getParameter("nick")+"'", true).get(0));
		request.getRequestDispatcher("page/profilePage.jsp").forward(request, response);
		return;
	}

}
=======
package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Blogger;


public class ProfileCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getSession().setAttribute("user", user);
		
		if(user.getNickname().equals(request.getParameter("nick"))) {
			request.getRequestDispatcher("page/userPage.jsp").forward(request, response);
			return;
		}
		request.setAttribute("blogger", bl.getBloggers(" NICKNAME='"+request.getParameter("nick")+"'", true).get(0));
		request.getRequestDispatcher("page/profilePage.jsp").forward(request, response);
		return;
	}

}
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
