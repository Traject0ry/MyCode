package com.org.SSH.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.SSH.Entity.User;
import com.org.SSH.Service.UserService;

public class UserAction extends ActionSupport {

	private UserService userService;
	private String username;
	private String password;
	private Integer userId;
	private String name;
	private String classes;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String execute() {
		System.out.println("in the action");
		User u = new User();
		u.setName(name);
		u.setPassword(password);
		u.setClasses(classes);
		u.setUsername(username);
		boolean flag = userService.saveUser(u);
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	
}
