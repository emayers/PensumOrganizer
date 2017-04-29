package com.pensumorganizer.ejb;

import javax.ejb.Stateless;

import com.pensumorganizer.dao.EstudianteProgramaDao;
import com.pensumorganizer.ejb.interfaces.StudentEJBInterface;
import com.pensumorganizer.managedbeans.AuthenticationBean;

@Stateless
public class StudentEJBImpl implements StudentEJBInterface {
	
	private static EstudianteProgramaDao studentDao = new EstudianteProgramaDao();
	private static Integer studentId = AuthenticationBean.aEJB.getUserName();

    public String getStudentName() {
    	return studentDao.getName(studentId);
    }
}
