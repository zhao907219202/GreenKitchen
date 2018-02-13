package com.zy.dto;

/**
 * RecipeMaterial entity. @author MyEclipse Persistence Tools
 */

public class RecipeMaterial implements java.io.Serializable {

	// Fields

	private Integer id;
	private Recipe recipe;
	private Materialtwo materialtwo;

	// Constructors

	/** default constructor */
	public RecipeMaterial() {
	}

	/** full constructor */
	public RecipeMaterial(Recipe recipe, Materialtwo materialtwo) {
		this.recipe = recipe;
		this.materialtwo = materialtwo;
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

	public Materialtwo getMaterialtwo() {
		return this.materialtwo;
	}

	public void setMaterialtwo(Materialtwo materialtwo) {
		this.materialtwo = materialtwo;
	}

}