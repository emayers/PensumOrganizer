package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.ManualOrganizationEJBImpl;
import com.pensumorganizer.util.structures.Course;

@ManagedBean
@SessionScoped
public class ManualOrganizationBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	ManualOrganizationEJBImpl moEJB = new ManualOrganizationEJBImpl();
	
	public List<Course> getNotSelectedCourses() {
		return moEJB.getNotSelectedCourses();
	}
	
	public Map<Integer, List<Course>> getReorganizedPensum(){
		return moEJB.getReorganizedPensum();
	}
	
	public String saveReorganization(){
		return moEJB.saveReorganization();
	}
	
	public void add(){
		moEJB.addCourse();
	}
	
	public void delete(Integer trimester, Course subject) {
		moEJB.deleteCourse(trimester, subject);
	}
	
	public Integer getSelectedTrimester(){
		return moEJB.getSelectedTrimester();
	}
	
	public void setSelectedTrimester(Integer selectedTrimester){
		moEJB.setSelectedTrimester(selectedTrimester);
	}
	
	public Course getClickedCourse() {
		return moEJB.getClickedCourse();
	}

	public void setClickedCourse(Course clickedCourse) {
		moEJB.setClickedCourse(clickedCourse);
	}
}

