package com.org.SSH.Action;

import com.opensymphony.xwork2.ActionSupport;
import com.org.SSH.Entity.User;
import com.org.SSH.Service.UserService;

public class UserAction extends ActionSupport {

	private UserService userService;
	private String name;
	private String password;
	private String qq;

	public String execute() {
		System.out.println("in the action");
		User u = new User();
		u.setName(name);
		u.setPassword(password);
		//u.setQq(qq);
		boolean flag = userService.saveUser(u);
		if (flag) {
			return SUCCESS;
		}
		return ERROR;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
