package com.timetable.timetable.service;

import java.util.List;

import com.timetable.timetable.model.Student;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.NotFoundException;

public interface StudentService {
	List<Student> listAllStudents();
	
	void createStudent(Student Student) throws AlreadyExistException;
	
	void editStudent(Student Student) throws NotFoundException;
	
	void deleteStudent(int id) throws NotFoundException;
  
}
