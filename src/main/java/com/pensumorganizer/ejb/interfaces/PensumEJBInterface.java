package com.pensumorganizer.ejb.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.pensumorganizer.util.structures.Course;

@Remote
public interface PensumEJBInterface {
	
	public Map<Integer, List<Course>> getPensum();
	
	public void recreatePensum(int studentId);
	
	public String getPensumName(int studentId);
	
	public int getPensumTotalTrimesters(int studentId);
	
	public int getPensumPermanence(int studentId);
	
	public int getPensumTotalCredits(int studentId);
	
	public int getPensumTotalCourses(int studentId);
}
