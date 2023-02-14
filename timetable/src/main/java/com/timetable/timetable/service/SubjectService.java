package com.timetable.timetable.service;

import java.util.List;

import com.timetable.timetable.model.Subject;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.NotFoundException;

public interface SubjectService {
	List<Subject> listAllSubjects();
	
	Subject getSubject(int id) throws NotFoundException;
	
	void createSubject(Subject Subject) throws AlreadyExistException;
	
	void editSubject(Subject Subject) throws NotFoundException;
	
	void deleteSubject(int id) throws NotFoundException;
  
}
