package com.pensumorganizer.util;

import java.util.Comparator;

import com.pensumorganizer.util.structures.Course;

public class CourseComparator implements Comparator<Course> {

	private static final int LOWER = -1,
							 HIGHER = 1,
							 EQUAL = 0;
	@Override
	public int compare(Course courseOne, Course courseTwo) {
		int courseOneWeight = courseOne.getWeight(),
				courseTwoWeight = courseTwo.getWeight();
		
		if(courseOneWeight < courseTwoWeight){
			return HIGHER;
		}
		
		if(courseOneWeight > courseTwoWeight){
			return LOWER;
		}
		
		return EQUAL;
	}
}
