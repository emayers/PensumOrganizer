package com.pensumorganizer.ejb.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.pensumorganizer.dao.Course;

@Remote
public interface HistoryEJBInterface {

	public Map<Integer, List<Course>> getHistory();
	
	public void recreateHistory();
	
}
