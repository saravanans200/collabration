package com.coll.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.model.Applyjob;

@Repository("ApplyjobDAO")
@Transactional
public class ApplyjobDAOImpl implements ApplyjobDAO{
	@Autowired
	SessionFactory sessionFactory;

	public boolean applyJob(Applyjob applyjob) {
		try {
			sessionFactory.getCurrentSession().save(applyjob);
			System.out.println("applied job");
			return true;
			}
		catch(Exception e)
		{
			return false;
		}
	}

	
	}


