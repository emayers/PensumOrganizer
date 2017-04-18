package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.Collections;
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
	private static Map<Integer, List<Course>> reorganizedPensum = getClonedPensum();
	
    public void deleteCourse(Integer trimester, Course subject) {    	
    	if(notSelectedCourses == null){
    		notSelectedCourses = new ArrayList<Course>();
    	}
    	
		System.out.println("Hey! Deleting!");
    	reorganizedPensum.get(trimester).remove(subject);
    	notSelectedCourses.add(subject);
    }
	
	public void addCourse(Integer trimester, Course subject){
		System.out.println("Hey! Adding!");
		reorganizedPensum.get(trimester-1).add(subject);
    	notSelectedCourses.remove(subject);
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
	
	private static Map<Integer, List<Course>> getClonedPensum(){
		Map<Integer, List<Course>> originalPensum = AutoPrioritizerBean.apEJB.getOrganizedPensum();
		Map<Integer, List<Course>> clonedPensum = new HashMap<Integer, List<Course>>();
		
		for (int index = 0; index < originalPensum.size(); index++) {
			List<Course> originalTrimester = (ArrayList<Course>) originalPensum.get(index);
			List<Course> clonedTrimester = new ArrayList<Course>(originalTrimester);

			Collections.copy(clonedTrimester, originalTrimester);
			clonedPensum.put(index, clonedTrimester);
		}
		
		return clonedPensum;
	}
	
}
