package com.timetable.timetable.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
	@NotNull(message="ID is mandatory field")
	private int id;
	@NotEmpty(message="Neptuncode is mandatory field")
	private String neptuncode;
	@NotEmpty(message="Name is mandatory field")
	private String name;
	
	
	
	public Student (int id, String neptuncode, String name) throws InvalidException
    {
		if(id<1) {
			throw new InvalidException("ID must be over 0");
		}
    	this.id = id;
    	if(neptuncode.length()!=6) {
    		throw new InvalidException("Neptuncode has to be 6 character");
    	}
    	this.neptuncode = neptuncode;	
        this.name = name;
    }
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNeptuncode() {
		return neptuncode;
	}
	public void setNeptuncode(String neptuncode) {
		this.neptuncode = neptuncode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

	

}
