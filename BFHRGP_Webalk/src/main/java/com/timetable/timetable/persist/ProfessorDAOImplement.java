package com.timetable.timetable.persist;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.timetable.timetable.model.Professor;
import com.timetable.timetable.service.NotFoundException;
@Component
public class ProfessorDAOImplement implements ProfessorDAO{
	 private Map<Integer, Professor> ProfessorMap;

	    public ProfessorDAOImplement(){
	    	ProfessorMap = new HashMap<>();
	    	ProfessorMap.put(1, new Professor(1, "Szabó Martin", 1));
	    	ProfessorMap.put(2, new Professor(2, "Sátán Ádám", 2));
	    	ProfessorMap.put(3, new Professor(3, "Dr. Kulcsárné Forrai Mónika", 3));
	    	ProfessorMap.put(4, new Professor(4, "Agárdi Anita", 4));
	    	ProfessorMap.put(5, new Professor(5, "Harangozó Zsolt", 5));
	    	ProfessorMap.put(6, new Professor(6, "Dr. Szilvásiné Rozgonyi Erika", 6));
	    	ProfessorMap.put(7, new Professor(7, "Lates Viktor", 7));
	    }

	    @Override
	    public Professor getProfessor(int id) throws NotFoundException {
	    	if(!ProfessorMap.keySet().contains(id)) {
	            throw new NotFoundException("Not found with this ID");
	            }
	    	 if (id < 1) { throw new InvalidParameterException("ID cannot be under 1");
	         }
	        return ProfessorMap.get(id);
	    }

	    @Override
	    public List<Professor> getAllProfessors() {
	        return new ArrayList<Professor>(ProfessorMap.values());
	    }

	    @Override
	    public void createProfessor(Professor Professor) {
	    	ProfessorMap.put(Professor.getId(), Professor);
	    }

	    @Override
	    public void updateProfessor(Professor Professor) {
	    	ProfessorMap.replace(Professor.getId(), Professor);
	    }

	    @Override
	    public void deleteProfessor(int id){
	    	ProfessorMap.remove(id);
	    }

}

