package com.timetable.timetable.persist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.timetable.timetable.model.InvalidException;
import com.timetable.timetable.model.Subject;



@Component
public class SubjectDAOImplement implements SubjectDAO {
	
	private  Map<Integer,Subject> SubjectMap;
	
	
	public SubjectDAOImplement() throws InvalidException	{
		
		SubjectMap = new HashMap<>();
		SubjectMap.put(1, new Subject(1, "GEIAL30ABL", "Windows System Management", "Wagner György"));
		SubjectMap.put(2, new Subject(2, "GEIAL333BL", "Web-based Applications in Java", "Kunné Dr. Tamás Judit"));
		SubjectMap.put(3, new Subject(3, "GEIAL332BL", "XML Data Management", "Dr. Bednarik László"));
		SubjectMap.put(4, new Subject(4, "GEIAL31GBL", "Current Trends in Information Technologies", "Tompa Tamás"));	
	
}

	@Override
	public List<Subject> getAllSubjects() {
		
		return new ArrayList<Subject>(SubjectMap.values());
	}

	@Override
	public Subject getSubject(int id) throws NotFoundException {
		if(SubjectMap.keySet().contains(id)) {
			return SubjectMap.get(id);
		}
		throw new NotFoundException("Not found with this ID");
	}
	
	@Override
	public void createSubject(Subject Subject) throws AlreadyExistException {
		if(idUsed(Subject.getId()))	{
      	  throw new AlreadyExistException("Subject already exists");
		}
			
		SubjectMap.put(Subject.getId(), Subject);
	}
	

	@Override
	public void updateSubject(Subject Subject) throws NotFoundException {
		if(!idUsed(Subject.getId())) {
			throw new NotFoundException("Subject not found");
		}
		SubjectMap.put(Subject.getId(), Subject);
	}

	@Override
	public void deleteSubject(int id) throws NotFoundException {
		if(!SubjectMap.keySet().contains(id)) {
			throw new NotFoundException("Not found ID");
		}
		SubjectMap.remove(id);
	}

	@Override
    public boolean idUsed(int id) {
        return SubjectMap.containsKey(id);
    }

}
