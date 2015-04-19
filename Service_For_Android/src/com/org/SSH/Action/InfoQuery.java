package com.org.SSH.Action;

import java.util.List;

import org.apache.struts2.ServletActionContext;




import com.org.SSH.Entity.Info;
import com.org.SSH.Entity.User;
import com.org.SSH.Service.UserService;

public class InfoQuery {

	public UserService userService;
	
	public String execute() {
		List<Info> infoList = userService.findAll();
		ServletActionContext.getRequest().setAttribute("infoList", infoList);
		return "ok";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
}
