<<<<<<< HEAD
package com.generation.blog.model.entities;
import java.util.List;

import com.generation.util.Date;
import com.generation.util.Entity;

public class Post extends Entity{
	final static int MAXLENGTH = 6000;
	String title, content, img;
	String[] tags;
	Date dop;
	Blogger author;
	int bloggerID;
	List<Comment> comments;
	String[] like;
	
	public Post(int id, String title, String content, Date dop, int bloggerID, String img, String[] tags, String [] like) {
		super(id);
		setTitle(title);
		setContent(content);
		setDop(dop);
		setImg(img);
		setTags(tags);
		setLike(like);
		setBloggerID(bloggerID);
	}
	
	public Post(String title, String content, Date dop, int bloggerID, String img, String[] tags, String[] like) {
		super();
		setTitle(title);
		setContent(content);
		setDop(dop);
		setImg(img);
		setTags(tags);
		setLike(like);
		setBloggerID(bloggerID);
	}

	
	
	public int getBloggerID() {
		return bloggerID;
	}

	public void setBloggerID(int bloggerID) {
		this.bloggerID = bloggerID;
	}

	public void setLike(String[] like) {
		this.like = like;
	}

	public String[] getLike() {
		return like;
	}
	
	public int getNumberLike() {
		if(getLikeString().isEmpty())
			return 0;
		return like.length;
	}
	
	public String getLikeString() {
		String s = "";
		if(like.length == 0)
			return "";
		
		for(int i=0; i<like.length;i++) {
			if(i == like.length-1)
				s += like[i];
			else
				s += like[i] + ",";
		}
		return s;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return 	title!=null					&&
				content!=null				&&
				!title.isBlank()			&&
				!content.isBlank()			&&
				content.length()<MAXLENGTH	&&
				dop!=null					;
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

	public Date getDop() {
		return dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}
	
	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getTagsString() {
		String s = "";
		if(tags.length == 0)
			return "";
		
		for(int i=0; i<tags.length;i++) {
			if(i == tags.length-1)
				s += tags[i];
			else
				s += tags[i] + ",";
		}
		return s;
	}
	
	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((dop == null) ? 0 : dop.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return other.getId() == this.id;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", content=" + content + ", dop=" + dop + "]";
	}

	public Blogger getAuthor() {
		return author;
	}

	public void setAuthor(Blogger author) {
		this.author = author;
	}

	
	
}
=======
package com.generation.blog.model.entities;
import java.util.List;

import com.generation.util.Date;
import com.generation.util.Entity;

public class Post extends Entity{
	final static int MAXLENGTH = 6000;
	String title, content, img;
	String[] tags;
	Date dop;
	Blogger author;
	int bloggerID;
	List<Comment> comments;
	String[] like;
	
	public Post(int id, String title, String content, Date dop, int bloggerID, String img, String[] tags, String [] like) {
		super(id);
		setTitle(title);
		setContent(content);
		setDop(dop);
		setImg(img);
		setTags(tags);
		setLike(like);
		setBloggerID(bloggerID);
	}
	
	public Post(String title, String content, Date dop, int bloggerID, String img, String[] tags, String[] like) {
		super();
		setTitle(title);
		setContent(content);
		setDop(dop);
		setImg(img);
		setTags(tags);
		setLike(like);
		setBloggerID(bloggerID);
	}

	
	
	public int getBloggerID() {
		return bloggerID;
	}

	public void setBloggerID(int bloggerID) {
		this.bloggerID = bloggerID;
	}

	public void setLike(String[] like) {
		this.like = like;
	}

	public String[] getLike() {
		return like;
	}
	
	public int getNumberLike() {
		if(getLikeString().isEmpty())
			return 0;
		return like.length;
	}
	
	public String getLikeString() {
		String s = "";
		if(like.length == 0)
			return "";
		
		for(int i=0; i<like.length;i++) {
			if(i == like.length-1)
				s += like[i];
			else
				s += like[i] + ",";
		}
		return s;
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return 	title!=null					&&
				content!=null				&&
				!title.isBlank()			&&
				!content.isBlank()			&&
				content.length()<MAXLENGTH	&&
				dop!=null					;
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

	public Date getDop() {
		return dop;
	}

	public void setDop(Date dop) {
		this.dop = dop;
	}
	
	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	
	
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getTagsString() {
		String s = "";
		if(tags.length == 0)
			return "";
		
		for(int i=0; i<tags.length;i++) {
			if(i == tags.length-1)
				s += tags[i];
			else
				s += tags[i] + ",";
		}
		return s;
	}
	
	public String[] getTags() {
		return tags;
	}

	public void setTags(String[] tags) {
		this.tags = tags;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((dop == null) ? 0 : dop.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return other.getId() == this.id;
	}

	@Override
	public String toString() {
		return "Post [title=" + title + ", content=" + content + ", dop=" + dop + "]";
	}

	public Blogger getAuthor() {
		return author;
	}

	public void setAuthor(Blogger author) {
		this.author = author;
	}

	
	
}
>>>>>>> 05221816458389c629d49feafd7f22ce9b2d909f
