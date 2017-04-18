package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.interfaces.ManualOrganizationEJBInterface;
import com.pensumorganizer.managedbeans.AutoPrioritizerBean;

@Singleton
public class ManualOrganizationEJBImpl implements ManualOrganizationEJBInterface {
	
	private static List<Course> notSelectedCourses;
	private static Map<Integer, List<Course>> reorganizedPensum 
					= AutoPrioritizerBean.apEJB.getOrganizedPensum();

    public void deleteCourse(Integer trimester, Course subject) {    	
    	if(notSelectedCourses == null){
    		notSelectedCourses = new ArrayList<Course>();
    	}
    	
    	reorganizedPensum.get(trimester).remove(subject);
    	notSelectedCourses.add(subject);
    }
	
	public void addCourse(Integer trimester, Course subject){
		System.out.println("Hey! Adding!");
		reorganizedPensum.get(trimester-1).add(subject);
    	notSelectedCourses.remove(subject);
    }
    
	public List<Course> getNotSelectedCourses() {
		return notSelectedCourses;
	}
	
	public Map<Integer, List<Course>> getReorganizedPensum() {
		return reorganizedPensum;
	}
	
}
