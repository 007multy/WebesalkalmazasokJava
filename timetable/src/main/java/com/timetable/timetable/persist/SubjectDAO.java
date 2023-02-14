package com.timetable.timetable.persist;

import java.util.List;

import com.timetable.timetable.model.Subject;

public interface SubjectDAO {
		List<Subject> getAllSubjects();
		
		Subject getSubject(int id) throws NotFoundException;
		
		void createSubject(Subject subject) throws AlreadyExistException;
		
		void updateSubject(Subject Subject) throws NotFoundException ;
		
		void deleteSubject(int id) throws NotFoundException;

		boolean idUsed(int id);

		
		

}
