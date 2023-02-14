package com.timetable.timetable.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Subject {
	@NotNull(message="ID is mandatory field")
	private int id;
	@NotEmpty(message="Subjectcode is mandatory field")
	private String subjectcode;
	@NotEmpty(message="Subjectname is mandatory field")
	private String subjectname;
	@NotEmpty(message="Lecture is mandatory field")
	private String lecture;
	
	
    public Subject (int id, String subjectcode, String subjectname, String lecture) throws InvalidException
    {
    	if(id<1) {
			throw new InvalidException("ID must be over 0");
		}
    	this.id = id;
    	if(subjectcode.length()!=10) {
    		throw new InvalidException("Subjectcode has to be 10 characters");
    	}
        this.subjectcode = subjectcode;
        this.subjectname = subjectname;
        this.lecture = lecture;
    }
    
    
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getLecture() {
		return lecture;
	}
	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
	public String getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
