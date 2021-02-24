package com.education.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="clsname",nullable = false)
	private String clsname;
	@Column(name="name",nullable = false)
	private String name;
	
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Subject(String clsname, String name) {
		super();
		this.clsname = clsname;
		this.name = name;
	}


	public Subject(int id, String clsname, String name) {
		super();
		this.id = id;
		this.clsname = clsname;
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getClsname() {
		return clsname;
	}


	public void setClsname(String clsname) {
		this.clsname = clsname;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Subject [id=" + id + ", clsname=" + clsname + ", name=" + name + "]";
	}
	
	
	
	
	
}
