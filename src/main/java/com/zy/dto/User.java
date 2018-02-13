package com.zy.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String sex;
	private Integer fansnum;
	private String description;
	private Set concernsForActorId = new HashSet(0);
	private Set userRecipes = new HashSet(0);
	private Set recipes = new HashSet(0);
	private Set concernsForConcerneeId = new HashSet(0);
	private Set messagesForReceiverId = new HashSet(0);
	private Set comments = new HashSet(0);
	private Set messagesForWriterId = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/** full constructor */
	public User(String username, String password, String sex, Integer fansnum,
			String description, Set concernsForActorId, Set userRecipes,
			Set recipes, Set concernsForConcerneeId, Set messagesForReceiverId,
			Set comments, Set messagesForWriterId) {
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.fansnum = fansnum;
		this.description = description;
		this.concernsForActorId = concernsForActorId;
		this.userRecipes = userRecipes;
		this.recipes = recipes;
		this.concernsForConcerneeId = concernsForConcerneeId;
		this.messagesForReceiverId = messagesForReceiverId;
		this.comments = comments;
		this.messagesForWriterId = messagesForWriterId;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getFansnum() {
		return this.fansnum;
	}

	public void setFansnum(Integer fansnum) {
		this.fansnum = fansnum;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getConcernsForActorId() {
		return this.concernsForActorId;
	}

	public void setConcernsForActorId(Set concernsForActorId) {
		this.concernsForActorId = concernsForActorId;
	}

	public Set getUserRecipes() {
		return this.userRecipes;
	}

	public void setUserRecipes(Set userRecipes) {
		this.userRecipes = userRecipes;
	}

	public Set getRecipes() {
		return this.recipes;
	}

	public void setRecipes(Set recipes) {
		this.recipes = recipes;
	}

	public Set getConcernsForConcerneeId() {
		return this.concernsForConcerneeId;
	}

	public void setConcernsForConcerneeId(Set concernsForConcerneeId) {
		this.concernsForConcerneeId = concernsForConcerneeId;
	}

	public Set getMessagesForReceiverId() {
		return this.messagesForReceiverId;
	}

	public void setMessagesForReceiverId(Set messagesForReceiverId) {
		this.messagesForReceiverId = messagesForReceiverId;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

	public Set getMessagesForWriterId() {
		return this.messagesForWriterId;
	}

	public void setMessagesForWriterId(Set messagesForWriterId) {
		this.messagesForWriterId = messagesForWriterId;
	}

}