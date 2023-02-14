package com.timetable.timetable.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.timetable.timetable.model.Student;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.NotFoundException;
import com.timetable.timetable.persist.StudentDAO;

@Service
public class StudentServiceImplement implements StudentService{

    private StudentDAO StudentDAO;

    public StudentServiceImplement(StudentDAO StudentDAO){
        this.StudentDAO = StudentDAO;
    }

    @Override
    public List<Student> listAllStudents() {
        return StudentDAO.getAllStudents();
    }
    

    
    @Override
    public void createStudent(Student Student)  throws AlreadyExistException{
    	try {
    		StudentDAO.createStudent(Student);
    	}catch (AlreadyExistException e) {
    		throw new AlreadyExistException(e);
    	}
    	
    }

    
    @Override
	public void editStudent(Student Student) throws NotFoundException {
    	try {
    		StudentDAO.updateStudent(Student);
    	}catch (NotFoundException e) {
    		throw new NotFoundException(e);
    	}
    	
		
	}

	@Override
	public void deleteStudent(int id) throws NotFoundException {
		try {
			StudentDAO.deleteStudent(id);
		}catch (NotFoundException e) {
    		throw new NotFoundException(e);
    	}
		
		
	}

	

}
