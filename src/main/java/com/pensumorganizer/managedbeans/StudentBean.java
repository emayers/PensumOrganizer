package com.pensumorganizer.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Student;

@ManagedBean
@SessionScoped
public class StudentBean {

//	@EJB
//	StudentEJBImpl sEJB = new StudentEJBImpl();
//	
//	public String getStudentName() {
//		return sEJB.getStudentName();
//	}
	
	Student student = new Student("Sara", "Fermin", 1053691, "IDS", 2013, "IDS", 2010);
	
	public Student getStudent(){
		return student;
	}
}
