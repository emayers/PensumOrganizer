package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.ManualOrganizationEJBImpl;

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
	
//	public String saveReorganization(){
//		return moEJB.saveReorganization();
//	}
//	
	public void add(Integer trimester, Course subject){
		moEJB.addCourse(trimester, subject);
	}
	
	public void delete(Integer trimester, Course subject) {
		moEJB.deleteCourse(trimester, subject);
	}
	
}
