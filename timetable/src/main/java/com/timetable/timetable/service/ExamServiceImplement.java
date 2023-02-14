package com.timetable.timetable.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.timetable.timetable.model.Exam;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.ExamDAO;
import com.timetable.timetable.persist.NotFoundException;



@Service
public class ExamServiceImplement implements ExamService{

    private ExamDAO ExamDAO;

    public ExamServiceImplement(ExamDAO ExamDAO){
        this.ExamDAO = ExamDAO;
    }

    @Override
    public Collection<Exam> listAllExams() {
        return ExamDAO.getAllExams();
    }
    

    
    @Override
   
    public void createExam(Exam Exam)  throws AlreadyExistException{
    	try {
    		ExamDAO.createExam(Exam);
    	}catch (AlreadyExistException e) {
    		throw new AlreadyExistException(e);
    	}
    	
    }

    
    @Override
	public void editExam(Exam Exam) throws NotFoundException {
    	try {
    		ExamDAO.updateExam(Exam);
    	}catch (NotFoundException e) {
    		throw new NotFoundException(e);
    	}
    	
		
	}

	@Override
	public void deleteExam(int id) throws NotFoundException {
		try {
			ExamDAO.deleteExam(id);
		}catch (NotFoundException e) {
    		throw new NotFoundException(e);
    	}
		
		
	}

	@Override
	public Exam listExambySubject(String subjectcode) throws NotFoundException {
		try {
			return ExamDAO.getExambySubject(subjectcode);
		}catch (NotFoundException e) {
    		throw new NotFoundException(e);
    	}
			
		
	}

	@Override
	public Exam listExambyStudent(String neptuncode) throws NotFoundException {
		try {
			return ExamDAO.getExambyStudent(neptuncode);
		}catch (NotFoundException e) {
			throw new NotFoundException(e);
			
		}
	}

	@Override
	public Exam listExambyDate(String date) throws NotFoundException {
		try {
			return ExamDAO.getExambyDate(date);
		}catch (NotFoundException e) {
			throw new NotFoundException(e);
		}
	}

	

}
