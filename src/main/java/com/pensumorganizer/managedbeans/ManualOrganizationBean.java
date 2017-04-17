package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;

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
	
	public void add(Integer trimester, Course subject){
		moEJB.addCourse(trimester, subject);
	}
	
	public void delete(Integer trimester, Course subject) {
		moEJB.deleteCourse(trimester, subject);
	}
	
}
