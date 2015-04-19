package com.org.SSH.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	public Integer getCouserId() {
		return couserId;
	}
	public void setCouserId(Integer couserId) {
		this.couserId = couserId;
	}
	public String getCname() {
		return Cname;
	}
	public void setCname(String cname) {
		Cname = cname;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	@Id
	@GeneratedValue
	@Column(name = "couserId")
	private Integer couserId;
	@Column(name = "Cname")
	private String Cname;
	@Column(name = "teacher")
	private String teacher;

}