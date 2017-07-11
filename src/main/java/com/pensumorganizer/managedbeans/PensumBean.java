package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pensumorganizer.ejb.PensumEJBImpl;
import com.pensumorganizer.util.structures.Course;

@ManagedBean
@ViewScoped
public class PensumBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	public static PensumEJBImpl pEJB = new PensumEJBImpl();
	
	public Map<Integer, List<Course>> getPensum() {		
		return pEJB.getPensum();
	}
	
	public void recreatePensum(int studentId){
		pEJB.recreatePensum(studentId);
	}
	
	public String getPensumName(int studentId){
		return pEJB.getPensumName(studentId);
	}
	
	public int getPensumTotalTrimesters(int studentId){
		return pEJB.getPensumTotalTrimesters(studentId);
	}
	
	public int getPensumPermanence(int studentId){
		return pEJB.getPensumPermanence(studentId);
	}
	
	public int getPensumTotalCredits(int studentId){
		return pEJB.getPensumTotalCredits(studentId);
	}
	
	public int getPensumTotalCourses(int studentId){
		return pEJB.getPensumTotalCourses(studentId);
	}
}
