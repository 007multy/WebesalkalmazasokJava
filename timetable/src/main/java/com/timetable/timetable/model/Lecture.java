package com.timetable.timetable.model;

import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Data
@Builder
public class Lecture {
	
	public Lecture(int id, int objectID, int professorID, int lecturehallID, String date) {
		this.id = id;
		this.objectID = objectID;
		this.professorID = professorID;
		this.lecturehallID = lecturehallID;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getobjectID() {
		return objectID;
	}

	public void setobjectID(int objectID) {
		this.objectID = objectID;
	}
	
	public int getprofessorID() {
		return professorID;
	}

	public void setprofessorID(int professorID) {
		this.professorID = professorID;
	}
	
	public int getlecturehallID() {
		return lecturehallID;
	}

	public void setlecturehallID(int lecturehallID) {
		this.lecturehallID = lecturehallID;
	}


	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	@NotNull(message="Mandatory field")
    private int id;
	
	
	@NotNull(message="Mandatory field")
	private int objectID;
	
	@NotNull(message="Mandatory field")
	private int professorID;
	
	@NotNull(message="Mandatory field")
	private int lecturehallID;

    
    @NotEmpty(message="Mandatory field")
    private String date;
}