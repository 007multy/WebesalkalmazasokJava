package com.timetable.timetable.service;


import org.springframework.stereotype.Service;

import com.timetable.timetable.model.Lecture;
import com.timetable.timetable.persist.LectureDAO;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class LectureServiceImplement implements GradeService{

    private LectureDAO LectureDAO;

    public LectureServiceImplement(LectureDAO LectureDAO){
        this.LectureDAO = LectureDAO;
    }

    @Override
    public List<Lecture> listAllLectures() {
        return LectureDAO.getAllLectures();
    }
    
    @Override
	public Lecture getLecture(int id) throws NotFoundException {
    	
    	return LectureDAO.getLecture(id);
	}

    
    @Override
    public void createLecture(Lecture Lecture) {
    	if (Lecture.getId() < 1) { throw new InvalidParameterException("ID cannot be under 1");
        }
    	LectureDAO.createLecture(Lecture);
    }

    
    @Override
	public void editLecture(Lecture Lecture) {
    	LectureDAO.updateLecture(Lecture);
		
	}

	@Override
	public void deleteLecture(int id) {
		LectureDAO.deleteLecture(id);
		
	}

	@Override
	public void getLecturebyObjectID(int objectID) {
		LectureDAO.getLecturebyObjectID(objectID);
		
	}

	@Override
	public void deleteLectureProfessor(int professorID) {
		LectureDAO.deleteLectureProfessor(professorID);
		
	}

	

}
