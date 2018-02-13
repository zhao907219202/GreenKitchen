package com.zy.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Materialone entity. @author MyEclipse Persistence Tools
 */

public class Materialone implements java.io.Serializable {

	// Fields

	private Integer id;
	private String type;
	private String name;
	private Set materialtwos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Materialone() {
	}

	/** minimal constructor */
	public Materialone(String type, String name) {
		this.type = type;
		this.name = name;
	}

	/** full constructor */
	public Materialone(String type, String name, Set materialtwos) {
		this.type = type;
		this.name = name;
		this.materialtwos = materialtwos;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getMaterialtwos() {
		return this.materialtwos;
	}

	public void setMaterialtwos(Set materialtwos) {
		this.materialtwos = materialtwos;
	}

}