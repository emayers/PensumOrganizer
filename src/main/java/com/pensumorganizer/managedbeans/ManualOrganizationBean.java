package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.push.annotation.Singleton;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.ManualOrganizer;

@ManagedBean
@SessionScoped
@Singleton
public class ManualOrganizationBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private static List<Course> notSelectedCourses;
//	
//	@PostConstruct
//	private void prepare(){
//		notSelectedCourses = ManualOrganizer.getNotSelectedCourses();
//	}
//	
//	public List<Course> getNotSelectedCourses() {
//		return notSelectedCourses;
//	}
//	
//	public void add(Map<Integer, List<Course>> pensum, Integer trimester, Course subject){
//		ManualOrganizer.addCourse(trimester, subject);
//	}
//	
//	public void delete(Integer trimester, Course subject) {
//		ManualOrganizer.deleteCourse(trimester, subject);
//	}
	
}
