package com.zy.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Recipe entity. @author MyEclipse Persistence Tools
 */

public class Recipe implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String title;
	private Integer collectednum;
	private Integer likednum;
	private Integer commentednum;
	private String difficulty;
	private String time;
	private String timestamp;
	private String description;
	private String note;
	private Set recipeTypes = new HashSet(0);
	private Set recipeMaterials = new HashSet(0);
	private Set recipeSteps = new HashSet(0);
	private Set userRecipes = new HashSet(0);
	private Set recipeSpices = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Recipe() {
	}

	/** minimal constructor */
	public Recipe(User user, String title, String difficulty, String time,
			String timestamp) {
		this.user = user;
		this.title = title;
		this.difficulty = difficulty;
		this.time = time;
		this.timestamp = timestamp;
	}

	/** full constructor */
	public Recipe(User user, String title, Integer collectednum,
			Integer likednum, Integer commentednum, String difficulty,
			String time, String timestamp, String description, String note,
			Set recipeTypes, Set recipeMaterials, Set recipeSteps,
			Set userRecipes, Set recipeSpices, Set comments) {
		this.user = user;
		this.title = title;
		this.collectednum = collectednum;
		this.likednum = likednum;
		this.commentednum = commentednum;
		this.difficulty = difficulty;
		this.time = time;
		this.timestamp = timestamp;
		this.description = description;
		this.note = note;
		this.recipeTypes = recipeTypes;
		this.recipeMaterials = recipeMaterials;
		this.recipeSteps = recipeSteps;
		this.userRecipes = userRecipes;
		this.recipeSpices = recipeSpices;
		this.comments = comments;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getCollectednum() {
		return this.collectednum;
	}

	public void setCollectednum(Integer collectednum) {
		this.collectednum = collectednum;
	}

	public Integer getLikednum() {
		return this.likednum;
	}

	public void setLikednum(Integer likednum) {
		this.likednum = likednum;
	}

	public Integer getCommentednum() {
		return this.commentednum;
	}

	public void setCommentednum(Integer commentednum) {
		this.commentednum = commentednum;
	}

	public String getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set getRecipeTypes() {
		return this.recipeTypes;
	}

	public void setRecipeTypes(Set recipeTypes) {
		this.recipeTypes = recipeTypes;
	}

	public Set getRecipeMaterials() {
		return this.recipeMaterials;
	}

	public void setRecipeMaterials(Set recipeMaterials) {
		this.recipeMaterials = recipeMaterials;
	}

	public Set getRecipeSteps() {
		return this.recipeSteps;
	}

	public void setRecipeSteps(Set recipeSteps) {
		this.recipeSteps = recipeSteps;
	}

	public Set getUserRecipes() {
		return this.userRecipes;
	}

	public void setUserRecipes(Set userRecipes) {
		this.userRecipes = userRecipes;
	}

	public Set getRecipeSpices() {
		return this.recipeSpices;
	}

	public void setRecipeSpices(Set recipeSpices) {
		this.recipeSpices = recipeSpices;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}
}