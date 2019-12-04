package com.five.points.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Employe {

	@Id
	@GeneratedValue

	private Long id;
	@Column(length = 80)
	private String name;
	@Column(length = 80)
	private String email;
	@Column(length = 80)
	private String password;
	@OneToMany(mappedBy = "employe")
	private List<Post> posts;
	@ManyToMany(mappedBy = "favoriteEmpl")
	@Column(nullable = false)
	private List<Post> favoritePost = new ArrayList<Post>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@JsonIgnore
	public List<Post> getPosts() {
		return posts;
	}

	@JsonSetter
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@JsonIgnore
	public List<Post> getFavoritePost() {
		return favoritePost;
	}

	@JsonSetter
	public void setFavoritePost(List<Post> favoritePost) {
		this.favoritePost = favoritePost;
	}

	public Employe(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Employe() {
		super();
	}

}
