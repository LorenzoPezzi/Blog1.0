package com.generation.blog.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetLikeCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int postid = Integer.parseInt(request.getParameter("postid"));
		String nick = request.getParameter("nick");
		int like = bl.setLike(postid, nick);
		System.out.println(like);
		response.getWriter().write(like+"");
	}

}
