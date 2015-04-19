package com.org.SSH.Dao;

import java.util.List;

import com.org.SSH.Entity.Info;
import com.org.SSH.Entity.User;

public interface userDao {
public List<User> findLogin(String name,String password);

public List<Info> findAll();
public void saveUser(User user);
public List<User> findByUsername(String name);
public void saveInfo(Info info);
public void updateInfo(Info info);
public List<Info> findById(int id);
public List<String> findAllUsername();
public List<String> findAllCourse();
	

}
