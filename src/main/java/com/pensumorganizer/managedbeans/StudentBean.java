package com.pensumorganizer.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Student;

@ManagedBean
@SessionScoped
public class StudentBean {

	private Student student = new Student("Juan", "Vasquez", 1037777, "AGO - OCT", 2012, "IDS", 2010);

	public Student getStudent() {
		return student;
	}
	
	public StudentBean() {
	}
	
}
