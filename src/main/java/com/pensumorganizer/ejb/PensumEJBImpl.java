package com.pensumorganizer.ejb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

import com.pensumorganizer.dao.PensumsDAO;
import com.pensumorganizer.dao.ProgramsDAO;
import com.pensumorganizer.dao.StudentsDAO;
import com.pensumorganizer.ejb.interfaces.PensumEJBInterface;
import com.pensumorganizer.util.structures.Course;

@Stateless
public class PensumEJBImpl implements PensumEJBInterface {

	private static Map<Integer, List<Course>> actualPensum = new LinkedHashMap<Integer, List<Course>>();
	private static PensumsDAO pensums = new PensumsDAO();
	private static ProgramsDAO programs = new ProgramsDAO();
	private static StudentsDAO students = new StudentsDAO();

	public Map<Integer, List<Course>> getPensum(){
		Map<Integer, List<Course>> program = new HashMap<Integer, List<Course>>(actualPensum);

		return program;
	}
	
	public void recreatePensum(int studentId){
		actualPensum.clear();

		List<Course> coursesProgram = pensums.getCourses(students.getProgramCode(studentId));
		
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
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("ProgramaCarrera.xhtml");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getPensumName(int studentId){
		return programs.getProgramName(getProgramCode(studentId));
	}
	
	public int getPensumTotalTrimesters(int studentId){
		int totalTrimesters = programs.getTotalTrimesters(getProgramCode(studentId));
		
		System.out.println("Total trimestres: " + totalTrimesters);
		
		return totalTrimesters;
	}
	
	public int getPensumPermanence(int studentId){
		int totalTrimesters = programs.getTotalTrimesters(getProgramCode(studentId));
		totalTrimesters = (int)(totalTrimesters * 1.5); //FORCE
		
		System.out.println("Total permanencia: " + totalTrimesters);
		
		return totalTrimesters;
	}

	public int getPensumTotalCredits(int studentId) {
		int totalCredits = programs.getProgramCredits(getProgramCode(studentId));
		
		System.out.println("Total creditos: " + totalCredits);
		
		return totalCredits;
	}

	public int getPensumTotalCourses(int studentId) {
		int totalCourses = programs.getTotalSubjects(getProgramCode(studentId));
		
		System.out.println("Total materias: " + totalCourses);
		
		return totalCourses;
	}
	
	private String getProgramCode(int studentId){
		return students.getProgramCode(studentId);
	}
}
