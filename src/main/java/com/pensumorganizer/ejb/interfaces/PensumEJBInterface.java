package com.pensumorganizer.ejb.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.pensumorganizer.util.structures.Course;

@Remote
public interface PensumEJBInterface {
	
	public Map<Integer, List<Course>> getPensum();
	
	public void recreatePensum();
	
}
