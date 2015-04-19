package com.org.SSH.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info")
public class Info {

	@Id
//	@GeneratedValue
//	@Column(name = "id")
//	private Integer id;
	@Column(name = "time")
	private String time;
	@Column(name = "url")
	private String url;
	@Column(name = "username")
	private String username;
	@Column(name = "course")
	private String course;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Info [time=" + time + ", url=" + url + ", username=" + username
				+ ", course=" + course + "]";
	}

//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}


}
