package com.zy.dto;

/**
 * UserRecipe entity. @author MyEclipse Persistence Tools
 */

public class UserRecipe implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Recipe recipe;

	// Constructors

	/** default constructor */
	public UserRecipe() {
	}

	/** full constructor */
	public UserRecipe(User user, Recipe recipe) {
		this.user = user;
		this.recipe = recipe;
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

}