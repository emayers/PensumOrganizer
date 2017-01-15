package com.pensumorganizer.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PensumReorganizer {
	final private static int IDEAL_TOTAL_TRIMESTERS = 14,
							 MAX_CREDITS_PER_TRIMESTER = 19,
							 HIGH_PRIORITY_WEIGHT = 10,
							 LOW_PRIORITY_WEIGHT = 5; 
	private static List<Course> coursesProgram = TrialDataSetter.coursesProgram;
	
	public PriorityQueue<Course> prioritizeCourses(){
		PriorityQueue<Course> coursesToTake = 
				new PriorityQueue<Course>(new CourseComparator());
		
		Course currentCourse;

		for (int index = coursesProgram.size() - 1; index > 0; index--) {
			currentCourse = coursesProgram.get(index);
			
			if(!currentCourse.isTaken()){
				int trimesterWeight = getTrimesterWeight(currentCourse);
				int creditsWeight = currentCourse.getCredits();
				int chainWeight = getChainWeight(currentCourse, coursesProgram);
				
				currentCourse.setWeight(trimesterWeight + creditsWeight + chainWeight);
				coursesToTake.add(currentCourse);
			}
		}
		
		return coursesToTake;
	}
	
	public Map<Integer, List<Course>> 
	reorganizePensum(PriorityQueue<Course> prioritizedCourses){
		
		Map<Integer, List<Course>> trimesters = 
				new LinkedHashMap<Integer, List<Course>>();
		List<Course> currentTrimester = new ArrayList<Course>();
		
		int trimesterCount = 0;
		int creditCount = 0;

		while(!prioritizedCourses.isEmpty()){
			Course currentCourse = 
					findNextAvailableCourse(prioritizedCourses, creditCount);
			
			if(currentCourse == null){
				trimesters.put(Integer.valueOf(trimesterCount), currentTrimester);
				updatePrerrequisitesStatus(prioritizedCourses, currentTrimester);
				currentTrimester = new ArrayList<Course>();
				creditCount = 0;
				trimesterCount++;
			}
			else{
				currentTrimester.add(currentCourse);
				prioritizedCourses.remove(currentCourse);
				creditCount += currentCourse.getCredits();			
			}	
		}
		
		trimesters.putIfAbsent(Integer.valueOf(trimesterCount), currentTrimester);
		
		return trimesters;
	}
	
	private static void updatePrerrequisitesStatus(PriorityQueue<Course> prioritizedCourses,
			List<Course> currentTrimester){

		for (Course takenCourse : currentTrimester) {
			for (Course course : prioritizedCourses) {
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
			
			if(currentCourse.isPreqTaken()){
				if((creditCount + currentCourse.getCredits()) <= 
						MAX_CREDITS_PER_TRIMESTER){
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
}
