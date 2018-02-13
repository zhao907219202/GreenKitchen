package com.zy.dto;

/**
 * RecipeSpice entity. @author MyEclipse Persistence Tools
 */

public class RecipeSpice implements java.io.Serializable {

	// Fields

	private Integer id;
	private Recipe recipe;
	private Integer ismain;
	private String spicename;
	private String amount;

	// Constructors

	/** default constructor */
	public RecipeSpice() {
	}

	/** full constructor */
	public RecipeSpice(Recipe recipe, Integer ismain, String spicename,
                     String amount) {
		this.recipe = recipe;
		this.ismain = ismain;
		this.spicename = spicename;
		this.amount = amount;
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

	public Integer getIsmain() {
		return this.ismain;
	}

	public void setIsmain(Integer ismain) {
		this.ismain = ismain;
	}

	public String getSpicename() {
		return this.spicename;
	}

	public void setSpicename(String spicename) {
		this.spicename = spicename;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}