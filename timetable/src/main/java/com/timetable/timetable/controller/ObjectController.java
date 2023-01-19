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

import com.timetable.timetable.model.Object;
import com.timetable.timetable.service.NotFoundException;
import com.timetable.timetable.service.ObjectService;

@Controller
public class ObjectController {

    private ObjectService ObjectService;

    @Autowired
    public ObjectController(ObjectService ObjectService){
        this.ObjectService = ObjectService;
    }

    @RequestMapping("allObjects")
    @ResponseBody
    public List<Object> getObjectList(){
        return ObjectService.listAllObjects();
    }
    
    @RequestMapping("getObject")
    @ResponseBody
    public Object getObject(@RequestParam("id")int id) throws NotFoundException {
    	        return ObjectService.getObject(id);
    	    }
		


    @RequestMapping("createObject")
    @ResponseBody
    public String createObject(@RequestParam("id") int id,
        @RequestParam("name") String name) throws NotFoundException{
    	ObjectService.createObject(new Object(id,name));
    	return "OK";
    }
    
    
    @RequestMapping("editObject")
    @ResponseBody
    public String editObject(@RequestParam("id") int id,
            @RequestParam("name") String name){
        	ObjectService.editObject(new Object(id,name));
        	return "OK";
        }
    
    @RequestMapping("deleteObject")
    @ResponseBody
    public String deleteObject(@RequestParam("id")int id) {
        ObjectService.deleteObject(id);
        return "OK";
    }


  

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void invalidParameterExceptionHandler() {  }
}


