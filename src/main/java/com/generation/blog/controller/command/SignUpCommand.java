package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Blogger;
import com.generation.util.Date;
import com.generation.util.SendMail;
import com.generation.util.UploadFile;

public class SignUpCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nickname = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("cryptPass");
		String bio = request.getParameter("contentText");
		String dob = request.getParameter("dob");

		String img = UploadFile.upload(request, response);
		
		Blogger b = new Blogger(nickname, email, password, bio, Date.make(dob), img, 0);
//		if(!Blogger.isValidEmail() || !Blogger.isValidPassword()) {
//			request.setAttribute("errorForm", "Invalid Data");
//			request.setAttribute("fakeBlogger", b);
//			request.getRequestDispatcher("signUpPage.jsp").forward(request, response);
//			break;
//		} 
		if(SendMail.send(b)) {
			bl.saveBlogger(b);
			request.getRequestDispatcher("page/loginPage.jsp").forward(request, response);
		}
		else {
			b.setVerified(1);
			bl.saveBlogger(b);
			request.getSession().setAttribute("user", b);
			request.getRequestDispatcher("page/optionPage.jsp").forward(request, response);
		}
		
	}

}
