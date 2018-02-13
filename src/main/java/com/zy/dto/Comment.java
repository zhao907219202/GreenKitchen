package com.zy.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Recipe recipe;
	private String content;
	private String timestamp;
	private Set commentreplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(User user, Recipe recipe, String content, String timestamp) {
		this.user = user;
		this.recipe = recipe;
		this.content = content;
		this.timestamp = timestamp;
	}

	/** full constructor */
	public Comment(User user, Recipe recipe, String content, String timestamp,
			Set commentreplies) {
		this.user = user;
		this.recipe = recipe;
		this.content = content;
		this.timestamp = timestamp;
		this.commentreplies = commentreplies;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Set getCommentreplies() {
		return this.commentreplies;
	}

	public void setCommentreplies(Set commentreplies) {
		this.commentreplies = commentreplies;
	}

}