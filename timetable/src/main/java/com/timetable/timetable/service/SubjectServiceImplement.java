package com.timetable.timetable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.timetable.timetable.model.Subject;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.NotFoundException;
import com.timetable.timetable.persist.SubjectDAO;

@Service
public class SubjectServiceImplement implements SubjectService{

    private SubjectDAO SubjectDAO;

    public SubjectServiceImplement(SubjectDAO SubjectDAO){
        this.SubjectDAO = SubjectDAO;
    }

    @Override
    public List<Subject> listAllSubjects() {
        return SubjectDAO.getAllSubjects();
    }
    

    @Override
	public Subject getSubject(int id) throws NotFoundException {
    	try {
    		return SubjectDAO.getSubject(id);
    	}catch (NotFoundException e) {
    		throw new NotFoundException(e);
    	}
	}
    
    
    @Override
    public void createSubject(Subject Subject)  throws AlreadyExistException{
    	try {
    		SubjectDAO.createSubject(Subject);
    	}catch (AlreadyExistException e) {
    		throw new AlreadyExistException(e);
    	}
    	
    }

    
    @Override
	public void editSubject(Subject Subject) throws NotFoundException {
    	try {
    		SubjectDAO.updateSubject(Subject);
    	}catch (NotFoundException e) {
    		throw new NotFoundException(e);
    	}
    	
		
	}

	@Override
	public void deleteSubject(int id) throws NotFoundException {
		try {
			SubjectDAO.deleteSubject(id);
		}catch (NotFoundException e) {
    		throw new NotFoundException(e);
    	}
		
		
	}


	

}
