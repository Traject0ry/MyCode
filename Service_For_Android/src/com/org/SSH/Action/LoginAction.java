package com.org.SSH.Action;

import java.util.ArrayList;
import java.util.List;

import com.org.SSH.Entity.User;
import com.org.SSH.Service.UserService;

//import com.org.SSH.Service.UserService;

public class LoginAction {
	private String name;
	private String password;
	private UserService userService;
	public String login()
	{
		if(null==name&&null==password)
		{
			return "login";
		}
		else {
			List<User> userList=new ArrayList<User>();
			userList = userService.findLogin(name, password);
			if(userList.size()!=0){
				return "ok";
			}
			else {
				return "error";
			}
			
		}
		
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
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
