package com.timetable.timetable.persist;

import java.util.List;

import com.timetable.timetable.model.Student;

public interface StudentDAO {
		List<Student> getAllStudents();
		
		void createStudent(Student Student) throws AlreadyExistException;
		
		void updateStudent(Student Student) throws NotFoundException ;
		
		void deleteStudent(int id) throws NotFoundException;

		boolean idUsed(int id);
		
}
