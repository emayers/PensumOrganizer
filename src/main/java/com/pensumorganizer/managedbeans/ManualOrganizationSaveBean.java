package com.pensumorganizer.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.ManualOrganizationSaveEJBImpl;

@ManagedBean
@SessionScoped
public class ManualOrganizationSaveBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	ManualOrganizationSaveEJBImpl moEJB = new ManualOrganizationSaveEJBImpl();
	
	public String saveReorganization(){
		return moEJB.saveReorganization();
	}
}
