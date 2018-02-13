package com.zy.dto;

/**
 * Commentreply entity. @author MyEclipse Persistence Tools
 */

public class Commentreply implements java.io.Serializable {

	// Fields

	private Integer id;
	private Comment comment;
	private User userByWriterId;
	private User userByReceiverId;
	private String content;
	private String timestamp;

	// Constructors

	/** default constructor */
	public Commentreply() {
	}

	/** full constructor */
	public Commentreply(Comment comment, User userByWriterId,
                      User userByReceiverId, String content, String timestamp) {
		this.comment = comment;
		this.userByWriterId = userByWriterId;
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

	public Comment getComment() {
		return this.comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
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

}