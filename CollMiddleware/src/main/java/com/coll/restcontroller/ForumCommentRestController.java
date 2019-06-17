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

import com.coll.dao.ForumCommentDAO;
import com.coll.model.ForumComment;

@RestController
public class ForumCommentRestController {

	@Autowired
	ForumCommentDAO forumcommentDAO;
	
	@GetMapping("/getForumComments")
	public ResponseEntity<List<ForumComment>> getForumComments() 
	{
		List<ForumComment> listForumComments=forumcommentDAO.getForumComments();
		if(listForumComments.size()>0) {
			return new ResponseEntity<List<ForumComment>>(listForumComments,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<ForumComment>>(listForumComments,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getForumComment/{commentId}")
	public ResponseEntity<ForumComment> getForumComment(@PathVariable("commentId") int commentId)
	{
		ForumComment forumcomment=forumcommentDAO.getForumComment(commentId);
		return new ResponseEntity<ForumComment>(forumcomment,HttpStatus.OK);
	}
	
	@PostMapping("/addForumComment")
	public ResponseEntity<String> addForumComment(@RequestBody ForumComment forumcomment)
	{
		forumcomment.setForumId(6);
		forumcomment.setForumComment("good");
		forumcomment.setCommentDate(new java.util.Date());
		forumcomment.setUsername("Saravana");
		if (forumcommentDAO.addForumComment(forumcomment))
		{
		return new ResponseEntity<String>("Forum added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error adding forum",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	@DeleteMapping("/deleteForumComment/{commentId}")
	public ResponseEntity<String> deleteForumComment(@PathVariable("commentId")int commentId)
	{
		ForumComment forumcomment=(ForumComment)forumcommentDAO.getForumComment(commentId);
				
		if(forumcommentDAO.deleteForumComment(forumcomment))
		{
			return new ResponseEntity<String>("Forum Comment Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/updateForumComment/{commentId}")
	public ResponseEntity<String> updateForum(@PathVariable("commentId")int commentId)
	{
		ForumComment forumcomment=(ForumComment)forumcommentDAO.getForumComment(commentId);
		forumcomment.setForumComment("bad");
				
		if(forumcommentDAO.updateForumComment(forumcomment))
		{
			return new ResponseEntity<String>("Forum Comment Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	}
	
	
