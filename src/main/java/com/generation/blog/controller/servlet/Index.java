<<<<<<< HEAD
package com.generation.blog.controller.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.generation.blog.controller.command.*;
import com.generation.blog.model.bl.BlogBL;
import com.generation.util.Config;

@WebServlet("/Index")
@MultipartConfig()
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> comandi = new HashMap<String, Command>();
    public Index() {
        super();        
        comandi.put("", new CommandNotFound());
        comandi.put("LOGINPAGE", new LoginPageCommand());
        comandi.put("LOGIN", new LoginCommand());
        comandi.put("HOME", new HomeCommand());
        comandi.put("GETPOST", new PostPageCommand());
        comandi.put("SAVEPOST", new SavePostCommand());
        comandi.put("DELETEPOST", new DeletePostCommand());
        comandi.put("SAVECOMMENT", new SaveCommentCommand());
        comandi.put("PROFILE", new ProfileCommand());
        comandi.put("SEARCHTAG", new TagCommand());
        comandi.put("OPTION", new OptionPageCommand());
        comandi.put("UPDATEPROFILE", new UpdateProfileCommand());
        comandi.put("GET", new GetSearchBarCommand());
        comandi.put("SETLIKE", new SetLikeCommand());
        comandi.put("SIGNUPFORM", new SignUpPageCommand());
        comandi.put("SIGNUP", new SignUpCommand());
        comandi.put("VERIFY", new VerifyCommand());
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(!comandi.containsKey(cmd) || cmd == null) cmd = "LOGINPAGE";		
		comandi.get(cmd).run(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
=======
package com.generation.blog.controller.servlet;


import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.generation.blog.controller.command.*;
import com.generation.blog.model.bl.BlogBL;
import com.generation.util.Config;

@WebServlet("/Index")
@MultipartConfig()
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Command> comandi = new HashMap<String, Command>();
    public Index() {
        super();        
        comandi.put("", new CommandNotFound());
        comandi.put("LOGINPAGE", new LoginPageCommand());
        comandi.put("LOGIN", new LoginCommand());
        comandi.put("HOME", new HomeCommand());
        comandi.put("GETPOST", new PostPageCommand());
        comandi.put("SAVEPOST", new SavePostCommand());
        comandi.put("SAVECOMMENT", new SaveCommentCommand());
        comandi.put("PROFILE", new ProfileCommand());
        comandi.put("SEARCHTAG", new TagCommand());
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		if(!comandi.containsKey(cmd) || cmd == null) cmd = "LOGINPAGE";		
		comandi.get(cmd).run(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
