package com.coll.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.UserDetail;

@Repository("userdetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			System.out.println("User added");
			return true;
		}
		catch(Exception e) {
		    return false;
		}
	}

	public UserDetail getUser(String username) {
		Session session=sessionFactory.openSession();
	    UserDetail user=session.get(UserDetail.class,username);
	    session.close();
		return user;
	}

	public boolean updateUser(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			System.out.println("User updated");
			return true;
		}
		catch(Exception e) 
		{
		return false;
		}
	}

	public List<UserDetail> getUsers() {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail");
		List<UserDetail> listUsers=query.list();
		return listUsers;
	}

	public UserDetail checkUser(UserDetail user)
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from UserDetail where username=:uname and password=:pword");
		query.setParameter("uname", user.getUsername());
		query.setParameter("pword",user.getPassword());
		
		List<UserDetail> list=query.list();
		if(list!=null) 
		{
			return list.get(0);
			
		}
		else
		{
			return null;
		}
		
		
	}

	
	

}
