package com.generation.blog.controller.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Blogger;
import com.generation.blog.model.entities.Post;

public class HomeCommand extends Command {
	
	@Override
	public void run(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		System.out.println("test2");
		request.getSession().setAttribute("user", user);
		List<Post> posts = bl.getPosts(" 1=1", false);
		System.out.println(posts);
		for(Post p: posts) {
			p.setAuthor(bl.getBloggers(" ID="+p.getBloggerID() , false).get(0));
		}
		
		List<Post> postsRecent = bl.getPosts(" DOP > '2021-02-01'", false);
		System.out.println(postsRecent);
		for(Post p: postsRecent) {
			p.setAuthor(bl.getBloggers(" ID="+p.getBloggerID() , false).get(0));
		}
		
		request.setAttribute("posts", posts);
		request.setAttribute("postsRecent", postsRecent);
		request.getRequestDispatcher("page/homePage.jsp").forward(request, response);
		return;
	}
	
}
