package com.timetable.timetable.persist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.timetable.timetable.model.Exam;
import com.timetable.timetable.model.Grade;
import com.timetable.timetable.model.InvalidException;

@Component
public class ExamDAOImplement implements ExamDAO {
	
	
	
	private  Map<Integer,Exam> ExamMap;
	public ExamDAOImplement() throws InvalidException	{
		
		ExamMap = new HashMap<>();
		ExamMap.put(1, new Exam(1,"GEIAL30ABL","2023-01-10","G6AKLS",Grade.Good));
		ExamMap.put(2, new Exam(2,"GEIAL333BL","2023-01-17","ABCDEF",Grade.Excellent));
		ExamMap.put(3, new Exam(3,"GEIAL332BL","2023-01-24","EFGHIJ",Grade.Pass));
		ExamMap.put(4, new Exam(4,"GEIAL31GBL","2023-01-26","KLMNOS",Grade.Fail));
		ExamMap.put(5, new Exam(5,"GEIAL31GBL","2023-02-03","KLMNOS",Grade.Satisfactory));
		ExamMap.put(6, new Exam(6,"GEIAL30ABL","2023-02-08","ABCDEF",Grade.Pass));
		ExamMap.put(7, new Exam(7,"GEIAL30ABL","2023-02-08","EFGHIJ",Grade.Excellent));
		ExamMap.put(8, new Exam(8,"GEIAL30ABL","2023-02-08","KLMNOS",Grade.Good));
			
		
		
	
	}
	
	
	
	
	
	
		Collection<Exam> collection = new ArrayList<Exam>(Arrays.asList(		
			new Exam (1,"GEIAL30ABL","2023-01-10","G6AKLS",Grade.Good),
			new Exam (2,"GEIAL333BL","2023-01-17","ABCDEF",Grade.Excellent),
			new Exam (3,"GEIAL332BL","2023-01-24","EFGHIJ",Grade.Pass),
			new Exam (4,"GEIAL31GBL","2023-01-26","KLMNOS",Grade.Fail),
			new Exam (5,"GEIAL31GBL","2023-02-03","KLMNOS",Grade.Satisfactory),
			new Exam (6,"GEIAL30ABL","2023-02-08","ABCDEF",Grade.Pass),
			new Exam (7,"GEIAL30ABL","2023-02-08","EFGHIJ",Grade.Excellent),
			new Exam (8,"GEIAL30ABL","2023-02-08","KLMNOS",Grade.Good)));		
		
		
	
		
		
		
		
		
		
		
	@Override
	public void createExam(Exam Exam) throws AlreadyExistException {
		if(idUsed(Exam.getId())) {
			throw new AlreadyExistException("Exam already exists");
		}
		ExamMap.put(Exam.getId(), Exam);
	}

	

	@Override
	public void updateExam(Exam Exam) throws NotFoundException {
		if(!idUsed(Exam.getId())) {
			throw new NotFoundException("Exam not found");
		}
		ExamMap.put(Exam.getId(), Exam);
	}

	@Override
	public void deleteExam(int id) throws NotFoundException {
		if(!ExamMap.keySet().contains(id)) {
			throw new NotFoundException("Not found ID");
		}
		ExamMap.remove(id);
	}


	@Override
	public List<Exam> getAllExams() {
		
		return new ArrayList<Exam>(ExamMap.values());
	}


	@Override
	public Exam getExambySubject(String subjectcode) throws NotFoundException{
		for (Exam getExambySubject : collection) {
			if(getExambySubject.getNeptuncode().matches(subjectcode)){
				return getExambySubject;
			}
		}
		throw new NotFoundException("No found with this code");
	}


	@Override
	public Exam getExambyStudent(String neptuncode) throws NotFoundException {
		for (Exam getExambyStudent : collection) {
			if(getExambyStudent.getNeptuncode().matches(neptuncode)){
				return getExambyStudent;
			}
		}
		throw new NotFoundException("No found with this code");
	}

	@Override
    public boolean idUsed(int id) {
        return ExamMap.containsKey(id);
    }

	@Override
	public Exam getExambyDate(String date) throws NotFoundException {
		for (Exam getExambyDate : collection) {
			if(getExambyDate.getDate().matches(date)){
				return getExambyDate;
			}
		}
		throw new NotFoundException("No found with this date, date format must be YYYY-MM-dd");
	}

}
