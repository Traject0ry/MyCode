package com.org.SSH.DaoImpl;

import java.util.List;

import org.hibernate.id.IdentityGenerator.GetGeneratedKeysDelegate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.org.SSH.Dao.userDao;
import com.org.SSH.Entity.Admin;
import com.org.SSH.Entity.Info;
import com.org.SSH.Entity.User;

public class userDaoImpl extends HibernateDaoSupport implements userDao {
	@SuppressWarnings("unchecked")
	public List<User> findLogin(String name, String password) {
		try {
			String queryString = "from User as s WHERE s.username = '" + name
					+ "' AND s.password = '" + password + "'";
			List<User> list = getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Info> findAll() {
		String queryString = "from Info";
		List<Info> list = getHibernateTemplate().find(queryString);
		return list;
	}

	@SuppressWarnings("unchecked")
	public void saveUser(User user) {
		getHibernateTemplate().save(user);

	}

	@SuppressWarnings("unchecked")
	public List<User> findByUsername(String name) {
		try {
			String queryString = "from User as s WHERE s.username = '" + name + "'";
			List<User> list = getHibernateTemplate().find(queryString);
			return list;
		} catch (RuntimeException re) {
			// TODO: handle exception
			throw re;
		}

	}

	@Override
	public void saveInfo(Info info) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(info);
	}

	@Override
	public void updateInfo(Info info) {
		// TODO Auto-generated method stub
		getHibernateTemplate().update(info);
	}

	@Override
	public List<Info> findById(int id) {
		// TODO Auto-generated method stub
		String queryString = "from Info as s WHERE s.id = '" + id + "'";
		List<Info> info = getHibernateTemplate().find(queryString);
		return info;

	}

	@Override
	public List<String> findAllUsername() {
		// TODO Auto-generated method stub
		String queryString = "select username from User";
		List<String> username = getHibernateTemplate().find(queryString);
		return username;
	}

	@Override
	public List<String> findAllCourse() {
		// TODO Auto-generated method stub
		String queryString = "select Cname from Course";
		List<String> Cname = getHibernateTemplate().find(queryString);
		return Cname;
	}

	@Override
	public List<Admin> findAdmin(String name,String password) {
		// TODO Auto-generated method stub
		String queryString = "from Admin as s WHERE s.name = '" + name
				+ "' AND s.password = '" + password + "'";
		List<Admin> list = getHibernateTemplate().find(queryString);
		return list;
		
	}

}
