package com.example.mdbspringboot.model;


import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("employee")
public class Employee implements Serializable {
	@Id 
	private String id;
	
	private String name;
	private String email;
	private String job;
	private String phone;
	private String imgurl;
	
	
	public Employee() {
		super();
	}


	public Employee(String id, String name, String email, String job, String phone, String imgurl) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.job = job;
		this.phone = phone;
		this.imgurl = imgurl;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", job=" + job + ", phone=" + phone
				+ ", imgurl=" + imgurl + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
	
	
	
	
	
}
