package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.JobDAO;
import com.coll.model.Job;

public class JobDAOTest {

	static JobDAO jobDAO;
	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		jobDAO=(JobDAO)context.getBean("jobDAO");
	}
	@SuppressWarnings("deprecation")
	@Ignore
	@Test
	public void addjobtest() {
		Job job=new Job();
		job.setJobDesignation("tester");
		job.setCompanyName("tcs");
	    job.setCTC(400000);
	    job.setJobLocation("tambaram");
	    job.setLastDate(new java.util.Date());
	    job.setSkills("java");
	    assertTrue("problem in adding job",jobDAO.addJob(job));
	}
	@Ignore
	@Test
	public void getjobtest() {
		assertNotNull("problem in getting job",jobDAO.getJob(1001));
	}
	@Ignore
	@Test 
	public void getjobstest() {
		List<Job> listJobs=jobDAO.getJobs();
	    for(Job job:listJobs) {
	    	System.out.println("jobid:"+job.getJobId());
	    }
	}
	
	@Test
	public void deletejobtest() {
		System.out.print("deleted");
		Job job=jobDAO.getJob(30);
		assertTrue("problem in adding job",jobDAO.deleteJob(job));
	}

}
