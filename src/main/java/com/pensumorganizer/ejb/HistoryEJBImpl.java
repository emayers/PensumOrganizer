package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.pensumorganizer.dao.HistoricDAO;
import com.pensumorganizer.ejb.interfaces.HistoryEJBInterface;
import com.pensumorganizer.managedbeans.AuthenticationBean;
import com.pensumorganizer.util.structures.Course;

@Stateless
public class HistoryEJBImpl implements HistoryEJBInterface{
	
	private static Map<Integer, List<Course>> actualHistory = new HashMap<Integer, List<Course>>();
	private static HistoricDAO studentHistory = new HistoricDAO();
	private static Integer studentId = AuthenticationBean.aEJB.getUserName();

	public Map<Integer, List<Course>> getHistory() {
		Map<Integer, List<Course>> history = new HashMap<Integer, List<Course>>(actualHistory);

		return history;
	}
	
	public void recreateHistory(){
		List<Course> takenCourses = getTakenCoursesList();
		//TODO CHECK
		for (Course course : takenCourses) {
			int courseTrimester = course.getTrimesterTaken() - 1;
			List<Course> currentTrimester = actualHistory.get(courseTrimester);
			
			if(currentTrimester == null){
				currentTrimester = new ArrayList<Course>();
			}
			
			if(!currentTrimester.contains(course)){
				currentTrimester.add(course);	
				actualHistory.put(courseTrimester, currentTrimester);
			}
		}
	}


	private static List<Course> getTakenCoursesList() {
//		List<Course> coursesProgram = TrialDataSetter.getCoursesProgram(),
//					 takenCourses = new ArrayList<Course>();
//		
//		for (Course courses : coursesProgram) {
//			if (courses.isTaken()) {
//				takenCourses.add(courses);
//			}
//		}
//		
//		return takenCourses;
		
		return studentHistory.getHistory(studentId);
	}

}
