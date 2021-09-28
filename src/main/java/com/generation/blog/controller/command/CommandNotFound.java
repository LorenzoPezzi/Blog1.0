<<<<<<< HEAD
package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandNotFound extends Command{
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		response.getWriter().append("comando non riconosciuto");
	}

	
}
=======
package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandNotFound extends Command{
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException{
		// TODO Auto-generated method stub
		response.getWriter().append("comando non riconosciuto");
	}

	
}
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
