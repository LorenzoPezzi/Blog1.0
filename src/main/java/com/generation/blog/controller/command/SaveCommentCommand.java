package com.generation.blog.controller.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Comment;
import com.generation.blog.model.entities.Post;
import com.generation.util.Date;

public class SaveCommentCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		try {
			String title = request.getParameter("title");
			String content = request.getParameter("contentText");
			int postid = Integer.parseInt(request.getParameter("postid"));
			Comment c = new Comment(title, content, user.getNickname(), Date.today, postid);
			bl.saveComm(c);
			//tolgo il cmd perche il metodo post che torna sulla stessa pagina, tiene in memoria la richiesta post
			//se refreshi nella pagina postPage dopo aver inviato un commento, rinviare quella richiesta post e rinvierà il commento
			request.getSession().setAttribute("user", user);
			Post p = bl.getPost(postid, true);
			request.setAttribute("post", p);
			//inoltro la risposta ad una pagina fittizia che farà il redirect alla giusta pagina
			//in ogni caso devo impostare l'attributo post per capire poi a che post essere rimandato
			request.getRequestDispatcher("page/redirectPost.jsp").forward(request, response);
		}catch(NumberFormatException e) {
			//error number
		}catch(SQLException e) {
			//error sql
		}
	}

}
