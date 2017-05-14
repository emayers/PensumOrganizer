package com.pensumorganizer.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.StudentEJBImpl;

@ManagedBean
@SessionScoped
public class StudentBean implements Serializable{

	private static final long serialVersionUID = 3447816911793044537L;
	
	@EJB
	StudentEJBImpl sEJB = new StudentEJBImpl();
	
	public String getStudentName() {
		return sEJB.getStudentName();
	}
}
