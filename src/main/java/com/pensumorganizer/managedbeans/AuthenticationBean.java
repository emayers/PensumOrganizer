package com.pensumorganizer.managedbeans;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.AuthenticationEJBImpl;

@ManagedBean
@SessionScoped
public class AuthenticationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	public static AuthenticationEJBImpl aEJB = new AuthenticationEJBImpl();

    public void submit() {    	
    	aEJB.submit();
    }
    
    @PreDestroy
    public void logOut(){
    	aEJB.logOut();
    }
    
    public String getStudentName() {
    	return aEJB.getStudentName();
    }

	public Integer getUserName() {
		return aEJB.getUserName();
	}

	public Integer getPassword() {
		return aEJB.getPassword();
	}
	
	public void setUserName(Integer userName) {
		aEJB.setUserName(userName);
	}

	public void setPassword(Integer password) {
		aEJB.setPassword(password);
	}
	
	public String getName() {
		return aEJB.getName();
	}
	
	public String getGPA() {
		return aEJB.getGPA();
	}
	
	public int getCoursedTrimesters() {
		return aEJB.getCoursedTrimesters();
	}
	
	public void redirectDashboard(){
		aEJB.redirectDashboard();
	}
	
	public void redirectHelp(){
		aEJB.redirectHelp();
	}

}
