package com.zy.dto;

/**
 * Messagereply entity. @author MyEclipse Persistence Tools
 */

public class Messagereply implements java.io.Serializable {

	// Fields

	private Integer id;
	private User userByWriterId;
	private Message message;
	private User userByReceiverId;
	private String content;
	private String timestamp;

	// Constructors

	/** default constructor */
	public Messagereply() {
	}

	/** full constructor */
	public Messagereply(User userByWriterId, Message message,
                      User userByReceiverId, String content, String timestamp) {
		this.userByWriterId = userByWriterId;
		this.message = message;
		this.userByReceiverId = userByReceiverId;
		this.content = content;
		this.timestamp = timestamp;
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

	public Message getMessage() {
		return this.message;
	}

	public void setMessage(Message message) {
		this.message = message;
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

}