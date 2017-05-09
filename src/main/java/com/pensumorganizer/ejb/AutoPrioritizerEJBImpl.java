package com.pensumorganizer.ejb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javax.ejb.Singleton;

import com.pensumorganizer.dao.CoursesToTakeDAO;
import com.pensumorganizer.dao.ReorganizationsDAO;
import com.pensumorganizer.ejb.interfaces.AutoPrioritizerEJBInterface;
import com.pensumorganizer.managedbeans.AuthenticationBean;
import com.pensumorganizer.managedbeans.PensumBean;
import com.pensumorganizer.util.CourseComparator;
import com.pensumorganizer.util.structures.Course;

@Singleton
public class AutoPrioritizerEJBImpl implements AutoPrioritizerEJBInterface {
	private static CoursesToTakeDAO notTakenCourses = new CoursesToTakeDAO();
	private static ReorganizationsDAO studentsOrganizations = new ReorganizationsDAO();
	private static int studentId = AuthenticationBean.aEJB.getUserName();
	final private static int IDEAL_TOTAL_TRIMESTERS = PensumBean.pEJB.getPensumTotalTrimesters(),
							 MAX_CREDITS_PER_TRIMESTER = getMaxCreditsPerTrimester(),
							 HIGH_PRIORITY_WEIGHT = 10,
							 LOW_PRIORITY_WEIGHT = 5; 
	
	private static Map<Integer, List<Course>> actualReorganizedPensum = studentsOrganizations.getOrganization(studentId);
	
	public Map<Integer, List<Course>> getOrganizedPensum(){
		Map<Integer, List<Course>> pensum = new HashMap<Integer, List<Course>>(actualReorganizedPensum);

		return pensum;
	}
	
	public String organizePensum(){
		PriorityQueue<Course> orderedCourses = prioritizeCourses();
		actualReorganizedPensum = reorganizePensum(orderedCourses);
		
		return "VistaPOAuto";
	}
	
	public void setOrganizedPensum(Map<Integer, List<Course>> pensum){
		actualReorganizedPensum = pensum;
	}
	
	private static PriorityQueue<Course> prioritizeCourses(){
		PriorityQueue<Course> prioritizedCourses = 
				new PriorityQueue<Course>(new CourseComparator());
		List<Course> coursesToTake = notTakenCourses.getSubjectsToTake(studentId);

		for (Course currentCourse : coursesToTake) {	
			int trimesterWeight = getTrimesterWeight(currentCourse);
			int creditsWeight = currentCourse.getCredits();
			int chainWeight = getChainWeight(currentCourse, coursesToTake);
			
			if(!currentCourse.getId().equals("PRO3")){
				currentCourse.setWeight( Math.abs(trimesterWeight + creditsWeight + chainWeight));
			}else{
				currentCourse.setWeight(Math.abs(trimesterWeight + creditsWeight + chainWeight)*7);
			}
			prioritizedCourses.add(currentCourse);

		}
		
		return prioritizedCourses;
	}
	
	private static Map<Integer, List<Course>> reorganizePensum(PriorityQueue<Course> prioritizedCourses){
		Map<Integer, List<Course>> trimesters = new LinkedHashMap<Integer, List<Course>>();
		List<Course> currentTrimester = new ArrayList<Course>();
		
		int trimesterCount = 0;
		int creditCount = 0;
		int totalCredits = 0;

		while(!prioritizedCourses.isEmpty()){
			Course currentCourse = 
					findNextAvailableCourse(prioritizedCourses, creditCount);
			
			if(currentCourse == null){
				trimesters.put(Integer.valueOf(trimesterCount), currentTrimester);
				updatePrerrequisitesStatus(prioritizedCourses, currentTrimester, totalCredits);
				currentTrimester = new ArrayList<Course>();
				creditCount = 0;
				trimesterCount++;
			}
			else{
				currentTrimester.add(currentCourse);
				prioritizedCourses.remove(currentCourse);
				creditCount += currentCourse.getCredits();
				totalCredits += currentCourse.getCredits();
			}	
		}
		
		trimesters.putIfAbsent(Integer.valueOf(trimesterCount), currentTrimester);
		
		return trimesters;
	}
	
	private static void updatePrerrequisitesStatus(PriorityQueue<Course> prioritizedCourses,
			List<Course> currentTrimester, int totalCredits){

		for (Course takenCourse : currentTrimester) {
			for (Course course : prioritizedCourses) {
				if(course.getCreditsReq() == totalCredits){
					course.setCreditsReqReached(true);
				}
				if(course.getPreqID().contains(takenCourse.getId())){
					course.setPreqTaken(true);
				}
			}
		}
	}
	
	private static Course findNextAvailableCourse(PriorityQueue<Course> prioritizedCourses,
			int creditCount){
		PriorityQueue<Course> temporalQueue = new PriorityQueue<Course>(prioritizedCourses);
		Course currentCourse = null;
		
		while(!temporalQueue.isEmpty()){
			currentCourse = temporalQueue.remove();
			
			if(currentCourse.isCreditsReqReached()){
				break;
			} 
			else if(currentCourse.isPreqTaken()){
				
				if((creditCount + currentCourse.getCredits()) <= 
						MAX_CREDITS_PER_TRIMESTER){
					break;
				}
				else if(prioritizedCourses.size()<2 && currentCourse.getCredits()<5){
					break;
				}
			}
			
			currentCourse = null;
		}

		return currentCourse;
	}
	
	private static int getTrimesterWeight(Course course){
		return (IDEAL_TOTAL_TRIMESTERS - course.getIdealTrimestrer()) * LOW_PRIORITY_WEIGHT;
	}
	
	private static int getChainWeight(Course course, List<Course> allCourses){
		Course currentCourse;
		
		int chainWeight = 0,
			coursePosition = allCourses.indexOf(course);

		for (int index = coursePosition + 1; index < allCourses.size(); index++) {
			currentCourse = allCourses.get(index);
			
			if(currentCourse.getPreqID().contains(course.getId())){
				chainWeight += (currentCourse.getWeight() + 1);
			}
		}
		
		return chainWeight * HIGH_PRIORITY_WEIGHT;
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
}
