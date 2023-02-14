package com.timetable.timetable.model;

import java.util.regex.Pattern;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Exam {
	@NotNull(message="ID is mandatory field")
	private int id;
	@NotEmpty(message="Subjectcode is mandatory field")
	private String subjectcode;
	@NotEmpty(message="Date is mandatory field")
	private String date = "^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$";
	@NotEmpty(message="Neptuncode is mandatory field")
	private String neptuncode;
	@NotBlank(message="Grade has to be Fail, Pass, Satisfactory, Good, Excellent")
	private Grade grade;
	
	Pattern pattern = Pattern.compile(date);
		
	
	
	public Exam (int id, String subjectcode, String date, String neptuncode, Grade grade) throws InvalidException
    {
		if(id<1) {
			throw new InvalidException("ID must be over 0");
		}
    	this.id = id;
    	if(subjectcode.length()!=10) {
    		throw new InvalidException("Subjectcode has to be 10 characters");
    	}
    	this.subjectcode = subjectcode;
    	
    
    	if(!date.matches("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$")) {
    		throw new InvalidException("Wrong date or date has to be in YYYY-MM-DD or YYYY.MM.DD format");
    	}
    	this.date = date;
    	if(neptuncode.length()!=6) {
    		throw new InvalidException("Neptuncode has to be 6 character");
    	}
    	this.neptuncode = neptuncode;
        this.grade = grade;
        
       
    }
	
	
	public Exam (int id, String subjectcode, String date, String neptuncode, String grade) throws InvalidException
    {
		this.id = id;
		this.subjectcode = subjectcode;
		this.date = date;
		this.neptuncode = neptuncode;
		
		try {
            this.grade = Grade.valueOf(grade);
        } catch (IllegalArgumentException e) {
            throw new InvalidException("Grade has to be Fail, Pass, Satisfactory, Good, Excellent");
        }

    }
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSubjectcode() {
		return subjectcode;
	}
	public void setSubjectcode(String subjectcode) {
		this.subjectcode = subjectcode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getNeptuncode() {
		return neptuncode;
	}
	public void setNeptuncode(String neptuncode) {
		this.neptuncode = neptuncode;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}	
	

}
