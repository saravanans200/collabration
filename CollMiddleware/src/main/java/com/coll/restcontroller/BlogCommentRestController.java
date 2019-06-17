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

import com.coll.dao.BlogCommentDAO;
import com.coll.model.BlogComment;

@RestController
public class BlogCommentRestController {

	@Autowired
	BlogCommentDAO blogcommentDAO;
	
	@GetMapping("/getBlogComments") 
	public ResponseEntity<List<BlogComment>> getBlogComments() 
	{
		List<BlogComment> listBlogComments=blogcommentDAO.getBlogComments();
		if(listBlogComments.size()>0) {
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<BlogComment>>(listBlogComments,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getBlogComment/{commentId}") 
	public ResponseEntity<BlogComment> getBlogComment(@PathVariable("commentId") int commentId)
	{
		BlogComment blogcomment=blogcommentDAO.getBlogComment(commentId);
		return new ResponseEntity<BlogComment>(blogcomment,HttpStatus.OK);
	}
	
	@PostMapping("/addBlogComment")
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogcomment)
	{
		blogcomment.setCommentDate(new java.util.Date());
		blogcomment.setUsername("Suriya");
		if(blogcommentDAO.addBlogComment(blogcomment))
		{
			return new ResponseEntity<String>("BlogComment added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error adding blogcomment",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deleteBlogComment/{commentId}")
	public ResponseEntity<String> deleteBlogComment(@PathVariable("commentId")int commentId)
	{
		BlogComment blogcomment=(BlogComment)blogcommentDAO.getBlogComment(commentId);
		
		if(blogcommentDAO.deleteBlogComment(blogcomment))
		{
			return new ResponseEntity<String>("Blog Comment Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/updateBlogComment/{commentId}")
	public ResponseEntity<String> updateBlog(@PathVariable("commentId")int commentId)
	{
		BlogComment blogcomment=(BlogComment)blogcommentDAO.getBlogComment(commentId);
		blogcomment.setBlogComment("nice");
				
		if(blogcommentDAO.updateBlogComment(blogcomment))
		{
			return new ResponseEntity<String>("Blog Comment Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	}

