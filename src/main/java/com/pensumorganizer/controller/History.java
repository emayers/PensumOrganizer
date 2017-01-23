package com.pensumorganizer.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.util.TrialDataSetter;

public class History {

	private static List<Course> coursesProgram;
	private static List<Course> takenCourses = new ArrayList<Course>();
	
	public static Map<Integer, List<Course>> getHistory() {
		TrialDataSetter dataSetter = new TrialDataSetter();
		dataSetter.setData();
		coursesProgram = TrialDataSetter.getCoursesProgram();
		return createHistory();
	}

	private static void takenCoursesList() {

		for (Course courses : coursesProgram) {
			if (courses.isTaken()) {
				takenCourses.add(courses);
			}
		}

	}

	private static Map<Integer, List<Course>> createHistory() {
		takenCoursesList();
		Integer currentTrimester = 1;
//		int lastTrimester = (int)takenCourses.get(takenCourses.size() - 2).getTrimesterTaken();
//		int trimesterTaken = 0;

		Map<Integer, List<Course>> trimester = new LinkedHashMap<Integer, List<Course>>();
		List<Course> history = new ArrayList<Course>();
		
		//FIXME It's better if I use ListIterator
		Course element;
		
		for(int i = 0; i < takenCourses.size(); i++){
			element = takenCourses.get(i);
			
			if(element.getTrimesterTaken() == currentTrimester){
				history.add(element);
			}
			else{
				trimester.put(currentTrimester, history);
				history = new ArrayList<Course>();
				currentTrimester = element.getTrimesterTaken();
				history.add(element);
			}
			
		}
		
		return trimester;
	}

}
