package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.pensumorganizer.dao.StudentsDAO;
import com.pensumorganizer.dao.PensumsDAO;
import com.pensumorganizer.dao.ProgramsDAO;
import com.pensumorganizer.ejb.interfaces.PensumEJBInterface;
import com.pensumorganizer.managedbeans.AuthenticationBean;
import com.pensumorganizer.util.structures.Course;

@Stateless
public class PensumEJBImpl implements PensumEJBInterface {

	private static Map<Integer, List<Course>> actualPensum = new LinkedHashMap<Integer, List<Course>>();
	private static PensumsDAO pensums = new PensumsDAO();
	private static ProgramsDAO programs = new ProgramsDAO();
	private static StudentsDAO students = new StudentsDAO();
	private static Integer studentId = AuthenticationBean.aEJB.getUserName();

	public Map<Integer, List<Course>> getPensum(){
		Map<Integer, List<Course>> program = new HashMap<Integer, List<Course>>(actualPensum);

		return program;
	}
	
	public void recreatePensum(){
//		List<Course> coursesProgram = TrialDataSetter.getCoursesProgram();
		List<Course> coursesProgram = pensums.getCourses(students.getProgramCode(studentId), 
														students.getProgramVersion(studentId));
		
		for (Course course : coursesProgram) {
			int courseTrimester = course.getIdealTrimestrer() - 1;
			List<Course> currentTrimester = actualPensum.get(courseTrimester);
			
			if(currentTrimester == null){
				currentTrimester = new ArrayList<Course>();
			}
			
			if(!currentTrimester.contains(course)){
				currentTrimester.add(course);	
				actualPensum.put(courseTrimester, currentTrimester);
			}
		}
	}
	
	public String getPensumName(){
		return programs.getProgramName(getStudentProgram());
	}
	
	public int getPensumTotalTrimesters(){
		return programs.getTotalTrimesters(getStudentProgram());
	}
	
	private String getStudentProgram(){
		return students.getProgramCode(studentId);
	}
}
