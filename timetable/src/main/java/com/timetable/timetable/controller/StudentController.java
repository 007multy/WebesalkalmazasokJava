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
import com.timetable.timetable.model.Student;
import com.timetable.timetable.persist.AlreadyExistException;
import com.timetable.timetable.persist.NotFoundException;
import com.timetable.timetable.service.StudentService;

@Controller
public class StudentController 
{
	private StudentService StudentService;

    @Autowired
    public StudentController(StudentService StudentService){
        this.StudentService = StudentService;
    }

    @RequestMapping(value = "/allStudents")
    @ResponseBody
    public List<Student> getStudentList(){
        return StudentService.listAllStudents();
    }
    

    @RequestMapping(value = "/createStudent")
    @ResponseBody
    public String createStudent(@RequestParam("id") int id,
    								@RequestParam("neptuncode") String neptuncode,
    								@RequestParam("name") String name) throws NotFoundException, AlreadyExistException, InvalidException{
    	StudentService.createStudent(new Student(id,neptuncode,name));
    	return "OK";
    }
    
    
    @RequestMapping(value = "/editStudent")
    @ResponseBody
    public String editStudent(@RequestParam("id") int id,
            @RequestParam("neptuncode") String neptuncode,
            @RequestParam("name") String name) throws NotFoundException, InvalidException{
        	StudentService.editStudent(new Student(id,neptuncode,name));
        	return "OK";
        }
    
    @RequestMapping(value = "/deleteStudent")
    @ResponseBody
    public String deleteStudent(@RequestParam("id")int id) throws NotFoundException {
        StudentService.deleteStudent(id);
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

