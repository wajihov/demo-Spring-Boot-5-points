package com.five.points.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Long id;
	@Column(length = 80)
	private String content;
	@Column(length = 80)
	private Date datePost;
	@ManyToOne
	private Employe employe;
	@ManyToMany
	@Column(nullable = false)
	List<Employe> favoriteEmpl = new ArrayList<Employe>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public List<Employe> getFavoriteEmpl() {
		return favoriteEmpl;
	}

	public void setFavoriteEmpl(List<Employe> favoriteEmpl) {
		this.favoriteEmpl = favoriteEmpl;
	}

	public Post(String content, Date datePost) {
		super();
		this.content = content;
		this.datePost = datePost;
	}

	public Post() {
		super();
	}

}
