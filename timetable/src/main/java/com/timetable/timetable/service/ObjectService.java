package com.timetable.timetable.service;

import java.util.List;

import com.timetable.timetable.model.Object;


public interface ObjectService {
	List<Object> listAllObjects();
	Object getObject(int id) throws NotFoundException;

    void createObject(Object Object) throws NotFoundException;

    void editObject(Object Object);

    void deleteObject(int id);

}
