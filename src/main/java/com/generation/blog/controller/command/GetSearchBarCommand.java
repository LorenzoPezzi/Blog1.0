package com.generation.blog.controller.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Blogger;
import com.generation.util.Date;
import com.google.gson.*;

public class GetSearchBarCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String word = request.getParameter("word");
		System.out.println(word);
		List<Blogger> listBlogger = null;	
		listBlogger = bl.getBloggers(" BIO LIKE '%"+ word +"%' OR NICKNAME LIKE '%"+ word +"%' ", false);
		List<String> list = new ArrayList<String>();
		for(Blogger b : listBlogger)
			list.add(b.getNickname());
		String json = new Gson().toJson(list);
		System.out.println(json);
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    response.getWriter().write(json);
	}

}
