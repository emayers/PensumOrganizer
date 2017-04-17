package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.interfaces.ManualOrganizationEJBInterface;

@Singleton
public class ManualOrganizationEJBImpl implements ManualOrganizationEJBInterface {

	@EJB
	private AutoPrioritizerEJBImpl apEJB = new AutoPrioritizerEJBImpl();
	
	private static List<Course> notSelectedCourses;

	public void addCourse(Integer trimester, Course subject){
		Map<Integer, List<Course>> reorganizedPensum = apEJB.getOrganizedPensum();
		List<Course> selectedTrimester = new ArrayList<Course>(reorganizedPensum.get(trimester-1));

    	selectedTrimester.add(subject);
    	notSelectedCourses.remove(subject);
    	
    	reorganizedPensum.put(trimester-1, selectedTrimester);
    	apEJB.setOrganizedPensum(reorganizedPensum);
    }
    
    public void deleteCourse(Integer trimester, Course subject) {
		Map<Integer, List<Course>> reorganizedPensum = apEJB.getOrganizedPensum();
    	List<Course> selectedTrimester = new ArrayList<Course>(reorganizedPensum.get(trimester));
    	
    	if(notSelectedCourses == null){
    		notSelectedCourses = new ArrayList<Course>();
    	}
    	
    	selectedTrimester.remove(subject);
    	notSelectedCourses.add(subject);

    	reorganizedPensum.put(trimester-1, selectedTrimester);
    	apEJB.setOrganizedPensum(reorganizedPensum);
    }
    
	public List<Course> getNotSelectedCourses() {
		return notSelectedCourses;
	}
	
}
