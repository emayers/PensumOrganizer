package com.pensumorganizer.ejb.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.pensumorganizer.dao.Course;

@Remote
public interface ManualOrganizationEJBInterface {
	
	public void addCourse(Integer trimester, Course subject);
    
    public void deleteCourse(Integer trimester, Course subject);
    
	public List<Course> getNotSelectedCourses();
}
