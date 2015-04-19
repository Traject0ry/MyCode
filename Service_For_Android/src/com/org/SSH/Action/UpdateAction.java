package com.org.SSH.Action;

import jxl.write.Pattern;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.org.SSH.Entity.Info;
import com.org.SSH.Service.UserService;

public class UpdateAction extends ActionSupport {

	private UserService userService;
	private int id;
	private String information;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	public String go(){
		
		userService.updateInfo(id, information);
		return SUCCESS;
	}

}
