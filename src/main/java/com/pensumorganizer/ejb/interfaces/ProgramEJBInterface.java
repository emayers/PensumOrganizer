package com.pensumorganizer.ejb.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.pensumorganizer.dao.Course;

@Remote
public interface ProgramEJBInterface {
	
	public Map<Integer, List<Course>> getProgram();
	
	public void recreateProgram();
	
}
