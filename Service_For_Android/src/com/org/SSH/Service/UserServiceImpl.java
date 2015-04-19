package com.org.SSH.Service;

import java.util.List;

import org.apache.struts2.components.Bean;

import com.org.SSH.Dao.userDao;
import com.org.SSH.Entity.Info;
import com.org.SSH.Entity.User;
public class UserServiceImpl implements UserService {
	private userDao userDao;
	public List<User> findLogin(String name, String password) {
		return userDao.findLogin(name, password);
	}

	public userDao getUserDao() {
		return userDao;
	}
	public void setUserDao(userDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<Info> findAll() {
		return userDao.findAll();
	}

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
	
		if (userDao.findByUsername(user.getName()).size()==0) {
			userDao.saveUser(user);
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<User> findName(String name) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(name);
	}

	@Override
	public boolean saveInfo(Info info) {
		// TODO Auto-generated method stub
		userDao.saveInfo(info);
		return true ;
	}

	@Override
	public void updateInfo(int id,String information) {
		// TODO Auto-generated method stub
//	Info info2=new Info();
//	info2=userDao.findById(id).get(0);
//	info2.setInformation(information);
//	userDao.updateInfo(info2);
	
	}

	@Override
	public List<User> Login(String username, String password) {
		// TODO Auto-generated method stub
		
		return userDao.findLogin(username, password);
	}

	@Override
	public List<String> findAllUsername() {
		// TODO Auto-generated method stub
		return userDao.findAllUsername();
	}

	@Override
	public List<String> findAllCourse() {
		// TODO Auto-generated method stub
		return userDao.findAllCourse();
	}

}
