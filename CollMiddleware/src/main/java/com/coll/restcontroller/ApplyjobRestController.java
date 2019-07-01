package com.coll.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.coll.dao.ApplyjobDAO;
import com.coll.model.Applyjob;

@RestController
public class ApplyjobRestController {
	@Autowired
	ApplyjobDAO applyjobDAO;
	
	@PostMapping(value="/applyjob",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> applyjob(@RequestBody Applyjob applyjob)
	{
		applyjob.setUsername("Suriya");
		applyjob.setJobapplied("developer");
		applyjob.setAppliedDate(new java.util.Date());
		if(applyjobDAO.applyJob(applyjob))
		{
			return new ResponseEntity<String>("applied for job",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Error in applying job",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
