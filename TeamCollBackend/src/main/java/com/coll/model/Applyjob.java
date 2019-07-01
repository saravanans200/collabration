package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Applyjob {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="applyId")
	@SequenceGenerator(name="applyId",allocationSize=1,sequenceName="applyIdseq")
	private int applyId;
	private String username;
	private String jobapplied;
	private Date appliedDate;
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJobapplied() {
		return jobapplied;
	}
	public void setJobapplied(String jobapplied) {
		this.jobapplied = jobapplied;
	}
	
}
