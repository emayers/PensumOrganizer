package com.pensumorganizer.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.StudentEJBImpl;

@ManagedBean
@SessionScoped
public class StudentBean {

	@EJB
	StudentEJBImpl sEJB = new StudentEJBImpl();
	
	public String getStudentName() {
		return sEJB.getStudentName();
	}
}
