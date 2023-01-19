package com.timetable.timetable.persist;

import java.util.List;

import com.timetable.timetable.model.Professor;
import com.timetable.timetable.service.NotFoundException;

public interface ProfessorDAO {
	Professor getProfessor(int id) throws NotFoundException;

    List<Professor> getAllProfessors();

    void createProfessor(Professor Professor);

    void updateProfessor(Professor Professor);

    void deleteProfessor(int id);

}
