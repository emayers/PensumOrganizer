package com.pensumorganizer.ejb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.faces.context.FacesContext;

import com.pensumorganizer.dao.HistoricDAO;
import com.pensumorganizer.ejb.interfaces.HistoryEJBInterface;
import com.pensumorganizer.util.structures.Course;

@Stateless
public class HistoryEJBImpl implements HistoryEJBInterface{
	
	private static Map<Integer, List<Course>> actualHistory = new HashMap<Integer, List<Course>>();
	private static HistoricDAO studentHistory = new HistoricDAO();

	public Map<Integer, List<Course>> getHistory() {
		Map<Integer, List<Course>> history = new HashMap<Integer, List<Course>>(actualHistory);

		return history;
	}
	
	public void recreateHistory(int studentId){
		actualHistory.clear();
		
		List<Course> takenCourses = getTakenCourses(studentId);
		System.out.println("Lista " + takenCourses);
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
		
		System.out.println("Size history " + actualHistory.size());
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("Historial.xhtml");
		} 
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public int getApprovedCredits(int studentId){
		List<Course> approvedCourses = getApprovedCourses(studentId);
		int creditCount = 0;
		
		for (Course course : approvedCourses) {
			creditCount += course.getCredits();
		}
		
		System.out.println("Creditos aprobados " + creditCount);
		
		return creditCount;
	}
	
	public int getTotalApprovedCourses(int studentId){
		int materiasAprobadas = getApprovedCourses(studentId).size();
		
		System.out.println("Total materias aprobadas: " + materiasAprobadas);
		
		return getApprovedCourses(studentId).size();
	}

	private static List<Course> getTakenCourses(int studentId) {
		System.out.println("Searching taken courses");
		System.out.println("EJB studentID: " + studentId);
		List<Course> takenCourses = studentHistory.getHistory(studentId);
		
		for (Course course : takenCourses) {
			System.out.println("Curso en historial: " + course.getName());
		}
		
		return takenCourses;
	}
	
	private List<Course> getApprovedCourses(int studentId){
		List<Course> approvedCourses = studentHistory.getApprovedCourses(studentId);
		
		for (Course course : approvedCourses) {
			System.out.println("Materia aprobada: " + course.getName());
		}
		
		return approvedCourses;
	}

}
