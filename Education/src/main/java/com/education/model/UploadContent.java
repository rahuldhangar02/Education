package com.education.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="uploadcontent")
public class UploadContent {

	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private int id;
	  private String title;
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  private String date;
	  private String className;
	  private String subjectName;
	  private String fileName;
	public UploadContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UploadContent(String title, String date, String className, String subjectName, String fileName) {
		super();
		this.title = title;
		this.date = date;
		this.className = className;
		this.subjectName = subjectName;
		this.fileName = fileName;
	}


	public UploadContent(int id, String title, String date, String className, String subjectName, String fileName) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.className = className;
		this.subjectName = subjectName;
		this.fileName = fileName;
	}


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


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String toString() {
		return "UploadContent [id=" + id + ", title=" + title + ", date=" + date + ", className=" + className
				+ ", subjectName=" + subjectName + ", fileName=" + fileName + "]";
	}
	  
	  
	  
	
}
