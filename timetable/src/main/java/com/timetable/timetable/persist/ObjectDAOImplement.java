package com.timetable.timetable.persist;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.timetable.timetable.model.Object;
import com.timetable.timetable.service.NotFoundException;
@Component
public class ObjectDAOImplement implements ObjectDAO{
	 private Map<Integer, Object> ObjectMap;

	    public ObjectDAOImplement(){
	    	ObjectMap = new HashMap<>();
	    	ObjectMap.put(1, new Object(1, "Informatikai rendszerek építése"));
	    	ObjectMap.put(2, new Object(2, "Haladó Java"));
	    	ObjectMap.put(3, new Object(3, "Erőforrás tervezés"));
	    	ObjectMap.put(4, new Object(4, "WEB technológiák 2"));
	    	ObjectMap.put(5, new Object(5, "Innováció menedzsment"));
	    	ObjectMap.put(6, new Object(6, "Bevezetés a CAD-be"));
	    	ObjectMap.put(7, new Object(7, "Termelő rendszerek irányítása"));
	    }

	    @Override
	    public Object getObject(int id) throws NotFoundException{
	    	if(!ObjectMap.keySet().contains(id)) {
	            throw new NotFoundException("Not found with this ID");
	            }
	    	 if (id < 1) { throw new InvalidParameterException("ID cannot be under 1");
	         }
	        return ObjectMap.get(id);
	    }

	    @Override
	    public List<Object> getAllObjects() {
	        return new ArrayList<Object>(ObjectMap.values());
	    }

	    @Override
	    public void createObject(Object Object) {
	    	ObjectMap.put(Object.getId(), Object);
	    }

	    @Override
	    public void updateObject(Object Object) {
	    	ObjectMap.replace(Object.getId(), Object);
	    }

	    @Override
	    public void deleteObject(int id){
	    	ObjectMap.remove(id);
	    }

}

