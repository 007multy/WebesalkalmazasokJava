package com.timetable.timetable.persist;

import com.timetable.timetable.model.Lecturehall;
import com.timetable.timetable.service.NotFoundException;

import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;
import java.util.*;

@Component
public class LecturehallDAOImplement implements LecturehallDAO{

    private Map<Integer, Lecturehall> LecturehallMap;

    public LecturehallDAOImplement(){
    	LecturehallMap = new HashMap<>();
    	LecturehallMap.put(1, new Lecturehall(1, "In/15", 30));
    	LecturehallMap.put(2, new Lecturehall(2, "In/103", 30));
    	LecturehallMap.put(3, new Lecturehall(3, "In/102", 30));
    	LecturehallMap.put(4, new Lecturehall(4, "V", 120));
    	LecturehallMap.put(5, new Lecturehall(5, "A1/216", 22));
    	LecturehallMap.put(6, new Lecturehall(6, "II", 312));
    }

    @Override
    public Lecturehall getLecturehall(int id) throws NotFoundException {
    	if(!LecturehallMap.keySet().contains(id)) {
            throw new NotFoundException("Not found with this ID");
            }
    	 if (id < 1) { throw new InvalidParameterException("ID cannot be under 1");
         }
        return LecturehallMap.get(id);
    }

    @Override
    public List<Lecturehall> getAllLecturehalls() {
        return new ArrayList<Lecturehall>(LecturehallMap.values());
    }

    @Override
    public void createLecturehall(Lecturehall Lecturehall) {
    	LecturehallMap.put(Lecturehall.getId(), Lecturehall);
    }

    @Override
    public void updateLecturehall(Lecturehall Lecturehall) {
    	LecturehallMap.replace(Lecturehall.getId(), Lecturehall);
    }

    @Override
    public void deleteLecturehall(int id){
    	LecturehallMap.remove(id);
    }

}
