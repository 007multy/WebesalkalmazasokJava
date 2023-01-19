package com.timetable.timetable.model;


import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



@Data
@Builder
public class Lecturehall {

	public Lecturehall(int id, String name, int space) {
		this.id = id;
		this.name = name;
		this.space = space;
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


	public int getSpace() {
		return space;
	}

	public void setAvailable(int space) {
		this.space = space;
	}



	@NotNull(message="Mandatory field")
    private int id;
    
    @NotEmpty(message="Mandatory field")
    private String name;
    
    @NotNull(message="Mandatory field")
    private int space;

	
}