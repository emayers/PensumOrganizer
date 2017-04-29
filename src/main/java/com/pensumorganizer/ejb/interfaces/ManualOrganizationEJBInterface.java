package com.pensumorganizer.ejb.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import com.pensumorganizer.dao.Course;

@Remote
public interface ManualOrganizationEJBInterface {
	
	public void addCourse(Course subject);
    
    public void deleteCourse(Integer trimester, Course subject);
    
    public String saveReorganization();
    
	public List<Course> getNotSelectedCourses();
	
	public Map<Integer, List<Course>> getReorganizedPensum();
	
	public Integer getSelectedTrimester();
	
	public void setSelectedTrimester(Integer selectedTrimester);
}
