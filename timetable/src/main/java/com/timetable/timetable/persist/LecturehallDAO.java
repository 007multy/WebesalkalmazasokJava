package com.timetable.timetable.persist;

import com.timetable.timetable.model.Lecturehall;
import com.timetable.timetable.service.NotFoundException;

import java.util.List;


public interface LecturehallDAO {
	
	    Lecturehall getLecturehall(int id) throws NotFoundException;

	    List<Lecturehall> getAllLecturehalls();

	    void createLecturehall(Lecturehall Lecturehall);

	    void updateLecturehall(Lecturehall Lecturehall);

	    void deleteLecturehall(int id);

	
}