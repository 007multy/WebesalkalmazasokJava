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

import com.timetable.timetable.model.Lecturehall;
import com.timetable.timetable.service.LecturehallService;
import com.timetable.timetable.service.NotFoundException;

@Controller
public class LecturehallController {

    private LecturehallService LecturehallService;

    @Autowired
    public LecturehallController(LecturehallService LecturehallService){
        this.LecturehallService = LecturehallService;
    }

    @RequestMapping("allLecturehalls")
    @ResponseBody
    public List<Lecturehall> getLecturehallList(){
        return LecturehallService.listAllLecturehalls();
    }
    
    @RequestMapping("getLecturehall")
    @ResponseBody
    public Lecturehall getLecturehall(@RequestParam("id")int id) throws NotFoundException {
        return LecturehallService.getLecturehall(id);
    }

    @RequestMapping("createLecturehall")
    @ResponseBody
    public String createLecturehall(@RequestParam("id") int id,
    								@RequestParam("name") String name,
    								@RequestParam("space") int space) throws NotFoundException{
    	LecturehallService.createLecturehall(new Lecturehall(id,name,space));
    	return "OK";
    }
    
    
    @RequestMapping("editLecturehall")
    @ResponseBody
    public String editLecturehall(@RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("space") int space){
        	LecturehallService.editLecturehall(new Lecturehall(id,name,space));
        	return "OK";
        }
    
    @RequestMapping("deleteLecturehall")
    @ResponseBody
    public String deleteLecturehall(@RequestParam("id")int id) {
        LecturehallService.deleteLecturehall(id);
        return "OK";
    }


  

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
}



