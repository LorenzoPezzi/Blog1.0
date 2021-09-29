package com.generation.blog.model.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.generation.util.Date;
import com.generation.util.Entity;

public class Blogger extends Entity {
	public final static Blogger DUMMY = new Blogger();
	
	static
	{
		DUMMY.setDob(new Date(1,1,1990));	
		DUMMY.setBio("");
		DUMMY.setNickname("");
		DUMMY.setEmail("");
	}
	
	protected String nickname, email,password, bio, img;
	protected int verified;
	protected Date dob;
	protected List<Post> posts = new ArrayList<Post>();
	
	public static Set<Blogger> CREATED = new HashSet<Blogger>();

	public Blogger() {}
	
	public static Blogger make(int id, String nickname, String email, String password, String bio, Date dob, String img, int verified) {
		Blogger blogger = new Blogger(id, nickname, email, password, bio, dob, img, verified);
		if(Blogger.CREATED == null) {
			Blogger.CREATED.add(blogger);
			return blogger;
		}	
		for(Blogger d : Blogger.CREATED)
			if(d.equals(blogger)) {
				return d;
			}
		Blogger.CREATED.add(blogger);
		return blogger;
	}
	
	
	public Blogger(int id, String nickname, String email, String password, String bio, Date dob, String img, int verified) {
		super(id);
		setNickname(nickname);
		setEmail(email);
		setPassword(password);
		setBio(bio);
		setDob(dob);
		setImg(img);
		setVerified(verified);
	}
	
	public Blogger(String nickname, String email, String password, String bio, Date dob, String img, int verified) {
		super();
		setNickname(nickname);
		setEmail(email);
		setPassword(password);
		setBio(bio);
		setDob(dob);
		setImg(img);
		setVerified(verified);
	}

	@Override
	public boolean isValid() {
		// TODO Auto-generated method stub
		return 	_validEmail(email) 			&&
				_validPassword(password) 	&&
				_validNickname(nickname)	;
	}

	private boolean _validNickname(String nickname) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean _validPassword(String password) {
		// TODO Auto-generated method stub
		return true;
	}

	private boolean _validEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public void setDob(String dob) {
		this.dob = Date.make(dob);
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	

	public int getVerified() {
		return verified;
	}

	public void setVerified(int verified) {
		this.verified = verified;
	}

	public static boolean isValidEmail() {
		// TODO Auto-generated method stub
		return false;
	}


	public static boolean isValidPassword() {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blogger other = (Blogger) obj;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Blogger [id= "+id+", nickname=" + nickname + ", posts=" + posts + "]";
	}
	
	
	
}