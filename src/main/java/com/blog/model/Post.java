package com.blog.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the posts database table.
 * 
 */
@Entity
@Table(name="posts")
@NamedQuery(name="Post.findAll", query="SELECT p FROM Post p")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="post_id")
	private Integer postId;

	@Column(name="category_id")
	private Integer categoryId;

	private String content;

	@Column(name="mod_date")
	private Timestamp modDate;

	@Column(name="reg_date")
	private Timestamp regDate;

	private String title;

	@Column(name="user_id")
	private Integer userId;

	public Post() {
	}

	public Integer getPostId() {
		return this.postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getModDate() {
		return this.modDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

	public Timestamp getRegDate() {
		return this.regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}