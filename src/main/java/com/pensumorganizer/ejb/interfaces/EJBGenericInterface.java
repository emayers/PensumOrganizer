package com.pensumorganizer.ejb.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.pensumorganizer.dao.Course;

@Remote
public interface EJBGenericInterface {
	
	public Map<Integer, List<Course>> getOrganizedPensum();
	
	public void setOrganizedPensum(Map<Integer, List<Course>> pensum);
	
	public void organizePensum();
}
