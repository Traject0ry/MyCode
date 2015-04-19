package com.org.SSH.Action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.org.SSH.Service.UserService;

public class AndroidFindCourse extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private UserService userService;
	HttpServletRequest request;
	HttpServletResponse response;
	private static final long serialVersionUID = 1L;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	public String CourseSpinner() throws Exception {
		System.out.println("in the action");
		this.response.setContentType("text/html;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");
		List<String> CourseList=userService.findAllCourse();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CourseList", CourseList);
		JSONArray jsArr = JSONArray.fromObject(map);
		String jsonString = jsArr.toString();
		jsonString = jsonString.substring(1, jsonString.length() - 1);
		this.response.getWriter().write(jsonString);
		System.out.println("jsonString----->"+jsonString);
		return null;
	}
}
