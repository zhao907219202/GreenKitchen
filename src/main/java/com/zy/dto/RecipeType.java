package com.zy.dto;

/**
 * RecipeType entity. @author MyEclipse Persistence Tools
 */

public class RecipeType implements java.io.Serializable {

	// Fields

	private Integer id;
	private Recipe recipe;
	private String style;
	private String method;
	private String flavor;
	private String kind;
	private String stape;
	private String bake;
	private String crowd;
	private String tool;
	private String scene;
	private String slim;
	private String effect;
	private String nurse;
	private String festival;

	// Constructors

	/** default constructor */
	public RecipeType() {
	}

	/** minimal constructor */
	public RecipeType(Recipe recipe) {
		this.recipe = recipe;
	}

	/** full constructor */
	public RecipeType(Recipe recipe, String style, String method,
			String flavor, String kind, String stape, String bake,
			String crowd, String tool, String scene, String slim,
			String effect, String nurse, String festival) {
		this.recipe = recipe;
		this.style = style;
		this.method = method;
		this.flavor = flavor;
		this.kind = kind;
		this.stape = stape;
		this.bake = bake;
		this.crowd = crowd;
		this.tool = tool;
		this.scene = scene;
		this.slim = slim;
		this.effect = effect;
		this.nurse = nurse;
		this.festival = festival;
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

	public String getStyle() {
		return this.style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getFlavor() {
		return this.flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getStape() {
		return this.stape;
	}

	public void setStape(String stape) {
		this.stape = stape;
	}

	public String getBake() {
		return this.bake;
	}

	public void setBake(String bake) {
		this.bake = bake;
	}

	public String getCrowd() {
		return this.crowd;
	}

	public void setCrowd(String crowd) {
		this.crowd = crowd;
	}

	public String getTool() {
		return this.tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getScene() {
		return this.scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public String getSlim() {
		return this.slim;
	}

	public void setSlim(String slim) {
		this.slim = slim;
	}

	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public String getNurse() {
		return this.nurse;
	}

	public void setNurse(String nurse) {
		this.nurse = nurse;
	}

	public String getFestival() {
		return this.festival;
	}

	public void setFestival(String festival) {
		this.festival = festival;
	}

}