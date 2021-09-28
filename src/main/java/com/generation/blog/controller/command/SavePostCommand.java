package com.generation.blog.controller.command;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.generation.blog.model.entities.Post;
import com.generation.util.Date;

public class SavePostCommand extends Command{

	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Post p = null;
		String title = request.getParameter("title");
		String content = request.getParameter("contentText");
		//File path: 
		String img = "img";
		String tag = request.getParameter("tag");
		Date dop = Date.today;
		int authorID = user.getId();
		if(!request.getParameter("idpost").isEmpty()) {
			
			bl.updatePost(" title='"+title+ "', content='"+ content	+"', IMGPOST='"+ img 
					+"', tags='"+tag+"'", " ID="+request.getParameter("idpost"));
			p = bl.getPost(Integer.parseInt(request.getParameter("idpost")), false);
			System.out.println(p);
//			for(Post p: user.getPosts())
//				if(p.getId() == Integer.parseInt(request.getParameter("postid"))) {
//					p.setDop(dop);
//					p.setTitle(title);
//					p.setContent(content);
//					p.setImg(img);
//					p.setTags(tag.split(","));
//				}					
		}else {
			p = new Post(title, content, dop, authorID, img, tag.split(","), "".split(","));
			try {
				p = bl.savePost(p);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		p.setAuthor(user);
		user.getPosts().add(p);
		request.setAttribute("post", p);
		request.getRequestDispatcher("page/redirectPost.jsp").forward(request, response);
	}
}
