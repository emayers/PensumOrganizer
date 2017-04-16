package com.pensumorganizer.ejb;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.inject.Singleton;

import com.pensumorganizer.controller.AutoPrioritizer;
import com.pensumorganizer.dao.Course;

@ManagedBean
@SessionScoped
@Singleton
@Named(value = "autoPOBean")
public class AutoPOBean {

	static private Map<Integer, List<Course>> pensum;
	
	@PostConstruct
	public void prepare(){
		AutoPrioritizer.organizePensum();
		pensum = AutoPrioritizer.getOrganizedPensum();
	}
	
	public Map<Integer, List<Course>> getPensum() {
		return pensum;
	}
}
