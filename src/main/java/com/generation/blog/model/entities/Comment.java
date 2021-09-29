package com.generation.blog.model.entities;

import com.generation.util.Date;
import com.generation.util.Entity;

public class Comment extends Entity{
	String title,content, author;
	Date dop;
	int postid;

	public Comment(String title, String content, String author, Date dop, int postid) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
		this.dop = dop;
		this.postid = postid;
	}
	
	
	public Comment(int id, String title, String content, String author, Date dop, int postid) {
		super(id);
		this.title = title;
		this.content = content;
		this.author = author;
		this.dop = dop;
		this.postid = postid;
	}

	
	
	public int getPostid() {
		return postid;
	}


	public void setPostid(int postid) {
		this.postid = postid;
	}


	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public Date getDop() {
		return dop;
	}



	public void setDop(Date dop) {
		this.dop = dop;
	}





	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String toString() {
		return "Comment [title=" + title + ", content=" + content + ", author=" + author + ", dop=" + dop + ", postid="
				+ postid + "]";
	}
	
	
	
}