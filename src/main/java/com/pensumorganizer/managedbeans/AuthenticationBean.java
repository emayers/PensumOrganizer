package com.pensumorganizer.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.AuthenticationEJBImpl;

@ManagedBean
@SessionScoped
public class AuthenticationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	public static AuthenticationEJBImpl aEJB= new AuthenticationEJBImpl();

    public String submit() {
    	System.out.println(aEJB.getUserName());
    	return aEJB.submit();
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
}
