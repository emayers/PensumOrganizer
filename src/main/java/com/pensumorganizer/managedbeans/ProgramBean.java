package com.pensumorganizer.managedbeans;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.GetProgram;

@ManagedBean
@SessionScoped
public class ProgramBean {
	Map<Integer, List<Course>> trimester = GetProgram.getData();
	
	public Map<Integer, List<Course>> getTrimester() {
		Map<Integer, List<Course>> newInstance = 
				new LinkedHashMap<Integer, List<Course>>(trimester);
		
		return newInstance;
	}
}
