package com.pensumorganizer.ejb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.pensumorganizer.dao.Course;

@ManagedBean
@RequestScoped
public class ManualOrganizationBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Course> notSelectedCourses = new ArrayList<Course>();
	
    public void add(LinkedHashMap<Integer, List<Course>> reorganizedPensum, Integer trimester, Course subject){
    	List<Course> selectedTrimester = reorganizedPensum.get(trimester-1);
    	
    	selectedTrimester.add(subject);
    	notSelectedCourses.remove(subject);
    	
    	reorganizedPensum.put(trimester, selectedTrimester);
    	AutoPOBean.setPensum(reorganizedPensum);
    }
    
    public void delete(LinkedHashMap<Integer, List<Course>> reorganizedPensum, Integer trimester, Course subject) {
    	List<Course> selectedTrimester = reorganizedPensum.get(trimester);
    	
    	selectedTrimester.remove(subject);
    	notSelectedCourses.add(subject);

    	reorganizedPensum.put(trimester, selectedTrimester);
    	AutoPOBean.setPensum(reorganizedPensum);
    }

	public List<Course> getNotSelectedCourses() {
		return notSelectedCourses;
	}

	public void setNotSelectedCourses(List<Course> notSelectedCourses) {
		this.notSelectedCourses = notSelectedCourses;
	}
	

}
