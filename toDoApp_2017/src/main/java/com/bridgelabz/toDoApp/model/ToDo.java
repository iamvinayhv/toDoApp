package com.bridgelabz.toDoApp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ToDo_Manager")
public class ToDo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GenericGenerator(name="gen", strategy="increment")
	@GeneratedValue(generator="gen")
	private int id;
	private String title;
	private String note;
	private Date remainder;
	private Date upDated = new Date();
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private User user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getRemainder() {
		return remainder;
	}
	public void setRemainder(Date remainder) {
		this.remainder = remainder;
	}
	public Date getUpDated() {
		return upDated;
	}
	public void setUpDated(Date upDated) {
		this.upDated = upDated;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
