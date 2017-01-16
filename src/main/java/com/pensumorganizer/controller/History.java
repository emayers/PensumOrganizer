package com.pensumorganizer.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class History {

	private static List<Course> coursesProgram;
	private static List<Course> takenCourses = new ArrayList<Course>();

	public static void takenCoursesList() {

		for (Course courses : coursesProgram) {
			if (courses.isTaken()) {
				takenCourses.add(courses);
			}
		}

	}

	public static Map<Integer, List<Course>> getHistory() {
		coursesProgram = TrialDataSetter.coursesProgram;
		return History();
	}

	private static Map<Integer, List<Course>> History() {
		takenCoursesList();
		Integer currentTrimester = 1;
		int lastTrimester = (int)takenCourses.get(takenCourses.size() - 2).getTrimesterTaken();
		int trimesterTaken = 0;

		Map<Integer, List<Course>> Trimester = new LinkedHashMap<Integer, List<Course>>();
		List<Course> history = new ArrayList<Course>();
		
		//FIXME It's better if I use ListIterator
		Course element;
		
		for(int i = 0; i < takenCourses.size(); i++){
			
			
			element = takenCourses.get(i);
			if(element.getTrimesterTaken() == currentTrimester ){
				history.add(element);
			}else{
				Trimester.put(currentTrimester, history);
				history = new ArrayList<Course>();
				currentTrimester = element.getTrimesterTaken();
				history.add(element);
			}
			
		}
		
		return Trimester;
	}

}
