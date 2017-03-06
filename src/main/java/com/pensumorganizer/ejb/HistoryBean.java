package com.pensumorganizer.ejb;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.controller.History;
import com.pensumorganizer.dao.Course;

@ManagedBean
@SessionScoped
public class HistoryBean {
	Map<Integer, List<Course>> trimester = History.getHistory();
	
	public Map<Integer, List<Course>> getTrimester() {
		Map<Integer, List<Course>> newInstance = 
				new LinkedHashMap<Integer, List<Course>>(trimester);
		
		return newInstance;
	}
}
