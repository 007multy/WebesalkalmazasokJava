package com.timetable.timetable.controller;

import java.security.InvalidParameterException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.timetable.timetable.model.Exam;
import com.timetable.timetable.model.Grade;
import com.timetable.timetable.model.InvalidException;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.NotFoundException;
import com.timetable.timetable.service.ExamService;

@Controller
public class ExamController 
{
	private ExamService ExamService;

    @Autowired
    public ExamController(ExamService ExamService){
        this.ExamService = ExamService;
    }

    
    @RequestMapping(value = "/allExams", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Exam> getExamList(){
        return ExamService.listAllExams();
    }
    
    @RequestMapping(value = "/getExambyStudent", method = RequestMethod.GET)
    @ResponseBody
    public Exam getExambyStudent(@RequestParam("neptuncode") String neptuncode) throws  NotFoundException{
        return ExamService.listExambyStudent(neptuncode);
    }
    
    @RequestMapping(value = "/getExambySubject", method = RequestMethod.GET)
    @ResponseBody
    public Exam getExambySubject(@RequestParam("subjectcode") String subjectcode)throws  NotFoundException{
        return ExamService.listExambySubject(subjectcode);
    }
    
    @RequestMapping(value = "/getExambyDate", method = RequestMethod.GET)
    @ResponseBody
    public Exam getExambyDate(@RequestParam("date") String date) throws  NotFoundException{
        return ExamService.listExambyDate(date);
    }
    
    
    
    @RequestMapping(value = "/createExam", method = RequestMethod.POST)
    @ResponseBody
    public String createExam(@RequestParam("id") int id,
    								@RequestParam("subjectcode") String subjectcode,
    								@RequestParam("date") String date,
    								@RequestParam("neptuncode") String neptuncode,
    								@RequestParam("grade") Grade grade) throws NotFoundException, AlreadyExistException, InvalidException{
    	ExamService.createExam(new Exam(id,subjectcode,date,neptuncode, grade));
    	return "OK";
    }
    
    
    @RequestMapping(value = "/editExam", method = RequestMethod.POST)
    @ResponseBody
    public String editExam(@RequestParam("id") int id,
			@RequestParam("subjectcode") String subjectcode,
			@RequestParam("date") String date,
			@RequestParam("neptuncode") String neptuncode,
			@RequestParam("grade") Grade grade) throws NotFoundException, AlreadyExistException, InvalidException{
        	ExamService.editExam(new Exam(id,subjectcode,date,neptuncode,grade));
        	return "OK"; 
        }
    
    @RequestMapping(value = "/deleteExam", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteExam(@RequestParam("id")int id) throws NotFoundException {
        ExamService.deleteExam(id);
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
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public String invalidParameterExceptionHandler(Exception ex) { 
    	return "Bad parameter:          "+ex.getMessage();
    	
    }
    
    
    
}

