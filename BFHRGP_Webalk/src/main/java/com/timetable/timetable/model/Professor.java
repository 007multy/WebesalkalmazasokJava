package com.timetable.timetable.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Professor {
	public Professor (int id, String name, int objectID) {
		this.id = id;
		this.name = name;
		this.objectID = objectID;
	}

	public Professor(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Professor(int id, int objectID) {
		this.id = id;
		this.objectID = objectID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getObjectID() {
		return objectID;
	}

	public void setObjectID(int objectID) {
		this.objectID = objectID;
	}



	@NotNull(message="Mandatory field")
    private int id;
    
    @NotEmpty(message="Mandatory field")
    private String name;
    
    @NotNull(message="Mandatory field")
    private int objectID;
   

}
