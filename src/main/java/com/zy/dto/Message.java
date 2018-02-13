package com.zy.dto;

import java.util.HashSet;
import java.util.Set;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */

public class Message implements java.io.Serializable {

	// Fields

	private Integer id;
	private User userByWriterId;
	private User userByReceiverId;
	private String content;
	private String timestamp;
	private Set messagereplies = new HashSet(0);

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(User userByWriterId, User userByReceiverId, String content,
			String timestamp) {
		this.userByWriterId = userByWriterId;
		this.userByReceiverId = userByReceiverId;
		this.content = content;
		this.timestamp = timestamp;
	}

	/** full constructor */
	public Message(User userByWriterId, User userByReceiverId, String content,
			String timestamp, Set messagereplies) {
		this.userByWriterId = userByWriterId;
		this.userByReceiverId = userByReceiverId;
		this.content = content;
		this.timestamp = timestamp;
		this.messagereplies = messagereplies;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUserByWriterId() {
		return this.userByWriterId;
	}

	public void setUserByWriterId(User userByWriterId) {
		this.userByWriterId = userByWriterId;
	}

	public User getUserByReceiverId() {
		return this.userByReceiverId;
	}

	public void setUserByReceiverId(User userByReceiverId) {
		this.userByReceiverId = userByReceiverId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public Set getMessagereplies() {
		return this.messagereplies;
	}

	public void setMessagereplies(Set messagereplies) {
		this.messagereplies = messagereplies;
	}

}