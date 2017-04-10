package com.pensumorganizer.ejb;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.pensumorganizer.controller.PensumReorganizer;
import com.pensumorganizer.dao.Course;

@ManagedBean
@RequestScoped
public class AutoPOBean {
	static private Map<Integer, List<Course>> pensum = PensumReorganizer.getOrganizedPensum();
	
	public Map<Integer, List<Course>> getPensum() {
//		Map<Integer, List<Course>> newInstance = 
//				new LinkedHashMap<Integer, List<Course>>(trimester);
		
		return pensum;
	}

	public static void setPensum(Map<Integer, List<Course>> trimester) {
		AutoPOBean.pensum = trimester;
	}
}
