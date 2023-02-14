package com.timetable.timetable.persist;

import java.util.Collection;
import com.timetable.timetable.model.Exam;

public interface ExamDAO {
		Collection<Exam> getAllExams();
		
		Exam getExambySubject (String subjectcode) throws NotFoundException;
		
		Exam getExambyStudent (String neptuncode) throws NotFoundException;
		
		Exam getExambyDate (String date) throws NotFoundException;
		
		void createExam(Exam Exam) throws AlreadyExistException;
		
		void updateExam(Exam Exam) throws NotFoundException ;
		

		void deleteExam(int  id) throws NotFoundException;

		boolean idUsed(int id);





		
		

}
