package com.timetable.timetable.persist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.timetable.timetable.model.InvalidException;
import com.timetable.timetable.model.Student;


@Component
public class StudentDAOImplement implements StudentDAO {
	
	private static Map<Integer,Student> StudentMap;
	
	public StudentDAOImplement() throws InvalidException{
			StudentMap = new HashMap<>();
		
			StudentMap.put(1, new Student(1, "G6AKLS","Kovács István"));
			StudentMap.put(2, new Student(2, "ABCDEF","Nagy Ferenc"));
			StudentMap.put(3, new Student(3, "EFGHIJ","Kis Enikő"));
			StudentMap.put(4, new Student(4, "KLMNOS","Nagy Eszter"));	
		
	}

	@Override
	public List<Student> getAllStudents() {
		
		return new ArrayList<Student>(StudentMap.values());
	}
	
	

	@Override
	public void createStudent(Student Student) throws AlreadyExistException {
		if(idUsed(Student.getId()))	{
        	  throw new AlreadyExistException("Student already exists");
		}
			
		StudentMap.put(Student.getId(), Student);
	}
	

	@Override
	public void updateStudent(Student Student) throws NotFoundException {
		if(!idUsed(Student.getId()))
		{
			throw new NotFoundException("Student not found");
		}
		StudentMap.replace(Student.getId(), Student);
		
	}

	@Override
	public void deleteStudent(int id) throws NotFoundException {
		if(!StudentMap.keySet().contains(id)) {
			throw new NotFoundException("Not found ID");
		}
	}
	
	@Override
    public boolean idUsed(int id) {
        return StudentMap.containsKey(id);
    }
}
