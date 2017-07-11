package com.pensumorganizer.managedbeans;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.pensumorganizer.ejb.HistoryEJBImpl;
import com.pensumorganizer.util.structures.Course;

@ManagedBean
@ViewScoped
public class HistoryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	public static HistoryEJBImpl hEJB = new HistoryEJBImpl();
	
	public Map<Integer, List<Course>> getTrimester() {
		return hEJB.getHistory();
	}
	
	public void recreateHistory(int studentId){
		hEJB.recreateHistory(studentId);
	}
	
	public int getApprovedCredits(int studentId){
		return hEJB.getApprovedCredits(studentId);
	}
	
	public int getApprovedCourses(int studentId){
		return hEJB.getTotalApprovedCourses(studentId);
	}
}
