package com.org.SSH.Service;

import java.util.List;

import com.org.SSH.Entity.Info;
import com.org.SSH.Entity.User;

public interface UserService {
	public List<User> findLogin(String name, String password);
	public List<Info> findAll();
	public boolean saveUser(User user);
	public List<User> findName(String name);
	public boolean saveInfo(Info info);
	public void updateInfo(int id,String information);
	public List<User> Login(String username,String password);
	public List<String> findAllUsername();
	public List<String> findAllCourse();
}
