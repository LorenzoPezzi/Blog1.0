package com.generation.blog.model.bl;

import java.sql.SQLException;
import java.util.List;

import com.generation.blog.model.entities.*;

public interface BlogBL{

	List<Blogger> login(String nickname, String password, boolean wPost);
	
	Blogger getBlogger(int id, boolean wPost);
	List<Blogger> getBloggers(String condition, boolean wPost);
	Blogger saveBlogger(Blogger b);
	
	List<Post> getPosts(String condition, boolean wComm);
	Post getPost(int id, boolean wComm);
	Post savePost(Post p) throws SQLException;
	
	Comment saveComm(Comment c) throws SQLException;
	
	boolean updateBlogger(String values, String condition);
	boolean deleteBlogger(int id, String condition);
	
	boolean updatePost(String values, String condition);
	boolean deletePost(int id, String condition);
	
	int setLike(int id, String nick);
}
