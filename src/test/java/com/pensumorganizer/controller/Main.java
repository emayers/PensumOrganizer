package com.pensumorganizer.controller;

import java.util.List;
import java.util.Map;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.AutoPrioritizerEJBImpl;

public class Main {

	public static void main(String[] args) {
		Map<Integer, List<Course>> trimesters = AutoPrioritizerEJBImpl.getOrganizedPensum();
		
		for (int index = 0; index < trimesters.size(); index++) {
			List<Course> current = trimesters.get(index);
			System.out.println("Trimestre " + (index+1));
			for (Course course : current) {
				System.out.println(course.getId());
			}
		}
		
//		Map<Integer, List<Course>> trimestersTaken = History.getHistory();
//		
//		System.out.println();
//		System.out.println(trimestersTaken.size());
//		
//		for (int index = 0; index < trimestersTaken.size(); index++) {
//			List<Course> current = trimestersTaken.get(index);
//			System.out.println("Trimestre " + (index+1));
//			for (Course course : current) {
//				System.out.println(course.getId());
//			}
//		}
	}

}
