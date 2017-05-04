package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.AutoPrioritizerEJBImpl;
import com.pensumorganizer.util.structures.Course;

@ManagedBean
@SessionScoped
public class AutoPrioritizerBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	public static AutoPrioritizerEJBImpl apEJB = new AutoPrioritizerEJBImpl();
	
	public String reorganizePensum(){
		return apEJB.organizePensum();
	}
	
	public Map<Integer, List<Course>> getPensum() {
		return apEJB.getOrganizedPensum();
	}
}
