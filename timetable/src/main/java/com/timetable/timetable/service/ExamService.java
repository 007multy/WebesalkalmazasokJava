package com.timetable.timetable.service;

import java.util.Collection;

import com.timetable.timetable.model.Exam;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.NotFoundException;

public interface ExamService {
	Collection<Exam> listAllExams();
	
	Exam listExambySubject (String subjectcode) throws NotFoundException;
	
	Exam listExambyStudent (String neptuncode) throws NotFoundException;
	
	Exam listExambyDate (String date) throws NotFoundException;
	
	void createExam(Exam Exam) throws AlreadyExistException;
	
	void editExam(Exam Exam) throws NotFoundException;
	
	void deleteExam(int id) throws NotFoundException;

  
}
