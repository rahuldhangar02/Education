package com.education.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	private String name;
	private String className;
	private String mobileNo;
	private String email;
	private String password;
	private String status;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String className, String mobileNo, String email, String password,String status) {
		super();
		this.id = id;
		this.name = name;
		this.className = className;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.status=status;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", className=" + className + ", mobileNo=" + mobileNo
				+ ", email=" + email + ", password=" + password + ", status=" + status + "]";
	}

	
	
	
	
	
}
