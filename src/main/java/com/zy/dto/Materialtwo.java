package com.zy.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Materialtwo entity. @author MyEclipse Persistence Tools
 */

public class Materialtwo implements java.io.Serializable {

	// Fields

	private Integer id;
	private Materialone materialone;
	private String name;
	private String pictureName;
	private String alias;
	private String heat;
	private String description;
	private Set recipeMaterials = new HashSet(0);

	// Constructors

	/** default constructor */
	public Materialtwo() {
	}

	/** minimal constructor */
	public Materialtwo(Materialone materialone, String name) {
		this.materialone = materialone;
		this.name = name;
	}

	/** full constructor */
	public Materialtwo(Materialone materialone, String name,
                     String pictureName, String alias, String heat, String description,
                     Set recipeMaterials) {
		this.materialone = materialone;
		this.name = name;
		this.pictureName = pictureName;
		this.alias = alias;
		this.heat = heat;
		this.description = description;
		this.recipeMaterials = recipeMaterials;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Materialone getMaterialone() {
		return this.materialone;
	}

	public void setMaterialone(Materialone materialone) {
		this.materialone = materialone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPictureName() {
		return this.pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getAlias() {
		return this.alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getHeat() {
		return this.heat;
	}

	public void setHeat(String heat) {
		this.heat = heat;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getRecipeMaterials() {
		return this.recipeMaterials;
	}

	public void setRecipeMaterials(Set recipeMaterials) {
		this.recipeMaterials = recipeMaterials;
	}

}