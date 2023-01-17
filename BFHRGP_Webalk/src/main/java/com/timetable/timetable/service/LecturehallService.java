package com.timetable.timetable.service;

import com.timetable.timetable.model.Lecturehall;
import java.util.List;


public interface LecturehallService {
	List<Lecturehall> listAllLecturehalls();
	Lecturehall getLecturehall(int id) throws NotFoundException;
	void createLecturehall(Lecturehall Lecturehall) throws NotFoundException;
	void editLecturehall(Lecturehall Lecturehall);
	void deleteLecturehall(int id);
	
	
}
