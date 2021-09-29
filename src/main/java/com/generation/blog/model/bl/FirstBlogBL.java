package com.generation.blog.model.bl;

import java.sql.SQLException;
import java.util.List;

import com.generation.blog.model.dao.*;
import com.generation.blog.model.entities.*;


public class FirstBlogBL implements BlogBL {
	public DAO<Post> postDAO;
	public DAO<Blogger> bloggerDAO;
	public DAO<Comment> commentDAO;
	
	
	public FirstBlogBL(DAO<Post> postDAO, DAO<Blogger> bloggerDAO, DAO<Comment> commentDAO) {
		super();
		this.postDAO = postDAO;
		this.bloggerDAO = bloggerDAO;
		this.commentDAO = commentDAO;
	}

	
	
	@Override
	public List<Blogger> login(String nickname, String password, boolean wPost) {
		List<Blogger> b = bloggerDAO.getAll("NICKNAME='"+ nickname +"' AND PASSWORD='"+ password +"'");
		if(wPost)
			try {
				b.get(0).setPosts(postDAO.getAll(" BLOGGERID="+b.get(0).getId()));
			}catch(Exception e) {
				return null;
			}
		return b != null ? b : null; 
	}


	@Override
	public Blogger getBlogger(int id, boolean wPost) {
		Blogger b = bloggerDAO.getOne(id);
		if(wPost)
			b.setPosts(postDAO.getAll(" BLOGGERID="+id));
		return b;
	}



	@Override
	public Post getPost(int id, boolean wComm) {
		Post post = postDAO.getOne(id);
		if(wComm)
			post.setComments(commentDAO.getAll(" POSTID="+id));
		return post;
	}



	@Override
	public List<Post> getPosts(String condition, boolean wComm) {
		List<Post> posts = postDAO.getAll(condition);
		if(wComm)
			for(Post p : posts)
				p.setComments(commentDAO.getAll(" POSTID="+p.getId()));
		return posts;
	}



	@Override
	public List<Blogger> getBloggers(String condition, boolean wPosts) {
		List<Blogger> bloggers = bloggerDAO.getAll(condition);
		if(wPosts)
			for(Blogger b : bloggers)
				b.setPosts(postDAO.getAll(" BLOGGERID=" + b.getId()));
		return bloggers;
	}



	@Override
	public Blogger saveBlogger(Blogger b) {
		String sql = "INSERT INTO BLOGGER (NICKNAME, EMAIL, PASSWORD, BIO, DOB, IMGBLOGGER, VERIFIED) VALUES"
				+ " ('[nickname]','[email]','[password]','[bio]','[dob]','[img]', [verified])";
		sql = sql.replace("[nickname]", b.getNickname());
		sql = sql.replace("[email]", b.getEmail());
		sql = sql.replace("[password]", b.getPassword());
		sql = sql.replace("[bio]", b.getBio());
		sql = sql.replace("[dob]", b.getDob().toAmerican());
		sql = sql.replace("[img]", b.getImg());
		sql = sql.replace("[verified]", b.getVerified()+"");
		
		try {
			bloggerDAO.addOne(b);
			return b;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public Post savePost(Post p) throws SQLException {
		return postDAO.addOne(p);
	}



	@Override
	public Comment saveComm(Comment c) throws SQLException {
		commentDAO.addOne(c);
		return c;
	}



	@Override
	public boolean updateBlogger(String values, String condition) {
		return bloggerDAO.update(values, condition);
	}



	@Override
	public boolean deleteBlogger(int id, String condition) {
		try {
			return bloggerDAO.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public boolean updatePost(String values, String condition) {
		return postDAO.update(values, condition);
	}



	@Override
	public boolean deletePost(int id, String condition) {
		try {
			return postDAO.delete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}



	@Override
	public int setLike(int id, String nick) {
		PostDAO postd = (PostDAO) postDAO;
		return postd.getUpdatePostLike(id, nick);
	}
	
	
	
}