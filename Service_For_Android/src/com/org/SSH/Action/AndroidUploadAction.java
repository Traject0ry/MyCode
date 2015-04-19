package com.org.SSH.Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.org.SSH.Entity.Info;
import com.org.SSH.Service.UserService;

public class AndroidUploadAction extends ActionSupport {
	private UserService userService;
	private String username;
	private String course;
	private String time;
	private File img;
	private String savePath;
	private String imgFileName;

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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getSavePath() {
		String realPath = ServletActionContext.getRequest().getRealPath(
				"/upload");
		System.out.println("savePath -- " + realPath);
		return realPath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	/**
	 * 上传文件操作
	 * 
	 * @return
	 * @throws Exception
	 */
	public void upload() throws Exception {

		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// 保存文件那一个路径
			fos = new FileOutputStream(getSavePath() + "\\" + getImgFileName());
			fis = new FileInputStream(getImg());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			fos.close();
			fis.close();
		}
		Info i = new Info();
		i.setUsername(username);
		i.setCourse(course);
		Date date = new Date();
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		i.setTime(time);
		String url = getSavePath() + "\\" + getImgFileName();
		i.setUrl(url);
		System.out.println("Info.toString---->" + i.toString());
		boolean flag = userService.saveInfo(i);
		System.out.println("flag-------->" + flag);

	}

}
