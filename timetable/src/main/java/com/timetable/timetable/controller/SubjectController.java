package com.timetable.timetable.controller;

import java.security.InvalidParameterException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.timetable.timetable.model.InvalidException;
import com.timetable.timetable.model.Subject;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.NotFoundException;
import com.timetable.timetable.service.SubjectService;

@Controller
public class SubjectController 
{
	private SubjectService SubjectService;

    @Autowired
    public SubjectController(SubjectService SubjectService){
        this.SubjectService = SubjectService;
    }

    @RequestMapping(value = "/allSubjects")
    @ResponseBody
    public List<Subject> getSubjectList(){
        return SubjectService.listAllSubjects();
    }
    

    @RequestMapping(value = "/getSubject")
    @ResponseBody
    public Subject getSubject(@RequestParam("id")int id) throws NotFoundException{
        return SubjectService.getSubject(id);
    }
    
    @RequestMapping(value = "/createSubject")
    @ResponseBody
    public String createSubject(@RequestParam("id") int id,
    								@RequestParam("subjectcode") String subjectcode,
    								@RequestParam("subjectname") String subjectname,
    								@RequestParam("lecture") String lecture) throws NotFoundException, AlreadyExistException, InvalidException{
    	SubjectService.createSubject(new Subject(id,subjectcode,subjectname,lecture));
    	return "OK";
    }
    
    
    @RequestMapping(value = "/editSubject")
    @ResponseBody
    public String editSubject(@RequestParam("id") int id,
			@RequestParam("subjectcode") String subjectcode,
			@RequestParam("subjectname") String subjectname,
			@RequestParam("lecture") String lecture) throws NotFoundException, AlreadyExistException, InvalidException{
        	SubjectService.editSubject(new Subject(id,subjectcode,subjectname,lecture));
        	return "OK";
        }
    
    @RequestMapping(value = "/deleteSubject")
    @ResponseBody
    public String deleteSubject(@RequestParam("id")int id) throws NotFoundException {
        SubjectService.deleteSubject(id);
        return "OK";
    }


 
    
    @ExceptionHandler(value = {AlreadyExistException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public String AlreadyExistExceptionExHandler(Exception ex){
        return "Data already exists:     "+ex.getMessage();
    }

    @ExceptionHandler(value = {InvalidException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String InvalidExceptionExHandler(Exception ex){
        return "Invalid data:     "+ex.getMessage();
    }

  

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String NotFoundExceptionExHandler(Exception ex){
        return "Not found:           "+ex.getMessage();
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
    
}

