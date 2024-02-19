package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Note {
	@Id
	private int id;
	private String title;
	@Column(length = 1500)
	private String content;
	private Date addedOn;

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Note(int id, String title, String content, Date addedOn) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.addedOn = addedOn;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

}
