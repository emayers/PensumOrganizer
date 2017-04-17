package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.interfaces.ProgramEJBInterface;
import com.pensumorganizer.util.TrialDataSetter;

@Stateless
public class ProgramEJBImpl implements ProgramEJBInterface {

	private static Map<Integer, List<Course>> actualProgram = new LinkedHashMap<Integer, List<Course>>();

	public Map<Integer, List<Course>> getProgram(){
		Map<Integer, List<Course>> program = new HashMap<Integer, List<Course>>(actualProgram);

		return program;
	}
	
	public void recreateProgram(){
		List<Course> coursesProgram = TrialDataSetter.getCoursesProgram();
		
		for (Course course : coursesProgram) {
			int courseTrimester = course.getIdealTrimestrer() - 1;
			List<Course> currentTrimester = actualProgram.get(courseTrimester);
			
			if(currentTrimester == null){
				currentTrimester = new ArrayList<Course>();
			}
			
			if(!currentTrimester.contains(course)){
				currentTrimester.add(course);	
				actualProgram.put(courseTrimester, currentTrimester);
			}
		}
	}
	
}
