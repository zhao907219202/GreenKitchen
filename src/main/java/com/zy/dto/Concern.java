package com.zy.dto;

/**
 * Concern entity. @author MyEclipse Persistence Tools
 */

public class Concern implements java.io.Serializable {

	// Fields

	private Integer id;
	private User userByActorId;
	private User userByConcerneeId;

	// Constructors

	/** default constructor */
	public Concern() {
	}

	/** full constructor */
	public Concern(User userByConcerneeId, User userByActorId) {
		this.userByConcerneeId = userByConcerneeId;
		this.userByActorId = userByActorId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserByConcerneeId() {
		return this.userByConcerneeId;
	}

	public void setUserByConcerneeId(User userByConcerneeId) {
		this.userByConcerneeId = userByConcerneeId;
	}

	public User getUserByActorId() {
		return this.userByActorId;
	}

	public void setUserByActorId(User userByActorId) {
		this.userByActorId = userByActorId;
	}

}