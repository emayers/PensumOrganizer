package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pensumorganizer.ejb.PensumEJBImpl;
import com.pensumorganizer.util.structures.Course;

@ManagedBean
@SessionScoped
public class PensumBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	public static PensumEJBImpl pEJB = new PensumEJBImpl();
	
	public Map<Integer, List<Course>> getPensum() {		
		return pEJB.getPensum();
	}
}
