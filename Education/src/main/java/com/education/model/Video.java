package com.education.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="video")
public class Video {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String date;
	private String className;
	private String subjectName;
	private String url;
	
	
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Video(int id, String title, String className, String subjectName, String url,String date) {
		super();
		this.id = id;
		this.title = title;
		this.className = className;
		this.subjectName = subjectName;
		this.url = url;
		this.date=date;
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



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}

  public String getDate()
  {
	  return date;
  }
  
  public void setDate(String date)
  {
	  this.date=date;
  }

	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", className=" + className + ", subjectName=" + subjectName
				+ ", url=" + url + ", date=" + date +"]";
	}
	
	
	
}
