package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.interfaces.ManualOrganizationEJBInterface;
import com.pensumorganizer.managedbeans.AutoPrioritizerBean;

@Singleton
public class ManualOrganizationEJBImpl implements ManualOrganizationEJBInterface {
	
	private static List<Course> notSelectedCourses;
	private static Integer selectedTrimester;
	private static Map<Integer, List<Course>> reorganizedPensum 
					= new HashMap<Integer, List<Course>>(AutoPrioritizerBean.apEJB.getOrganizedPensum());

    public void deleteCourse(Integer trimester, Course subject) {    	
    	if(notSelectedCourses == null){
    		notSelectedCourses = new ArrayList<Course>();
    	}
    	
    	reorganizedPensum.get(trimester).remove(subject);
    	notSelectedCourses.add(subject);
    	return;
    }
	
	public void addCourse(Course subject){
		System.out.println("Hey! adding!");
		reorganizedPensum.get(selectedTrimester-1).add(subject);
    	notSelectedCourses.remove(subject);
    	return;
    }
	
	public String saveReorganization(){
		System.out.println("Hey! Saving!");
    	AutoPrioritizerBean.apEJB.setOrganizedPensum(reorganizedPensum);
    	return "VistaPOAuto";
	}
    
	public List<Course> getNotSelectedCourses() {
		return notSelectedCourses;
	}
	
	public Map<Integer, List<Course>> getReorganizedPensum() {
		return reorganizedPensum;
	}

	public Integer getSelectedTrimester() {
		return selectedTrimester;
	}

	public void setSelectedTrimester(Integer selectedTrimester) {
		ManualOrganizationEJBImpl.selectedTrimester = selectedTrimester;
	}

	
}
