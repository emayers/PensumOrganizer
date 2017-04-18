package com.pensumorganizer.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.pensumorganizer.ejb.AuthenticationEJBImpl;

@ManagedBean
@RequestScoped
public class AuthenticationBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	AuthenticationEJBImpl aEJB = new AuthenticationEJBImpl();

    public String submit() {    	
    	return aEJB.submit();
    }

	public Integer getUserName() {
		return aEJB.getUserName();
	}

	public Integer getPassword() {
		return aEJB.getPassword();
	}
}
