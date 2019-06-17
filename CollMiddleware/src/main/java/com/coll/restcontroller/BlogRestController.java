package com.coll.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;


@RestController
public class BlogRestController {
	
	@Autowired
	BlogDAO blogDAO;
		
	@GetMapping("/getBlogs")
	public ResponseEntity<List<Blog>> getBlogs() 
	{
		List<Blog> listBlogs=blogDAO.getBlogs();
		if(listBlogs.size()>0)
		{
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<List<Blog>>(listBlogs,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getBlog/{blogId}") 
	public ResponseEntity<Blog> getBlog(@PathVariable("blogId") int blogId)
	{
		Blog blog=blogDAO.getBlog(blogId);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	@PostMapping("/addBlog")
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setBlogName("saran");
		blog.setBlogContent("fouth");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(1);
		blog.setDislikes(1);
		if(blogDAO.addBlog(blog))
		{
			return new ResponseEntity<String>("blog added",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("failure",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PutMapping("/updateBlog/{blogId}")
	public ResponseEntity<String> updateBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(1);
		blog.setDislikes(1);
		blog.setStatus("NA");
		blog.setBlogName("NIITTnagar");
		
		if(blogDAO.updateBlog(blog))
		{
			return new ResponseEntity<String>("Blog Updated",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Failure",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/deleteBlog/{blogId}")
	public ResponseEntity<String> deleteBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		
		if(blogDAO.deleteBlog(blog))
		{
			return new ResponseEntity<String>("Blog Deleted",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/approveBlog/{blogId}")
	public ResponseEntity<String> approveBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		if(blogDAO.approveBlog(blogId))
		{
			return new ResponseEntity<String>("Approved",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);				
	}
	
	@GetMapping("/rejectBlog/{blogId}")
	public ResponseEntity<String> rejectBlog(@PathVariable("blogId")int blogId)
	{
		Blog blog=(Blog)blogDAO.getBlog(blogId);
		
		if(blogDAO.rejectBlog(blogId))
		{
			return new ResponseEntity<String>("Approved",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);				
	}
	
	@GetMapping("/incrementLikes/{blogId}")
	public ResponseEntity<String> incrementLikes(@PathVariable("blogId")int blogId)
	
	{
		if(blogDAO.incrementLikes(blogId))
		{
			return new ResponseEntity<String>("Incremented likes",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/incrementDislikes/{blogId}")
	public ResponseEntity<String> incrementDisLikes(@PathVariable("blogId")int blogId)
	
	{
		if(blogDAO.incrementDislikes(blogId))
		{
			return new ResponseEntity<String>("Incremented Dislikes",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("Failure",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
