package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.ForumDAO;
import com.coll.model.Forum;

@RestController
public class ForumRestController {

	@Autowired
	ForumDAO forumDAO;
	
	@GetMapping("/getForums") 
	public ResponseEntity<List<Forum>> getForums() 
	{
		List<Forum> listForums=forumDAO.getForums();
		if(listForums.size()>0) {
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Forum>>(listForums,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
	@GetMapping("/getForum/{forumId}")
	public ResponseEntity<Forum> getForum(@PathVariable("forumId") int forumId) 
	{
		Forum forum=forumDAO.getForum(forumId);
		return new ResponseEntity<Forum>(forum,HttpStatus.OK);
	}
	
	@PostMapping("/addForum")
	public ResponseEntity<String> addForum(@RequestBody Forum forum)
	{
		forum.setCreateDate(new java.util.Date());
		forum.setStatus("NA");
		forum.setUsername("Saravana");
		if(forumDAO.addForum(forum))
		{
			return new ResponseEntity<String>("Forum added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error adding forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updateForum/{forumId}")
	public ResponseEntity<String> updateBlog(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		forum.setForumContent("Content");
		
		
		if(forumDAO.updateForum(forum))
		{
			return new ResponseEntity<String>("Forum Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/deleteForum/{forumId}")
	public ResponseEntity<String> deleteForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		
		if(forumDAO.deleteForum(forum))
		{
			return new ResponseEntity<String>("Forum Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/approveForum/{forumId}")
	public ResponseEntity<String> approveForum(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		if(forumDAO.approveForum(forumId))
		{
			return new ResponseEntity<String>("Forum Approved",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);				
	}
	
	@GetMapping("/rejectForum/{forumId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("forumId")int forumId)
	{
		Forum forum=(Forum)forumDAO.getForum(forumId);
		
		if(forumDAO.rejectForum(forumId))
		{
			return new ResponseEntity<String>("Forum Rejected",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);				
	}
	
}
