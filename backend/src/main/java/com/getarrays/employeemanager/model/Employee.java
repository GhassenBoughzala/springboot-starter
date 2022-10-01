package com.getarrays.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, updatable = false)
	private Long id;
	private String name;
	private String email;
	private String job;
	private String phone;
	private String imgUrl;
	@Column(nullable = false, updatable = false)
	private String employeeCode;
	
	public Employee() {}
	
	public Employee(String name, String email, String job, String phone, String imgUrl, String employeeCode) {
		super();
		this.name = name;
		this.email = email;
		this.job = job;
		this.phone = phone;
		this.imgUrl = imgUrl;
		this.employeeCode = employeeCode;
	}

	public Employee(Long id, String name, String email, String job, String phone, String imgUrl, String employeeCode) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.job = job;
		this.phone = phone;
		this.imgUrl = imgUrl;
		this.employeeCode = employeeCode;
	}

	@Override
	public String toString() {
		return "Employee {id=" + id + ", name=" + name + ", email=" + email + ", job=" + job + ", phone=" + phone
				+ ", imgUrl=" + imgUrl + ", employeeCode=" + employeeCode + "}";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

}
