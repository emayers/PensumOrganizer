package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.dao.Course;
import com.pensumorganizer.ejb.AutoPrioritizerEJBImpl;

@ManagedBean
@SessionScoped
public class AutoPrioritizerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	AutoPrioritizerEJBImpl apEJB = new AutoPrioritizerEJBImpl();
	
	@PostConstruct
	public void prepare(){
		apEJB.organizePensum();
	}
	
	public Map<Integer, List<Course>> getPensum() {
		return apEJB.getOrganizedPensum();
	}
}
