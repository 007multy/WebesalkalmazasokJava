package com.timetable.timetable.persist;

import com.timetable.timetable.model.Lecture;
import com.timetable.timetable.service.NotFoundException;

import java.util.List;


public interface LectureDAO {
	
	    Lecture getLecture(int id) throws NotFoundException;

	    List<Lecture> getAllLectures();

	    void createLecture(Lecture Lecture);

	    void updateLecture(Lecture Lecture);

	    void deleteLecture(int id);

		Lecture getLecturebyObjectID(int objectID);

		void deleteLectureProfessor(int professorID);

	
}