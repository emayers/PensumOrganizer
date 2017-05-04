package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;

import com.pensumorganizer.ejb.interfaces.ManualOrganizationEJBInterface;
import com.pensumorganizer.managedbeans.AutoPrioritizerBean;
import com.pensumorganizer.managedbeans.HistoryBean;
import com.pensumorganizer.managedbeans.PensumBean;
import com.pensumorganizer.util.structures.Course;

@Singleton
public class ManualOrganizationEJBImpl implements ManualOrganizationEJBInterface {
	
	private static Integer selectedTrimester;
	private static Course clickedCourse;
	private static List<Course> notSelectedCourses;
	private static Map<Integer, List<Course>> reorganizedPensum = getClonedPensum();
	final private static int MAX_CREDITS_PER_TRIMESTER = getMaxCreditsPerTrimester();
	
    public void deleteCourse(Integer currentTrimester, Course subject) {    	
    	if(notSelectedCourses == null){
    		notSelectedCourses = new ArrayList<Course>();
    	}
    	
		System.out.println("Hey! Deleting!");
    	reorganizedPensum.get(currentTrimester).remove(subject);
    	notSelectedCourses.add(subject);
    }
	
	public void addCourse(){
		System.out.println("Hey! Adding!");
		
		if(validateInsertion()){
			reorganizedPensum.get(selectedTrimester - 1).add(clickedCourse);
	    	notSelectedCourses.remove(clickedCourse);
		}
		else{
			//TODO ERROR
		}
    }
    
	public String saveReorganization(){
		System.out.println("Hey! Saving!");
    	AutoPrioritizerBean.apEJB.setOrganizedPensum(reorganizedPensum);
    	return "VistaPOAuto";
	}
	
	public Map<Integer, List<Course>> getReorganizedPensum(){
		return reorganizedPensum;
	}
	
	public List<Course> getNotSelectedCourses(){
		return notSelectedCourses;
	}
	
	public Integer getSelectedTrimester() {
		return selectedTrimester;
	}

	public void setSelectedTrimester(Integer selectedTrimester) {
		ManualOrganizationEJBImpl.selectedTrimester = selectedTrimester;
	}
	
	public Course getClickedCourse() {
		return clickedCourse;
	}

	public void setClickedCourse(Course clickedCourse) {
		ManualOrganizationEJBImpl.clickedCourse = clickedCourse;
	}
	
	private static Map<Integer, List<Course>> getClonedPensum(){
		Map<Integer, List<Course>> originalPensum = AutoPrioritizerBean.apEJB.getOrganizedPensum();
		Map<Integer, List<Course>> clonedPensum = new HashMap<Integer, List<Course>>();
		
		for (int index = 0; index < originalPensum.size(); index++) {
			List<Course> originalTrimester = (ArrayList<Course>) originalPensum.get(index);
			List<Course> clonedTrimester = new ArrayList<Course>(originalTrimester);

			Collections.copy(clonedTrimester, originalTrimester);
			clonedPensum.put(index, clonedTrimester);
		}
		
		return clonedPensum;
	}
	
	private static boolean validateInsertion(){
		if(exceedsCreditsLimit()){
			return false;
		}
		else if(requirementsNotMet()){
			return false;
		}
		
		return true;
	}
	
	private static boolean exceedsCreditsLimit(){
		List<Course> currentTrimester = reorganizedPensum.get(selectedTrimester - 1);
		int trimesterCredits = 0;

		for (Course course : currentTrimester) {
			trimesterCredits += course.getCredits();
		}
		
		if((trimesterCredits + clickedCourse.getCredits()) > MAX_CREDITS_PER_TRIMESTER){
			return true;
		}
		else{
			return false;
		}
	}
	
	private static boolean requirementsNotMet(){
		//TODO ENCADENAMIENTO PROYECTOS FINALES
		if(getApprovedCredits() < clickedCourse.getCreditsReq()){
			return true;
		}
		
		for(int indice = 0; indice < selectedTrimester; indice++){
			List<Course> currentTrimester = reorganizedPensum.get(indice);
			
			for (Course course : currentTrimester) {
				if(clickedCourse.getPreqID().contains(course.getId())){
					return true;
				}
				else if(clickedCourse.getCoReqID().contains(course.getId())){
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static int getMaxCreditsPerTrimester(){
		Map<Integer, List<Course>> studentPensum = PensumBean.pEJB.getPensum();
		int maxCredits = 0;
		
		for(int indice = 0; indice < studentPensum.size(); indice++){
			List<Course> currentTrimester = studentPensum.get(indice);
			int currentCredits = 0;
			
			for (Course course : currentTrimester) {
				currentCredits += course.getCredits();
			}
			
			maxCredits = Math.max(maxCredits, currentCredits);
		}
		
		return maxCredits;
	}
	
	private static int getApprovedCredits(){
		List<Course> approvedCourses = HistoryBean.hEJB.getApprovedCourses();
		int approvedCredits = 0;
		
		for (Course course : approvedCourses) {
			approvedCredits += course.getCredits();
		}
		
		return approvedCredits;
	}
}

