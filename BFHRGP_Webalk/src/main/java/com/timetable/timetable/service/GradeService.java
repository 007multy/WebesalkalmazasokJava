package com.timetable.timetable.service;

import com.timetable.timetable.model.Lecture;
import java.util.List;


public interface GradeService {
	List<Lecture> listAllLectures();
	Lecture getLecture(int id) throws NotFoundException;
	void getLecturebyObjectID(int objectID);
	void createLecture(Lecture Lecture);
	void editLecture(Lecture Lecture);
	void deleteLecture(int id);
	void deleteLectureProfessor(int professorID);
	
	
	
}
