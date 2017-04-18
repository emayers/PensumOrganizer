package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.ProgramEJBImpl;

@ManagedBean
@SessionScoped
public class ProgramBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	ProgramEJBImpl pEJB = new ProgramEJBImpl();
	
	@PostConstruct
	private void prepare(){
		pEJB.recreateProgram();
	}
	
	public Map<Integer, List<Course>> getProgram() {		
		return pEJB.getProgram();
	}
}
