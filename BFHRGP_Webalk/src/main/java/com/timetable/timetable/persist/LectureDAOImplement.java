package com.timetable.timetable.persist;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.timetable.timetable.model.Lecture;
import com.timetable.timetable.service.NotFoundException;

@Component
public class LectureDAOImplement implements LectureDAO{

    private Map<Integer, Lecture> LectureMap;

    public LectureDAOImplement(){
    	LectureMap = new HashMap<>();
    	LectureMap.put(1, new Lecture(1, 1, 1, 1, "2022.02.11"));
    	LectureMap.put(2, new Lecture(2, 2, 2, 2, "2022.02.18"));
    	LectureMap.put(3, new Lecture(3, 3, 3, 1, "2022.02.25"));
    	LectureMap.put(4, new Lecture(4, 5, 5, 4, "2022.03.04"));
    	LectureMap.put(5, new Lecture(5, 2, 2, 2, "2022.03.11"));
    	LectureMap.put(6, new Lecture(6, 3, 3, 1, "2022.03.18"));
    	LectureMap.put(7, new Lecture(7, 3, 3, 5, "2022.04.01"));
    	LectureMap.put(8, new Lecture(8, 7, 7, 6, "2022.04.29"));
    }

    @Override
    public Lecture getLecture(int id) throws NotFoundException {
    	if(!LectureMap.keySet().contains(id)) {
            throw new NotFoundException("Not found with this ID");
            }
    	 if (id < 1) { throw new InvalidParameterException("ID cannot be under 1");
         }
        return LectureMap.get(id);
    }

    @Override
    public List<Lecture> getAllLectures() {
        return new ArrayList<Lecture>(LectureMap.values());
    }

    @Override
    public void createLecture(Lecture Lecture) {
    	LectureMap.put(Lecture.getId(), Lecture);
    }

    @Override
    public void updateLecture(Lecture Lecture) {
    	LectureMap.replace(Lecture.getId(), Lecture);
    }

    @Override
    public void deleteLecture(int id){
    	LectureMap.remove(id);
    }

	@Override
	public Lecture getLecturebyObjectID(int objectID) {
		return LectureMap.get(objectID);
		
	}

	@Override
	public void deleteLectureProfessor(int professorID) {
	LectureMap.remove(professorID);
		
	}

}
