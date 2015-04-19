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

public class AndroidLoginAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {
	private String username;
	private String password;
	private UserService userService;

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

	private static final long serialVersionUID = 1L;

	HttpServletRequest request;
	HttpServletResponse response;

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
	
	public String login() throws Exception {

		System.out.println("in the action");
		this.response.setContentType("text/html;charset=utf-8");
		this.response.setCharacterEncoding("UTF-8");

		List<com.org.SSH.Entity.User> userList = userService.Login(username, password);
		if (userList.size() > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", userList.get(0));
			map.put("code", 1);
			// 将哈希表生成一个json格式的字符串
			JSONArray jsArr = JSONArray.fromObject(map);
			String jsonString = jsArr.toString();
			jsonString = jsonString.substring(1, jsonString.length() - 1);
			this.response.getWriter().write(jsonString);
			System.out.println("jsonString----->"+jsonString);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user", "");
			map.put("code", 0);
			// 将哈希表生成一个json格式的字符串
			JSONArray jsArr = JSONArray.fromObject(map);
			String jsonString = jsArr.toString();
			jsonString = jsonString.substring(1, jsonString.length() - 1);
			this.response.getWriter().write(jsonString);
			System.out.println("jsonString----->"+jsonString);
		}
		
		return null;
	}

}
