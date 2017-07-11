package com.pensumorganizer.ejb;

import javax.ejb.Stateless;

import com.pensumorganizer.dao.StudentsDAO;
import com.pensumorganizer.ejb.interfaces.StudentEJBInterface;
import com.pensumorganizer.managedbeans.AuthenticationBean;

@Stateless
public class StudentEJBImpl implements StudentEJBInterface {
	
	private static StudentsDAO students = new StudentsDAO();
	private static Integer studentId = AuthenticationBean.aEJB.getUserName();

    public String getStudentName() {
    	System.out.println(studentId.toString()+" studentEJB");
    	return students.getName(studentId);
    }
}
