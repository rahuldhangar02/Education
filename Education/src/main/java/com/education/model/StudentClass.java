package com.education.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cls")
public class StudentClass {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	@Column(name="clsname" ,nullable = false,unique = true)
	private String clsname;
	
	public StudentClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public StudentClass(String clsname) {
		super();
		this.clsname = clsname;
	}


	public StudentClass(int id, String clsname) {
		super();
		this.id = id;
		this.clsname = clsname;
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


	@Override
	public String toString() {
		return "StudentClass [id=" + id + ", clsname=" + clsname + "]";
	}
	
	
	
}
