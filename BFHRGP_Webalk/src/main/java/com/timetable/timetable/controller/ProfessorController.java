package com.timetable.timetable.controller;

import com.timetable.timetable.model.Professor;
import com.timetable.timetable.service.NotFoundException;
import com.timetable.timetable.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@Controller
public class ProfessorController {

    private ProfessorService ProfessorService;

    @Autowired
    public ProfessorController(ProfessorService ProfessorService){
        this.ProfessorService = ProfessorService;
    }

    @RequestMapping("allProfessors")
    @ResponseBody
    public List<Professor> getProfessorList(){
        return ProfessorService.listAllProfessors();
    }
    
    @RequestMapping("getProfessor")
    @ResponseBody
    public Professor getProfessor(@RequestParam("id")int id) throws NotFoundException {
        ProfessorService.getProfessor(id);
        return ProfessorService.getProfessor(id);
    }

    @RequestMapping("createProfessor")
    @ResponseBody
    public String createProfessor(@RequestParam("id") int id,
        @RequestParam("name") String name,
    	@RequestParam("objectID") int objectID){
    	ProfessorService.createProfessor(new Professor(id,name,objectID));
    	return "OK";
    }
    
    
    @RequestMapping("editProfessorName")
    @ResponseBody
    public String editProfessor(@RequestParam("id") int id,
    		@RequestParam("name") String name){
        	ProfessorService.editProfessor(new Professor(id,name));
        	return "OK";
        }
    
    @RequestMapping("editProfessorObject")
    @ResponseBody
    public String editProfessor(@RequestParam("id") int id,
        	@RequestParam("objectID") int objectID){
        	ProfessorService.editProfessor(new Professor(id,objectID));
        	return "OK";
        }
    
    @RequestMapping("deleteProfessor")
    @ResponseBody
    public String deleteProfessor(@RequestParam("id")int id) {
        ProfessorService.deleteProfessor(id);
        return "OK";
    }


  

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }

}


