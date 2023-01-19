package com.timetable.timetable.service;


import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.timetable.timetable.model.Lecturehall;
import com.timetable.timetable.persist.LecturehallDAO;

@Service
public class LecturehallServiceImplement implements LecturehallService{

    private LecturehallDAO LecturehallDAO;

    public LecturehallServiceImplement(LecturehallDAO LecturehallDAO){
        this.LecturehallDAO = LecturehallDAO;
    }

    @Override
    public List<Lecturehall> listAllLecturehalls() {
        return LecturehallDAO.getAllLecturehalls();
    }
    
    @Override
	public Lecturehall getLecturehall(int id) throws NotFoundException{
    
		return LecturehallDAO.getLecturehall(id);
	}

    
    @Override
    public void createLecturehall(Lecturehall Lecturehall)  throws NotFoundException{
    	if(Lecturehall.getId() < 1) {
    		throw new InvalidParameterException("ID cannot be under 1");
    	}
    	LecturehallDAO.createLecturehall(Lecturehall);
    }

    
    @Override
	public void editLecturehall(Lecturehall Lecturehall) {
    	LecturehallDAO.updateLecturehall(Lecturehall);
		
	}

	@Override
	public void deleteLecturehall(int id) {
		LecturehallDAO.deleteLecturehall(id);
		
	}

	

}
