package com.coll.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumDAO;
import com.coll.model.Forum;

public class ForumDAOTest {
	static ForumDAO forumDAO;

	@BeforeClass
	public static void executefirst() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		forumDAO=(ForumDAO)context.getBean("forumDAO");
	}
    @Ignore
	@Test
	public void addforumtest() {
		Forum forum=new Forum();
		forum.setForumName(" forum");
		forum.setForumContent("second content");
		forum.setCreateDate(new java.util.Date());
		forum.setUsername("Saravana");
		forum.setStatus("NA");
		assertTrue("problem in adding forum",forumDAO.addForum(forum));
	}
	@Ignore
	@Test
	public void getforumtest() {
		assertNotNull("problem in getting forum",forumDAO.getForum(5));
	}
	
	@Test
	public void updateforumtest() {
		Forum forum=forumDAO.getForum(5);
		forum.setForumContent("first content");
		assertTrue("problem in updating forum",forumDAO.updateForum(forum));
	}
	@Ignore
	@Test
	public void deleteforumtest() {
		Forum forum=forumDAO.getForum(1001);
		assertTrue("problem in deleting forum",forumDAO.deleteForum(forum));
	}

	@Test
	public void listblogtest() {
		List<Forum> listForums=forumDAO.getForums();
		for(Forum forum:listForums) {
			System.out.println("id:"+forum.getForumId());
		}
	}
	@Ignore
	@Test
	public void approveforumtest() {
		assertTrue("problem in incrementing likes",forumDAO.approveForum(503));
	}
	@Ignore
	@Test
	public void rejectforumtest() {
		assertTrue("problem in incrementing likes",forumDAO.rejectForum(503));
	}

}
