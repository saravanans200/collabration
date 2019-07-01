package com.coll.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ApplyjobDAO;
import com.coll.model.Applyjob;

public class ApplyjobDAOTest {
	
	static ApplyjobDAO applyjobDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		applyjobDAO=(ApplyjobDAO)context.getBean("applyjobDAO");
	}
	@SuppressWarnings("deprecation")
	@Test
	public void Applyjobtest() {
		Applyjob applyjob=new Applyjob();
		applyjob.setJobapplied("tester");
		applyjob.setUsername("sneha");
		applyjob.setAppliedDate(new java.util.Date());
		assertTrue("problem in applying job",applyjobDAO.applyJob(applyjob));
		
	}

}
