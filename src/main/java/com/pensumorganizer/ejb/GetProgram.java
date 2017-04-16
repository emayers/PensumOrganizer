package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.util.TrialDataSetter;

public class GetProgram {

	public static Map<Integer, List<Course>> getData(){
		TrialDataSetter dataSetter = new TrialDataSetter();
		dataSetter.setData();
		List<Course> coursesProgram = TrialDataSetter.getCoursesProgram();
		Map<Integer, List<Course>> trimesters = new LinkedHashMap<Integer, List<Course>>();
		int trimesterCount = 0;
		int creditCount = 0;
		List<Course> currentTrimester = new ArrayList<Course>();
		
		for (Course course : coursesProgram) {
			currentTrimester.add(course);
			
			creditCount += course.getCredits();
			
			if(creditCount >= 19){
				trimesters.put(Integer.valueOf(trimesterCount), currentTrimester);
				trimesterCount++;
				creditCount = 0;
				currentTrimester = new ArrayList<Course>();
			}
		}
		
		return trimesters;
	}
	
}
