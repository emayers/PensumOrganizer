package com.pensumorganizer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pensumorganizer.dao.Course;

public class ManualOrganizer {

//	private static List<Course> notSelectedCourses = new ArrayList<Course>();

//	public static void addCourse(Integer trimester, Course subject){
//		Map<Integer, List<Course>> reorganizedPensum = AutoPrioritizer.getOrganizedPensum();
//		List<Course> selectedTrimester = new ArrayList<Course>(reorganizedPensum.get(trimester-1));
//
//    	selectedTrimester.add(subject);
//    	notSelectedCourses.remove(subject);
//    	
//    	reorganizedPensum.put(trimester, selectedTrimester);
//    	AutoPrioritizer.setOrganizedPensum(reorganizedPensum);
//    }
//    
//    public static void deleteCourse(Integer trimester, Course subject) {
//		Map<Integer, List<Course>> reorganizedPensum = AutoPrioritizer.getOrganizedPensum();
//    	List<Course> selectedTrimester = new ArrayList<Course>(reorganizedPensum.get(trimester));
//    	
//    	selectedTrimester.remove(subject);
//    	notSelectedCourses.add(subject);
//
//    	reorganizedPensum.put(trimester, selectedTrimester);
//    	AutoPrioritizer.setOrganizedPensum(reorganizedPensum);
//    }
//    
//	public static List<Course> getNotSelectedCourses() {
//		return notSelectedCourses;
//	}
	
}
