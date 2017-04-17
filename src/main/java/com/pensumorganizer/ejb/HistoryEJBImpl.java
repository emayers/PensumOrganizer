package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.interfaces.HistoryEJBInterface;
import com.pensumorganizer.util.TrialDataSetter;

@Stateless
public class HistoryEJBImpl implements HistoryEJBInterface{
	//TODO CHECK
	private static List<Course> coursesProgram;
	private static List<Course> takenCourses = new ArrayList<Course>();
	
	public Map<Integer, List<Course>> getHistory() {
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

		Map<Integer, List<Course>> trimester = new LinkedHashMap<Integer, List<Course>>();
		List<Course> history = new ArrayList<Course>();
		
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
