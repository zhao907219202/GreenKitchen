package com.zy.dto;

/**
 * RecipeStep entity. @author MyEclipse Persistence Tools
 */

public class RecipeStep implements java.io.Serializable {

	// Fields

	private Integer id;
	private Recipe recipe;
	private String step;

	// Constructors

	/** default constructor */
	public RecipeStep() {
	}

	/** full constructor */
	public RecipeStep(Recipe recipe, String step) {
		this.recipe = recipe;
		this.step = step;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return this.recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getStep() {
		return this.step;
	}

	public void setStep(String step) {
		this.step = step;
	}

}